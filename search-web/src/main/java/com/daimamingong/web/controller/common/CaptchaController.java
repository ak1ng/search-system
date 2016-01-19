package com.daimamingong.web.controller.common;

import com.daimamingong.common.util.CaptchaUtil;
import com.daimamingong.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证码
 *
 * @author robben.qu
 */
@Controller
public class CaptchaController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaptchaController.class);

    /**
     * 生成验证码
     *
     * @param response
     */
    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public void captcha(HttpSession session, HttpServletResponse response) throws IOException {
        LOGGER.debug("生成验证码图片");
        // 设置响应头
        this.setResponseHeader(response);
        // 生成验证码
        CaptchaUtil captcha = new CaptchaUtil(120, 40, 4, 100);
        LOGGER.debug("验证码：" + captcha.getCode());
        session.setAttribute("code", captcha.getCode());
        captcha.write(response.getOutputStream());
    }

    /**
     * 设置响应头
     *
     * @param response
     */
    private void setResponseHeader(HttpServletResponse response) {
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpg");
    }
}
