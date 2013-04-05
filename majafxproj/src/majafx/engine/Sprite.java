package majafx.engine;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.scene.Node;
import majafx.gfx.SpriteSheet;

/**
 *
 * @author mathias
 */
public abstract class Sprite {
    
    //public List<Animation> animations = new ArrayList<>();
    //public Node node;
    
    public int width, height; // size of sprite
    public int col, row; // position in spritesheet
    
    public boolean isDead = false;
    
    public Sprite(SpriteSheet ss, int w, int h, int c, int r) {
        width = w; height = h;
        col = width * (c-1); row = height * (r-1);
    }
    
    /**
     * Update velocity or animation.
     */
    //public abstract void update();
    
    public boolean collide(Sprite other) {
        return false;
    }
    
}
