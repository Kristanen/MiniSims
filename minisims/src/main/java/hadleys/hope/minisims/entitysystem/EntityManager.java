package hadleys.hope.minisims.entitysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManager {
    
    private static EntityManager gEntityManager;
    
    public static void startUp() {
        gEntityManager = new EntityManager();
    }
    
    public static void shutDown() {
        gEntityManager = null;
    }
    
    public static EntityManager get() {
        
        if (gEntityManager == null) {
            throw new IllegalStateException("Entity Manager has not been initialized.");
        }
        
        return gEntityManager;
    }
    
    private Map<String, Entity> entities;
    
    private EntityManager() {
        this.entities = new HashMap<String, Entity>();
    }
    
    public void addEntity(final Entity entity) {
        this.entities.put(entity.getId(), entity);
    }
    
    public Entity getEntity(final String id) {
        return this.entities.get(id);
    }
    
    public List<Entity> getAllEntities() {
        return new ArrayList<Entity>(this.entities.values());
    }
    
    public boolean removeEntity(final String id) {
        return this.entities.remove(id) != null;
    }
}
