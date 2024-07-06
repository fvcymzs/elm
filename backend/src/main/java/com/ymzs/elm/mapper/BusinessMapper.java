package com.ymzs.elm.mapper;
import java.util.List;

import com.ymzs.elm.domain.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author ymzs
* @description 针对表[business]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.Business
*/
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    List<Business> selectAllByOrdertypeid(@Param("ordertypeid") Integer ordertypeid);

    List<Business> selectAllByBusinessnameLike(@Param("businessname") String businessname);

    List<Business> selectAllByBusinessaddressLike(@Param("businessaddress") String businessaddress);
}




