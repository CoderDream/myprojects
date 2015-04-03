/***********************************************
 * Filename        : MenuLinkVo.java 
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.innovaee.eorder.vo;

import java.util.List;

/**
 * @Title: MenuLinkVo
 * @Description: 菜单链接值对象（用于显示菜单）
 *
 * @version V1.0
 */

public class MenuLinkVO extends BaseVO {

    /** 对象序列化ID */
    private static final long serialVersionUID = 736234576556777192L;

    /** 菜单项排序号 */
    private String order;

    /** 菜单ID */
    private Long id;

    /** 父功能ID */
    private Long functionParent;

    /** 菜单名 */
    private String name;

    /** 功能名称 */
    private String functionName;

    /** 功能描述 */
    private String functionDesc;

    /** 功能图片 */
    private String functionPicture;

    /** 链接地址 */
    private String link;

    /** 菜单等级，1为父节点，2为子节点 */
    private String flag;

    /** 子节点菜单列表 */
    private List<MenuLinkVO> list;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<MenuLinkVO> getList() {
        return list;
    }

    public void setList(List<MenuLinkVO> list) {
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunctionPicture() {
        return functionPicture;
    }

    public void setFunctionPicture(String functionPicture) {
        this.functionPicture = functionPicture;
    }

    public Long getFunctionParent() {
        return functionParent;
    }

    public void setFunctionParent(Long functionParent) {
        this.functionParent = functionParent;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

}