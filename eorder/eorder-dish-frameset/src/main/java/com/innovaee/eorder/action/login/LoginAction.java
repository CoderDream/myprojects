/***********************************************
 * Filename        : LoginAction.java
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.innovaee.eorder.action.login;

import com.innovaee.eorder.action.BaseAction;

/**
 * @Title: LoginAction
 * @Description: 登录Action
 *
 * @version V1.0
 */
public class LoginAction extends BaseAction {

    /** 对象序列化ID */
    private static final long serialVersionUID = 6040009827802629154L;

    /**
     * 进入登录页面
     * 
     * @return
     */
    public String login() {
        return SUCCESS;
    }

    /**
     * 进入主页
     * 
     * @return
     */
    public String doLogin() {
        return SUCCESS;
    }

    /**
     * 退出系统
     * 
     * @return
     */
    public String logout() {
        return SUCCESS;
    }

    public String doHeader() {
        return SUCCESS;
    }

    public String doUserInfo() {
        return SUCCESS;
    }

    public String doRight() {
        return SUCCESS;
    }

    public String doBottom() {
        return SUCCESS;
    }

    /*
     * add a function item into menu list
     */
    public String doLeft() {
        return SUCCESS;
    }

    public String doComputer() {
        return SUCCESS;
    }

    public String doDefault() {
        return SUCCESS;
    }

    public String doError() {
        return SUCCESS;
    }

    public String doFilelist() {
        return SUCCESS;
    }

    public String doForm() {
        return SUCCESS;
    }

    public String doImglist() {
        return SUCCESS;
    }

    public String doImglist1() {
        return SUCCESS;
    }

    public String doImgtable() {
        return SUCCESS;
    }

    public String doIndex() {
        return SUCCESS;
    }

    public String doTab() {
        return SUCCESS;
    }

    public String doTools() {
        return SUCCESS;
    }

}