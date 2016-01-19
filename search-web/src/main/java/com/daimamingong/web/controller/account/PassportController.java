package com.daimamingong.web.controller.account;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.web.controller.handler.ValidatorResultHandler;
import com.daimamingong.model.common.Result;
import com.daimamingong.model.user.User;
import com.daimamingong.service.passport.PassportService;
import com.daimamingong.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 账户控制器
 *
 * @author robben.qu
 * @since 2015年10月29日 10:54:43
 */
@Controller
@RequestMapping(value = "account")
public class PassportController extends BaseController {

    Logger LOGGER = LoggerFactory.getLogger(PassportController.class);

    @Autowired
    private PassportService passportService;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "login.html", method = RequestMethod.GET)
    public String initLogin() {
        LOGGER.debug("访问登录页面");
        return "account/login";
    }

    /**
     * 注册页面
     *
     * @return String
     */
    @RequestMapping(value = "register.html", method = RequestMethod.GET)
    public String preRegister() {
        LOGGER.debug("访问注册页面");
        return "account/register";
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login.ajax", method = RequestMethod.POST)
    public Result login(@Validated @ModelAttribute User user, BindingResult bindingResult) throws Exception {
        LOGGER.debug("登录");
        Result validateResult = ValidatorResultHandler.validate(bindingResult);
        if (ResultCode.CODE_SUCCESS.equals(validateResult.getCode()))
            return passportService.login(user);
        return validateResult;
    }

    /**
     * 用户激活
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "active.html", method = RequestMethod.GET)
    public Result active(@Validated @RequestParam String code, BindingResult bindingResult, HttpSession session)
            throws Exception {
        Result validateResult = ValidatorResultHandler.validate(bindingResult);
        if (ResultCode.CODE_SUCCESS.equals(validateResult.getCode()))
            return passportService.active(super.getSessionUser(session), code);
        return validateResult;
    }

    /**
     * 找回密码页面
     *
     * @return
     */
    @RequestMapping(value = "find_password.html", method = RequestMethod.GET)
    public String preFindPassword() {
        LOGGER.debug("访问找回密码页面");
        return "account/find_password";
    }

    /**
     * 注册
     *
     * @param user
     * @return Result
     */
    @RequestMapping(value = "register.ajax", method = RequestMethod.POST)
    public Result register(@Validated @ModelAttribute User user, BindingResult bindingResult) throws Exception {
        LOGGER.debug("注册");
        Result validateResult = ValidatorResultHandler.validate(bindingResult);
        if (ResultCode.CODE_SUCCESS.equals(validateResult.getCode()))
            return passportService.register(user);
        return validateResult;
    }

    /**
     * 校验用户是否已经存在
     *
     * @param userName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "checkUserName.ajax", method = RequestMethod.GET)
    public boolean checkUserName(@RequestParam(required = true) String userName) throws Exception {
        if (StringUtils.isBlank(userName) || ResultCode.CODE_SUCCESS != passportService.isExists(userName).getCode())
            return false;
        return true;
    }

    /**
     * 找回密码
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findPassword.ajax", method = RequestMethod.POST)
    public Result findPassword(@Validated @ModelAttribute User user, BindingResult bindingResult) throws Exception {
        LOGGER.debug("找回密码");
        Result validateResult = ValidatorResultHandler.validate(bindingResult);
        if (ResultCode.CODE_SUCCESS.equals(validateResult.getCode()))
            return passportService.findPassword(user);
        return validateResult;
    }

    /**
     * 重置密码
     *
     * @param newPassword
     * @param confirmPassword
     * @param code
     * @return
     */
    @RequestMapping(value = "resetPassword.ajax", method = RequestMethod.POST)
    public Result resetPassword(HttpSession session, @RequestParam String newPassword,
                                @RequestParam String confirmPassword, @RequestParam String code,
                                BindingResult bindingResult) throws Exception {
        Result validateResult = ValidatorResultHandler.validate(bindingResult);
        if (ResultCode.CODE_SUCCESS.equals(validateResult.getCode())) {
            User user = super.getSessionUser(session);
            Result result = passportService.resetPassword(user, newPassword, code);
            if (ResultCode.CODE_SUCCESS == result.getCode())
                session.invalidate(); // 注销SESSION
            return result;
        }
        return new Result(ResultCode.CODE_FAIL);
    }
}
