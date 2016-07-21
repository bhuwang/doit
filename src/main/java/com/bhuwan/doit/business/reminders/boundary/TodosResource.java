/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.reminders.boundary;

import com.bhuwan.doit.business.reminders.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author bhuwan
 */
@Path("todos")
public class TodosResource {

    @GET
    @Path("{id}")
    public ToDo find(@PathParam("id") long id) {
        return new ToDo("Implement rest endpoint " + id, "Rest endpoint implementation", 10);
    }

    @GET
    public List<ToDo> all() {
        List<ToDo> all = new ArrayList<>();
        all.add(find(5));
        return all;
    }

    @POST
    public void save(ToDo todo) {
        System.out.println("todo: " + todo);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") long id) {
        System.out.println("removed todo id: " + id);
    }
}
