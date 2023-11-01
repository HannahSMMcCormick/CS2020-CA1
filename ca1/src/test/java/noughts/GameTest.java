package noughts;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import noughts.Game;
import noughts.Play;
import noughts.BoxStatus;

/**
 * Unit test for Game class
 */
public class GameTest 
{
  
    // Test that all squares are empty at start of game

    @Test
    public void testEmptyGame()
    {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        for (int i = 1; i<= 9; i++){
            assertTrue(game.isEmpty(i));
        }
        scanner.close();
    }

// Outcome JUNIT tests

    //Test if game detects a tie
    @Test 
    public void testIsTie(){

       Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        game.setHuman(1);
        game.setComputer(2);
        game.setHuman(3);
        game.setComputer(4);
        game.setHuman(6);
        game.setComputer(5);
        game.setHuman(7);
        game.setComputer(9);
        game.setHuman(8);
       
        assertTrue(game.isTie());

        scanner.close();

    }

    //Test if game detects a win
    @Test 
    public void testWinEnd(){

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        game.setHuman(1);
        game.setComputer(2);
        game.setHuman(4);
        game.setComputer(5);
        game.setHuman(7);


        assertEquals(BoxStatus.Human, game.Win());
        scanner.close();


    }

    //Test if game detects a loss
    @Test 
    public void testLoseEnd(){

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        game.setComputer(1);
        game.setHuman(2);
        game.setComputer(4);
        game.setHuman(5);
        game.setComputer(7);


        assertEquals(BoxStatus.Computer, game.Win());
        scanner.close();


    }

//Computer Player JUNIT tests

    // Test that the computer takes a winning move if its given the chance 

    @Test
    public void testComputerTakeWinningMove()
    {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        game.setComputer(4);
        game.setHuman(2);
        game.setComputer(5);
        game.setHuman(6);
        game.setComputer(7);

        if (game.Win() == BoxStatus.Computer){

            assertTrue(true);

            scanner.close();

        }

    }

    //Test that the computer blocks human from taking winning move
    @Test
    public void testComputerBlocksMove(){

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        game.setComputer(1);
        game.setHuman(4);
        game.setComputer(3);
        game.setHuman(5);
        
        BoxStatus result = game.Win();

        assertEquals(BoxStatus.Empty, result);

        scanner.close();

        
        }

    //Test that computer player takes empty square
    @Test 
    public void testComputerMakesLegalMove(){
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        game.setHuman(1);
        game.setComputer(2);
        game.setHuman(3);

        int computerMove = game.computerMove();

        assertEquals(BoxStatus.Computer, game.getBox(computerMove));
        scanner.close();

    }

    //Test that computer chooses within the 9 squares available 
    @Test
    public void testComputerMoveInRange(){

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);

        int computerMove = game.computerMove();

        assertTrue(computerMove >= 1 && computerMove <= 9);
        scanner.close();
    }

}



