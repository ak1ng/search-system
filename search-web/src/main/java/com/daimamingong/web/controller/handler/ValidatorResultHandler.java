package com.daimamingong.web.controller.handler;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.model.common.Result;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 验证器
 *
 * @author robben.qu
 */
public class ValidatorResultHandler {

    /**
     * 验证
     *
     * @param result
     * @return
     */
    public static Result validate(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return new Result(list.get(0).getDefaultMessage());
        }
        return new Result(ResultCode.CODE_SUCCESS);
    }
}
