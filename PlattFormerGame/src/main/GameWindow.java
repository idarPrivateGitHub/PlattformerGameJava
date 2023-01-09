package main;

import javax.swing.*;

public class GameWindow  extends JFrame{
    /*This Constructor prepares the gaming window
     * we use the Frame as a Container for the Panel that we display the conent in
     * so the JFrame needs to receive the gamepanel*/


    public GameWindow(GamePanel gamePanel){
        this.setSize(400 , 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(gamePanel);


    }
    public GameWindow(GamePanelExp gamePanelExp){
        this.setSize(400 , 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(gamePanelExp);


    }
}
