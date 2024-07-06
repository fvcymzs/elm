package com.ymzs.elm.exception;

import com.ymzs.elm.advice.R;
import com.ymzs.elm.advice.ResultCode;

public class UesrNameOrPasswordException extends ApiException {

    @Override
    public R<Object> handleException() {
        return R.fail(ResultCode.NAME_OR_PASSWORD_ERROR.getCode(), ResultCode.NAME_OR_PASSWORD_ERROR.getMessage());
    }

}
