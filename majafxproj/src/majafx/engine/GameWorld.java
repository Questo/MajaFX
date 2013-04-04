package majafx.engine;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;

/**
 *
 * @author mathias
 */
public abstract class GameWorld {
    
    private final int FPS;
    private final String NAME;
    
    private Timeline gameLoop;
    private Scene gameSurface;
    private Group gameNodes;
    
    private SpriteManager spriteManager = new SpriteManager();
    
    public GameWorld(final int FPS, final String NAME) {
        this.FPS = FPS;
        this.NAME = NAME;
        
    }
    
}
