package com.jdr.maven.sc.integration.userconsumer.controller.api;

import com.jdr.maven.sc.integration.userconsumer.model.UserModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * user-provider服务模块
 *
 * @author zhoude
 * @date 2020/8/17 21:23
 */
@FeignClient(name = "user-provider")
public interface ProviderService {

    @GetMapping(value = "/userProvider/get/{name}")
    UserModel getUserByName(@PathVariable("name") String userName);

}
