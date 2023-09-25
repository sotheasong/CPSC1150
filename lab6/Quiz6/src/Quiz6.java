public class Quiz6{
    public static void main (String[] args){
        int test1 = 36498;
        int test2 = 473;
        int test3 = 81;
        int test4 = 1;

        // test cases
        System.out.println(" test 1:  leftRotate ( "+test1+ " )= "+ leftRotate(test1));
        System.out.println(" test 2:  leftRotate ( "+test2+ " )= "+ leftRotate(test2));
        System.out.println(" test 3:  leftRotate ( "+test3+ " )= "+ leftRotate(test3));
        System.out.println(" test 4:  leftRotate ( "+test4+ " )= "+ leftRotate(test4));
    }

    /** Takes a positive integer number, n, as argument, and returns numer of digits of n*/
    public static  int numberOfDigits(int n){

        // your code goes here
        int count = 0;
        while (n>0){
            n = n/10;
            count += 1;
        }
        return count;
    }

    /** use numberOfDigitsI( int n), and right-rotate the given positive integer n, and returns the result. */

    public static int leftRotate(int n){

        // your code goes here
        int d = numberOfDigits(n);
        double r = n%(Math.pow(10, d-1));
        double q = n/(Math.pow(10, d-1));
        double ans = r * 10 + q;
        return (int)ans;
    }

}