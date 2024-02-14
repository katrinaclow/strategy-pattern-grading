import java.util.HashMap;
import java.util.Map;

/**
 * Course class that keeps track of the course's name, number, and enrollment list
 */
class Course {
    private String name; // Course's name
    private String number; // Course's number
    private Map<String, Student> enrollmentList; // List of students enrolled in the course

    /**
     * Constructor
     *
     * @param name the course's name
     * @param number the course's number
     */
    public Course(String name, String number) {
        this.name = name;
        this.number = number;
        this.enrollmentList = new HashMap<>();
    }

    /**
     * Add a student to the course if they aren't already enrolled
     *
     * @param s the student to add
     */
    public void addStudent(Student s) {
        if (hasStudent(s)) {
            enrollmentList.put(s.getName(), s);
        }
    }

    /**
     * check if the student is enrolled in the course
     *
     * @param s the student to check
     * @return true if the student is enrolled in the course, false otherwise
     */
    public boolean hasStudent(Student s) {
        return !enrollmentList.containsValue(s);
    }

    /**
     * Get the course's name
     *
     * @return the course's name
     */
    public String getCourseName() {
        return name;
    }

    /**
     * Get the course's number
     *
     * @return the course's number
     */
    public String getCourseNumber() {
        return number;
    }
}
