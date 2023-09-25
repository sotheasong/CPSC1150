import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {

        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a positive integer number: ");
        n = in.nextInt();
        // Your code goes here

        if (n % 3 == 0){
            if (n % 7 == 0){
                System.out.print(n + " is divisible by both 3 and 7");
            } else {
                System.out.print(n + " is divisible by only 3");
            }
        } else if (n % 7 == 0) {
            System.out.print(n + " is only divisible by 7.");
        } else {
            System.out.print(n + " is not divisible by neither 3 or 7.");
        }
    }
}