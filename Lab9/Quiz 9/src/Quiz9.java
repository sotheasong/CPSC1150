/** Test program for lab auiz 9 */
public class Quiz9{
    public static void main(String[] args){

        // test cases
        System.out.println("Test cases (Part A)");
        System.out.println(myParseInt("2378"));
        System.out.println(myParseInt("-28"));
        System.out.println(myParseInt("234.0")); // not a valid decimal integer number

        System.out.println("Test cases (Part B)");
        System.out.println(myParseDouble("2378.35"));
        System.out.println(myParseDouble("-28.85"));
        System.out.println(myParseDouble("185.F4"));// not a valid decimal double number


        System.out.println("Test cases (Part C)");
        String[] arr1 = {"this is a test", "another test", "and more"};
        System.out.println(countSymbol(arr1,'t'));
        System.out.println(countSymbol(arr1,' '));
        System.out.println(countSymbol(arr1,'v'));

        String[] arr2 = {"", "another test", " "};
        System.out.println(countSymbol(arr2,'o'));
        System.out.println(countSymbol(arr2,'r'));


    }

    /** gets a string representation of an integer number, and returns its integer value. If the argument is not a valid integer number, then it returns 0
     @param str : string
     @return the integer represented by the string.
     */
    public static int myParseInt(String str) {
        int value=0;
        // Your code goes here
        int count = 0;
        for (int l = str.length()-1; l >= 0; l--){
            if (str.charAt(l) == '-'){
                value *= -1;
            } else if (str.charAt(l) >= '0' && str.charAt(l) <= '9'){
                int digit = str.charAt(l) - '0';
                value += digit * Math.pow(10, count);
                count++;
            } else return 0;

        }

        return value;
    }

    /** gets a string representation of a double number, and returns its double value. If the argument is not a valid double number, then it returns 0
     @param str : string
     @return the double represented by the string.
     */
    public static double myParseDouble(String str) {
        double value=0;
        // Your code goes here

        int count = 0;
        for (int l = str.length()-1; l >= 0; l--){
            if (str.charAt(l) == '-'){
                value *= -1;
            } else if (str.charAt(l) >= '0' && str.charAt(l) <= '9'){
                int digit = str.charAt(l) - '0';
                value += digit * Math.pow(10, count);
                count++;
            } else if (str.charAt(l) == '.'){
                value *= Math.pow(10, -count);
                count = 0;
            } else return 0;
        }
        return value;
    }



    /** Count number of times character x appears in array of Strings
     @param arr : array of String
     @param x : the character should be counted
     @return number of times x appears in the arr
     */
    public static int countSymbol(String[] arr, char x) {

        int count=0;
        // Your code goes here
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == x) {
                    count++;
                }
            }
        }

        return count;

    }
}   