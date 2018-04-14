package connect.four.tests;

import connect.four.board.Board;
import connect.four.player.RandomPlayer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class RandomPlayerTest {
  static Board defaultBoard = new Board(6, 6);
  static Board largeBoard = new Board(10, 10);
  static Board emptyBoard = new Board(0, 0);
  
  static RandomPlayer rp; 
  static RandomPlayer rpOpponent; 
  static RandomPlayer rpEmpty;

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    defaultBoard = null;
    largeBoard = null;
    emptyBoard = null;
  }

  @After
  public void tearDown() throws Exception {
    rp = null;
    rpOpponent = null;
    rpEmpty = null;
  }

  @Test
  public void performDefaultPlayTest() {
    rp = new RandomPlayer();
    rpOpponent = new RandomPlayer();
    
    rp.performPlay(defaultBoard);
    assertTrue(defaultBoard.getMoveCount() == 1);
    rpOpponent.performPlay(defaultBoard);
    assertTrue(defaultBoard.getMoveCount() == 2);
  }
  
  @Test
  public void performLargePlayTest() {
    rp = new RandomPlayer();
    rpOpponent = new RandomPlayer();
    
    rp.performPlay(largeBoard);
    assertTrue(largeBoard.getMoveCount() == 1);
    rpOpponent.performPlay(largeBoard);
    assertTrue(largeBoard.getMoveCount() == 2);
  }
  
  @Test
  public void performEmptyPlayTest() {
    rp = new RandomPlayer();
    rpOpponent = new RandomPlayer();
    
    try {
      rpEmpty.performPlay(emptyBoard);
      fail("rp empty to empty board");
    } catch (Exception e) {
      assertTrue(emptyBoard.getMoveCount() == 0);
    }  
    
    try {
      rp.performPlay(emptyBoard);
      fail("rp default to empty board");
    } catch (Exception e) {
      assertTrue(emptyBoard.getMoveCount() == 0);
    } 
  }

}
