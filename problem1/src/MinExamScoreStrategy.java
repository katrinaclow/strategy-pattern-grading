/**
 * A grading strategy that calculates the final grade for a student in a course according to the minimum exam score
 */
public class MinExamScoreStrategy implements GradingStrategy {
    private double assignmentWeight = 0.4;
    private double examWeight = 0.6;

    /**
     * Get the final grade for a student in a course. If the exam average is < 50%, then the final grade will be the
     * minimum between the weighted total grade and 45%.
     *
     * @param s the student
     * @return the final grade
     */
    @Override
    public int getFinalGrade(Student s, Course c) {
        double grade = (s.getAssignmentAverage(c) * assignmentWeight) + (s.getExamAverage(c) * examWeight);
        if (s.getExamAverage(c) < 50) {
            grade = Math.min(grade, 45);
        }
        return (int) grade;
    }

    /**
     * Get the description of the grading strategy
     *
     * @return the description of the grading strategy
     */
    @Override
    public String description() {
        return "Minimum Exam Score Strategy - assignments are worth 40% of the final grade, exams are worth 60%. " +
                "If the exam average is < 50%, then the final grade will be the minimum between the weighted total grade and " +
                "45%.";
    }

}
