package com.jdr.maven.sc.integration.userconsumer.controller;

import com.jdr.maven.sc.integration.userconsumer.controller.api.ProviderService;
import com.jdr.maven.sc.integration.userconsumer.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhoude
 * @date 2019/10/15 10:51
 */
@RestController
@RequestMapping("/userConsumer")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProviderService providerService;

    /**
     * rest方式
     */
    @GetMapping(value = "/get/{name}")
    public UserModel getUserByName(@PathVariable("name") String userName) {
        return restTemplate.getForObject("http://user-provider/userProvider/get/" + userName, UserModel.class);
    }

    /**
     * feign方式
     */
    @GetMapping(value = "/feign/get/{name}")
    public UserModel getUserByNameToFeign(@PathVariable("name") String userName) {
        return providerService.getUserByName(userName);
    }

}
