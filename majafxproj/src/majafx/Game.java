/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package majafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import majafx.engine.GameWorld;

/**
 *
 * @author mathias
 */
public class Game extends GameWorld {
    
    private static final int WIDTH = 320;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 4;
    
    public Game(int fps, String name) {
        super(fps, name);
    }

    @Override
    public void init(final Stage primaryStage) {
        // Sets the window title
        primaryStage.setTitle(getName());
        
        // Create the scene
        setGameNodes(new Group());
        setGameSurface(new Scene(getGameNodes(), WIDTH * SCALE, HEIGHT * SCALE));
        primaryStage.setScene(getGameSurface());
    }
    
}
