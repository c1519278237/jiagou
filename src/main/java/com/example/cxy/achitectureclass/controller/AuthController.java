package com.example.cxy.achitectureclass.controller;

import com.example.cxy.achitectureclass.dto.LoginResponseDto;
import com.example.cxy.achitectureclass.dto.UserInfoDto;
import com.example.cxy.achitectureclass.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @project: myachitecture
 * @description:
 * @author: cxy
 * @Date: 2024/1/13 13:27
 * @copyright www.cxy.com
 */
@Api(tags = "登录接口")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserService userService;

    @ApiOperation("登录接口")
    @GetMapping("/login")
    public LoginResponseDto login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public boolean register(@RequestBody UserInfoDto userInfoDto) {
        return userService.register(userInfoDto);
    }

}
