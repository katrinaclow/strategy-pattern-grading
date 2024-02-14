/**
 * Interface for grading strategies
 */
public interface GradingStrategy {

    /**
     * Get the final grade for a student in a course
     *
     * @param s the student
     * @return the final grade
     */
    int getFinalGrade(Student s, Course c);

    /**
     * Get the description of the grading strategy
     *
     * @return the description of the grading strategy
     */
    String description();
}