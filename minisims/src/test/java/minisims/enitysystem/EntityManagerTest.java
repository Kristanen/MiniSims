/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minisims.enitysystem;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import minisims.entitysystem.EntityManager;

public class EntityManagerTest {
    
    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetIsCalledBeforeStartUp() {
        EntityManager.get();
    }
    
    @Test
    public void shouldBeAbleToGetAfterStartUpIsCalled() {
        EntityManager.startUp();
        assertTrue(EntityManager.get() != null);
    }
}
