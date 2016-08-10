package com.ccl.action;

import com.ccl.bean.User;
import com.ccl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by ccl on 16/8/10.
 */
@Path("user")
public class UserAction {
    @Autowired
    private UserService userService;
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=" + "UTF-8")
    @Consumes({ "application/json;charset=utf-8" })
    public User getGreeting(@PathParam("id") Integer id) throws Exception {
        return userService.queryById(id);
    }
}