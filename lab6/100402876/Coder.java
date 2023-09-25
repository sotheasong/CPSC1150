import java.util.Scanner;
public class Coder {
    /**
     ** Program Name: Coder
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         June 24, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args) 
    {
        char[] msg;
        int key;
        Scanner input = new Scanner(System.in);
        msg = getMsg(input); // Read the message from keyboard
        key = getKey(input);
        System.out.println("Key : "+key);

        String stringMsg = "";
        for (int k = 0; k < msg.length; k++)
            stringMsg += msg[k];

        String encryptedMsg = encrypt(stringMsg, key);
        String binaryMsg = "";
        // Appends the binary message into one string
        for (int i = 0; i < encryptedMsg.length(); i++){
            binaryMsg += ascii2binary(encryptedMsg.charAt(i)); // Turns each character in the string into binary and gets appended
        }
        System.out.println("Output: " + binaryMsg); // Outputs the binary message
    }

    /**
     * Encrypts the message using the key
     * @param msg message to be encrypted
     * @param key how many position t the right the original letter moves to
     *            (For example if cipher key is equal to 5, then A will change to F, B will change to G, ..., U will change to
     *              Z, V to A, W to B)
     * @return encrypted message
     */
    public static String encrypt(String msg, int key){
        String ecrMsg = "";
        
        for (int i = 0; i < msg.length(); i++){
            int temp = msg.charAt(i);
            // Checks for upper case
            if(temp >= 'A' && temp <= 'Z') {
                ecrMsg += (char)(((temp + key - 'A') % ('Z' - 'A' + 1)) + 'A');
                // Formula to add the char and the key, and if the ASCii value of the encrypted key is passed 'Z'
                // (the length from 'A' to 'Z') then the value of the first character 'A' is added to it.
            }
            // Checks if lowercase
            else if(temp >= 'a' && temp <= 'z') {
                ecrMsg += (char)(((temp + key - 'a') % ('z' - 'a' + 1)) + 'a');
                // Formula to add the char and the key, and if the ASCii value of the encrypted key is passed 'z'
                // (the length from 'a' to 'z') then the value of the first character 'a' is added to it.
            }
            // Checks if digit
            else if(temp >= '0' && temp <= '9') {
                ecrMsg += (char)(((temp + key - '0') % ('9' - '0' + 1)) + '0');
                // Formula to add the char and the key, and if the ASCii value of the encrypted key is passed '9'
                // (the length from '0' to '9') then the value of the first character '9' is added to it.
            }
            else ecrMsg += (char)temp;
            // If its not a letter or a digit then the character is added straight into the encrypted message string.
        }
        return ecrMsg;
    }

    /**
     * Converts the input in integer into binary.
     * @param n The passed integer value to be converted into binary
     * @return string of binary converted from the integer
     */
    public static String ascii2binary(int n){
        // The encrypted character is first passed as their ascii value (integer) then its converted to binary.
        String convBinary = Integer.toBinaryString(n);

        // Adds zeros if the length of the binary length is less than 8
        if (convBinary.length() < 8){
            for (int i = 0; i <= 8 - convBinary.length(); i++)
                convBinary = "0" + convBinary;
        }
        return convBinary;
    }

    /** Read a line of message from keyboard and return it as an array of char
     @return Array of characters
     */
    public static char[] getMsg(Scanner input){
        String myMessage;
        System.out.print("Input Message: ");
        myMessage = input.nextLine();// Read a line of message
        return myMessage.toCharArray();
    }

    /** Read an integer from keyboard and return it
     @return key
     */
    public static int getKey(Scanner input){
        System.out.print("Input Key: ");
        return input.nextInt();
    }
}
