import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/** tests readWrite method   */
public class Lab11Test{
    public static void main (String[] args)  throws FileNotFoundException{


        // test cases
        readWrite("input.txt", "output1.txt", "Java", "JAVA");
        readWrite("input.txt", "output2.txt", " is ", " was ");

    }

    /** Copies content of source file to destination file and changes all occurances of oldStr to new Str
     @param srcFileName: source file name
     @param dstFileName: destination file name
     @param oldStr : old string that will be replace by new String
     @param newStr :   new string that will be substituded for the oldstr in the destination file
     */
    public static void readWrite(String srcFileName, String dstFileName, String oldStr, String newStr)  throws FileNotFoundException{
        // your code goes here
        File in_file = new File(srcFileName);
        Scanner in = new Scanner(in_file);
        File out_file = new File(dstFileName);
        PrintWriter out = new PrintWriter(out_file);
        while(in.hasNextLine()){
            String s = in.nextLine();
            s = s.replaceAll(oldStr, newStr);
            out.println(s);
        }


        in.close();
        out.close();
    }
}    