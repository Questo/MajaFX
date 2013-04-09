package majafx.engine;

import majafx.entities.Sprite;
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
    
    private final static List<Sprite> SPRITE_LIST = new ArrayList<>();
    private static final List<Sprite> COLLISION_LIST = new ArrayList<>();
    private static final Set<Sprite> DEAD_SPRITES = new HashSet<>();
    
    public void addSprites(Sprite... sprites) {
        SPRITE_LIST.addAll(Arrays.asList(sprites));
    }
    
    public void removeSprites(Sprite... sprites) {
        SPRITE_LIST.removeAll(Arrays.asList(sprites));
    }
    
    public void addDeadSprites(Sprite... sprites) {
        // Sometimes we want to have a sprite massacre
        if(sprites.length > 1) {
            DEAD_SPRITES.addAll(Arrays.asList(sprites));
        }
        else { // and sometimes just one dies
            DEAD_SPRITES.add(sprites[0]);
        }
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
    
    public List<Sprite> getAllSprites() { return SPRITE_LIST; }
    public Set<Sprite> getDeadSprites() { return DEAD_SPRITES; }
    public List<Sprite> getCollisions() { return COLLISION_LIST; }
    
}
