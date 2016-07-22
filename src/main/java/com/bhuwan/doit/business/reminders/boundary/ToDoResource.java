/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.reminders.boundary;

import com.bhuwan.doit.business.reminders.entity.ToDo;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author bhuwan
 */
public class ToDoResource {

    long id;
    ToDoManager manager;

    public ToDoResource(long id, ToDoManager manager) {
        this.id = id;
        this.manager = manager;
    }

    @DELETE
    public void remove() {
        manager.removeById(id);
    }

    @PUT
    @Path("/status")
    public Response updateStatus(JsonObject statusUpdate) {
        if (statusUpdate.containsKey("done")) {
            boolean done = statusUpdate.getBoolean("done");
            ToDo todo = manager.updateStatus(id, done);
            if (todo == null) {
                return Response.status(Response.Status.BAD_REQUEST).header("reason", "todo with id " + id + " doesn't exist").build();
            } else {
                return Response.ok(todo).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).header("reason", "JsonObject should contain filed 'done'").build();
        }
    }

    @PUT
    public ToDo update(ToDo todo) {
        todo.setId(id);
        return manager.save(todo);
    }

    @GET
    public ToDo find() {
        return manager.findById(id);
    }
}
