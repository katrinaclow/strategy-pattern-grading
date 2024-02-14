
# Strategy Pattern
We want to implement a Java class to represent students and their scores from a course they
are enrolled in. The Student class provides at least the following methods:

```
public Student(String name); //constructor
public void addAssignmentScore (Course course, double aScore); //add 1 assignment score
public void addExamScore (Course course, double eScore); //add 1 exam score

```

There is also a Course class that stores a list of the Students in a particular class. The Course
class provides at least these methods:

```
public Course(String name, String number); //constructor
public String getCourseName(); //getter for name
public void addStudent (Student student); //add 1 student
```

We need a method to return a Student’s final grade for a given course, but the algorithm to
compute the final grade must be able to be selected at runtime. It also must be possible to add
new algorithms to compute the final grade if necessary without having to modify the Student
and Course classes. Implement this solution using the Strategy pattern.

Use the following two algorithms for computing the grade in your implementation:
A. The average score of the assignments contributes 40% of the final grade, and the average of
the exams contributes 60%.
B. Use the same percentages as the first algorithm, but if the student fails (less than 50%) the
test portion of the course then its final grade will be the minimum between the actual grade and
45%.

**Testing:** The driver creates a Student, adds three assignment scores and two exam scores, and
computes their average first using method A and then using method B.
