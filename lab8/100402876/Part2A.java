import java.util.Scanner;
public class Part2A {
    /**
     ** Program Name: Lab 8
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         July 6, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("input first number: ");
        String first_int = input.nextLine();
        System.out.println("input second number: ");
        String second_int = input.nextLine();

        String sum = sumOf(first_int, second_int);
        String product = productOf(first_int, second_int);

        // For formatting the first integer
        char[] firstint = formatting(first_int);
        String newfirstint = arrToString(firstint);

        // For formatting the second integer
        char[] secondint = formatting(second_int);
        String newsecondint = arrToString(secondint);

        // For formatting the sum of the 2 integers
        char[] sumarr = formatting(sum);
        String newsum = arrToString(sumarr);

        // For formatting the product of the 2 integers
        char[] sumprod = formatting(product);
        String newprod = arrToString(sumprod);

        // Outputs the sum and product of the 2 integers
        output_sum(newfirstint, newsecondint, newsum);
        output_product(newfirstint, newsecondint, newprod);
    }

    /** Finds the sum of the 2 integers
     * @param s1 first integer passed as string
     * @param s2 second integer passed as string
     * @return the sum of the 2 integers as a string
     */
    public static String sumOf(String s1, String s2)
    {
        // Goes through the digits in the numbers starting from right to left and if the sum is bigger than 10 then increment carry
        String string_sum = "";
        int carry = 0;
        int i = s1.length()-1, j = s2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0){
            int digit1 = i;
            if (digit1 >= 0){
                digit1 = s1.charAt(i) - '0'; // Gets the integer value of the char
            } else digit1 = 0;

            int digit2 = j;
            if (digit2 >= 0){
                digit2 = s2.charAt(j) - '0'; // Gets the integer value of the char
            } else digit2 = 0;

            int sum = digit1 + digit2 + carry; // Sum of the digits
            carry = sum/10;
            int digit = sum % 10;
            string_sum = digit + string_sum; // Appends the sum to the string
            i--;
            j--;
        }
        return string_sum;
    }

    /** Finds the product of the 2 integers
     * @param s1 first integer passed as string
     * @param s2 second integer passed as string
     * @return the product of the 2 integers as string
     */
    // BONUS PART
    public static String productOf(String s1, String s2)
    {
        String string_product = "";
        int[] product = new int[s1.length() + s2.length()];

        int i , j;
        for (i = s1.length()-1; i >= 0; i--){
            for (j = s2.length() - 1; j >= 0; j--){
                int digit1 = s1.charAt(i) - '0'; // Gets the integer value of the char
                int digit2 = s2.charAt(j) - '0';

                int multiply = digit1 * digit2; // Product of the 2 integers
                int sum = product[i+j+1] + multiply; // Adds the value in the position after the position of the 2 integers
                                                        // to add the carry as well

                product[i+j] += sum/10; // Assigns the least significant digit to the position of the integer
                product[i+j+1] = sum%10; // Assigns significant digit to the position after
            }
        }

        for (int element : product){
            if (!(string_product.length() == 0 && element == 0)){
                string_product += element; // Appends the element of the product into the product string
            }
        }

        if (string_product.length() == 0){
            return "0";
        } else return string_product;
    }

    /** Formats the string to add commas every 3 digits
     * @param n string of the integer to add commas
     * @return formatted string of the integer with added commas
     */
    public static char[] formatting(String n){
        int temp = 0;
        int k = n.length();
        while (k > 0){ // Checks how many extra lengths to add for the commas
            if (k % 3 == 0){ // For every 3 digits we add an extra space for the commas
                temp++;
            }
            k--;
        }

        int l = n.length() + temp;
        char[] arr = new char[l];
        int count = 1;
        for (int i = arr.length - 1, j = n.length() - 1; i >= 0; i--, j--){
            if (count % 4 == 0){ // If the position is at 4 which is where the comma is at, adds comma
                arr[i] = ',';
                j++;
            } else arr[i] = n.charAt(j); // If not then appends the array with the integer
            count++;
        }
        return arr;
    }

    /** Turns array into string
     *
     * @param arr array to be turned into string
     * @return array turned into string
     */
    public static String arrToString(char[] arr)
    {
        String newString = "";
        for (char c : arr) {
            newString += c; // appends element in the array into string
        }

        return newString;
    }

    /** Output the integers and the sum between the integers in the format given
     * @param n1 first integer
     * @param n2 second integer
     * @param n3 sum of the 2 integers
     */
    public static void output_sum(String n1, String n2, String n3)
    {
        String newString1 = String.format("%31s" ,n1); // 31 spaces for integers and remaining spaces
        System.out.println(newString1 + " +");
        String newString2 = String.format("%31s" ,n2);
        System.out.println(newString2);
        System.out.println("-------------------------------");
        String newString3 = String.format("%31s", n3);
        System.out.println(newString3);
        System.out.println();
    }

    // BONUS PART
    /** Output the integers and the product between the integers in the format given
     * @param n1 first integer
     * @param n2 second integer
     * @param n3 product of the 2 integers
     */
    public static void output_product(String n1, String n2, String n3)
    {
        String newString1 = String.format("%60s" ,n1); // 60 spaces for integers and remaining spaces
        System.out.println(newString1 + " x");
        String newString2 = String.format("%60s" ,n2);
        System.out.println(newString2);
        System.out.println("------------------------------------------------------------");
        String newString3 = String.format("%60s", n3);
        System.out.println(newString3);
        System.out.println();
    }


}