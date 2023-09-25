import java.util.*;
import java.io.*;
/**
 ** Program Name: Lab10
 ** Author:       Sothea Song
 ** Id:           100402876
 ** Date:         July 20, 2023
 ** Course:       CPSC 1150
 ** Compiler:     JDK 1.8
 */
public class Lab10 {
    public static void main(String[] args) throws IOException
    {
        int count;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter input file");
        String inFile_name = input.next();
        File inFile = new File(inFile_name);
        if(!inFile.exists()){
            System.out.println("Unable to open file, file doesn't exist");
            input.close();
            return;
        }

        Scanner file = new Scanner(inFile);
        count =  countWord(file);
        file.close();
        file = new Scanner(inFile);
        String[] arr = new String[count];
        readFile(file, arr);
        file.close();

        cleanWordArray(arr);
        toLowerCase(arr);
        printReport(arr);
        sort(arr);

        System.out.println("Enter output file");
        String outFile_name = input.next();
        FileWriter output = new FileWriter(outFile_name);
        writeFile(output, arr);

        output.close();
        input.close();
    }

    /**
     * Counts how many words there are in the file
     * @param in: file that is going to be read
     * @return the amount of words in the file
     */
    public static int countWord(Scanner in) {
        int count = 0;
        while(in.hasNext()){
            in.next();
            count++;
        }
        return count;
    }

    /**
     * Stores all the words in an array
     * @param in: file with all the words
     * @param arr: array that the words are going to be stored in
     */
    public static void readFile(Scanner in, String[] arr) {
        int i = 0;
        while(in.hasNext()){
            arr[i] = in.next();
            i++;
        }
    }

    /**
     * Removes the unncessary string characters that don't fit the criteria
     * @param s the string that contains the characters
     * @param n position of the char in the string
     * @return string without any characters
     */
    public static String removeChar(String s, int n)
    {
        return s.substring(0, n) + s.substring(n+1);
    }

    /**
     * Formats the string, so it fits in the criteria given (If words have any non-letter symbols in the beginning or at
     * the end of the words, then remove them from both sides of the words. If the word still contains any other
     * non-letter symbol except hyphen '-', then get rid of the word, otherwise keep it.)
     * @param str the string is going to be formatted
     * @return the formatted string
     */
    public static String cleanWord(String str) {
        int i = 0;
        while (true) {
            if (i == str.length())
                break;
            else {
                char ch = str.charAt(i);
                if (!(ch >= 'A' && ch <= 'Z') && !(ch >= 'Z' && ch <= '{') && !(ch == '-')) { // Checks if
                    str = removeChar(str, i);
                    i = 0;
                } else i++;
            }
        }
        return str;
    }

    /**
     * Takes all the string in the array and formats it
     * @param arr array with all the strings to be formatted
     */
    public static void cleanWordArray(String[] arr)
    {
        for (int i = 0; i < arr.length; i++){
            arr[i] = cleanWord(arr[i]);
        }
    }

    /**
     * Converts all the string in the array into lowercase
     * @param arr array with all the strings to be turned into lowercase
     */
    public static void toLowerCase(String[] arr)
    {
        for (int i = 0; i< arr.length; i++){
            arr[i] = arr[i].toLowerCase();
        }
    }

    /**
     * Prints out how many words there are in the file and how many times each letter occurs in the file
     * @param arr array that contains all the words in the file after it has been formatted
     */
    public static void printReport(String[] arr)
    {
        int count = 0;
        int[] temp_arr = new int[26];

        // Counts how many words there are and ignoring all the words that starts with a hyphen
        for (String s : arr) {
            if (s.length() == 0 || s.charAt(0) == '-')
                continue;
            count++;
        }


        System.out.println("No. of words: " + count);
        // Counts the frequency of each letter ('a' to 'z')
        for (String s : arr) {
            for (int j = 0; j < s.length(); j++) {
                int x = s.charAt(j);
                if ((x - 'a') >= 0 && (x - '`') < 26) // Checks if the letter is between a to z
                    temp_arr[x - 'a']++; // Appends the amount of time each character appears into an array
            }
        }

        // Prints how many times each letter occurs in the file
        int num = 'a';
        for (int i = 0; i < 26; i++){ // Goes through how many times each character occurred in the array that has been appended
                                        // and prints out how many times each character occurs
            char ch = (char)num;
            System.out.println(ch + "-" + temp_arr[i]);
            num++;
        }
    }

    /**
     * Sorts the array in descending order from a to z
     * @param arr array that contains all the words in the file after it has been formatted
     */
    public static void sort(String[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; i++){
            String temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(temp) > 0){ // Checks if the last word is bigger or smaller than the current letter
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = temp;
        }
    }

    /**
     * Writes all the formatted string into the file and ignoring any reoccuring words
     * @param output file that is going to be written into
     * @param arr with all the string to be written
     * @throws IOException ignores error if there's any error in the input and output of the file
     */
    public static void writeFile(FileWriter output, String[] arr) throws IOException
    {
        String temp, prev = "";
        for (String s : arr) {
            if (s.length() == 0 || s.charAt(0) == '-')
                continue;
            temp = s;
            if (temp.compareTo(prev) != 0) { // Compares if the word is the same as the previous word, if not then its written into the file
                output.write(temp + "\n");
                prev = temp;
            }
        }
    }





}