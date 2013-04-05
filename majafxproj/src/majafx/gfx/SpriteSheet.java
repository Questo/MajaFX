package majafx.gfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author mathias
 */
public class SpriteSheet {
    
    public ImageView spriteView;
    public Image img;
    
    public String path;
    public int width, height;
    
    public SpriteSheet(String path) {
        img = new Image(getClass()
                .getResourceAsStream(path));
        spriteView = new ImageView(img);
        
        width = (int) img.getWidth();
        height = (int) img.getHeight();
    }
    
    public Image getSpriteSheet() {
        return img;
    }
    
}
