//Tidy later

 /*
 * Play.java
 *
 * Play a game of noughts and crosses
 * includes main method
 */
 
 package noughts;

import java.util.Scanner;
import java.util.Random; //for computer move

class Play{
    Game game;   // the noughts and crosses game
    Scanner input;

        public static void main(String[] args) {
            // main method - just create a Play object
            new Play();
        }

        public Play () {
            // constructor
            System.out.println("Welcome to noughts and crosses"); 
            game = new Game();  // create game board
            input = new Scanner(System.in);  // Scanner for user input
            int TurnCounter = 0;

            Scanner input = new Scanner(System.in);

            System.out.println("Please choose who will go first, 'c' = Computer or 'h' = Human");

            String Player = input.nextLine();

            game.printBoard(); // print board

            do{

                // might have to change this once implement win/loss logic

                if (TurnCounter == 9) {

                    System.out.println("This game is a tie");

                    break;
                }

                if (Player.equals("h")){
                    playerTurn(); // human turn
                    Player = "c";
                    game.printBoard();

                }else if (Player.equals("c")){
                    computerTurn(); // computer turn
                    Player = "h";
                    game.printBoard();
                }

               BoxStatus Win = game.Win();

                if (Win == BoxStatus.Human)

                { 
                    System.out.println("You Win, Congratulations :)");
                    break;
                }else if  (Win == BoxStatus.Computer)
                
                {
                    System.out.println("You Lose, Better Luck Next Time :(");
                    break;
                }

                TurnCounter++;
            }while(true);  
        }
    
    public void playerTurn()  {

        int square;

        do{
        // Player turn: just read in a sqaure and claim it for human
        System.out.print("Take a square (1-9): ");
                // Reading data using readLine
        square = input.nextInt();
        //check validility 

        //Checks if human chooses an existing square
        if
        (square < 1 || square >9) {

            System.out.println("Please enter a valid input between 1 and 9");
               
        }
        //Checks if human chooses an already tooken square 
        else if
     
        (game.getBox(square)!= BoxStatus.Empty){

            System.out.println("Square already taken, please take empty square");

        } else{

            break;
        }
        
        } while (true);

        game.setHuman(square);

    
    }

    public void computerTurn() {
        // computer turn - currently does nothing other than print out a message
        System.out.println("Computer is thinking");


        //Only check for win/loose/Block from turn 4 
        //if 
        //(i>=4)


        Random random = new Random();
        int square;

        do {

            square = random.nextInt(9)+1;
        // I think i need to put in logic for computer turn use player as reference
        //remember rules for save and win
    }while (game.getBox(square)!= BoxStatus.Empty);

    game.setComputer(square);

    }

}

