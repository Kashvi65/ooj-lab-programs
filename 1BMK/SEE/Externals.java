// File: SEE/Externals.java
package SEE;

import CIE.Internals;  // Import Internals class from CIE package
import java.util.Scanner;

public class Externals extends Internals {
    protected int externalMarks[] = new int[5];  // Array to store external marks for 5 courses
    protected int finalMarks[] = new int[5];     // Array to store final marks (sum of internal and external)

    // Constructor to initialize arrays
    public Externals() {
        externalMarks = new int[5];
        finalMarks = new int[5];
    }

    // Method to input external marks
    public void inputSEEmarks() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter External Marks for 5 courses: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Course " + (i + 1) + ": ");
            externalMarks[i] = s.nextInt();
        }
    }

    // Method to calculate final marks (sum of internal and external)
    public void calculateFinalMarks() {
        for (int i = 0; i < 5; i++) {
            finalMarks[i] = marks[i] + externalMarks[i];  // Internal + External
        }
    }

    // Method to display final marks
    public void displayFinalMarks() {
        displayStudentDetails();  // Display student details (from parent class)
        displayCIEmarks();        // Display internal marks (from parent class)
        
        System.out.println("External Marks: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + externalMarks[i]);
        }

        System.out.println("Final Marks: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + finalMarks[i]);
        }
    }
}
