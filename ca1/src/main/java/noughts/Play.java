//Tidy later

 /*
 * Play.java
 *
 * Play a game of noughts and crosses
 * includes main method
 */
 
package noughts;
import java.util.Scanner;


class Play{

    Game game;   // the noughts and crosses game
    Scanner input;

     // main method - just create a Play object

        public static void main(String[] args) {
           
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

                if (TurnCounter == 9) {
                    if (game.isTie()){
                    System.out.println("This game is a tie");
                    }
                    break;
                }


                if (Player.equals("h")){
                    playerTurn(); // human turn
                    Player = "c";
                    game.printBoard(); // print board

                }else if (Player.equals("c")){
                    computerTurn(); // computer turn
                    Player = "h";
                    game.printBoard(); // print board
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

    public int computerTurn() {

        System.out.println("Computer is thinking");

        int square = game.computerMove();

        return square;

}



}
