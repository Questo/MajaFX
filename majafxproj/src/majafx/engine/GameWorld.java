package majafx.engine;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mathias
 */
public abstract class GameWorld {
    
    private final int FPS;
    private final String NAME;
    
    private Timeline gameLoop;
    private Scene gameSurface;
    private Group gameNodes;
    
    private SpriteManager spriteManager = new SpriteManager();
    
    /**
     * Constructor is called from derived class. This will
     * set the frames per second, title and setup the game loop.
     * 
     * @param FPS - Frames per second
     * @param NAME - Title of the Application Window
     */
    public GameWorld(final int FPS, final String NAME) {
        this.FPS = FPS;
        this.NAME = NAME;
        
        // Create and set timeline for the game loop
        setupGameLoop();
    }
    
    /**
     * Initialize the game world by updating the primaryStage.
     * 
     * @param primaryStage 
     */
    public abstract void init(final Stage primaryStage);
    
    public void beginGameLoop() {
        getGameLoop().play();
    }
    
    /**
     * Builds and sets the game loop ready to be started.
     * Species what shall be done each time the game is updated.
     */
    protected void setupGameLoop() {
        final Duration interval = Duration.millis(1000 / (float) getFPS());
        final KeyFrame keyFrame = new KeyFrame(interval,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                // update actors
                updateSprites();
                
                // check for collisions
                checkCollisions();
                
                // remove dead actors
                cleanupSprites();
                
            }
        });
        
        // set the Timeline for the game
        setGameLoop(TimelineBuilder.create()
                .cycleCount(Animation.INDEFINITE)
                .keyFrames(keyFrame)
                .build());
    }
    
    /**
     * Updates each sprite in the game world. The method will loop through
     * all the sprites in the game and pass them to the handleUpdate() method.
     * The Derived class should override the handleUpdate() method.
     */
    protected void updateSprites() {
        for(Sprite sprite : spriteManager.getAllSprites()) {
            handleUpdate(sprite);
        }
    }
    
    /**
     * Updates the sprite's position on the game surface.
     * 
     * @param sprite - Sprite to update
     */
    protected void handleUpdate(Sprite sprite) {
    }
    
    /**
     * Checks each game sprite against another object to determine if a
     * collision occured. The method will loop through each sprite
     * and passing it to the handleCollision() method.
     * 
     * The derived class should override the handleCollision() method.
     */
    protected void checkCollisions() {
        spriteManager.resetCollisionCheck();
        // check each sprite against other sprites
        for(Sprite spriteA : spriteManager.getCollisions()) {
            for(Sprite spriteB : spriteManager.getAllSprites()) {
                if(handleCollision(spriteA, spriteB)) {
                    break;
                }
            }
        }
    }
    
    /**
     * When two sprite objects collide this method can determine the course
     * of action. By default it returns false, meaning no collision occured.
     * 
     * @param spriteA - sprite to be compared ( checkCollisions() )
     * @param spriteB - sprite to be compared ( checkCollisions() )
     * @return 
     */
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        return false;
    }
    
    protected void cleanupSprites() {
        spriteManager.cleanupSprites();
    }
    
    /**
     * Returns the JavaFX Scene. This "surface" allows the developer to add
     * JavaFX Node objects onto the Scene.
     * @return 
     */
    public Scene getGameSurface() {
        return gameSurface;
    }
    
    /**
     * Returns all the game nodes that will be rendered onto the game surface.
     * All nodes are Group objects
     * @return 
     */
    public Group getGameNodes() {
        return gameNodes;
    }
    
    public String getName() { return NAME; }
    protected int getFPS() { return FPS; }
    protected Timeline getGameLoop() { return gameLoop; }
    protected SpriteManager getSpriteManager() { return spriteManager; }
    
    protected void setGameLoop(Timeline gameLoop) { this.gameLoop = gameLoop; }
    
    /**
     * Sets the JavaFX Scene. This is the game surface the 
     * developer uses to add nodes to the game.
     * 
     * @param gameSurface - The main game surface
     */
    protected void setGameSurface(Scene gameSurface) {
        this.gameSurface = gameSurface;
    }
    
    /**
     * Sets the JavaFX Group that will hold all the nodes which are 
     * rendered onto the game surface(Scene).
     * 
     * @param gameNodes - The root container having many child-nodes
     *                    to be displayed in the scene area
     */
    protected void setGameNodes(Group gameNodes) {
        this.gameNodes = gameNodes;
    }
    
}
