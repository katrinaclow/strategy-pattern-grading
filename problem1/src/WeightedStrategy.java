/**
 * A grading strategy that calculates the final grade for a student in a course based on weighted assignment and exam averages
 */
public class WeightedStrategy implements GradingStrategy {
    private double assignmentWeight = 0.4;
    private double examWeight = 0.6;

    /**
     * Get the final grade for a student in a course
     */
    @Override
    public int getFinalGrade(Student s, Course c) {
        return (int) ((s.getAssignmentAverage(c) * assignmentWeight) + (s.getExamAverage(c) * examWeight));
    }

    /**
     * Get the description of the grading strategy
     *
     * @return the description of the grading strategy
     */
    @Override
    public String description() {
        return "Weighted Strategy - assignments are worth 40% of the final grade, exams are worth 60%";
    }
}
