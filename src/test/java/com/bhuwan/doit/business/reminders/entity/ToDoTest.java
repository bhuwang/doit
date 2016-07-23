/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.reminders.entity;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author bhuwan
 */
public class ToDoTest {
 
    @Test
    public void validToDo(){
        ToDo toDo = new ToDo("implement", "description", 11);
        assertTrue(toDo.isValid());
    }
    
    @Test
    public void validToDo1(){
        ToDo toDo = new ToDo("implement", null, 9);
        assertTrue(toDo.isValid());
    }
    
    @Test
    public void invalidToDo1(){
        ToDo toDo = new ToDo("implement", null, 11);
        assertFalse(toDo.isValid());
    }
}
