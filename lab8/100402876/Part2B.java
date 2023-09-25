public class Part2B{
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
        String[] arr = {"CPSC 1181", "there is no digit here", "0-0", "cpsc1153-003", "x=1"};
        int multi = findDigits(arr);
        System.out.println("multiplication = " + multi);
    }

    /** Finds the integers in the string in the array and outputs the product of the all the sum of the integers in each string
     * @param arr array passed to find the sums of the digits and find the product of the sums
     * @return the product of all the sums of the digits
     */
    public static int findDigits(String[] arr)
    {
        int product = 1;
        int[] sumarr = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = 0; j < arr[i].length(); j++){ // Goes through each character of the string in the array
                if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9'){ // Checks if its a digit
                    int digit = arr[i].charAt(j) - '0'; // Converts character into digit
                    sum += digit;
                }
            }

            if (sum == 0){ // If sum of the digits is equal to zero, then assume the sum is equal to 1
                sumarr[i] = 1;
            } else sumarr[i] = sum;
        }

        for (int element: sumarr){
            product *= element; // Product of all the sums of the digits
        }

        return product;
    }

}