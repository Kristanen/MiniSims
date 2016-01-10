package hadleys.hope.minisims.entitysystem;

/**
 * Presents all entities in the game world.
 * @author Krista Iltanen
 */
public abstract class Entity {
    
    private final String id;
    
    /**
     * Constructor for entity.
     * @param id Unique identifier for the entity.
     */
    public Entity(final String id) {
        this.id = id;
        
        EntityManager.get().addEntity(this);
    }
    
    public abstract void update(double deltaTime);
    
    public String getId() {
        return this.id;
    }
    
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        
        if (object.getClass() != this.getClass()) {
            return false;
        }
        
        Entity other = (Entity) object;
        
        if (!other.id.equals(this.id)) {
            return false;
        }
        
        return true;
    }
}
