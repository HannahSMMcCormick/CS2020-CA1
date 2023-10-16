/*
 * Play.java
 *
 * Play a game of noughts and crosses
 * includes main method
 */
 
 package noughts;

import java.util.Scanner;
// import java.util.Random;? for computer move

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
            
            while (true) { // infinite loop
                game.printBoard(); // print board
            //Choose player or computer?
                playerTurn(); // human turn
                computerTurn(); // computer tuen
        }
    }
    public void playerTurn()  {
        // Player turn: just read in a sqaure and claim it for human
        System.out.print("Take a square (1-9): ");
                // Reading data using readLine
        int square = input.nextInt();
        //check validility 
        game.setHuman(square);
    }

    public void computerTurn() {
        // computer turn - currently does nothing other than print out a message
        System.out.println("Computer is thinking");
        // I think i need to put in logic for computer turn use player as reference
        //remember rules for save and win
    }
}

