package com.ccl.action;

import com.ccl.bean.User;
import com.ccl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by ccl on 16/8/10.
 */
@Path("user")
public class UserAction {
    @Autowired
    private UserService userService;
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getGreeting(@PathParam("id") Integer id) throws Exception {
        return userService.queryById(id);
    }
}