package majafx.engine;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author mathias
 */
public class SpriteAnimation extends Transition {
    
    private ImageView imageView;
    private int offsetX, offsetY, startX, startY, width, height;
    private int count = 0;
    private int lastIndex;
    
    /**
     * 
     * @param imageView - Sprite image view
     * @param offsetX - X value of sprite
     * @param offsetY - Y value of sprite
     * @param width - Width of sprite
     * @param height - Height of sprite
     * @param count  - How many frames should be animated
     */
    public SpriteAnimation(
            ImageView imageView,
            int offsetX, int offsetY,
            int width, int height,
            int count) {
        this.imageView = imageView;
        this.offsetX = startX = offsetX; this.offsetY = startY = offsetY;
        this.width = width; this.height = height;
        this.count = count;
        setCycleDuration(Duration.millis(1000));
        setInterpolator(Interpolator.LINEAR);
    }
    
    @Override
    protected void interpolate(double d) {
        final int index = Math.min((int) Math.floor(d*count),count-1);
        if(index != lastIndex)
        {
            if(offsetX < startX + width * (count-1)) {
                offsetX = offsetX + width;
            }
            else {
                offsetX = startX;
            }
            imageView.setViewport(
                    new Rectangle2D(offsetX, offsetY, width, height));
            lastIndex = index;
            
        }
    }
    
}
