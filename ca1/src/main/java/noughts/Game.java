/*
 * Represents a game of noughts and crosses
 */

package noughts;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    BoxStatus[] board = new BoxStatus[9];  // board contains 9 boxes
    private Scanner input;


    public Game(Scanner input) {
        this.input = input;
        for(int i = 0; i<9; i++){
            board[i] = BoxStatus.Empty;  // initially each box is empty (not taken)
        }
    }

    // Checks if a box is empty
    public boolean isEmpty(int n) {
        return (board[n-1] == BoxStatus.Empty);
    }
    
    //Checks if box is taken by computer player
    public boolean isComputer(int n) {
        return (board[n-1] == BoxStatus.Computer);
    }
    
    //Checks if box is taken by human player
    public boolean isHuman(int n) {
        return (board[n-1] == BoxStatus.Human);
    }
    
    //Sets square to human piece
    public void setHuman(int n) {
        board[n-1] = BoxStatus.Human;
    }
    
    //Sets square to computer piece
    public void setComputer(int n) {
        board[n-1] = BoxStatus.Computer;
    }
    
    /*
    * Sets square back to empty
    * Used in computerMove to reset prediction
    * in winning/blocking
    */
    public void setBoxEmpty(int n){
        //set box to empty
        board[n-1] = BoxStatus.Empty;

    }

    /*
    *Gives status of box
    * is human/computer
    */
    public BoxStatus getBox(int n) {
        // return square N
        return board[n-1];
    }

    //Used to check and show that game has resulted in tie
    public boolean isTie(){

        for (int i = 1; i <= 9; i++){

            if (isEmpty(i)){

            return false;
            }

        }

        return Win() == BoxStatus.Empty;

    }


//Checking for winning combinations 

    public BoxStatus Win(){

        //Check rows for matches

        for (int i = 0; i < 9; i += 3){

            if (getBox(i+1) != BoxStatus.Empty &&
            getBox(i+1) == getBox(i+2) &&
            getBox(i+2) == getBox(i+3)){

                return getBox(i+1);
            }  
        }

        //check columbs for matches

        for (int i = 1; i <= 3; ++i){

            if (getBox(i) != BoxStatus.Empty &&
            getBox(i) == getBox(i+3) &&
            getBox(i+3) == getBox(i+6)){

                return getBox(i);
            }
        }

        // check diagonals for matches

        if (getBox(1) != BoxStatus.Empty &&
        getBox(1) == getBox(5) &&
        getBox(5) == getBox(9)){

            return getBox(1);
        }

        if (getBox(3) != BoxStatus.Empty &&
        getBox(3) == getBox(5) &&
        getBox(5) == getBox(7)){

            return getBox(3);
        }


        return BoxStatus.Empty;

    }
    
    //Computer move rules
    public int computerMove(){

        int square = -1;


    // Win
        for (int i = 1; i <= 9; i++){

            if(isEmpty(i)){

                setComputer(i);

                if (Win() == BoxStatus.Computer){

                    square = i;
                    break;    

                }else{

                    setBoxEmpty(i);

                } 
            }

            }


    //Block
            if (square == -1){

                for (int i = 1; i <= 9; i++){

                        if(isEmpty(i)){

                            setHuman(i);

                            if (Win() == BoxStatus.Human){

                                square = i; 
                                setComputer(i);
                                break;

                            }else{

                                setBoxEmpty(i);

                            } 
                        }

                        }
        
            }

    // if no winning or blocking move 
        if (square == -1){
        Random random = new Random();
        do {

            square = random.nextInt(9)+1;
        
        }while (getBox(square)!= BoxStatus.Empty);

            setComputer(square);

    }


   return square;

}

    //Human move rules
    public int humanMove(int square){
        

        do{
        System.out.print("Take a square (1-9): ");
        square = input.nextInt();
    
        //Validate choosing valid input
        if(square < 1 || square >9) {
            System.out.println("Please enter a valid input between 1 and 9");
        }else if (getBox(square)!= BoxStatus.Empty){
            System.out.println("Square already taken, please take empty square");
        }else{
            break;
        }
    } while (true);

        setHuman(square);

        return square;

    }


    //Used to show if square is occupied by human/computer or empty
    public char boxChar(int n) {
        switch (board[n-1]) {
            case Human: return 'H';
            case Computer: return 'C';
            case Empty: return '.';
        }
        return ' ';
    }

    //Prints board
    public void printBoard() {
        System.out.println("Board");
        System.out.printf("| %c %c %c |\n", boxChar(1), boxChar(2), boxChar(3));
        System.out.printf("| %c %c %c |\n", boxChar(4), boxChar(5), boxChar(6));
        System.out.printf("| %c %c %c |\n", boxChar(7), boxChar(8), boxChar(9));
    }
    
}
