package connect.four.tests;

import connect.four.board.Board;
import connect.four.player.ComputerPlayer;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

public class ComputerPlayerTest {

  static Board defaultBoard = new Board(6, 6);
  static Board largeBoard = new Board(10, 10);
  static Board emptyBoard = new Board(0, 0);
  
  static ComputerPlayer cp; 
  static ComputerPlayer cpOpponent; 
  static ComputerPlayer cpEmpty; 

  @After
  public void tearDown() throws Exception {
    cp = null;
    cpOpponent = null;
    cpEmpty = null;
  }
  
  @Test
  public void performDefaultPlayTest() {
    cp = new ComputerPlayer();
    cpOpponent = new ComputerPlayer();
    
    cp.performPlay(defaultBoard);
    assertTrue(defaultBoard.getMoveCount() == 1);
    cpOpponent.performPlay(defaultBoard);
    assertTrue(defaultBoard.getMoveCount() == 2);
  }
  
  @Test //10x10, but takes 20secs
  public void performLargePlayTest() {
    cp = new ComputerPlayer(10);
    cpOpponent = new ComputerPlayer();
    
    cp.performPlay(largeBoard);
    assertTrue(largeBoard.getMoveCount() == 1);
    cpOpponent.performPlay(largeBoard);
    assertTrue(largeBoard.getMoveCount() == 2);
  }
  
  @Test
  public void performEmptyPlayTest() {
    cp = new ComputerPlayer();
    cpEmpty = new ComputerPlayer(0);
    
    try {
      cpEmpty.performPlay(emptyBoard);
      fail("cp empty to empty board");
    } catch (Exception e) {
      assertTrue(emptyBoard.getMoveCount() == 0);
    }  
    
    try {
      cp.performPlay(emptyBoard);
      fail("cp default to empty board");
    } catch (Exception e) {
      assertTrue(emptyBoard.getMoveCount() == 0);
    }  
  }
  
}
