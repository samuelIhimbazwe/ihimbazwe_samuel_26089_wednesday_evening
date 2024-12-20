
import java.io.*;  
import java.sql.*; 

public class ExceptionHandling {

    public static void main(String[] args) {
        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();

        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }

    private static void simulateIOException() {
        System.out.println("\nSimulating IOException:");
        try (BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"))) {
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    private static void simulateFileNotFoundException() {
        System.out.println("\nSimulating FileNotFoundException:");
        try {
            FileReader file = new FileReader("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    private static void simulateEOFException() {
        System.out.println("\nSimulating EOFException:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emptyfile.dat"))) {
            ois.readObject();
        } catch (EOFException e) {
            System.out.println("EOFException caught: End of file reached unexpectedly.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Other exception caught: " + e.getMessage());
        }
    }

    private static void simulateSQLException() {
        System.out.println("\nSimulating SQLException:");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentdb", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    private static void simulateClassNotFoundException() {
        System.out.println("\nSimulating ClassNotFoundException:");
        try {
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    private static void simulateArithmeticException() {
        System.out.println("\nSimulating ArithmeticException:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    private static void simulateNullPointerException() {
        System.out.println("\nSimulating NullPointerException:");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    private static void simulateArrayIndexOutOfBoundsException() {
        System.out.println("\nSimulating ArrayIndexOutOfBoundsException:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void simulateClassCastException() {
        System.out.println("\nSimulating ClassCastException:");
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    private static void simulateIllegalArgumentException() {
        System.out.println("\nSimulating IllegalArgumentException:");
        try {
            Thread thread = new Thread();
            thread.setPriority(20);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void simulateNumberFormatException() {
        System.out.println("\nSimulating NumberFormatException:");
        try {
            int num = Integer.parseInt("NotANumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
