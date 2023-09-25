
/** tests recursive method   */
public class Quiz12{
    public static void main (String[] args) {

        //Test Cases
        System.out.println(myMethod(6));
        System.out.println(myMethod(12));
        System.out.println(myMethod(1));

    }

    /** Prints numbers from n to 1, one number each number in a line using recursion
     without using any looping mechanism.
     @param n: a positive integer number
     */
    public static double myMethod(int n) 	{
        // your code goes here
        double result = 1/n;
        if (n == 1) {
            return 1;
        }
        return result + myMethod(n-1);
    }
}    