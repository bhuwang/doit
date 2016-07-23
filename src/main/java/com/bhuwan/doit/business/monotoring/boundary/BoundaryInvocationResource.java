/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.monotoring.boundary;

import com.bhuwan.doit.business.monotoring.entity.CallEvent;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * invoke using the curl below:
 *
 * curl -i -H"Accept: application/json"
 * http://localhost:8080/doit/api/boundary-invocations
 *
 * @author bhuwan
 */
@Stateless
@Path("boundary-invocations")
public class BoundaryInvocationResource {

    @Inject
    MonitorSink ms;

    @GET
    public List<CallEvent> expose() {
        return this.ms.getRecentEvents();
    }
}
