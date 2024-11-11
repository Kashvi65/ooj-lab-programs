// File: Main.java
import CIE.*;
import SEE.*;

// File: Main.java
import SEE.Externals;  // Import Externals class from SEE package

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        // Array to store student data
        Externals[] students = new Externals[n];
        
        // Loop to input data for each student
        for (int i = 0; i < n; i++) {
            students[i] = new Externals();
            
            // Input student details, internal marks, and external marks
            students[i].inputStudentDetails();
            students[i].inputCIEmarks();
            students[i].inputSEEmarks();
            students[i].calculateFinalMarks();
        }
        
        // Display the final results of all students
        for (int i = 0; i < n; i++) {
            students[i].displayFinalMarks();
            System.out.println("--------------------------------------------");
        }
    }
}
