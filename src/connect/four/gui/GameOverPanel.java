

package connect.four.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;



public class GameOverPanel extends JPanel {

  GUI gui;

  private JButton butMainMenu;
  private JButton butPlayAgain;
  private JButton exit;
  private JLabel labelGameOVer;
  private JLabel winner;
  private JLabel winnerDisplay;
  
  public GameOverPanel(GUI gui, String winner) {
    initComponents();
    this.gui = gui;
    setSize(1280, 800);
    System.out.println("Here!");
    winnerDisplay.setText(winner);
    setVisible(true);
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    winnerDisplay = new JLabel();
    winner = new JLabel();
    labelGameOVer = new JLabel();
    butPlayAgain = new JButton();
    exit= new JButton();
    butMainMenu = new JButton();

    setBackground(new Color(0, 0, 0));

    winnerDisplay.setFont(new Font("Lucida Grande", 0, 24)); // NOI18N
    winnerDisplay.setForeground(new Color(255, 255, 255));
    winnerDisplay.setText("Winner");

    winner.setFont(new Font("Lucida Grande", 0, 24)); // NOI18N
    winner.setForeground(new Color(255, 255, 255));
    winner.setText("Winner:");

    labelGameOVer.setFont(new Font("Lucida Grande", 0, 48)); // NOI18N
    labelGameOVer.setForeground(new Color(255, 255, 255));
    labelGameOVer.setText("GAME OVER");

    butPlayAgain.setFont(new Font("Lucida Grande", 0, 14)); // NOI18N
    butPlayAgain.setText("Play Again");
    butPlayAgain.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        butPlayAgainActionPerformed(evt);
      }
    });
    
    exit.setFont(new Font("Lucida Grande", 0, 14)); // NOI18N
    exit.setText("Exit Game");
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    butMainMenu.setFont(new Font("Lucida Grande", 0, 14)); // NOI18N
    butMainMenu.setText("Main Menu");
    butMainMenu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        butMainMenuActionPerformed(evt);
      }
      
    });

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addGap(499, 499, 499)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addComponent(winner)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(winnerDisplay, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
        		
        .addComponent(butPlayAgain, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(labelGameOVer, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addGroup(layout.createSequentialGroup()
         .addGap(551, 551, 551)
         
         
         .addComponent(exit, GroupLayout.DEFAULT_SIZE, 
                 GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(labelGameOVer, GroupLayout.DEFAULT_SIZE, 
                 GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
             .addGroup(layout.createSequentialGroup()
              .addGap(400, 400, 400)
         
         
         
        .addComponent(butMainMenu, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(429, Short.MAX_VALUE)));
        
        
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(145, 145, 145)
            .addComponent(labelGameOVer)
            .addGap(43, 43, 43)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(winnerDisplay, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
            .addComponent(winner, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
            .addGap(63, 63, 63)
            .addComponent(butPlayAgain, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
            .addGap(37, 37, 37)
            .addComponent(butMainMenu, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(304, Short.MAX_VALUE)));
  }

  private void butPlayAgainActionPerformed(ActionEvent evt) {
    gui.remove(this);
    gui.addGamePanel(2);
    gui.revalidate();
    gui.repaint();
  }

  private void butMainMenuActionPerformed(ActionEvent evt) {
    gui.remove(this);
    gui.addMainMenu();
    gui.revalidate();
    gui.repaint();
  }
  
  
}
