package majafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import majafx.engine.GameWorld;
import majafx.entities.Player;
import majafx.gfx.SpriteSheet;

/**
 *
 * @author mathias
 */
public class Game extends GameWorld {
    
    private static final int WIDTH = 320;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 2;
 
    private Player player = new Player(10, ((WIDTH * SCALE)/2) - 16, ((HEIGHT*SCALE)/2) - 32);
    
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
        
        // Add player
        getGameNodes().getChildren().add(player.node);
    }
    
}
