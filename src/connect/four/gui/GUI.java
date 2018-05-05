/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;
import javax.swing.*;

/**
 * This class initializes the GUI for the game.
 */
public class GUI extends JFrame {
  private static boolean isDevBuild;  
  MainMenuPanel mainMenu;
  GamePanel gamePanel;
  GameOverPanel gameOverPanel;
  String p1Name;
  String p2Name;
  String winner;
  static int score1 = 0;
  static int score2 = 0;
  static int wins1 = 0;
  static int losses1 = 0;
  static int wins2 = 0;
  static int losses2 = 0;
  static int winsComp = 0;
  static int lossesComp = 0;

  /**
   * GUI constructor.
   */
  public GUI() {
    getScore();
    initComponents();
    mainMenu = new MainMenuPanel(this);
    add(mainMenu);
  }

  private void initComponents() {
    
    //setDefaultCloseOperation( addWindowListener);   
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent w) {
        saveCurrentProgress();
        w.getWindow().dispose();
      }      
    });
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1280, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 800, Short.MAX_VALUE));

    pack();
  }

  /**
   * Main game code.
   * @param args command line argument
   */
  public static void main(String[] args) {
    //TODO: check for dev build
    isDevBuild = false;
    try {
      for (UIManager.LookAndFeelInfo info : 
          UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
    }

    /* Create and display the form */
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GUI().setVisible(true);
      }
    });
  }

  //Methods
  void updateDisplay() {
    revalidate();
    repaint();
  }

  void setPlayer1Name(String name) {
    p1Name = name;
    System.out.println("Player 1's name set to " + name);
  }

  void setPlayer2Name(String name) {
    p2Name = name;
    System.out.println("Player 2's name set to " + name);
  }

  String getPlayer1Name() {
    return p1Name;
  }

  String getPlayer2Name() {
    return p2Name;
  }

  GamePanel addGamePanel(int startingPlayer) {
    gamePanel = new GamePanel(this, mainMenu.getIsEnabled(), startingPlayer);
    add(gamePanel);
    return gamePanel;
  }

  void removeGamePanel() {
    remove(gamePanel);
  }

  void addMainMenu() {
    //score1 = 0;
    //score2 = 0;
    mainMenu = new MainMenuPanel(this);
    add(mainMenu);
  }

  void addGameOver() {
    remove(gamePanel);
    System.out.println("New Game Over Panel added");
    gameOverPanel = new GameOverPanel(this, winner);
    add(gameOverPanel);
    updateDisplay();
  }

  void setWinner(String winner) {
    this.winner = winner;
  }

  int getScore1() {
    return score1;
  }

  int getScore2() {
    return score2;
  }

  void setScore1(int newScore) {
    score1 = newScore;
  }

  void setScore2(int newScore) {
    score2 = newScore;
  }
  
  /**
   * Gets the win/loses of the systems history.
   */
  private void getScore() {
    try {

      BufferedReader in = new BufferedReader(new FileReader("game.save"));
      String str;
      while (in.ready()) {
        str = in.readLine();
        if (str != null) {          
          if (str.length() > 6 && str.substring(0, 6).equals("Wins1=")) {
            wins1 = Integer.parseInt(new String(str.substring(6)));
          } else if (str.length() > 8 && str.substring(0, 8).equals("Losses1=")) {
            losses1 = Integer.parseInt(new String(str.substring(8)));
          } else if (str.length() > 6 && str.substring(0, 6).equals("Wins2=")) {
            wins2 = Integer.parseInt(new String(str.substring(6)));
          } else if (str.length() > 8 && str.substring(0, 8).equals("Losses2=")) {
            losses2 = Integer.parseInt(new String(str.substring(8)));
          } else if (str.length() > 9 && str.substring(0, 9).equals("WinsComp=")) {
            winsComp = Integer.parseInt(new String(str.substring(9)));
          } else if (str.length() > 11 && str.substring(0, 11).equals("LossesComp=")) {
            lossesComp = Integer.parseInt(new String(str.substring(11)));
          }
        }
      }
      in.close();

    } catch (IOException e) {
      System.out.println("IOException handled in getScore(): " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Exception handled in getScore(): " + e.getMessage());
    }
  }
  
  /**
   * Get old scores from the last session.
   */
  public void getOldProgress() {
    try {

      BufferedReader in = new BufferedReader(new FileReader("game.save"));
      String str;
      while (in != null && in.ready()) {
        str = in.readLine();
        if (str != null) {
          if (str.length() > 11 && str.substring(0, 11).equals("Player1Win=")) {
            score1 = Integer.parseInt(new String(str.substring(11)));
          } else if (str.length() > 11 && str.substring(0, 11).equals("Player2Win=")) {
            score2  = Integer.parseInt(new String(str.substring(11)));;
          }
        }
      }
      in.close();

    } catch (IOException e) {
      System.out.println("IOException handled in getOldProgress(): " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Exception handled in getOldProgress(): " + e.getMessage());
    }
  }

  /**
   * This method saves the score of the game and the wins/loses of the players.
   */
  public boolean saveCurrentProgress() {
    try {
      String str;
      File file = new File("game.save");
      File tmp = new File("game.save.tmp");

      if (tmp.exists()) {
        System.out.println("Deleting existing game.save.tmp file");
        if (!tmp.delete()) {
          System.out.println("Could not delete game.save.tmp");
        }
      }

      BufferedReader in = new BufferedReader(new FileReader(file));
      BufferedWriter out = new BufferedWriter(new FileWriter(tmp));

      if (this.isDevBuild()) {
        in.close();
        out.close();
        return true;
      }
      
      while (in.ready()) {
        str = in.readLine();
        if (str != null) {
          if (str.length() > 11 && str.substring(0, 11).equals("Player1Win=")) {
            out.write("Player1Win=" + Integer.toString(score1) + "\r\n");
          } else if (str.length() > 11 && str.substring(0, 11).equals("Player2Win=")) {
            out.write("Player2Win=" + Integer.toString(score2) + "\r\n");
          } else if (str.length() > 6 && str.substring(0, 6).equals("Wins1=")) {
            out.write("Wins1=" + Integer.toString(wins1) + "\r\n");
          } else if (str.length() > 8 && str.substring(0, 8).equals("Losses1=")) {
            out.write("Losses1=" + Integer.toString(losses1) + "\r\n");
          } else if (str.length() > 6 && str.substring(0, 6).equals("Wins2=")) {
            out.write("Wins2=" + Integer.toString(wins2) + "\r\n");
          } else if (str.length() > 8 && str.substring(0, 8).equals("Losses2=")) {
            out.write("Losses2=" + Integer.toString(losses2) + "\r\n");
          } else if (str.length() > 9 && str.substring(0, 9).equals("WinsComp=")) {
            out.write("WinsComp=" + Integer.toString(winsComp) + "\r\n");
          } else if (str.length() > 11 && str.substring(0, 11).equals("LossesComp=")) {
            out.write("LossesComp=" + Integer.toString(lossesComp) + "\r\n");
          } else {
            out.write(str +  "\r\n");
          }
        }
      }
      
      in.close();
      out.close();

      if (!file.delete()) {
        System.out.println("game.save cannot be deleted "
            + "to replace with .tmp file.");
        if (!tmp.delete()) {
          System.out.println("game.save file not deleted.");
          return false;
        }
      } else {
        if (!tmp.renameTo(file)) {
          System.out.println("Cannot rename game.save to game.save.");
          return false;
        }
      }

    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException handled in saveCurrentProgress(): " 
          + e.getMessage());
      return false;
    } catch (IOException e) {
      System.out.println("IOException handled in saveCurrentProgress(): " + e.getMessage());
      return false;
    } catch (Exception e) {
      System.out.println("Exception handled in saveCurrentProgress(): " + e.getMessage());
      return false;
    }
    return true;
  }

  private boolean isDevBuild() {
    return isDevBuild;
  }
}
