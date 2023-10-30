/*
 * Game.java
 *
 * Represents a game of noughts and crosses
 */

package noughts;

import java.util.ArrayList;
import java.util.List;
//Tidy later
/**
 *
 * @author ereiter
 */
public class Game {
    
    BoxStatus[] board = new BoxStatus[9];  // board contains 9 boxes
    
    /** Creates a new instance of game */
    public Game() {
        for(int i = 0; i<9; i++)
            board[i] = BoxStatus.Empty;  // initially each box is empty (not taken)
        
    }
    
    public boolean isEmpty(int n) {
        // is a box empty?
        return (board[n-1] == BoxStatus.Empty);
    }
    
    public boolean isComputer(int n) {
        // is a box taken by the Computer?
        return (board[n-1] == BoxStatus.Computer);
    }
    
    public boolean isHuman(int n) {
        // is a box taken by the Human?
        return (board[n-1] == BoxStatus.Human);
    }
    
//Mentioned in Play.java 
    public void setHuman(int n) {
        // human claims square N
        board[n-1] = BoxStatus.Human;
    }
    
    public void setComputer(int n) {
        // computer claims square N
        board[n-1] = BoxStatus.Computer;
    }
    
    public BoxStatus getBox(int n) {
        // return square N
        return board[n-1];
    }

    public BoxStatus Win(){

        //Checking for winning combinations 

        //Check rows for matches

        for (int i = 0; i < 9; i += 3){

            if (getBox(i+1) != BoxStatus.Empty &&
            getBox(i+1) == getBox(i+2) &&
            getBox(i+2) == getBox(i+3)){

                return

                getBox(i+1);

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

        // check diagonal for matches

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

    public char boxChar(int n) {
        // return a character which shows whether a square is empty, taken by the computer, or taken by the human
        switch (board[n-1]) {
            case Human: return 'H';
            case Computer: return 'C';
            case Empty: return '.';
        }
        return ' ';
    }

    public void printBoard() {
        // print the noard on System.out
        System.out.println("Board");
        System.out.printf("| %c %c %c |\n", boxChar(1), boxChar(2), boxChar(3));
        System.out.printf("| %c %c %c |\n", boxChar(4), boxChar(5), boxChar(6));
        System.out.printf("| %c %c %c |\n", boxChar(7), boxChar(8), boxChar(9));
    }
    
}
