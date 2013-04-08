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
    private int width, height;
    private int col, row;
    
    private double oldX = vX;
    private double oldY = vY;
    
    private ImageView spriteView;
    private Image spriteSheet;
    
    /**
     * 
     * @param hp
     * @param x
     * @param y
     * @param spriteSheet
     * @param width
     * @param height
     * @param col
     * @param row 
     */
    public Player(int hp, int x, int y, Image spriteSheet,
            int width, int height, int col, int row) {
        this.hp = hp;
        this.x = x; this.y = y;
        this.width = width; this.height = height;
        this.col = col; this.row = row;
        this.spriteSheet = spriteSheet;
        
        // Load player image
        Image img = new Image(getClass()
                .getResourceAsStream("/res/spritesheet_trans.png"));
        spriteView = new ImageView(img);
        spriteView.setViewport(
                new Rectangle2D((width * col), (height * row), width, height));
        
        spriteView.setTranslateX(x);
        spriteView.setTranslateY(y);
        
        node = spriteView;
    }

    @Override
    public void update() {
    }

    public void addAnimations(Animation... anim) {
        animations.addAll(Arrays.asList(anim));
    }
    
    public ImageView getPlayerImage() { return spriteView; }
    
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getColumn() { return col; }
    public int getRow() { return row; }
    
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
