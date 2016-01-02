package hadleys.hope.minisims.entitysystem;

/**
 * Presents all entities in the game world.
 * @author Krista Iltanen
 */
public abstract class Entity {
    
    private final String id;
    
    public Entity(final String id) {
        this.id = id;
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
