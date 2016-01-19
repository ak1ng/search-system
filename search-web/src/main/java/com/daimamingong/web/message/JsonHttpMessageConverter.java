package com.daimamingong.web.message;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.model.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * 国际化JOSN响应数据
 *
 * @author robben.qu
 */
public class JsonHttpMessageConverter extends FastJsonHttpMessageConverter {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
        Result result = (Result) obj;
        String code = ResultCode.MESSAGE_CODE_PREFIX + result.getCode();
        String message = messageSource.getMessage(code, new Object[]{}, LocaleContextHolder.getLocale());
        result.setMsg(message);
        super.writeInternal(result, outputMessage);
    }
}
