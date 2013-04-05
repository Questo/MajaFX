package majafx.entities;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import majafx.engine.Sprite;

/**
 *
 * @author mpma
 */
public class Player extends Sprite {
    
    private int hp;
    private int x, y; // coordinates
    private int a;
    
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
        imgView.setFitWidth(100);
        imgView.setFitHeight(164);
        node = imgView;
    }

    @Override
    public void update() {
        System.out.println("^__^");
    }
}
