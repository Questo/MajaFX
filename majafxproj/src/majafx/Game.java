package majafx;

import javafx.animation.Animation;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
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
 
    private Player player = new Player(
            10,
            ((WIDTH * SCALE)/2) - 16,
            ((HEIGHT*SCALE)/2) - 32);
    
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
        
        getSpriteManager().addSprites(player);
        
        // Add player
        setupPlayer(player);
        getGameNodes().getChildren().add(player.node);
    }

    private void setupInput(Stage primaryStage) {
        EventHandler<KeyEvent> movePlayer = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.UP) {
                    player.animations.get(0).stop();
                    player.vY--;
                    player.animations.get(0).play();
                }
                if(event.getCode() == KeyCode.DOWN) {
                    player.animations.get(1).stop();
                    player.vY++;
                    player.animations.get(1).play();
                }
                if(event.getCode() == KeyCode.LEFT) {
                    player.animations.get(2).stop();
                    player.vX--;
                    player.animations.get(2).play();
                    
                }
                if(event.getCode() == KeyCode.RIGHT) {
                    player.animations.get(3).stop();
                    player.vX++;
                    player.animations.get(3).play();
                    
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
        Animation walkUp = new SpriteAnimation(player.getPlayerImage(),
                0, 0, 32, 64, 3);
        
        player.addAnimations(walkUp);
    }
    
}
