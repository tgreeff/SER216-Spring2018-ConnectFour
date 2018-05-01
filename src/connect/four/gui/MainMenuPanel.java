/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class MainMenuPanel extends JPanel {

  private String name1;
  private String name2;
  GUI gui;
  private boolean isEnabled;
  
  private JButton butPlay;
  private JLabel playerName1Label;
  private JLabel playerName2Label;
  private JToggleButton jtComputerToggle;
  private JTextField tfplayer1;
  private JTextField tfplayer2;
  private JLabel title;
  private JButton play1;
  private JButton play2;
  private JButton board1;
  private JButton board2;
  private JButton board3;
  
  private JLabel win1Label;
  private JLabel loss1Label;
  private JLabel win2Label;
  private JLabel loss2Label;
  private JLabel winCompLabel;
  private JLabel lossCompLabel;
  private JButton loadButton;
  
  //SOUND
  private AudioInputStream computerMercyAIS;
  private Clip computerMercyClip;
  private AudioInputStream humanAIS;
  private Clip humanClip;
  
  /**
   * Main Menu constructor.
   * @param gui the gui object for the game.
   */
  public MainMenuPanel(GUI gui) {
    initComponents();
    setSize(1280,800);
    
    this.gui = gui;
    isEnabled = false;

    setVisible(true);
    
    //SOUND
    try {
    	computerMercyAIS = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/SOUNDS/computer_mercy.wav"));
    	computerMercyClip = AudioSystem.getClip();
    	computerMercyClip.open(computerMercyAIS);
    	humanAIS = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/SOUNDS/lets_play.wav"));
    	humanClip = AudioSystem.getClip();
    	humanClip.open(humanAIS);
    	} catch(Exception e) {
    		System.out.println("Failure to load sound");
    }
  }

  /**
   * This method is called from within the constructor to initialize the
   * form. WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void initComponents() {

    title = new JLabel();
    tfplayer1 = new JTextField();
    tfplayer2 = new JTextField();
    playerName1Label = new JLabel();
    playerName2Label = new JLabel();
    play1 = new JButton();
    play2 = new JButton();
    board1 = new JButton();
    board2 = new JButton();
    board3 = new JButton();
    butPlay = new JButton();
    jtComputerToggle = new JToggleButton();
    
    win1Label = new JLabel();
    loss1Label = new JLabel();
    win2Label = new JLabel();
    loss2Label = new JLabel();
    winCompLabel = new JLabel();
    lossCompLabel = new JLabel();
    loadButton = new JButton();
    
    setBackground(new Color(50, 50, 50));

    title.setFont(new Font("Source Sans Pro Black", 0, 48)); // NOI18N
    title.setForeground(new Color(0, 0, 0));
    title.setText("Connect Four");

    tfplayer1.setText("Player 1");

    tfplayer1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        tfplayer1ActionPerformed(evt);
      }
    });

    tfplayer2.setText("Player 2");

    tfplayer2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        tfplayer2ActionPerformed(evt);
      }
    });

    playerName1Label.setFont(new Font("Lucida Grande", 0, 18));
    playerName1Label.setForeground(new Color(0, 0, 0));
    playerName1Label.setText("Player 1:");

    playerName2Label.setFont(new Font("Lucida Grande", 0, 18));
    playerName2Label.setForeground(new Color(0, 0, 0));
    playerName2Label.setText("Player 2:");
    
    play1.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
    play1.setText("Player 1 Start ");
    play1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        play1ActionPerformed(evt);
      }
    });

    play2.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
    play2.setText("Player 2 Start");
    play2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        play2ActionPerformed(evt);

      }
    });
    
    board1.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
    board1.setText("Board 1 ");
    board1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        board1ActionPerformed(evt);
      }
    });
    
    board2.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
    board2.setText("Board 2 ");
    board2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        board2ActionPerformed(evt);
      }
    });
    
    board3.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
    board3.setText("Board 3 ");
    board3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        board3ActionPerformed(evt);
      }
    });
    
    win1Label.setFont(new Font("Lucida Grande", 0, 18));
    win1Label.setForeground(new Color(0, 0, 0));
    win1Label.setText("Player 1 Wins: " + GUI.wins1);
    
    loss1Label.setFont(new Font("Lucida Grande", 0, 18));
    loss1Label.setForeground(new Color(0, 0, 0));
    loss1Label.setText("Player 1 Losses: " + GUI.losses1);
    
    win2Label.setFont(new Font("Lucida Grande", 0, 18));
    win2Label.setForeground(new Color(0, 0, 0));
    win2Label.setText("Player 2 Wins: " + GUI.wins2);
    
    loss2Label.setFont(new Font("Lucida Grande", 0, 18));
    loss2Label.setForeground(new Color(0, 0, 0));
    loss2Label.setText("Player 2 Losses: " + GUI.losses2);
    
    winCompLabel.setFont(new Font("Lucida Grande", 0, 18));
    winCompLabel.setForeground(new Color(0, 0, 0));
    winCompLabel.setText("Computer Wins: " + GUI.winsComp);
    
    lossCompLabel.setFont(new Font("Lucida Grande", 0, 18));
    lossCompLabel.setForeground(new Color(0, 0, 0));
    lossCompLabel.setText("Computer Losses: " + GUI.lossesComp);

    butPlay.setFont(new Font("Lucida Grande", 0, 18));
    butPlay.setText("Random Start");
    butPlay.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        butPlayActionPerformed(evt);
      }
    });
    
    loadButton.setFont(new Font("Lucida Grande", 0, 36));
    loadButton.setText("Load Last Game");
    loadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        loadButtonActionPerformed(evt);
      }
    });

    jtComputerToggle.setFont(new Font("Lucida Grande", 0, 36));
    jtComputerToggle.setText("Play Against Computer");
    jtComputerToggle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jtComputerToggleActionPerformed(evt);
      }
    });
 
    JPanel playerPanel = new JPanel();
    playerPanel.setPreferredSize(new Dimension(200, 200));
    
    JPanel titlePanel = new JPanel();
    titlePanel.setPreferredSize(new Dimension(1100, 100));
    titlePanel.setBackground(new Color(100, 150, 150));
    
    JPanel scorePanel = new JPanel(new GridLayout(3, 2));
    scorePanel.setPreferredSize(new Dimension(400, 200));
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(700, 75));

    initPlayerPanel(playerPanel);
    initTitlePanel(titlePanel);
    initScorePanel(scorePanel);
    initButtonPanel(buttonPanel);
    
    this.add(titlePanel);
    this.add(playerPanel);    
    this.add(scorePanel);
    this.add(buttonPanel);
  }

  private void initPlayerPanel(JPanel panel) {
    GroupLayout layout = new GroupLayout(panel);

    JComponent contentPane = new JPanel(new BorderLayout(), true); 
    contentPane.setLayout(layout);  
    layout.setAutoCreateGaps(false);
    layout.setAutoCreateContainerGaps(false);
    
    GroupLayout.SequentialGroup horizontalLayout = layout.createSequentialGroup();  
    GroupLayout.SequentialGroup verticalLayout = layout.createSequentialGroup();
    
    //Horizontal Group Layout Setup
    //Add components to column 1
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(playerName1Label)
        .addComponent(tfplayer1));      
    //Main Middle column 2
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(playerName2Label)
        .addComponent(tfplayer2));
    //Play button column 3
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(play1)
        .addComponent(play2)
        .addComponent(butPlay));   
    layout.setHorizontalGroup(horizontalLayout);
    
    //Add components to row 1
    verticalLayout.addGroup(layout.createParallelGroup()
        .addComponent(playerName1Label)
        .addComponent(tfplayer1)
        .addComponent(play1)
        .addComponent(butPlay)); 
  //Add components to row 2
    verticalLayout.addGroup(layout.createParallelGroup()
        .addComponent(playerName2Label)
        .addComponent(tfplayer2)
        .addComponent(play2));           
    layout.setVerticalGroup(verticalLayout);
  }
  
  private void initTitlePanel(JPanel panel) {
    GroupLayout layout = new GroupLayout(panel);

    JComponent contentPane = new JPanel(new BorderLayout(), true); 
    contentPane.setLayout(layout);  
    layout.setAutoCreateGaps(false);
    layout.setAutoCreateContainerGaps(false);
    
    GroupLayout.SequentialGroup horizontalLayout = layout.createSequentialGroup();  
    GroupLayout.SequentialGroup verticalLayout = layout.createSequentialGroup();
    
    //Horizontal Group Layout Setup
    //Add components to column 1
    horizontalLayout.addGroup(layout.createParallelGroup()        
        .addComponent(title));        
    layout.setHorizontalGroup(horizontalLayout);
    
    //Vertical Group Layout Setup
    //Add components to row 1
    verticalLayout.addGroup(layout.createParallelGroup()
        .addComponent(title ));
    layout.setVerticalGroup(verticalLayout);
  }
  
  private void initScorePanel(JPanel panel) {
    GroupLayout layout = new GroupLayout(panel);

    JComponent contentPane = new JPanel(new BorderLayout(), true); 
    contentPane.setLayout(layout);  
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    
    GroupLayout.SequentialGroup horizontalLayout = layout.createSequentialGroup();  
    GroupLayout.SequentialGroup verticalLayout = layout.createSequentialGroup();
    
    //Horizontal Group Layout Setup
    //Add components to column 
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(win1Label));      
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(loss1Label));    
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(win2Label));        
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(loss2Label));    
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(winCompLabel));        
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(lossCompLabel));    
    layout.setHorizontalGroup(horizontalLayout);

    //Vertical Group Layout Setup
    //Add components to row 1
    verticalLayout.addGroup(layout.createParallelGroup()
        .addComponent(win1Label)
        .addComponent(loss1Label)
        .addComponent(win2Label)
        .addComponent(loss2Label)
        .addComponent(winCompLabel)
        .addComponent(lossCompLabel));        
    layout.setVerticalGroup(verticalLayout);
  }
  
  private void initButtonPanel(JPanel panel) {
    GroupLayout layout = new GroupLayout(panel);

    JComponent contentPane = new JPanel(new BorderLayout(), true); 
    contentPane.setLayout(layout);  
    layout.setAutoCreateGaps(false);
    layout.setAutoCreateContainerGaps(false);
    
    GroupLayout.SequentialGroup horizontalLayout = layout.createSequentialGroup();  
    GroupLayout.SequentialGroup verticalLayout = layout.createSequentialGroup();
    
    //Horizontal Group Layout Setup
    //Add components to column 
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(jtComputerToggle));    
    horizontalLayout.addGroup(layout.createParallelGroup()
        .addComponent(loadButton));
    //horizontalLayout.addGroup(layout.createParallelGroup()
        //.addComponent(butPlay));           
    layout.setHorizontalGroup(horizontalLayout);
    
    //Vertical Group Layout Setup
    //Add components to row 1    
    verticalLayout.addGroup(layout.createParallelGroup()
        .addComponent(jtComputerToggle)
        .addComponent(loadButton));               
    layout.setVerticalGroup(verticalLayout);
  }
  
  private void tfplayer2ActionPerformed(ActionEvent evt) {

  }

  private void tfplayer1ActionPerformed(ActionEvent evt) {

  }

  private void butPlayActionPerformed(ActionEvent evt) {
    gui.setPlayer1Name(tfplayer1.getText());
    gui.setPlayer2Name(tfplayer2.getText());
    //gui.game.start();
    
    gui.remove(this);
    gui.addGamePanel(2);
    gui.updateDisplay();
  }
  
  private void play1ActionPerformed(ActionEvent evt) {
    if (!isEnabled) {
      play2.setEnabled(false);
      //play1.pla

    } else {
      play2.setEnabled(true);
    }
    gui.setPlayer1Name(tfplayer1.getText());
    gui.setPlayer2Name(tfplayer2.getText());
    gui.remove(this);
    gui.addGamePanel(0);
    gui.updateDisplay();

  }
  

  private void play2ActionPerformed(ActionEvent evt) {
    if (!isEnabled) {
      play1.setEnabled(false);
    } else {
      play2.setEnabled(true);
    }
    gui.setPlayer1Name(tfplayer1.getText());
    gui.setPlayer2Name(tfplayer2.getText());
    gui.remove(this);
    gui.addGamePanel(1);
    gui.updateDisplay();
  }
  
  private void board1ActionPerformed(ActionEvent evt) {
	  }
  
  private void board2ActionPerformed(ActionEvent evt) {
  }
  
  private void board3ActionPerformed(ActionEvent evt) {
  }
  
  private void loadButtonActionPerformed(ActionEvent evt) {
    gui.getOldProgress();
    
  }

  private void jtComputerToggleActionPerformed(ActionEvent evt) {
    if (!isEnabled) {
      tfplayer2.setText("Computer");
      jtComputerToggle.setText("Play Against Player  ");
      //SOUND
      computerMercyClip.setFramePosition(1);
      computerMercyClip.start();
      tfplayer2.setEditable(false);
      isEnabled = true;
    } else {
      tfplayer2.setText("Player 2");
      jtComputerToggle.setText("Play Against Computer");
      //SOUND
      humanClip.setFramePosition(1);
      humanClip.start();
      tfplayer2.setEditable(true);
      isEnabled = false;
    }
  }
  

  public boolean getIsEnabled() {
    return isEnabled;
  }

}
