package com.example.demo1.v1.controller;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BasicsController {
    /**
     * 根据用户Id 查
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @ApiOperation(value = "登陆", notes = "登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户姓名", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "用户密码", required = true, dataType = "string"),
    })
    @RequestMapping(value = "/l")
    @ResponseBody
    public String login1(HttpServletRequest request, String username, String password){
        request.getSession().setAttribute("user",username);
        return "1";
    }
}
