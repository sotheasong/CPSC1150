import java.util.Scanner;
/**
 ** Program Name: lab1
 ** Author:       Sothea Song
 ** Id:           100402876
 ** Date:         May 18 2023
 ** Course:       CPSC 1150
 ** Compiler:     JDK 1.8
 */
public class lab1 {
    public static void main(String[] args)
    {
        int Ta, V;
        double Twc;
        System.out.println("Enter the temperature in Celsius: ");
        Scanner input = new Scanner(System.in);
        Ta = input.nextInt();
        System.out.println("Enter the wind speed kilometers per hour: ");
        V = input.nextInt();
        Twc = 13.112 + (0.6215 * Ta) - (11.37 * Math.pow(V, 0.16)) + (0.3965 * Ta * Math.pow(V, 0.16));
        System.out.println("The wind chill index is " + Twc);
    }
}