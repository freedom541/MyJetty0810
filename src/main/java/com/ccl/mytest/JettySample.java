package com.ccl.mytest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ccl on 16/8/10.
 */
@Path("hello")
public class JettySample {
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) throws Exception {
        return "hello wolrd! "+name;
    }
}
