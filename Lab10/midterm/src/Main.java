public class Main {
    public static void main(String[] args)
    {
        int[] arr = {-12, -1, 5, 8, 12, 19, 21, 23, 34};
        int index = insertElement(arr, 13);
        System.out.println(index);
    }

    public static int insertElement(int[] arr, int m)
    {
        int temp = 0;
        boolean inserted = false;
        int index = 0;
        for (int i = 0; i<arr.length; i++){
            if (!inserted) {
                if (m <= arr[i]) {
                    for (int j = i + 1; j < arr.length-1; j++) {
                        arr[j] = arr[j-1];
                        arr[j+1] = arr[j-1];
                    }
                    arr[i] = m;
                    index = i;
                    inserted = true;
                    break;
                }
            }
        }
        for (int e: arr){
            System.out.print(e + " ");
        }
        System.out.println();
        if (inserted){
            return index;
        } else return -1;
    }

}