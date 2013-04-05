package majafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import majafx.engine.GameWorld;
import majafx.gfx.SpriteSheet;

/**
 *
 * @author mathias
 */
public class Game extends GameWorld {
    
    private static final int WIDTH = 320;
    private static final int HEIGHT = WIDTH / 12 * 9;
    private static final int SCALE = 3;
    
    private SpriteSheet sSheet = new SpriteSheet("/res/spritesheet_trans.png");
    
    public Game(int fps, String name) {
        super(fps, name);
    }

    @Override
    public void init(final Stage primaryStage) {
        // Sets the window title
        primaryStage.setTitle(getName());
        
        System.out.println(sSheet.width + "x" + sSheet.height);
        
        // Create the scene
        setGameNodes(new Group());
        setGameSurface(new Scene(getGameNodes(), WIDTH * SCALE, HEIGHT * SCALE));
        primaryStage.setScene(getGameSurface());
    }
    
}
