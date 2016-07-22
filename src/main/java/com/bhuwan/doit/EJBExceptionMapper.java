/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit;

import javax.ejb.EJBException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author bhuwan
 */
@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException> {

    @Override
    public Response toResponse(EJBException exception) {
        Throwable cause = exception.getCause();
        Response unKnownError = Response.serverError().header("cause", exception.toString()).build();
        if (cause == null) {
            return unKnownError;
        }

        if (cause instanceof OptimisticLockException) {
            return Response.status(Response.Status.CONFLICT).header("cause", "Conflict Occured: " + cause).build();
        }

        return unKnownError;
    }

}
