package majafx.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.Animation;
import javafx.scene.Node;

/**
 * The Sprite class represents all entities in the game world.
 * A sprite will be will contain a velocity for the image/node to move
 * across the scene. The game loop will call the update() and collide()
 * at every keyframe interval. A list of animations can be used during
 * different situations in the game.
 * 
 * @author mathias
 */
public abstract class Sprite {
    
    /** Animations for the node */
    public List<Animation> animations = new ArrayList<>();
    
    /** Current display node */
    public Node node;
    
    public double vX = 0;
    public double vY = 0;
    
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
    
    public void addAnim(Animation... anim) {
        animations.addAll(Arrays.asList(anim));
    }
    
}
