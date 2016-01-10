package hadleys.hope.minisims.enitysystem;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hadleys.hope.minisims.entitysystem.EntityManager;
import hadleys.hope.minisims.test.utils.TestCollidableEntity;
import hadleys.hope.minisims.test.utils.TestEntity;
import hadleys.hope.minisims.test.utils.TestRenderableEntity;
import java.util.Arrays;

public class EntityManagerTest {
    
    @Test
    public void shouldBeAbleToGetAfterStartUpIsCalled() {
        EntityManager.startUp();
        assertTrue(EntityManager.get() != null);
    }
    
    @Test
    public void shouldNotReturnRenderableObjectsWhenThereAreNone() {
        EntityManager.startUp();
        
        new TestEntity("testEntity1");
        
        assertTrue(EntityManager.get().getRenderableObjects().isEmpty());
    }
    
    @Test
    public void shouldNotReturnCollidableObjectsWhenThereAreNone() {
        EntityManager.startUp();
        
        new TestEntity("testEntity1");
        
        assertTrue(EntityManager.get().getCollidableObjects().isEmpty());
    }
    
    @Test
    public void shouldReturnCollidableObjectsWhenTheyAreAdded() {
        EntityManager.startUp();
        
        new TestEntity("testEntity1");
        new TestRenderableEntity("testEntity2");
        new TestEntity("testEntity3");
        
        TestCollidableEntity collidable1 = new TestCollidableEntity("testCollidableEntity1");
        TestCollidableEntity collidable2 = new TestCollidableEntity("testCollidableEntity2");
        TestCollidableEntity collidable3 = new TestCollidableEntity("testCollidableEntity3");
        
        assertTrue(EntityManager.get().getCollidableObjects().containsAll(Arrays.asList(collidable1, collidable2, collidable3)));
    }
    
    @Test
    public void shouldReturnRenderableObjectsWhenTheyAreAdded() {
        EntityManager.startUp();
        
        new TestEntity("testEntity1");
        new TestCollidableEntity("testEntity2");
        new TestEntity("testEntity3");
        
        TestRenderableEntity renderable1 = new TestRenderableEntity("testRenderableEntity1");
        TestRenderableEntity renderable2 = new TestRenderableEntity("testRenderableEntity2");
        TestRenderableEntity renderable3 = new TestRenderableEntity("testRenderableEntity3");
        
        assertTrue(EntityManager.get().getRenderableObjects().containsAll(Arrays.asList(renderable1, renderable2, renderable3)));
    }
    
    @Test
    public void shouldReturnEmptyListWhenThereAreNoEntities() {
        EntityManager.startUp();
        
        assertTrue(EntityManager.get().getAllEntities().isEmpty());
    }
    
    @Test
    public void shouldReturnListOfAllEntitiesWhenThereAreMany() {
        EntityManager.startUp();
        
        TestEntity entity = new TestEntity("testEntity1");
        TestCollidableEntity collidable = new TestCollidableEntity("testEntity2");
        TestRenderableEntity renderable = new TestRenderableEntity("testRenderableEntity1");
        
        assertTrue(EntityManager.get().getAllEntities().containsAll(Arrays.asList(entity, renderable, collidable)));
    }
    
    @Test
    public void shouldRemoveEntityCorrectly() {
        TestEntity entity = new TestEntity("testEntity1");
        TestCollidableEntity collidable = new TestCollidableEntity("testEntity2");
        TestRenderableEntity renderable = new TestRenderableEntity("testRenderableEntity1");
        
        EntityManager.get().removeEntity(renderable.getId());
        
        assertTrue(!EntityManager.get().getAllEntities().contains(renderable));
        assertTrue(EntityManager.get().getAllEntities().containsAll(Arrays.asList(collidable, entity)));
    }
}
