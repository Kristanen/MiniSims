package hadleys.hope.minisims;

import hadleys.hope.minisims.collisionsystem.CollisionManager;
import hadleys.hope.minisims.entitysystem.EntityManager;

/**
 * Represents the game as a whole.
 * @author Krista Iltanen
 */
public final class PoolGame implements Manager {
    
    private static PoolGame gPoolGame;
    
    /**
     * Creates the pool game.
     */
    public static void startUp() {
        
        if (gPoolGame != null) {
            throw new IllegalStateException("Tried to initialize PoolGame twice.");
        }
        
        gPoolGame = new PoolGame();
    }
    
    /**
     * 
     */
    public static void shutdow() {
        EntityManager.get().removeEntity(gPoolGame.poolTable.getId());
        gPoolGame = null;
    }
    
    /**
     * Returns the pool game object.
     * 
     * @return 
     */
    public static PoolGame get() {
        
        if (gPoolGame == null) {
            throw new IllegalStateException("PoolGame wasn't initialized before first get.");
        }
        
        return gPoolGame;
    }
    
    private PoolTable poolTable;
    
    private int hits;
    
    private PoolGame() {
        this.poolTable = new PoolTable("poolTable");
    }
    
    /**
     * Returns the pool table which is currently being played on.
     * 
     * @return 
     */
    public PoolTable getPoolTable() {
        return this.poolTable;
    }
    
    /**
     * Resets the game.
     */
    public void clearGame() {
        this.hits = 0;
        
        this.poolTable.clear();
        EntityManager.get().removeEntity(this.poolTable.getId());
        
        CollisionManager.get().clear();
        
        this.poolTable = new PoolTable("poolTable");
    }
    
    /**
     * Increases the amount of hits by one.
     */
    public void hitPerformed() {
        this.hits++;
    }
    
    /**
     * Returns the number of used hits.
     * @return 
     */
    public int getHits() {
        return this.hits;
    }
    
    @Override
    public void update(double deltaTime) {
        
    }
}
