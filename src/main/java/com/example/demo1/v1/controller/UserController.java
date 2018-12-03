package com.example.demo1.v1.controller;

import com.example.demo1.common.customsection.LoginRequired;
import com.example.demo1.v1.bean.User;
import com.example.demo1.v1.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(value = "UserController", description = "用户")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据用户Id 查
     * @return
     */
    @LoginRequired
    @RequestMapping(value = "/selectUserById",method = RequestMethod.POST)
    @ApiOperation(value = "社区资讯", notes = "社区资讯")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户ID", required = true, dataType = "string"),
          })
    public User selectUserById(String userId){
        return userService.selectUserById(userId);
    }

}
