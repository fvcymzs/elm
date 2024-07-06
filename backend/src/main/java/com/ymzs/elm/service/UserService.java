package com.ymzs.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymzs.elm.domain.User;
import com.ymzs.elm.vo.res.UserVO;

/**
 * @author ymzs
 * @description 针对表[user]的数据库操作Service
 */
public interface UserService extends IService<User> {

    User login(String userid, String password);

    Boolean checkUserid(String userid);

    Boolean register(String userid, String password, String username, Integer usersex);

    String toToken(User user);

    User fromToken(String token);

    UserVO getUserVO(User user);

    UserVO getUserVO(String userid);

    Boolean deleteUser(User user);

}
