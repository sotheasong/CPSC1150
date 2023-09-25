import java.util.Scanner;
public class Assignment2 {
    /**
 ** Program Name: Change
 ** Author:       Sothea Song
 ** Id:           100402876
 ** Date:         May 22, 2023
 ** Course:       CPSC 1150
 ** Compiler:     JDK 1.8
 */
    public static void main(String[] args)
    {
        // Initialize
        double a, b, c, x, delta, x1, x2;

        // Takes user input
        Scanner input = new Scanner(System.in);
        System.out.print("input a: ");
        a = input.nextDouble();
        System.out.print("input b: ");
        b = input.nextDouble();
        System.out.print("input c: ");
        c = input.nextDouble();

        // Formula for the discriminant
        delta = Math.pow(b,2) - (4 * a * c);

        if (a == 0){
            if (b == 0) {
                System.out.println("Not a valid input. Try again."); // a=0, b=0
            } else {
                System.out.println("Linear equation"); // only a=0
                x = -c / b;
                System.out.print("x = " + x);
            }
        } else if (delta == 0){
            System.out.println("Double roots");
            x1 = (-b + Math.sqrt(delta))/(2 * a);
            System.out.print("x1 = x2 = " + x1);
        } else if (delta > 0){
            System.out.println("Two real roots");
            x1 = (-b + Math.sqrt(delta))/(2 * a);
            x2 = (-b - Math.sqrt(delta))/(2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            System.out.println("No real roots");
        }

    }
}