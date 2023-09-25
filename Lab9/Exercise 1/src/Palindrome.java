import java.util.Scanner;
public class Palindrome {
    /**
     ** Program Name: Palindrome
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         July 13, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        System.out.print("String: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String phrase = format(s);
        boolean palindrome = is_palindrome(phrase);
        System.out.println("is it a palindrome? " + palindrome);
    }

    /**
     * Checks if its a palindrome
     * @param phrase string passed to check if its a palindrone or not
     * @return true if the phrase is a palindrome, false if the phrase is not
     */
    public static boolean is_palindrome(String phrase)
    {
        int count = 0;
        for (int i = 0, j = phrase.length()-1-i; i < phrase.length()/2; i++, j--){
            // Starts from the first character in the string and the last character of the string and compares the two
            // If its the same then count is incremented.
            if (phrase.charAt(i) == phrase.charAt(j))
                count++;
        }

        // Checks if the count is the same as half the length of the string, if its the same then its a palindrome
        return count == phrase.length() / 2;


    }

    /**
     * Used to format the string by putting it all lowercase and remove any whitespace characters
     * @param s string passed to get formatted
     * @return string with no whitespace and all in lowercase
     */
    public static String format(String s)
    {
        String newphrase;
        newphrase = s.toLowerCase();
        for (int i = 0; i < newphrase.length(); i++){
            if (!(newphrase.charAt(i) >= 'a' && newphrase.charAt(i) <= 'z')){
                char temp = newphrase.charAt(i);
                String charac = Character.toString(temp);
                newphrase = newphrase.replace(charac, ""); // Replaces the whitespace characters with an empty string
            }
        }
        return newphrase;
    }

}
