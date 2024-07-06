package com.ymzs.elm.service.impl;

import com.ymzs.elm.domain.User;
import com.ymzs.elm.exception.UesrNameOrPasswordException;
import com.ymzs.elm.service.UserService;
import com.ymzs.elm.utils.Text2Img;
import com.ymzs.elm.vo.res.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymzs.elm.mapper.UserMapper;

/**
 * @author ymzs
 * @description 针对表[user]的数据库操作Service实现
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean checkUserid(String userid) {
        return userMapper.countByUserid(userid) > 0;
    }

    @Override
    public String toToken(User user) {
        if (user == null) {
            return "";
        }
        return user.getUserid() + ":" + user.getPassword();
    }

    @Override
    public User fromToken(String token) {
        if (!StringUtils.hasLength(token)) {
            return null;
        }
        String[] split = token.split(":");
        String userid = split[0];
        String password = split[1];
        return login(userid, password);
    }

    @Override
    public User login(String userid, String password) {
        User user = userMapper.selectOneByUseridAndPassword(userid, password);
        if (user == null) {
            throw new UesrNameOrPasswordException();
        }
        return user;
    }

    @Override
    public Boolean register(String userid, String password, String username, Integer usersex) {
        if (checkUserid(userid)) {
            return false;
        }
        User user = new User();
        user.setUserid(userid);
        user.setPassword(password);
        user.setUsername(username);
        user.setUsersex(usersex);
        user.setUserimg(Text2Img.getAvatar(username));
        return save(user);
    }

    @Override
    public UserVO getUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserid(user.getUserid());
        userVO.setUsername(user.getUsername());
        userVO.setUsersex(user.getUsersex());
        userVO.setUserimg(user.getUserimg());
        return userVO;
    }

    @Override
    public UserVO getUserVO(String userid) {
        User user = getById(userid);
        return getUserVO(user);
    }

    @Override
    public Boolean deleteUser(User user) {
        return removeById(user.getUserid());
    }

}
