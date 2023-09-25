public class Quiz8{
    public static void main(String [] args)
    {

        char arr1[] = {'a', 'b', 'c', 'd', 'e'};
        char arr2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char arr3[] = {'a', 'b'};
        char arr4[] = {'a'};


        // Test Cases:
        // Test case 1:
        System.out.println("\ntest Right-Rotate:");
        System.out.println("-------------------");
        System.out.println("Test Case 1:");
        System.out.print("array:  ");
        printArray(arr1);
        rightRotate(arr1,2);
        System.out.print("right rotated n=2:  ");
        printArray(arr1);

        // Test case 2:
        System.out.println("\nTest Case 2:");
        System.out.print("array: ");
        printArray(arr2);
        rightRotate(arr2,4);
        System.out.print("right rotated n=4:  ");
        printArray(arr2);


        // Test case 3:
        System.out.println("\nTest Case 3:");
        System.out.print("array: ");
        printArray(arr3);
        rightRotate(arr3,1);
        System.out.print("right rotated n=1:  ");
        printArray(arr3);

        // Test case 4:
        System.out.println("\nTest Case 4:");
        System.out.print("array: ");
        printArray(arr4);
        rightRotate(arr4,1);
        System.out.print("right rotated n=1:  ");
        printArray(arr4);

        //-----------------------
        char a1[] = {'a', 'b', 'c', 'd', 'e'};
        char a2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char a3[] = {'a', 'b'};
        char a4[] = {'a'};
        // Test Cases:
        // Test case 1:
        System.out.println("\ntest Left-Rotate:");
        System.out.println("-------------------");
        System.out.println("Test Case 1:");
        System.out.print("array:  ");
        printArray(a1);
        leftRotate(a1,2);
        System.out.print("left rotated n=2:  ");
        printArray(a1);

        // Test case 2:
        System.out.println("\nTest Case 2:");
        System.out.print("array: ");
        printArray(a2);
        leftRotate(a2,4);
        System.out.print("left rotated n=4:  ");
        printArray(a2);


        // Test case 3:
        System.out.println("\nTest Case 3:");
        System.out.print("array: ");
        printArray(a3);
        leftRotate(a3,1);
        System.out.print("left rotated n=1:  ");
        printArray(a3);

        // Test case 4:
        System.out.println("\nTest Case 4:");
        System.out.print("array: ");
        printArray(a4);
        leftRotate(a4,1);
        System.out.print("left rotated n=1:  ");
        printArray(a4);
    }

    //--------
    public static void rightRotate(char[] arr, int n)
    {
        // Your code goes here
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length - 1];
                arr[arr.length - 1] = temp;
            }
        }
    }

    //--------
    public static void leftRotate(char[] arr,int n)
    {
        // Your code goes here
        for (int i = 1; i <= n; i++){
            for (int j = arr.length-1; j >= 0; j--){
                char temp = arr[j];
                arr[j] =  arr[0];
                arr[0] = temp;
            }
        }
    }


    //--------
    public static void printArray(char arr[])
    {
        int i;
        for (i=0; i< arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println();
    }
}