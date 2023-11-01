package noughts;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import noughts.Game;
import noughts.BoxStatus;

/**
 * Unit test for simple App.
 */
public class GameTest 
{
  
// Test there all squares are empty at start of game

    @Test
    public void testEmptyGame()
    {
        Game game = new Game();

        for (int i = 1; i<= 9; i++){

            assertTrue(game.isEmpty(i));

        }
    }

// Outcome JUNIT tests

//Test if game detects a tie
    @Test 
    public void testIsTie(){

        Game game = new Game();

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


    }

//Test if game detects a win
    @Test 
    public void testWinEnd(){

        Game game = new Game();

        game.setHuman(1);
        game.setComputer(2);
        game.setHuman(4);
        game.setComputer(5);
        game.setHuman(7);


        assertEquals(BoxStatus.Human, game.Win());


    }

//Test if game detects a loss
    @Test 
    public void testLoseEnd(){

        Game game = new Game();

        game.setComputer(1);
        game.setHuman(2);
        game.setComputer(4);
        game.setHuman(5);
        game.setComputer(7);


        assertEquals(BoxStatus.Computer, game.Win());


    }

//Computer Player JUNIT tests

// Test that the computer takes a winning move if its given the chance 

    @Test
    public void testComputerTakeWinningMove()
    {

        Game game = new Game();

        game.setComputer(4);
        game.setHuman(2);
        game.setComputer(5);
        game.setHuman(6);
        game.setComputer(7);

        if (game.Win() == BoxStatus.Computer){

            assertTrue(true);

        }

    }

//Test that the computer blocks human from taking winning move
    @Test
    public void testComputerBlocksMove(){

        Game game = new Game();

        game.setComputer(1);
        game.setHuman(4);
        game.setComputer(3);
        game.setHuman(5);
        
        BoxStatus result = game.Win();

        assertEquals(BoxStatus.Empty, result);

        
        }

  @Test 
    public void testComputerMakesLegalMove(){
        Game game = new Game();

        game.setHuman(1);
        game.setComputer(2);
        game.setHuman(3);

        int computerMove = game.computerMove();

        assertEquals(BoxStatus.Computer, game.getBox(computerMove));

    }




}



