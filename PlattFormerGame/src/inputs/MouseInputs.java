package inputs;

import main.GamePanel;
import main.GamePanelExp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener , MouseMotionListener {
    private GamePanel gamePanel;
    private GamePanelExp gamePanelExp;
    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public MouseInputs(GamePanelExp gamePanelExp){
        this.gamePanelExp = gamePanelExp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        switch(e.getButton()){
            case MouseEvent.BUTTON1 : gamePanelExp.spawnRect(e.getX() , e.getY());
            break;

            case MouseEvent.BUTTON2: gamePanelExp.deleteRect();
            break;

            case MouseEvent.BUTTON3: gamePanelExp.removeAll();
            break;
        };
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e){

    };
    public void mouseMoved(MouseEvent e){

    };
}
