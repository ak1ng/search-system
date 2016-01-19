package com.daimamingong.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.common.constants.SystemConstants;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController {

    Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * 基于注解的异常处理
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        // 根据不同的请求类型响应页面或JSON
        if (this.isJsonRequest(request))
            this.responseJson(request, response, ex);
        else
            this.responsePage(request, response, ex);
        return null;
    }

    /**
     * 是否是JSON请求
     *
     * @param request
     * @return
     */
    private boolean isJsonRequest(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (null != accept && accept.indexOf("application/json") > -1)
            return true;

        String contentType = request.getContentType();
        if (null != contentType && contentType.indexOf("application/json") > -1)
            return true;

        String XRequestedWith = request.getHeader("X-Requested-With");
        if (null != XRequestedWith && XRequestedWith.indexOf("XMLHttpRequest") > -1)
            return true;
        return false;
    }

    /**
     * 响应JSON
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    private void responseJson(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        LOGGER.error(ex.getMessage());
        // 设置响应头
        this.setResponseHeader(response);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(this.getJsonResult(ex));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 获取JSON响应数据
     *
     * @param ex
     * @return
     */
    private String getJsonResult(Exception ex) {
        String code = this.getExceptionCode(ex);
        String message = messageSource.getMessage(ResultCode.MESSAGE_CODE_PREFIX + code, new Object[]{},
                LocaleContextHolder.getLocale());
        return JSON.toJSONString(new Result(code, null, message), SerializerFeature.WriteMapNullValue);
    }

    /**
     * 设置响应头
     *
     * @param response
     */
    private void setResponseHeader(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
        response.setHeader("Expires", "1L");
    }

    /**
     * 响应页面
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    private String responsePage(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        return "error/500";
    }

    /**
     * 获得异常类型
     *
     * @param ex
     * @return
     */
    private String getExceptionCode(Exception ex) {
        String code = ResultCode.CODE_SYSTEM_ERROR;
        if (ex instanceof HttpMessageNotReadableException)
            code = ResultCode.CODE_PARAMETER_INVALID;
        else if (ex instanceof MissingServletRequestParameterException)
            code = ResultCode.CODE_PARAMS_MISS;
        return code;
    }

    /**
     * 设置SESSION值
     *
     * @param request
     * @param key
     * @param obj
     */
    public void setSessionAttribute(HttpServletRequest request, String key, Object obj) {
        request.getSession().setAttribute(key, obj);
    }

    /**
     * 删除SESSION值
     *
     * @param request
     */
    public void removeSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    /**
     * 获取SESSION用户
     *
     * @param session
     * @return
     */
    public User getSessionUser(HttpSession session) {
        Object sessionObject = session.getAttribute(SystemConstants.SESSION_KEY);
        if (null == sessionObject)
            return null;
        return (User) sessionObject;
    }
}
