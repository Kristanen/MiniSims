package hadleys.hope.minisims;

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
        
        this.clearGame();
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
    }

    @Override
    public void update(double deltaTime) {
        
    }
}
