package minisims.entitysystem;


public abstract class Entity {
    
    private final String id;
    
    public Entity(final String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
}
