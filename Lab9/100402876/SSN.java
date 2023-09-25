import java.util.Scanner;
public class SSN {
    /**
     ** Program Name: SSN
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         July 13, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        System.out.print("Enter an SSN: ");
        Scanner input = new Scanner(System.in);
        String ssn = input.nextLine();
        check(ssn);
    }

    /**
     * Checks if all the sets of 3 digits is in the correct format (The first digit isn't zero, and the second set of three digits is more than 100)
     * @param s The SSN input by the user
     */
    public static void check(String s)
    {
        int sum;
        boolean wrong = false;
        String[] s1 = s.split("-", 3); // Takes the SSN and splits it by "-"
        int[] arr = new int[s1.length];

        for (String e : s1){ // Checks if the sets of digits is 3 digits
            if (e.length() != 3) {
                wrong = true;
                break;
            }
        }

        for (int i = 0; i < s1.length; i++){
            String temp = s1[i];
            if (i == 0) { // Checks if the first digit is 0 or not
                if (s1[i].charAt(0) == '0') {
                    wrong = true;
                    break;
                }
            }
            // Converts the string into integer and appends it into the array
            sum = Integer.parseInt(temp);
            arr[i] = sum;
        }

        if (arr[1] > 100 && !wrong ){ // Checks if the second set of three digits is more than 100 and any other factors
            System.out.println(s + " is a valid social security number.");
        } else System.out.println(s + " is an invalid social security number");
    }

}