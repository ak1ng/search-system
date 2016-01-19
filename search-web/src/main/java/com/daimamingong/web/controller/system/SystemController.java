package com.daimamingong.web.controller.system;

import com.daimamingong.model.common.Result;
import com.daimamingong.model.user.User;
import com.daimamingong.service.permission.PermissionService;
import com.daimamingong.web.controller.BaseController;
import com.daimamingong.web.controller.annotation.AccessRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 系统控制器
 *
 * @author robben.qu
 */
@Controller
@RequestMapping("admin")
public class SystemController extends BaseController {

    Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private PermissionService permissionService;

    /**
     * 主页
     *
     * @return
     */
    @AccessRequired
    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
    public String dashboard(HttpSession session, ModelMap modelMap) {
        logger.debug("主页");
        User user = super.getSessionUser(session);
        Result result = permissionService.getMenuList(user.getUserId());
        modelMap.put("menuList", result.getData());
        return "dashboard";
    }

    /**
     * 获取菜单列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMenuList.ajax", method = RequestMethod.POST)
    public Result getMenuList(HttpSession session) {
        logger.debug("获取菜单列表");
        User user = super.getSessionUser(session);
        return permissionService.getMenuList(user.getUserId());
    }
}
