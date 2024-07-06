package com.ymzs.elm.vo.req;

import com.ymzs.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginVO {
    // 用户编号
    @NotBlank(message = ValidInfo.USER_ID_NOT_NULL)
    private String userid;

    // 密码
    @NotBlank(message = ValidInfo.PASSWORD_NOT_NULL)
    private String password;

}
