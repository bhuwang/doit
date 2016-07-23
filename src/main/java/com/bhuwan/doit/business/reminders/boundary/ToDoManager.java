/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.reminders.boundary;

import com.bhuwan.doit.business.logging.boundary.BoundaryLogger;
import com.bhuwan.doit.business.reminders.entity.ToDo;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bhuwan
 */
@Stateless
@Interceptors(BoundaryLogger.class)
public class ToDoManager {

    @PersistenceContext(unitName = "com.bhuwan.doit_doit_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public void removeById(long id) {
        try {
            ToDo reference = em.getReference(ToDo.class, id);
            this.em.remove(reference);
        } catch (EntityNotFoundException e) {
            // no worries, we just want to remove.
        }
    }

    public ToDo findById(long id) {
        return em.find(ToDo.class, id);
    }

    public List<ToDo> findAll() {
        return this.em.createNamedQuery(ToDo.FINDALL, ToDo.class).getResultList();
    }

    public ToDo save(ToDo todo) {
        return this.em.merge(todo);
    }

    ToDo update(ToDo todo) {
        return this.em.merge(todo);
    }

    public ToDo updateStatus(long id, boolean done) {
        ToDo todo = findById(id);
        if (todo == null) {
            return null;
        }
        todo.setDone(done);
        return todo;
    }

}
