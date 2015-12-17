/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minisims.entitysystem;

/**
 *
 * @author Hicks48
 */
public class EntityManager {
    
    private static EntityManager gEntityManager;
    
    public static void startUp() {
        gEntityManager = new EntityManager();
    }
    
    public static void shutDown() {
        
    }
    
    public static EntityManager get() {
        
        if (gEntityManager == null) {
            throw new IllegalStateException("Entity Manager has not been initialized.");
        }
        
        return gEntityManager;
    }
    
    private EntityManager() {
        
    }
}
