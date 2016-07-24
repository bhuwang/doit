/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.monotoring.entity;

import com.bhuwan.doit.business.reminders.entity.ToDo;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.PostPersist;

/**
 *
 * @author bhuwan
 */
public class ToDoAuditor {
    
    @PostPersist
    public void onToDoUpdate(ToDo todo) {
        System.out.println("-----------todo = " + todo);
    }
}
