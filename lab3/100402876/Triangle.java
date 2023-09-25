import java.util.Scanner;
public class Triangle {
    /**
     * * Program Name: Triangle
     * * Author:       Sothea Song
     * * Id:           100402876
     * * Date:         June 1, 2023
     * * Course:       CPSC 1150
     * * Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        // Declaring
        int n, i, j;
        Scanner input = new Scanner(System.in);
        System.out.println("What is the value of n?"); // Asks for value of n
        n = input.nextInt();

        for (i=1; i<=n; i++){
            for (j=1; j<=n-i; j++)
                System.out.print("  "); // Used to print the amount of spaces before the numbers
                                        // 2 spaces because one for the space itself and one for the space that is taken up by the number
            for (j=i; j>=1; j--)
                System.out.print(j + " "); // Used to print the numbers that come after the spaces
                                           // Decrements from j
            System.out.println(); // Used to go down a line each iteration
        }

    }
}