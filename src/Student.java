import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Student class that keeps track of the student's name, grading strategy, and scores
 */
public class Student {
    private String name;  // Student's name
    private GradingStrategy gradingStrategy;  // Grading strategy to be used
    private Map<Course, List<Double>> assignmentScores;
    private Map<Course, List<Double>> examScores;
    Helper h = new Helper();  // Helper object to calculate averages

    /**
     * Constructor
     *
     * @param name the student's name
     */
    public Student(String name) {
        this.name = name;
        this.assignmentScores = new HashMap<>();
        this.examScores = new HashMap<>();
        this.gradingStrategy = new WeightedStrategy();  // Default grading strategy
    }

    /**
     * Validate that the student is enrolled in the course
     *
     * @param course the course to validate the student for
     */
    public void validateEnrollment(Course course) {
        if (course.hasStudent(this)) {
            throw new IllegalArgumentException("Student is not enrolled in the course");
        }
    }

    /**
     * Validate that the score is between 0 and 100
     *
     * @param score the score to validate
     */
    public void validateScore(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }

    /**
     * Get the student's name
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the grading strategy for the student
     *
     * @param gradingStrategy the grading strategy to be used
     */
    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    /**
     * Add an assignment score for the student
     *
     * @param course the course to add the assignment score for
     * @param aScore the assignment score to add
     */
    public void addAssignmentScore(Course course, double aScore) {
        validateScore(aScore);
        assignmentScores.computeIfAbsent(course, k -> new ArrayList<>()).add(aScore); // line of code helped by ChatGPT
    }

    /**
     * Add an exam score for the student
     *
     * @param course the course to add the exam score for
     * @param eScore the exam score to add
     */
    public void addExamScore(Course course, double eScore) {
        validateScore(eScore);
        examScores.computeIfAbsent(course, k -> new ArrayList<>()).add(eScore); // line of code helped by ChatGPT
    }

    /**
     * Get the average of the student's assignment scores
     *
     * @param course the course to get the assignment average for
     * @return the average of the student's assignment scores
     */
    public double getAssignmentAverage(Course course) {
        if (!assignmentScores.containsKey(course)) {
            throw new IllegalArgumentException("Student has no assignment scores for this course");
        }
        return h.getAverage(assignmentScores.get(course));
    }

    /**
     * Get the average of the student's exam scores
     *
     * @param course the course to get the exam average for
     * @return the average of the student's exam scores
     */
    public double getExamAverage(Course course) {
        if (!examScores.containsKey(course)) {
            throw new IllegalArgumentException("Student has no exam scores for this course");
        }
        return h.getAverage(examScores.get(course));
    }

    /**
     * Display the student's final grade
     *
     * @param course the course to display the student's final grade for
     */
    public int displayFinalGrade(Course course) {
        validateEnrollment(course);
        return gradingStrategy.getFinalGrade(this, course);
    }

    /**
     * Get the description of the grading strategy
     *
     * @return the description of the grading strategy
     */
    public String getGradingStrategyDescription() {
        return gradingStrategy.description();
    }
}