import java.util.Scanner;
public class Lab5 {
    /**
     ** Program Name: Lab5
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         June 15, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the value of n? ");
        int n = input.nextInt();

        // GOES THROUGH EVERY NUMBER FROM 2 (BECAUSE IT'S THE FIRST PALINDROME AND PRIME NUMBER) ALL THE TO N
        // TO CHECK IF THEY ARE A PRIME NUMBER AND PALINDROME AND PRINTS THE ONES THAT ARE BOTH.
        for (int i=2; i<=n; i++){
            if (is_prime(i) && is_palindrome(i))
                System.out.print(i + " ");
        }
        System.out.print("are all palindrome prime numbers less than or equal to " + n);
    }

    /**
     * Checks if the number that is passed in as a parameter is a prime number or not
     * @param n : value of i that is passed through after each iteration
     * @return true if n is a prime number, false if n is not a prime number
     */
    public static boolean is_prime(int n)
    {
        for (int i=2; i<n; i++) { // CHECKS EVERY NUMBER FROM TO UNTIL THE VALUE OF i AFTER EACH ITERATION
                                    // AND CHECKS IF THE NUMBER IS DIVISIBLE BY i
            if (n % i == 0)
                return false; // IF DIVISIBLE, NOT A PRIME NUMBER
        } return true;
    }

    /**
     * Checks if the number that is passed in as a  parameter is a palindrome or not.
     * Checks it by reversing the number and checks if it is the same as the number that was
     * passed in.
     * @param n : value of i that is passed through after each iteration
     * @return true if n is a palindrome number, false if n is not a palindrome number.
     */
    public static boolean is_palindrome(int n)
    {
        int start = n;
        int sum = 0;
        int d = checksDigit(n);
        while (d>0){ // REVERSES THE NUMBER
            int r = n%10;
            sum += r * Math.pow(10, d-1);
            n = n/10;
            d-=1;
        }
        return (start == sum); // CHECKS IF THE NUMBER FIRST PASSED THROUGH IS THE SAME AS THE REVERSED NUMBER
    }

    /**
     * Checks how many digits there are in the number
     * @param n : value of i that is passed through after each iteration
     * @return count = the number of digits in the number
     */
    public static int checksDigit(int n)
    {
        int count = 0;
        while (n>0){
            n = n/10;
            count += 1;
        }
        return count;
    }

}