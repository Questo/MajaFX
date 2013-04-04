package majafx.engine;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;

/**
 *
 * @author mathias
 */
public abstract class Sprite {
    
    public List animations = new ArrayList<>();
    public Node node;
    
    public double vX = 0;
    public double vY = 0;
    
    public boolean isDead = false;
    
    public abstract void update();
    
    public boolean collide(Sprite other) {
        return false;
    }
    
    
}
