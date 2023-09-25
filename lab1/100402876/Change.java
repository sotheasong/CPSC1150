import java.util.Scanner;
/**
 ** Program Name: Change
 ** Author:       Sothea Song
 ** Id:           100402876
 ** Date:         May 18, 2023
 ** Course:       CPSC 1150
 ** Compiler:     JDK 1.8
 */
public class Change {
    public static void main(String[] args)
    {
        // Declaration
        int loonie, quarter, dime, nickel, penny;
        int sum = 0;
        int temp = 0;

        // Asks for inputs
        Scanner input = new Scanner(System.in);
        System.out.println("Enter pennies: ");
        sum = input.nextInt();

        // Calculations
        loonie = sum/100;
        temp = sum%100;
        quarter = temp/25;
        temp %= 25;
        dime = temp/10;
        temp %= 10;
        nickel = temp/5;
        penny = temp%5;

        // Output
        System.out.println("Loonie: " + loonie);
        System.out.println("Quarter: " + quarter);
        System.out.println("Dime: " + dime);
        System.out.println("Nickel: " + nickel);
        System.out.println("Penny: " + penny);
    }
}