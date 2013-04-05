/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package majafx.entities;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.scene.Node;
import majafx.engine.Sprite;
import majafx.gfx.SpriteSheet;

/**
 *
 * @author mpma
 */
public abstract class Mob extends Sprite {
    
    public List<Animation> animations = new ArrayList<Animation>();
    public Node node;
    
    public boolean isDead = false;
    
    public Mob(SpriteSheet ss, int w, int h, int c, int r) {
        super(ss, w, h, c, r);
    }

    /**
     * Update position or animation
     */
    public abstract void update();
    
}
