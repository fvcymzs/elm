package com.ymzs.elm.controller;

import com.ymzs.elm.config.ElmProperties;
import com.ymzs.elm.domain.User;
import com.ymzs.elm.validation.ValidInfo;
import com.ymzs.elm.vo.req.LoginVO;
import com.ymzs.elm.vo.req.RegisterVO;
import com.ymzs.elm.vo.res.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymzs.elm.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    // 用户登录
    @PostMapping("/login")
    public Boolean login(@RequestBody @Validated LoginVO loginVO, HttpServletResponse response) {
        User user = userService.login(loginVO.getUserid(), loginVO.getPassword());
        Cookie cookie = new Cookie(ElmProperties.cookieToken, userService.toToken(user));
        cookie.setPath("/");
        cookie.setMaxAge(ElmProperties.cookieTokenExpire);
        response.addCookie(cookie);
        return true;
    }

    // 用户登出
    @PostMapping("/logout")
    public Boolean logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(ElmProperties.cookieToken, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return true;
    }

    // 检查用户名是否存在
    @GetMapping("/check/{userid}")
    public Boolean checkUserid(@PathVariable("userid") @NotNull(message = ValidInfo.USER_ID_NOT_NULL) String userid) {
        return userService.checkUserid(userid);
    }

    // 用户注册
    @PostMapping("/register")
    public Boolean register(@RequestBody @Validated RegisterVO registerVO) {
        return userService.register(registerVO.getUserid(), registerVO.getPassword(),
                registerVO.getUsername(), registerVO.getUsersex());
    }

    // 用户注销
    @DeleteMapping("/delete")
    public Boolean deleteUser(@RequestAttribute(ElmProperties.requestUser) User user) {
        return userService.deleteUser(user);
    }

    // 用户查询（根据id）
    @GetMapping("/{userid}")
    public UserVO getUser(@PathVariable("userid") @NotBlank(message = ValidInfo.USER_ID_NOT_NULL) String userid) {
        return userService.getUserVO(userid);
    }

    // 获取当前用户信息
    @GetMapping("/info")
    public UserVO currentUserInfo(@RequestAttribute(ElmProperties.requestUser) User user) {
        return userService.getUserVO(user);
    }

}
