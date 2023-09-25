public class Quiz5
{
    public static void main (String[] args)
    {
        double  x = 1.89;
        double sinx=0;
        int n = 23;

        // your code goes here
        for (int i = 1; i <= n; i++){
            sinx += ((Math.pow(x, 2*i-1)) / (factorial(2*i-1))*(Math.pow(-1, i+1)));
        }

        System.out.println(" sinx  = "+ sinx);
    }

    /** calcutes and returns  n!
     @param n : a positive integer number
     @return n!
     */
    public static double factorial(int n)
    {
        // your code goes here
        if (n<=1)
            return 1;
        else
            return n * factorial(n-1);

    }
}