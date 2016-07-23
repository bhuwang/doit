/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.reminders.boundary;

import com.bhuwan.doit.business.reminders.entity.ToDo;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author bhuwan
 */
@Path("todos")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class TodosResource {

    @Inject
    ToDoManager manager;

    @Path("{id}")
    public ToDoResource getResourceWithParamId(@PathParam("id") long id) {
        return new ToDoResource(id, manager);
    }

    @GET
    public List<ToDo> all() {
        return manager.findAll();
    }

    @POST
    public Response save(@Valid ToDo todo, @Context UriInfo info) {
        ToDo saved = manager.save(todo);
        long id = saved.getId();
        URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
        return Response.created(uri).build();
    }
}
