package inputs;

import main.GamePanel;
import main.GamePanelExp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInputs implements KeyListener {

    private GamePanel gamePanel;

    private GamePanelExp gamePanelExp;
    public KeyBoardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }
    public KeyBoardInputs(GamePanelExp gamePanelExp){
        this.gamePanelExp = gamePanelExp;

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       switch(e.getKeyCode()){
           case KeyEvent.VK_W:
               gamePanel.setyDelta(-5);
               break;
           case KeyEvent.VK_A:
               gamePanel.setxDelta(-5);

               break;
           case KeyEvent.VK_S:
               gamePanel.setyDelta(5);
               break;
           case KeyEvent.VK_D:

               gamePanel.setxDelta(5);
               break;
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
