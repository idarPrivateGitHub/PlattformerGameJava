package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    //XDelta and YDelta are the point in the Coordinate System(JFrame) of the upper left corner
    //of the Object that we are drawing basically the starting position from which we draw
    //The xDir and yDir variables help us control the direction of the Object each time we repaint it
    private float xDelta = 100;
    private float xDir = 1f;
    private float yDelta = 100;
    private float yDir = 1f;
    private Color color = new Color(100, 50, 200);

    private Random random;

    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    //Sets the x position of an object in the gamepanel
    public void setxDelta(int value) {
        this.xDelta = this.xDelta + value;
    }

    //Sets the y position of an object in the gamepanel
    public void setyDelta(int value) {
        this.yDelta = this.yDelta + value;
    }

    public void setRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    // paintComponent never gets called directly
    // It gets called when press play
    // JPanel cannot draw on its own, therefore we need a graphics Object
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    }

    //Updates the position in which the Object is supposed to be drawn
    //after paint is called we paint the Object at one position and when updateRectangle is called
    //we change the values of the variables and when we call repaint() the the Object is gonna be drawn
    //in a different place
    private void updateRectangle() {
        xDelta = xDelta + xDir;
        //We are reversing the direction when of the moving Object when
        //the x Coordinate reaches a pixel Coordinate greater than 400 or smaller than zero
        //the y Coordinate follows the same logic
        //Additionally we add a color change when the conditions are true
        if (xDelta > 400 || xDelta < 0) {
            xDir = xDir * (-1);
            color = getRandColor();
        }
        yDelta = yDelta + yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir = yDir * (-1);
            color = getRandColor();
        }
    }

    private Color getRandColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }
}
