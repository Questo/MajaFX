package majafx.engine;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;

/**
 * The Sprite class represents a image or node to be displayed.
 * A sprite will be will contain a velocity for the image/node to move
 * across the scene. The game loop will call the update() and collide()
 * at every keyframe interval. A list of animations can be used during
 * different situations in the game.
 * 
 * @author mathias
 */
public abstract class Sprite {
    
    /** Animations for the node */
    public List animations = new ArrayList<>();
    
    /** Current display node */
    public Node node;
    
    /** DEAD?! */
    public boolean isDead = false;
    
    /**
     * Updates the sprite.
     */
    public abstract void update();
    
    /**
     * Did this sprite collide with the other sprite?
     * 
     * @param other - The other sprite
     * @return 
     */
    public boolean collide(Sprite other) {
        return false;
    }
    
}
