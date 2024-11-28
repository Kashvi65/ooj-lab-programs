import java.util.Scanner;

// Custom exception for invalid ages
class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

// Father class
class Father {
    int age;

    // Constructor
    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative.");
        }
        this.age = age;
    }
}

// Son class extending Father
class Son extends Father {
    int sonAge;

    // Constructor
    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative.");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to Father's age.");
        }
        this.sonAge = sonAge;
    }
}

// Main class
public class ExceptionHandlingInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input for Father's age
            System.out.print("Enter Father's age: ");
            int fatherAge = scanner.nextInt();

            // Input for Son's age
            System.out.print("Enter Son's age: ");
            int sonAge = scanner.nextInt();

            // Create Son object
            Son son = new Son(fatherAge, sonAge);
            System.out.println("Father's age: " + son.age);
            System.out.println("Son's age: " + son.sonAge);

        } catch (WrongAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

