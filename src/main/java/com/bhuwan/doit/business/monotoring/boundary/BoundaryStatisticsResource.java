/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.monotoring.boundary;

import java.util.LongSummaryStatistics;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author bhuwan
 */
@Path("boundary-statistics")
public class BoundaryStatisticsResource {

    @Inject
    MonitorSink ms;

    @GET
    public JsonObject get() {
        LongSummaryStatistics statistics = ms.getStatistics();
        return Json.createObjectBuilder().add("average-duration", statistics.getAverage()).
                add("invocation-count", statistics.getCount()).
                add("min-duration", statistics.getMin()).
                add("max-duration", statistics.getMax()).build();
    }
}
