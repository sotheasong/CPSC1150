public class Lab7 {
    /**
     ** Program Name: Lab 7
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         July 1, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        int size = 10;
        int lowerBound = -20;
        int upperBound = 10;
        int [] arr = initialize(size, lowerBound, upperBound);

        System.out.print("array: \t\t");
        printArray(arr); // Takes an array of integers as argument and prints the contents of the array in a line separated by space.

/*        System.out.print("reversed: \t");
        reverse(arr); // Reverse contents of the given array

        System.out.print("sorted: \t");
        sort(arr); // Sort content of the given array in ascending order*/

        System.out.println("count: \t");
        count(arr); // Counts how many times each number occurred in the array, and then print the result without repeating the elements.

        // Insert number, int n, at index location of the array of int[] arr.
        boolean inserted = insert(arr, 5, -1);
        if (inserted){
            System.out.print("inserted: \t");
            printArray(arr);
        } else System.out.println("Element is not inserted into array.");

        int[] uniqueArr = unique(arr);
        System.out.print("unique: \t");
        printArray(uniqueArr);
    }

    /** Creates an array of integers with length equal to size, initialize the content of the array to random
     integer numbers in range [lowerBound to upperBound], and returns the reference of the array
     * @param size size of the array
     * @param lowerBound the minimum that the number in the array can be
     * @param upperBound the maximum value that the number in the array can be
     * @return arr that is created using the lower and upper bounds
     */
    public static int[] initialize(int size, int lowerBound, int upperBound)
    {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(lowerBound + Math.random() * (upperBound - lowerBound + 1)); // Formula to generate a random number between the lower and upperbound
        }
        return arr;
    }

    /** Takes an array of integers as argument and prints the contents of the array in a line separated by
     space
     * @param arr array to be printed and outputted
     */
    public static void printArray(int[] arr)
    {
        for (int element : arr){
            System.out.print(element + ", ");
        }
        System.out.println("\b\b");
    }

    /** Reverse contents of the given array of integers without using a temporary array
     * @param arr array to be reversed
     */
    public static void reverse(int[] arr)
    {
        int j = arr.length-1;
        // Starts reversing the array reversing the first element and the last element and continues on until everything is reversed (halfway through the array)
        for (int i = 0; i < arr.length/2; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        printArray(arr);
    }

    /** Sort content of the given array in ascending order (smallest to largest order).
     * @param arr array to be sorted
     */
    public static void sort(int[] arr)
    {
        int temp;
        // Uses bubble sort to sort through everything
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length; j++){
                if (arr[j-1] > arr[j]){ // The element before arr[j] is bigger then we swap the 2 elements
                                        // We continue doing this until every element in the array is sorted
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        printArray(arr);
    }

    /** Counts how many times each number occurred in the array, and then print the result without
     repeating the elements.
     * @param arr array to be counted of how each element occur in the array
     */
    public static void count(int[] arr)
    {
        int[] visited = new int[arr.length];
        int visit = -1;

        for (int i = 0; i < arr.length; i++){
            int count = 1;
            // Goes through every element in the array after arr[i] and checks if it's the same. If it's the same then it
            // increments count which counts how time elements appears and replaces the elements counted with -1.
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    count++;
                    visited[j] = visit;
                }
            }
            // If the element to be counted isn't in the visited array then it's assigned into the array with count which
            // say show many times the element appears in the array.
            if (visited[i] != visit)
                visited[i] = count;
            // For example : array: 17, 11, 18, 14, 19, 19, 18, 11, 14, 14
            //               visited array: 2, -1, 3, -1, -1, 1, 2, -1, 2, -1
            //                              (11)   (14)     (17) (18)  (19)
            // 11 occurs = 2
            // 14 occurs = 3
            // 17 occurs = 1
            // 18 occurs = 2
            // 19 occurs = 2
        }

        // Prints the amount of times the element occurs
        for (int k = 0; k < visited.length; k++){
            if (visited[k] != visit)
                System.out.println(arr[k] + " occurs = " + visited[k]);
        }
    }

    /** Insert number, int n, at index location of the array of int[] arr. The elements after the index should be
     shifted to right, and the last element should be dumped. The method returns true in case of success,
     and false in case of failure
     * @param arr array for the element to be inserted into
     * @param n element to be inserted
     * @param index index where the element is inserted
     * @return true if the element can be inserted, false if there's no space for the element to be inserted into.
     */
    public static boolean insert(int[] arr, int n, int index)
    {
        int l = arr.length;
        if (index < l && index >= 0) { // Checks if index is within the range of the length of the array
            arr[l-1] = n; // Sets the last index to be the element to be inserted
            // Right reverse the element to be inserted which is in the last index until it is in the right index
            for (int i = index; i < l; i++){
                int temp = arr[i];
                arr[i] = arr[l-1];
                arr[l-1] = temp;
            }
            return true;
        } else return false;
    }

    /** Takes an array of integers as its argument, and returns elements of the array as unique elements.
     * @param arr array to be counted and only appends non duplicates of the array it into a new array
     * @return array with non duplicates
     */
    public static int[] unique(int[] arr)
    {
        // Creates the length of the new array with amount of elements aren't the same
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int j;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;
            if (i == j)
                count++;
        }
        int[] newarr = new int[count];

        // Appends elements that aren't the same into the new array.
        int n = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int j;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;
            if (i == j) {
                newarr[n] = arr[i];
                n++;
            }
        }

        // Sort the array
        int temp;
        for (int i = 0; i < newarr.length; i++){
            for (int j = 1; j < newarr.length; j++){
                if (newarr[j-1] > newarr[j]){
                    temp = newarr[j-1];
                    newarr[j-1] = newarr[j];
                    newarr[j] = temp;
                }
            }
        }

        return newarr;
    }
}