
import java.util.ArrayList;
import java.util.Scanner;

/*
    Module 4 Activity: Arrays and ArrayList
    Topics Covered:
    - Declaring and creating arrays
    - Initializing arrays
    - Passing arrays to methods
    - Enhanced for loop
    - Exception handling with arrays
    - Multidimensional arrays
    - Variable-length arguments
    - ArrayList introduction
 */
 /*
    VarArgs method
    - can have variable amount of values
    - VarArgs(type...values)
 */
// STEP 1: Utility class for array operations
class ArrayUtilities {

    // Method to calculate sum of array elements - method name is sumArray, in params we are saying this is accepting an int array - you can pass arrays as params to methods
    public static int sumArray(int[] numbers) {
        // TO DO: use a loop to calculate sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to find average - make sure to check return value, in this case is a double which means we need to return it as double
    public static double averageArray(int[] numbers) {
        // TO DO: call sumArray and compute average
        int sum = sumArray(numbers);
        return (double) sum / numbers.length; // this is how to convert to double
    }

    // Variable-length argument method (Varargs) - allows passing any number of values
    public static int maxValue(int... values) {
        // TO DO: find maximum value
        int max = values[0]; // initialize max with first values index
        for (int val : values) {
            if (val > max) {
                max = val; // update max whenever a value bigger than the max is found
            }
        }
        return max;
    }
}

// STEP 2: Class to demonstrate 2D arrays
class GradeBook {

    private int[][] grades; // declare 2D array with [][]

    // Constructor -- initializing the value of instanced var grades
    public GradeBook(int[][] gradesArray) {
        // TO DO: assign grades
        this.grades = gradesArray;
    }

    // Display grades
    public void displayGrades() {
        // TO DO: nested loop to print 2D array
        System.out.println("\nStudent Grades: ");
        //first loop - first array is grades, this loop sets up the rows in the multiarray
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Student: " + i + 1 + ":");
            //second loop - this array is for populating each row because of passing i through grades[i].length, this goes through the grades of each student because each student is an i
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print(grades[i][j] + "");
            }
            System.out.println();
            /*
                student1 {10,20,30}
                student2 {40,50,60}
                student3 {70,80,90}
             */
        }
    }

    // Calculate average for each student
    public void calculateAverages() {
        // TO DO: loop through rows and compute averages
        System.out.println("\nStudent Averages");
        for (int i = 0; i < grades.length; i++) {
            int sum = 0;
            for (int num : grades[i]) {
                sum += num;
            }
            double avg = (double) sum / grades[i].length;
            System.out.println("Student " + (i + 1) + " Average: " + avg);
        }
    }
}

// STEP 3: Main driver class
public class ArrayModuleDemo {

    public static void main(String[] args) {
        //user input
        Scanner scanner = new Scanner(System.in);

        // -----------------------------
        // PART 1: One-Dimensional Arrays
        // -----------------------------
        // TO DO: Declare and create an int array of size 5
        int[] numbers = new int[5];

        // TO DO: Populate array using Scanner
        System.out.println("Enter 5 grades: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt(); // user input populates the numbers array
        }

        // TO DO: Display array using enhanced for loop
        System.out.println("\nGrade values: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // TO DO: Call sumArray and averageArray methods
        int sum = ArrayUtilities.sumArray(numbers);
        double avg = ArrayUtilities.averageArray(numbers);
        System.out.println("\nSum: " + sum);
        System.out.println("\nAverage: " + avg);

        // -----------------------------
        // PART 2: Exception Handling
        // -----------------------------
        try {
            // TO DO: Access an invalid index to demonstrate exception
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // TO DO: print exception message
            System.out.println("\nException Caught: " + e.getMessage());
        }

        // -----------------------------
        // PART 3: Multidimensional Arrays
        // -----------------------------
        int[][] studentGrades = {
            {85, 90, 78}, // each row is 1 student, each column is 1 grade
            {88, 76, 92},
            {70, 68, 75}
        };

        // TO DO: Create GradeBook object
        GradeBook gb = new GradeBook(studentGrades);
        // TO DO: Display grades
        gb.displayGrades();
        // TO DO: Calculate averages
        gb.calculateAverages();

        // -----------------------------
        // PART 4: ArrayList Introduction
        // -----------------------------
        ArrayList<String> names = new ArrayList<>();

        // TO DO: Add 3 student names
        names.add("Mat");
        names.add("Josh");
        names.add("Kasib");
        // TO DO: Display names using enhanced for loop
        System.out.println("\nStudent Names: ");
        for (String name : names) {
            System.out.println(name);
        }
        // TO DO: Remove one name
        names.remove(1);
        // TO DO: Display updated list
        System.out.println("\nUpdated Student Names: ");
        for (String name : names) {
            System.out.println(name);
        }

        // -----------------------------
        // PART 5: Varargs Method Call
        // -----------------------------
        
        // TO DO: Call maxValue with multiple arguments
        // Example: maxValue(10, 20, 5, 40, 15)
        int max = ArrayUtilities.maxValue(10,20,5,6,15);
        System.out.println("\nMaximum Value: " + max);
        
        scanner.close();
    }
}