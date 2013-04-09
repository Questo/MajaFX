package majafx;

import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import majafx.engine.GameWorld;
import majafx.entities.Sprite;
import majafx.engine.SpriteAnimation;
import majafx.entities.Player;

/**
 *
 * @author mathias
 */
public class Game extends GameWorld {
    
    private static final int WIDTH = 320;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 2;
    
    private Image ss1 = new Image(getClass()
            .getResourceAsStream("/res/spritesheet_trans.png"));
    
    public Game(int fps, String name) {
        super(fps, name);
    }

    @Override
    public void init(final Stage primaryStage) {
        // Sets the window title
        primaryStage.setTitle(getName());
        
        // Create the scene
        setGameNodes(new Group());
        setGameSurface(new Scene(getGameNodes(),
                WIDTH * SCALE,
                HEIGHT * SCALE));
        primaryStage.setScene(getGameSurface());
        
    }
    
    @Override
    protected void handleUpdate(Sprite sprite) {
        sprite.update();
    }
    
}
