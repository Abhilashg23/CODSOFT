import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseName;
    private int maxStudents;
    private List<Student> studentsEnrolled;

    public Course(String courseCode, String courseName, int maxStudents) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxStudents = maxStudents;
        this.studentsEnrolled = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }
}

class Student {
    private String studentID;
    private String studentName;
    private List<Course> coursesRegistered;

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.coursesRegistered = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Course> getCoursesRegistered() {
        return coursesRegistered;
    }
}

public class CourseRegistrationSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Course Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Register Student");
            System.out.println("3. Display Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    displayCourses();
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter the course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter the course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter the maximum number of students: ");
        int maxStudents = scanner.nextInt();

        Course course = new Course(courseCode, courseName, maxStudents);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    private static void registerStudent(Scanner scanner) {
        System.out.print("Enter the student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentID, studentName);
        students.add(student);

        displayCourses();
        System.out.print("Enter the course code to register the student: ");
        String courseCode = scanner.nextLine();

        Course selectedCourse = findCourseByCode(courseCode);
        if (selectedCourse != null) {
            if (selectedCourse.getStudentsEnrolled().size() < selectedCourse.getMaxStudents()) {
                selectedCourse.getStudentsEnrolled().add(student);
                student.getCoursesRegistered().add(selectedCourse);
                System.out.println("Student registered for the course successfully.");
            } else {
                System.out.println("Course is full. Student registration failed.");
            }
        } else {
            System.out.println("Course not found. Student registration failed.");
        }
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static void displayCourses() {
        System.out.println("Courses Available:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Max Students: " + course.getMaxStudents());
            System.out.println("Students Enrolled: " + course.getStudentsEnrolled().size());
            System.out.println("------------------------------------------------");
        }
    }
}
