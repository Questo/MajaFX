package majafx.gfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author mathias
 */
public class SpriteSheet {
    
    public String path;
    public int width, height;
    
    public SpriteSheet(String path) {
        final Image img = new Image(getClass()
                .getResourceAsStream(path));
        final ImageView imgView = new ImageView(img);
        
        width = (int) img.getWidth();
        height = (int) img.getHeight();
    }
    
}
