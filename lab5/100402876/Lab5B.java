public class Lab5B{
    /**
     ** Program Name: Lab5b
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         June 15, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        // Sample test case:
        int n=26540;
        System.out.println("n= "+n+", ans= "+even2odd(n));
        n=9528;
        System.out.println("n= "+n+", ans= "+even2odd(n));
    }

    /**
     changes all even digits of argument to odd digits by adding 1 to each digits
     @param n: a positive integer number
     @return the result as an integer number
     */
    public static int even2odd(int n)
    {
        int ans=0;
        int pos = 1; // STARTS WITH THE ONES DIGIT

        while (n>0){
            if (n % 2 == 0) // CHECKS IF THE NUMBER IS EVEN
                n += 1; // ADDS 1 IF THE NUMBER IS ODD
            ans = ans + ((n % 10) * pos); // UPDATES THE NUMBER TO ADD THE NEW MODIFIED NUMBER
            pos = pos * 10; // MOVES UP THE DIGIT (TO THE TENS, HUNDREDS, THOUSANDS)
            n = n/10; // GOES TO THE NEXT SET OF DIGIT
        }
        return ans;
    }
} 