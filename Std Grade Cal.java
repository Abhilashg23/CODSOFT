import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the student's score for the first exam: ");
        double exam1Score = scanner.nextDouble();

        System.out.print("Enter the student's score for the second exam: ");
        double exam2Score = scanner.nextDouble();

        System.out.print("Enter the student's score for the final exam: ");
        double finalExamScore = scanner.nextDouble();

        // Calculate the average score
        double averageScore = (exam1Score + exam2Score + finalExamScore) / 3;

        // Determine the grade based on the average score
        String grade;
        if (averageScore >= 90) {
            grade = "A";
        } else if (averageScore >= 80) {
            grade = "B";
        } else if (averageScore >= 70) {
            grade = "C";
        } else if (averageScore >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Student Name: " + studentName);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
