public class StudentGradeGenerator {
    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Student s1 = new Student("Student1"); // Create student
        Course c1 = new Course("MATH", "101"); // Create course
        c1.addStudent(s1); // Add student to course

        s1.addAssignmentScore(c1, 90);
        s1.addAssignmentScore(c1, 80);
        s1.addAssignmentScore(c1, 70);
        s1.addExamScore(c1, 35);
        s1.addExamScore(c1, 45);

        displayStudentFinalGrade(s1, c1); // final grade using the default grading strategy: 'Weighted Strategy'
        s1.setGradingStrategy(new MinExamScoreStrategy()); // Change grading strategy for student 1
        displayStudentFinalGrade(s1, c1); // final grade using 'Min Exam Score Strategy'
    }

    /**
     * Helper method to print information about a student's final grade
     *
     * @param s the student
     * @param c the course
     */
    private static void displayStudentFinalGrade(Student s, Course c) {
        System.out.println("\nMethod: " + s.getGradingStrategyDescription() +
                "\nStudent Name: " + s.getName() +
                "\nCourse: " + c.getCourseName() + c.getCourseNumber() +
                "\nFinal Grade: " + s.displayFinalGrade(c) +
                "\nAssignment Average: " + s.getAssignmentAverage(c) +
                "\nExam Average: " + s.getExamAverage(c));
    }
}