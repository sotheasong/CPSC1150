import java.util.Scanner;
public class Lab4 {
    /**
     ** Program Name: Lab4
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         June 9, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args) {
        // INITIALIZE BY ASKING THE USER FOR THE COORDINATES OF THE POINTS
        userInput();
    }

    /**
     * This method is used to verify if the user's input of the coordinates are within the range
     * (0,40).
     * @param  x x-coordinate of a point
     * @param  y y-coordinate of a point
     * @return true if the coordinates are between the range (0,40), false if the coordinates are not between the range (0,40)
     */
    public static boolean verify_input (int x, int y)
    {
        if (x >= 0 && y >= 0){
            return x <= 40 && y <= 40;
        } else return false;
    }

    /**
     * This method takes in 4 parameters which are the coordinates of 2 points and returns the
     * distance between these 2 points by using the formula: d=√((x2 – x1)² + (y2 – y1)²).
     * @param  x1 x-coordinate of the first point
     * @param  y1 y-coordinate of the first point
     * @param  x2 x-coordinate of the second point
     * @param  y2 y-coordinate of the second point
     * @return the distance between these points
     */
    public static double distance (int x1, int y1, int x2, int y2)
    {
        double A = Math.pow((x2-x1),2);
        double B = Math.pow((y2-y1),2);
        return Math.sqrt(A+B);
    }

    /**
     * This method takes in 6 parameters which are the coordinates of 3 points and returns the
     * perimeter between these 3 points. The method calls the distance method to calculate the length
     * between each point and add up all the distance between each point and finding the perimeter.
     * @param  xA x-coordinate of the first point
     * @param  yA y-coordinate of the first point
     * @param  xB x-coordinate of the second point
     * @param  yB y-coordinate of the second point
     * @param  xC x-coordinate of the third point
     * @param  yC y-coordinate of the third point
     * @return the perimeter between these points
     */
    public static double perimeter (int xA, int yA, int xB, int yB, int xC, int yC)
    {
        return distance(xA, yA, xB, yB) + distance(xA, yA, xC, yC) + distance(xB, yB, xC, yC);
    }

    /**
     * This method takes in 6 parameters which are the coordinates of 3 points and returns the
     * area between these 3 points. The method calls the perimeter method to calculate the perimeter
     * between each point, and it calls the distance method to calculate the distance between each
     * 2 points. The method calculates the semi perimeter "s" by taking the value of perimeter and
     * dividing by 2. The method then calculates the area of the triangle by using Heron's Formula
     * which is: A = √s(s - a)(s - b)(s - c).
     * @param  xA x-coordinate of the first point
     * @param  yA y-coordinate of the first point
     * @param  xB x-coordinate of the second point
     * @param  yB y-coordinate of the second point
     * @param  xC x-coordinate of the third point
     * @param  yC y-coordinate of the third point
     * @return the perimeter between these points
     */
    public static double area (int xA, int yA, int xB, int yB, int xC, int yC)
    {
        double s = perimeter(xA, yA, xB, yB, xC, yC)/2;
        return Math.sqrt(s * (s - distance(xA, yA, xB, yB)) * (s - distance(xB, yB, xC, yC)) * (s - distance(xA, yA, xC, yC)));
    }

    /**
     * This method is used to prompt the user to input the coordinates of the coordinate of the first
     * point, second point and the second point. It verifies the inputs if they are within the range after
     * each step of asking for the coordinates of each point. It calls the "isLine" method to verify
     * if the points input form a line or not. It then calls the main2 method.
     */
    public static void userInput()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the coordinates of triangle ABC");

        System.out.print("x-coordinate of A: ");
        int xA = input.nextInt();
        System.out.print("y-coordinate of A: ");
        int yA = input.nextInt();
        boolean v1 = verify_input(xA, yA); // VERIFIES THE COORDINATES OF THE THIRD POINT

        System.out.print("x-coordinate of B: ");
        int xB = input.nextInt();
        System.out.print("y-coordinate of B: ");
        int yB = input.nextInt();
        boolean v2 = verify_input(xB, yB); // VERIFIES THE COORDINATES OF THE THIRD POINT

        System.out.print("x-coordinate of C: ");
        int xC = input.nextInt();
        System.out.print("y-coordinate of C: ");
        int yC = input.nextInt();
        boolean v3 = verify_input(xC, yC); // VERIFIES THE COORDINATES OF THE THIRD POINT

        boolean is_line = isLine(xA, yA, xB, yB, xC, yC); // CHECKS IF THE 3 POINTS FORM A LINE
        main2(v1, v2, v3, xA, yA, xB, yB, xC, yC, is_line); // CALLS THE MAIN METHOD
    }

    /**
     * This method takes in 10 parameters which are the coordinates of 3 points and the boolean value of
     * the verification if the coordinates are in the range (0,40) and boolean value of the verification if
     * the points form a line. The method outputs the perimeter and area of the triangle if all the criteria are met.
     * The method also outputs the coordinates that are not in the range and outputs that the points form a line
     * if the points form a line.
     * @param v1 boolean value that shows if the coordinates of the first point is within the range (0,40)
     * @param v2 boolean value that shows if the coordinates of the second point is within the range (0,40)
     * @param v3 boolean value that shows if the coordinates of the third point is within the range (0,40)
     * @param  xA x-coordinate of the first point
     * @param  yA y-coordinate of the first point
     * @param  xB x-coordinate of the second point
     * @param  yB y-coordinate of the second point
     * @param  xC x-coordinate of the third point
     * @param  yC y-coordinate of the third point
     * @param is_line boolean value that shows if the points are on a line or not
     */
    public static void main2(boolean v1, boolean v2, boolean v3, int xA, int yA, int xB, int yB, int xC, int yC, boolean is_line)
    {
        if (v1 && v2 && v3) {
            if (!is_line) {
                // OUTPUTS THE TRIANGLE THE USER HAS INPUT AND OUTPUTS THE FORMULA AND AREA
                System.out.println("Triangle: A(" + xA + ", " + yA + "), B(" + xB + ", " + yB + "), and C(" + xC + ", " + yC + ")");
                double perim = perimeter(xA, yA, xB, yB, xC, yC);
                System.out.println("Perimeter = " + perim);
                double area = area(xA, yA, xB, yB, xC, yC);
                System.out.println("Area = " + area + "\n");
                // CALLS RETRY METHOD TO CHECK IF THE USER WANTS TO RUN THE PROGRAM AGAIN
                retry();
            }
            // IF THE COORDINATES FORM A LINE THEN IT OUTPUTS SAYING THAT IT FORMS A LINE
            else {
                System.out.println("With the coordinates, it forms a line and not a triangle.");
                retry();
            }
            // IF THE COORDINATES OF ALL THE POINTS ARE NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF ALL THE POINTS AND SAYS THAT IT'S NOT IN THE RANGE
        } else if (!v1 && !v2 && !v3) {
            System.out.println("\ncoordinate (" + xA + ", " + yA + ") is not in acceptable range");
            System.out.println("coordinate (" + xB + ", " + yB + ") is not in acceptable range");
            System.out.println("coordinate (" + xC + ", " + yC + ") is not in acceptable range\n");
            retry();
            // IF THE COORDINATES OF THE FIRST AND THIRD ARE POINTS NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF THOSE 2 POINTS AND SAYS THAT IT'S NOT IN THE RANGE
        } else if (!v1 && !v3) {
            System.out.println("\ncoordinate (" + xA + ", " + yA + ") is not in acceptable range");
            System.out.println("coordinate (" + xC + ", " + yC + ") is not in acceptable range\n");
            retry();
            // IF THE COORDINATES OF THE FIRST AND SECOND POINTS ARE NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF THOSE 2 POINTS AND SAYS THAT IT'S NOT IN THE RANGE
        } else if (!v1 && !v2) {
            System.out.println("\ncoordinate (" + xA + ", " + yA + ") is not in acceptable range");
            System.out.println("coordinate (" + xB + ", " + yB + ") is not in acceptable range\n");
            retry();
            // IF THE COORDINATES OF THE FIRST POINT ARE NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF THE POINT AND SAYS THAT IT'S NOT IN THE RANGE
        } else if (!v2 && !v3) {
            System.out.println("\ncoordinate (" + xB + ", " + yB + ") is not in acceptable range");
            System.out.println("coordinate (" + xC + ", " + yC + ") is not in acceptable range\n");
            retry();
            // IF THE COORDINATES OF THE SECOND AND THIRD POINT ARE NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF THE POINT AND SAYS THAT IT'S NOT IN THE RANGE
        } else if (!v2) {
            System.out.println("coordinate (" + xB + ", " + yB + ") is not in acceptable range\n");
            retry();
            // IF THE COORDINATES OF THE SECOND POINT ARE NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF THE POINT AND SAYS THAT IT'S NOT IN THE RANGE
        } else if (!v3) {
            System.out.println("coordinate (" + xC + ", " + yC + ") is not in acceptable range\n");
            retry();
            // IF THE COORDINATES OF THE THIRD POINT ARE NOT WITHIN THE RANGE
            // IT OUTPUTS THE COORDINATES OF THE POINT AND SAYS THAT IT'S NOT IN THE RANGE
        } else {
            System.out.println("\ncoordinate (" + xA + ", " + yA + ") is not in acceptable range");
            retry();
        }
    }

    /**
     * This method takes in 6 parameters which are the coordinates of 3 points and checks if all the points or at least
     * 2 points form a line. The method does this by checking if the slope formed by any 2 points is the same.
     * @param  xA x-coordinate of the first point
     * @param  yA y-coordinate of the first point
     * @param  xB x-coordinate of the second point
     * @param  yB y-coordinate of the second point
     * @param  xC x-coordinate of the third point
     * @param  yC y-coordinate of the third point
     * @return true if these 3 coordinates form a line and not a triangle, false if these 3 coordinates
     * doesn't form a line.
     */
    public static boolean isLine (double xA, double yA, double xB, double yB, double xC, double yC)
    {
        double m1 = (yB - yA)/(xB - xA); // SLOPE OF LINE FORMED BY FIRST POINT
        double m2 = (yC - yA)/(xC - xA); // SLOPE OF LINE FORMED BY SECOND POINT
        double m3 = (yC - yB)/(xC - xB); // SLOPE OF LINE FORMED BY THIRD POINT
        return m1 == m2 || m2 == m3 || m1 == m3; // CHECKS ANY SLOPE IS THE SAME, CONFIRMING THAT IT'S A LINE.
    }

    /**
     * This method asks if the user wants to restart the program by prompting the user to input 1 or 2 (1 to restart the
     * program and 2 to end the program). The method restarts the program by calling the "userInput" method again.
     */
    public static void retry()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to repeat the program (1 for yes, 2 for no)? ");
        int choice = input.nextInt();
        if (choice == 2){
            System.out.println("End of program");
        } else {
            userInput();
        }
    }

}