package com.daimamingong.model.user;

import com.daimamingong.common.constants.ResultCode;
import com.daimamingong.model.Base;
import com.daimamingong.model.system.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * 用户信息实体
 *
 * @author robben.qu
 */
public class User extends Base<User> {

    private static final long serialVersionUID = -2161652700896968206L;

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = ResultCode.CODE_EMAIL_FORMAT_ERROR)
    @Email(message = ResultCode.CODE_EMAIL_FORMAT_ERROR)
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = ResultCode.CODE_PASSWORD_LENGTH_BETWEEN_6_AND_16)
    @Length(min = 6, max = 16, message = ResultCode.CODE_PASSWORD_LENGTH_BETWEEN_6_AND_16)
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 在线状态
     */
    private String onlineStatus;

    /**
     * 确认密码
     */
    private String confirmPassword;

    /**
     * 角色列表
     */
    private List<Role> roleList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
