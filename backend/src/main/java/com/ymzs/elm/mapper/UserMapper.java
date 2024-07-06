package com.ymzs.elm.mapper;
import com.ymzs.elm.domain.User;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ymzs
* @description 针对表[user]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectOneByUseridAndPassword(@Param("userid") String userid, @Param("password") String password);

    int countByUserid(@Param("userid") String userid);
}




