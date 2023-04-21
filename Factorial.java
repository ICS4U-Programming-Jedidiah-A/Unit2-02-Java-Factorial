import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* The program for today will convert
* my input number and give them the factorials.
*
* @author Jedidiah Alfred
* @version 1.0
* @since 2023-04-17
*/

public final class Factorial {
    /**
    * For style checkers.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print the messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {

        // Declare a list.
        final ArrayList<String> list = new ArrayList<String>();
        try {

            // new file object
            final File input = new File("input.txt");
            final Scanner scanner = new Scanner(input);

            // Create a file to which to save the output.
            final FileWriter output = new FileWriter("output.txt");

            // This is use to read the input file.
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            // Create an array with all elements in the input list.
            final String[] listArr = new String[list.size()];
            for (int location = 0; location < listArr.length; location++) {
                listArr[location] = list.get(location);
            }

            // this is a Loop to send the lines to function.
            for (String strNum : listArr) {
                try {
                    // In this section of the program, a
                    // function will be called.
                    final double factored =
                        factorial(Double.parseDouble(strNum));
                    System.out.println(factored);
                    output.write(factored + "\n");

                    // incase of a Number error
                } catch (NumberFormatException err) {
                    System.out.println("This input is invalid.");

                }
            }

            // Close writer.
            output.close();
        } catch (IOException err) {

            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function generates marks for each assignment.
    *
    *
    * @param numbers from file
    * @return factored number
    */

    public static double factorial(double numbers) {
        // Detect if the number < 1.
        if (numbers <= 1) {
            return numbers;
        } else {
            // Here, the function will be recalled
            return factorial(numbers - 1) * numbers;
        }
    }
}
