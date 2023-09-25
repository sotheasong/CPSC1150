public class Quiz3{
    public static void main(String[] args){
        int n=50;
        double x = 10;
        double y=0, z=0;

        // your code
        for (double i=1; i<=n; i++){
            y += i/(i+1);
        }

        for (int j=1; j<=n; j++){
            z += (x+j)/Math.pow(x,j);
        }

        System.out.println("y = "+ y);
        System.out.println("z = "+ z);
    }
}