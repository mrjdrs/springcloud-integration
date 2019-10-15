package com.jdr.maven.sc.integration.userprovider.controller;

import com.jdr.maven.sc.integration.userprovider.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author zhoude
 * @date 2019/10/15 10:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Map<String, UserModel> USERS = new HashMap<>();

    static {
        USERS.put("ZD", new UserModel("ZD", 20));
        USERS.put("JDR", new UserModel("JDR", 30));
    }

    @GetMapping(value = "/get/{name}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserModel getUserByName(@PathVariable("name") String userName) {
        return USERS.get(userName);
    }
}
