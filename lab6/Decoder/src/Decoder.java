import java.util.Scanner;
public class Decoder {
    /**
     ** Program Name: Decoder
     ** Author:       Sothea Song
     ** ID:           100402876
     ** Date:         June 24, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Message : ");
        String binMsg = input.nextLine();
        System.out.print("Input key : ");
        int key = input.nextInt();

        String decryptedMsg = decryptMsg(binMsg, key);
        System.out.println("Original Message : " + decryptedMsg);
    }

    /**
     * Decrypts the encrypted message into its original message
     * @param binMsg encrypted message (in binary)
     * @param key key used to move the encrypted message back to the left
     * @return decrypted string message
     */
    private static String decryptMsg(String binMsg, int key) {
        String decrypted = "";
        String[] binarySegments = binMsg.split("(?<=\\G.{8})"); // Splits the binary into segments of 8 and append into an array

        // Convert the segments into ASCii value
        for (String element : binarySegments) {
            int ch = Integer.parseInt(element, 2); // Converts the segments of binary into integer
                                                        // Radix 2 returns each element in the array into binary
           // Checks if its uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch -= key;
                if (ch < 'A') { // Checks if after decrypted character ascii value is less than the ascii value of the
                                // smallest uppercase.
                    ch = 'Z' - ('A' - ch) + 1; // Turns the character back into an uppercase character
                }
            }
            // Checks if its lowercase
            else if (ch >= 'a' && ch <= 'z') {
                ch -= key;
                if (ch < 'a') { // Checks if after decrypted character ascii value is less than the ascii value of the
                                // smallest lowercase character.
                    ch = 'z' - ('a' - ch) + 1; // Turns the character back into a lowercase character
                }
            }
            // Checks if its a digit
            else if (ch >= '0' && ch <= '9' ) {
                ch -= key;
                if (ch < '0') { // Checks if after decrypted character ascii value is less than the ascii value of the
                                // smallest digit character.
                    ch = '9' - ('0' - ch) + 1; // Turns the character back into a digit character
                }
            }
            decrypted += (char)(ch); // Appends the decrypted message into a string
        }
        return decrypted;
    }

}