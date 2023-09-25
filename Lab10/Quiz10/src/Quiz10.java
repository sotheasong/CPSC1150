import java.io.*;
import java.util.*;

/** Test program for quiz 10 */

// Import packages


public class Quiz10{
    public static void main(String[] args) throws FileNotFoundException{

        // Test cases
        readWrite("files/test1.txt", "out1.txt");
        readWrite("files/test2.txt", "out2.txt");


    }

    /** copies the content of the srcFileName into dstFileName, and add the average of the number to the end of the dstFileName
     @param srcFileName :  souce file name contains double numbers
     @param dstFileName : destination file name
     */
    public static void readWrite(String srcFileName, String dstFileName) throws FileNotFoundException {
        // Your code goes here
        File myFile = new File(srcFileName);
        Scanner input = new Scanner(myFile);
        PrintWriter output = new PrintWriter(dstFileName);
        double sum = 0;
        double i = 0;
        while (input.hasNextDouble()){
            double digit = input.nextDouble();
            output.println(digit);
            sum += digit;
            i++;
        }
        double avg = sum/i;
        output.print(avg);
        input.close();
        output.close();
    }
}