package majafx.entities;

import java.util.Arrays;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import majafx.engine.Sprite;
import majafx.engine.SpriteAnimation;

/**
 *
 * @author mpma
 */
public class Player extends Sprite {
    
    private int hp;
    private int x, y; // coordinates
    private int a;
    
    private double oldX = vX;
    private double oldY = vY;
    
    private ImageView imgView;
    
    public Player(int hp, int x, int y) {
        this.hp = hp;
        this.x = x; this.y = y;
        
        // Load player image
        Image img = new Image(getClass()
                .getResourceAsStream("/res/spritesheet_trans.png"));
        imgView = new ImageView(img);
        imgView.setViewport(
                new Rectangle2D((32*4), (64*a), 32, 64));
        
        imgView.setTranslateX(x);
        imgView.setTranslateY(y);
        
        node = imgView;
    }

    @Override
    public void update() {
    }
    
    public ImageView getPlayerImage() {
        return imgView;
    }
    
    public void addAnimations(Animation... anim) {
        animations.addAll(Arrays.asList(anim));
    }

   /* private void setupAnimations() {
        Animation walkUp = new SpriteAnimation(imgView, 0, 0, 32, 64, 3);
        walkUp.setCycleCount(Animation.INDEFINITE);

        Animation walkDown = new SpriteAnimation(imgView, 96, 0, 32, 64, 3);
        walkDown.setCycleCount(Animation.INDEFINITE);

        Animation walkLeft = new SpriteAnimation(imgView, 192, 0, 32, 64, 3);
        walkLeft.setCycleCount(Animation.INDEFINITE);

        Animation walkRight = new SpriteAnimation(imgView, 288, 0, 32, 64, 3);
        walkRight.setCycleCount(Animation.INDEFINITE);

        animations.add(walkUp);
        animations.add(walkDown);
        animations.add(walkLeft);
        animations.add(walkRight);
    }*/
}
