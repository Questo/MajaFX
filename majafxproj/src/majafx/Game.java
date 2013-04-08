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
import majafx.engine.Sprite;
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
    
    private Player p1 = new Player(10, 320, 120, ss1, 32, 64, 4, 4);
    
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
        
        // Setup game input
        setupInput(primaryStage);
        
        getSpriteManager().addSprites(p1);
        
        // Add player
        setupPlayer(p1);
        getGameNodes().getChildren().add(p1.node);
    }

    private void setupInput(Stage primaryStage) {
        EventHandler<KeyEvent> movePlayer = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.UP) {
                    p1.animations.get(0).stop();
                    p1.vY--;
                    p1.animations.get(0).play();
                }
            }
        };
       primaryStage.getScene().setOnKeyPressed(movePlayer);
               
    }
    
    @Override
    protected void handleUpdate(Sprite sprite) {
        sprite.update();
    }

    private void setupPlayer(Player player) {
        Animation walkUp = new SpriteAnimation(p1.getPlayerImage(),
                0, 0, p1.getWidth(), p1.getHeight(), 3);
        
        p1.addAnimations(walkUp);
    }
    
}
