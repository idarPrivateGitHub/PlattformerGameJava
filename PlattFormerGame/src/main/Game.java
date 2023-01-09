package main;

public class Game implements Runnable{
    private GameWindow window;
    private GamePanel gamePanel;

    private GamePanelExp gamePanelExperiment;
    private Thread gameThread;
    private final int FPS_SET = 120;

    private int something;
    public Game(){
        gamePanel = new GamePanel();
        window = new GameWindow(gamePanel);
        gamePanel.requestFocus();//The line of code enables the Panel to focus on Inputs
        startGameLoop();
    }

    public Game(GamePanelExp exp){
        gamePanelExperiment = exp;
        window = new GameWindow(gamePanelExperiment);
        gamePanelExperiment.requestFocus();//The line of code enables the Panel to focus on Inputs
        startGameLoop();
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
//    public void run(){
//
//        //This is defining the duration each frame should last
//        //And we are using nanoseconds because we need to be very precise about it
//        double timePerFrame = 1000000000.0 / FPS_SET;
//        long lastFrame = System.nanoTime();
//        long now = System.nanoTime();
//
//        int frames = 0;
//        long lastCheck = System.currentTimeMillis();
//
//        //We are going to check from the previous frame to the current
//        //if that duration has past , if that duration has past , it is time for a new Frame
//        //then we do another refresh of the game screen , speak, repaint
//        while(true){
//            now = System.nanoTime();
//            if( (now - lastFrame) >= timePerFrame ){
//                gamePanel.repaint();
//                lastFrame = now;
//                frames++;
//            }
//
//            //After a second has passed we stop counting the frames and print them out
//            //Reset then the frames counter for the next second
//            if((System.currentTimeMillis() - lastCheck) >= 1000) {
//                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames);
//                frames = 0;
//
//            }
//        }
//    }
    public void run(){

        //This is defining the duration each frame should last
        //And we are using nanoseconds because we need to be very precise about it
        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        //We are going to check from the previous frame to the current
        //if that duration has past , if that duration has past , it is time for a new Frame
        //then we do another refresh of the game screen , speak, repaint
        while(true){
            now = System.nanoTime();
            if( (now - lastFrame) >= timePerFrame ){
                gamePanelExperiment.repaint();
                lastFrame = now;
                frames++;
            }

            //After a second has passed we stop counting the frames and print them out
            //Reset then the frames counter for the next second
            if((System.currentTimeMillis() - lastCheck) >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;

            }
        }
    }
}
