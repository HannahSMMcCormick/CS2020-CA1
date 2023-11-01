package noughts;

import java.util.Scanner;


public class Play{
    Game game;   // the noughts and crosses game
    Scanner input;

     // main method - just create a Play object
        public static void main(String[] args) {
            new Play();
        }

        public Play () {
            System.out.println("Welcome to noughts and crosses"); 
            game = new Game(new Scanner(System.in));  // create game board
            input = new Scanner(System.in);  // Scanner for user input
            int TurnCounter = 0;

            String Player;
            do {
            System.out.println("Please choose who will go first, 'c' = Computer or 'h' = Human");
            Player = input.nextLine().toLowerCase();

            }while (!Player.equals("c") && !Player.equals("h"));

            game.printBoard(); // print board

            do{
                //Check for a tie if all squares filled
                if (TurnCounter == 9) {
                    if (game.isTie()){
                    System.out.println("This game is a tie");
                    }
                    break;
                }


                if (Player.equals("h")){
                    playerTurn(); // human's turn
                    Player = "c";
                    game.printBoard(); // print board
                }else if (Player.equals("c")){
                    computerTurn(); // computer's turn
                    Player = "h";
                    game.printBoard(); // print board
                }

               BoxStatus Win = game.Win();

                if (Win == BoxStatus.Human){ 
                    System.out.println("You Win, Congratulations :)");
                    break;
                }else if  (Win == BoxStatus.Computer){
                    System.out.println("You Lose, Better Luck Next Time :(");
                    break;
                }

                TurnCounter++;
            }while(true);  
        }
    
    //Human's turn
    public void playerTurn()  {
        System.out.println("Chooses a square between 1-9");
      int square = game.humanMove(0);
    }

    //computer's turn
    public int computerTurn() {
        System.out.println("Computer is thinking");
        int square = game.computerMove();
        return square; //return square for JUNIT test

}

}
