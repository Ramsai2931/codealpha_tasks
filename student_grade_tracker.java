import java.util.ArrayList;
import java.util.Scanner;

class student_grade_tracker 
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        // Input grades
        System.out.println("Enter student grades (type -1 to end): ");
        while (true) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();

            if (grade == -1) { // Exit condition
                break;
            }

            // Validate grade input (e.g., between 0 and 100)
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            }
        }

        // Check if there are any grades
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } 
	else {
            // Compute average, highest, and lowest scores
            double sum = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double grade : grades) {
                sum += grade;
                if (grade > highest) highest = grade;
                if (grade < lowest) lowest = grade;
            }

            double average = sum / grades.size();

            // Display results
            System.out.printf("Average Score: %.2f%n", average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
        }

        scanner.close();
    }
}