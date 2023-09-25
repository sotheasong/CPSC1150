public class Quiz4{
    public static void main (String[] args){
        int n = 99;
        double y=0;

        // Your code goes here

        for (int i = n; i>=3; i = i-2){
            for (double j = i; j>=3; j = j-2){
                y += (j-2)/j;
            }
            System.out.println("n = " + i + " ,y = " + y);
            y=0;
        }
    }
}