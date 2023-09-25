import java.util.*;
import java.io.*;
/**
 ** Program Name: Lab11
 ** Author:       Sothea Song
 ** Id:           100402876
 ** Date:         July 27, 2023
 ** Course:       CPSC 1150
 ** Compiler:     JDK 1.8
 */
public class Lab11 {
    static String[] number;
    static String[] word;
    public static void main(String[] args) throws FileNotFoundException
    {
        String strOut = "";

        int index = 0;
        int count = 0;

        String in_file_name = "telephone.txt";
        File in_file = new File(in_file_name);
        Scanner in = new Scanner(in_file);

        // Counts how many telephone numbers there are
        while (in.hasNextLine()) {
            in.nextLine();
            index++;
        }

        // Creates an array to store all the phone numbers excluding 604
        number = new String[index];
        Scanner read = new Scanner(in_file);
        read.useDelimiter("604");
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] digit = line.split(" ");
            number[count] = digit[1];
            count++;
        }

        index = 0;
        count = 0;
        String word_file_name = "samplewords.txt";
        File word_file = new File(word_file_name);
        Scanner in_word = new Scanner(word_file);

        // Counts how many words there are
        while (in_word.hasNextLine()) {
            in_word.nextLine();
            index++;
        }

        // Creates an array to store all the words
        Scanner read_word = new Scanner(word_file);
        word = new String[index];
        while (read_word.hasNextLine()) {
            String line = read_word.nextLine();
            word[count] = line;
            count++;
        }

        in.close();
        in_word.close();
        read.close();
        read_word.close();

        for (String s : number) {
            int flag;
            int first = 0;
            for (String value : word) {
                flag = 0;
                for (int k = 0; k < s.length(); k++) {
                    // We only match the phone number to a word if its length is either 3, 4 or 7
                    if (value.length() == 7) {
                        switch (s.charAt(k)) {
                            case '2': // If its 2 then it can either be A B or C
                                switch (value.charAt(k)) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '3': // If its 3 then it can either be D E or F
                                switch (value.charAt(k)) {
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '4': // If its 3 then it can either be G H or I
                                switch (value.charAt(k)) {
                                    case 'G':
                                    case 'H':
                                    case 'I':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '5':
                                switch (value.charAt(k)) {
                                    case 'J':
                                    case 'K':
                                    case 'L':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '6':
                                switch (value.charAt(k)) {
                                    case 'M':
                                    case 'N':
                                    case 'O':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '7':
                                switch (value.charAt(k)) {
                                    case 'P':
                                    case 'Q':
                                    case 'R':
                                    case 'S':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '8':
                                switch (value.charAt(k)) {
                                    case 'T':
                                    case 'U':
                                    case 'V':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                            case '9':
                                switch (value.charAt(k)) {
                                    case 'W':
                                    case 'X':
                                    case 'Y':
                                    case 'Z':
                                        break;
                                    default:
                                        flag = 1;
                                        break;
                                }
                                break;
                        }
                    } else if (value.length() == 4) {
                        if (k < 4) {
                            switch (s.substring(3, 7).charAt(k)) {
                                case '2':
                                    switch (value.charAt(k)) {
                                        case 'A':
                                        case 'B':
                                        case 'C':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '3':
                                    switch (value.charAt(k)) {
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '4':
                                    switch (value.charAt(k)) {
                                        case 'G':
                                        case 'H':
                                        case 'I':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '5':
                                    switch (value.charAt(k)) {
                                        case 'J':
                                        case 'K':
                                        case 'L':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '6':
                                    switch (value.charAt(k)) {
                                        case 'M':
                                        case 'N':
                                        case 'O':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '7':
                                    switch (value.charAt(k)) {
                                        case 'P':
                                        case 'Q':
                                        case 'R':
                                        case 'S':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '8':
                                    switch (value.charAt(k)) {
                                        case 'T':
                                        case 'U':
                                        case 'V':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '9':
                                    switch (value.charAt(k)) {
                                        case 'W':
                                        case 'X':
                                        case 'Y':
                                        case 'Z':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                            }
                        }


                    } else if (value.length() == 3) {
                        if (k < 3) {
                            switch (s.substring(0, 3).charAt(k)) {
                                case '2':
                                    switch (value.charAt(k)) {
                                        case 'A':
                                        case 'B':
                                        case 'C':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '3':
                                    switch (value.charAt(k)) {
                                        case 'D':
                                        case 'E':
                                        case 'F':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '4':
                                    switch (value.charAt(k)) {
                                        case 'G':
                                        case 'H':
                                        case 'I':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '5':
                                    switch (value.charAt(k)) {
                                        case 'J':
                                        case 'K':
                                        case 'L':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '6':
                                    switch (value.charAt(k)) {
                                        case 'M':
                                        case 'N':
                                        case 'O':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '7':
                                    switch (value.charAt(k)) {
                                        case 'P':
                                        case 'Q':
                                        case 'R':
                                        case 'S':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '8':
                                    switch (value.charAt(k)) {
                                        case 'T':
                                        case 'U':
                                        case 'V':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                                case '9':
                                    switch (value.charAt(k)) {
                                        case 'W':
                                        case 'X':
                                        case 'Y':
                                        case 'Z':
                                            break;
                                        default:
                                            flag = 1;
                                            break;
                                    }
                                    break;
                            }
                        }


                    }
                    if (flag == 1) {
                        break;
                    }
                }
                //we output here
                if (flag == 0) {
                    if (first == 0) { // If its the first number then we output the telephone number first
                        first = 1;
                        strOut += "-------------\r";
                        strOut += "TEL: 604 " + s + "\r";
                    }
                    if (value.length() == 7) { // If the matching character is 7 numbers, then we output
                                                // the 7 numbers and the matching word
                        strOut += s + " : " + value + "\r";
                    } else if (value.length() == 4) { // If the matching character is 4 numbers, then we output
                                                        // the substring with the 4 numbers and the matching word
                        strOut += s.substring(3, 7) + " : " + value + "\r";
                    } else if (value.length() == 3) { // If the matching character is 3 numbers, then we output
                                                        // the substring with the 3 numbers and the matching word
                        strOut += s.substring(0, 3) + " : " + value + "\r";
                    }
                }
            }

        }
        output(strOut);
    }

    /**
     * Used to write the strings into the output file
     * @param s the string to be written into the output file
     * @throws FileNotFoundException
     */
    public static void output(String s) throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter("result.txt");
        out.println(s);
        out.close();
    }

}
