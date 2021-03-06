package hadleys.hope.minisims.entitysystem;

import hadleys.hope.minisims.Manager;
import hadleys.hope.minisims.collisionsystem.Collidable;
import hadleys.hope.minisims.renderingsystem.Renderable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages all entities in the game world.
 * @author Krista Iltanen
 */
public class EntityManager implements Manager {
    
    private static EntityManager gEntityManager;
    
    /**
     * Activates the Entity Manager.
     */
    public static void startUp() {
        gEntityManager = new EntityManager();
    }
    
    /**
     * Shuts down the Entity Manager.
     */
    public static void shutDown() {
        gEntityManager.entities.clear();
        gEntityManager.renderableObjects.clear();
        gEntityManager.collidableObjects.clear();
        gEntityManager = null;
    }
    
    public static EntityManager get() {
        
        if (gEntityManager == null) {
            throw new IllegalStateException("Entity Manager has not been initialized.");
        }
        
        return gEntityManager;
    }
    
    private Map<String, Entity> entities;
    private List<Renderable> renderableObjects;
    private List<Collidable> collidableObjects;
    
    private EntityManager() {
        this.entities = new HashMap<String, Entity>();
        this.renderableObjects = new ArrayList<Renderable>();
        this.collidableObjects = new ArrayList<Collidable>();
    }
    
    /**
     * Adds entity to the list of all entities and to lists of collidable or renderable entities if it is collidable or renderable.
     * @param entity Entity which is being examined.
     */
    public void addEntity(final Entity entity) {
        this.entities.put(entity.getId(), entity);
        
        if (entity instanceof Renderable) {
            this.renderableObjects.add((Renderable) entity);
        }
        
        if (entity instanceof Collidable) {
            this.collidableObjects.add((Collidable) entity);
        }
    }
    
    public Entity getEntity(final String id) {
        return this.entities.get(id);
    }
    
    public List<Entity> getAllEntities() {
        return new ArrayList<Entity>(this.entities.values());
    }
    
    public List<Renderable> getRenderableObjects() {
        return this.renderableObjects;
    }
    
    public List<Collidable> getCollidableObjects() {
        return this.collidableObjects;
    } 
    
    /**
     * Removes the entity from the lists of entities and renderable or collidable entities.
     * @param id Unique identifier of the entity.
     * @return True if the entity isn't on the list and false if it is.
     */
    public boolean removeEntity(final String id) {
        Entity entity = this.entities.get(id);
        
        if (entity != null && entity instanceof Renderable) {
            this.renderableObjects.remove((Renderable) entity);
        }
        
        if (entity != null && entity instanceof Collidable) {
            this.collidableObjects.remove((Collidable) entity);
        }
        
        return this.entities.remove(id) != null;
    }

    @Override
    public void update(double deltaTime) {
        
    }
}
