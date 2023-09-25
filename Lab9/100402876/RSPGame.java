import java.util.Scanner;
import java.util.Random;
public class RSPGame {
    /**
     ** Program Name: RSPGame
     ** Author:       Sothea Song
     ** Id:           100402876
     ** Date:         July 13, 2023
     ** Course:       CPSC 1150
     ** Compiler:     JDK 1.8
     */
    public static void main(String[] args)
    {
        boolean playing = true;
        int i = 1;

        while(playing){
            System.out.print("Round " + i + ": ");
            System.out.print("Select rock (0), scissor (1), or paper (2): ");
            Scanner input = new Scanner(System.in);
            int user_move = input.nextInt();
            int computer_move = game();
            if (user_move == 0){ // If user input is rock
                if (computer_move == 0){ // The computer is rock
                    System.out.println("The computer is rock. You are rock too. It is draw.");
                } else if (computer_move == 1){ // The computer is scissor
                    System.out.println("The computer is scissor. You are rock. You won!");
                } else if (computer_move == 2){ // The computer is paper
                    System.out.println("The computer is paper. You are rock. Computer won!");
                }
            }
            else if (user_move == 1){ // If user input is scissor
                if (computer_move == 0){ // The computer is rock
                    System.out.println("The computer is rock. You are scissor. Computer won!.");
                } else if (computer_move == 1){ // The computer is scissor
                    System.out.println("The computer is scissor. You are scissor too. It is draw.");
                } else if (computer_move == 2){ // The computer is paper
                    System.out.println("The computer is paper. You are scissor. You won!");
                }
            }
            else if (user_move == 2){ // If user input is paper
                if (computer_move == 0){ // The computer is rock
                    System.out.println("The computer is rock. You are paper. You won!");
                } else if (computer_move == 1){ // The computer is scissor
                    System.out.println("The computer is scissor. You are paper. Computer won!");
                } else if (computer_move == 2){ // The computer is paper
                    System.out.println("The computer is paper. You are paper. It is draw.");
                }
            } else if (user_move == -1){ // Ends program
                System.out.println("Program terminated.");
                playing = false;
            } else { // For other inputs
                System.out.println("Invalid input.");
            }
            System.out.println();
            i++;
        }
    }

    /**
     * Used to generate a random integer between 0-2
     * @return a random integer between 0-2
     */
    public static int game(){
        Random random = new Random();
        return random.nextInt(3);
    }

}