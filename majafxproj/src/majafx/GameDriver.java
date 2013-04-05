package majafx;

import javafx.application.Application;
import javafx.stage.Stage;
import majafx.engine.GameWorld;

/**
 * The main driver of the game.
 * @author mathias
 */
public class GameDriver extends Application {
    
    GameWorld gameWorld = new Game(60, "MajaFX 0.01");
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameWorld.init(primaryStage);
        gameWorld.beginGameLoop();
        
        primaryStage.show();
    }
    
    
    
}
