/***********************************************
 * Filename        : UserFunctionVo.java 
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.innovaee.eorder.vo;

import com.innovaee.eorder.entity.Function;
import com.innovaee.eorder.entity.Role;
import com.innovaee.eorder.entity.User;

/**
 * @Title: UserFunctionVo
 * @Description: 用户功能值对象
 *
 * @version V1.0
 */
public class UserFunctionVO extends BaseVO {

    /** 对象序列化ID */
    private static final long serialVersionUID = -6837897041052541070L;

    /** 用户实体 */
    private User user;

    /** 角色实体 */
    private Role role;

    /** 功能实体 */
    private Function function;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    
    public String toString() {
        return "UserFunctionVo [user=" + user + ", role=" + role
                + ", function=" + function + "]";
    }

}