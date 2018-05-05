package connect.four.tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import connect.four.board.Board;
import connect.four.player.ComputerPlayer;

public class BoardTest {

  static Board defaultBoard = new Board(7, 6);
  static Board smallBoard = new Board(5, 4);
  static Board emptyBoard = new Board(0, 0);
  
  static ComputerPlayer cp; 
  static ComputerPlayer cpOpponent; 

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    defaultBoard = null;
    smallBoard = null;
    emptyBoard = null;
  }
  
  @After
  public void tearDown() throws Exception { 
    cp = null;
    cpOpponent = null;
  }

  @Test
  public void defaultBoardTest() {
    cp = new ComputerPlayer();
    cpOpponent = new ComputerPlayer();
    
    try {
      for (int x = 0; x < 21; x++) { //test with all 42 spots
        cp.performPlay(defaultBoard);
        assertTrue(defaultBoard.getMoveCount() == (2 * x + 1));
        cpOpponent.performPlay(defaultBoard);
        assertTrue(defaultBoard.getMoveCount() == (2 * x + 2));
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getMessage());
    }
    
    try {
      defaultBoard.clear();      
    } catch (Exception e) {
      e.printStackTrace();
    }  
    assertTrue(defaultBoard.getMoveCount() == 0);
  }
  
  @Test
  public void smallBoardTest() {
    cp = new ComputerPlayer(4);
    cpOpponent = new ComputerPlayer(4);
    
    try {
      for (int x = 0; x < 10; x++) { //test with all 20 spots
        cp.performPlay(smallBoard);
        assertTrue(smallBoard.getMoveCount() == (2 * x + 1));
        cpOpponent.performPlay(smallBoard);
        assertTrue(smallBoard.getMoveCount() == (2 * x + 2));
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getMessage());
    }
  }

  @Test
  public void emptyBoardTest() {
    cp = new ComputerPlayer();
    cpOpponent = new ComputerPlayer(0);
    
    try {
      for (int x = 0; x < 1; x++) { //test with all 42 spots
        cp.performPlay(emptyBoard);
        assertFalse(emptyBoard.getMoveCount() == (2 * x + 1));
        cpOpponent.performPlay(emptyBoard);
        assertFalse(emptyBoard.getMoveCount() == (2 * x + 2));
      }
    } catch (Exception e) {
      e.printStackTrace();
      assertTrue("Exception has been thrown as needed.", true);
    }
  }
}
