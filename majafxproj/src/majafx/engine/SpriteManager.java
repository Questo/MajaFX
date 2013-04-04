package majafx.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Handles all the sprites in the game.
 * 
 * @author mathias
 */
public class SpriteManager {
    
    private static final List SPRITE_LIST = new ArrayList<>();
    private static final List COLLISION_LIST = new ArrayList<>();
    private static final Set DEAD_SPRITES = new HashSet<>();
    
    public void addSprites(Sprite... sprites) {
        SPRITE_LIST.add(Arrays.asList(sprites));
    }
    
    public void removeSprites(Sprite... sprites) {
        SPRITE_LIST.remove(Arrays.asList(sprites));
    }
    
    public void addDeadSprites(Sprite... sprites) {
        DEAD_SPRITES.add(Arrays.asList(sprites));
    }
    
    /**
     * Resets the list to check for collisions.
     */
    public void resetCollisionCheck() {
        COLLISION_LIST.clear();
        COLLISION_LIST.addAll(SPRITE_LIST);
    }
    
    public void cleanupSprites() {
        // Remove dead sprites from live ones
        SPRITE_LIST.removeAll(DEAD_SPRITES);
        
        // Bury the dead sprites for good
        DEAD_SPRITES.clear();
    }
    
    public List getAllSprites() {
        return SPRITE_LIST;
    }
    
    public Set getDeadSprites() {
        return DEAD_SPRITES;
    }
    
    public List getCollisions() {
        return COLLISION_LIST;
    }
    
}
