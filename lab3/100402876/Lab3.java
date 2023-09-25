import java.util.Scanner;
public class Lab3 {
    /**
     * * Program Name: Lab3
     * * Author:       Sothea Song
     * * Id:           100402876
     * * Date:         June 1, 2023
     * * Course:       CPSC 1150
     * * Compiler:     JDK 1.8
     */
    public static void main(String[] args) {
        // Declaring
        double iBalance, balance;
        double interestRate = 0.06 / 12;
        double expense = 500.00;
        int months = 0;

        // Asks for input and formula
        Scanner input = new Scanner(System.in);
        System.out.println("What is the initial balance?");
        iBalance = input.nextDouble();
        balance = iBalance * (1 + interestRate);

        // For if the balance that gets updated each month is always bigger than the expense
        if (balance-expense >= iBalance){
            System.out.println("The account balance will never deplete.");
        } else {
            // Checks if the balance is depleted
            while (balance >= 0){
                balance = balance - expense; // The expense every month
                balance = balance * (1 + interestRate); // The balance gets updated each month
                months++; // Increases the months if the balance is not yet depleted
            }
            int years = months/12;
            if (years > 0){ // Checks if it has been more than 12 months
                months = months%12;
                System.out.println(years + " years and " + months + " month(s)");
            } else {
                System.out.println(months + " month(s)");
            }

        }
    }
}