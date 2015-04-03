/***********************************************
 * Filename       : DishDao.java
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/
package com.innovaee.eorder.dao;

import com.innovaee.eorder.entity.Dish;

/**
 * @Title: DishDao
 * @Description: 菜品数据访问对象接口
 * 
 * @version V1.0
 */
public interface DishDao extends BaseDao<Dish> {

    /**
     * 根据菜品名称获取菜品对象
     * 
     * @param name
     *            菜品名称
     * @return 返回菜品对象或者null
     */
    public Dish getDishByName(final String name);

    /**
     * 根据分类ID获取菜品记录条数
     * 
     * @param categoryId
     *            分类ID
     * @return 返回菜品记录条数
     */
    public Integer getDishCountById(final Long categoryId);

}
