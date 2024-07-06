package com.ymzs.elm.vo.req;

import com.ymzs.elm.validation.ValidInfo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdersNewVO {
    // 商家编号
    @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL)
    private Integer businessid;

    // 送货地址编号
    @NotNull(message = ValidInfo.DELIVERY_ADDRESS_ID_NOT_NULL)
    private Integer daid;
}
