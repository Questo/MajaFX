package majafx.entities;

import java.util.Arrays;
import javafx.animation.Animation;

/**
 * Simple Player class. 
 * @author mpma
 */
public class Player extends Sprite {
    
    private int hp;
    private double x, y;
    
    /**
     * 
     * @param hp - hit points
     * @param x - coordinate
     * @param y - coordinate
     */
    public Player(int hp, int x, int y) {
        this.hp = hp;
        this.x = x; this.y = y;
    }

    @Override
    public void update() {
        
    }
    
}
