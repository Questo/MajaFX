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
     * Initialize the game world by updating the primaryStage
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
    
    protected void checkCollisions() {
    }
    
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        return false;
    }
    
    protected void cleanupSprites() {
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
    
    /**
     * Returns the name of the game.
     * @return 
     */
    public String getName() {
        return NAME;
    }
    
    protected int getFPS() {
        return FPS;
    }
    
    protected Timeline getGameLoop() {
        return gameLoop;
    }
    
    protected SpriteManager getSpriteManager() {
        return spriteManager;
    }
    
    protected void setGameLoop(Timeline gameLoop) {
    }
    
    protected void setGameSurface(Scene gameSurface) {
    }
    
    protected void setGameNodes(Group gameNodes) {
    }
    
}
