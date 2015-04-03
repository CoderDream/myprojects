/***********************************************
 * Filename       : CategoryAction.java 
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 03/01/2015
 ************************************************/

package com.innovaee.eorder.action.category;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.innovaee.eorder.action.BaseAction;
import com.innovaee.eorder.entity.Category;
import com.innovaee.eorder.exception.CategoryNotFoundException;
import com.innovaee.eorder.exception.DuplicateNameException;
import com.innovaee.eorder.exception.InvalidPageSizeException;
import com.innovaee.eorder.exception.PageIndexOutOfBoundExcpeiton;
import com.innovaee.eorder.service.CategoryService;
import com.innovaee.eorder.utils.Constants;
import com.innovaee.eorder.utils.MenuUtil;
import com.innovaee.eorder.utils.MessageUtil;
import com.innovaee.eorder.vo.CategoryVO;
import com.innovaee.eorder.vo.EOrderUserDetailVO;
import com.innovaee.eorder.vo.MenuLinkVO;

/**
 * @Title: CategoryAction
 * @Description: 菜品分类Action
 *
 * @version V1.0
 */
public class CategoryAction extends BaseAction {

    /** 对象序列化ID */
    private static final long serialVersionUID = -5184755551662453454L;

    /** 数据库中对应的菜单分类描述常量 */
    public static final String FUNCTION_DESC = "Category";

    /** 菜单分类名称 */
    private String name;

    /** 菜单分类图片 */
    private String picPath;

    /** 菜单分类值对象列表 */
    private List<CategoryVO> categoryvos = new ArrayList<CategoryVO>();

    /** 菜单分类服务类对象 */
    @Resource
    private CategoryService categoryService;

    /**
     * 进入菜单分类页面
     * 
     * @return
     */
    public String category() {

        refreshDataList();

        // 更新页面数据
        refreshPageData();
        return SUCCESS;
    }

    /**
     * 新增页面
     * 
     * @return
     */
    public String add() {
        // 更新页面数据
        renewPage();
        return SUCCESS;
    }

    /**
     * 保存菜单分类
     * 
     * @return
     */
    public String save() {
        // 更新页面数据
        renewPage();

        // 新增成功
        Category newCategory = null;
        CategoryVO categoryVO = null;
        try {
            categoryVO = new CategoryVO();
            if (null != name && !"".equals(name.trim())) {
                categoryVO.setName(name);
            } else {
                this.setMessage(MessageUtil.getMessage("category_name_empty"));
                return INPUT;
            }

            if (null != picPath && !"".equals(picPath.trim())) {
                categoryVO.setPicPath(picPath);
            } else {
                this.setMessage(MessageUtil
                        .getMessage("category_picture_empty"));
                return INPUT;
            }

            newCategory = categoryService.addCategory(categoryVO);

            if (null != newCategory) {
                this.setMessage(MessageUtil.getMessage("add_success"));
                this.setName("");
                this.setPicPath(Constants.DEFAULT_CATEGORY_PIC);
                renewPage();
            } else {
                this.setMessage(MessageUtil.getMessage("add_failure"));
                return INPUT;
            }
        } catch (DuplicateNameException e) {
            this.setMessage(MessageUtil.getMessage("duplicate_name_exception",
                    name));
            return INPUT;
        }

        return SUCCESS;
    }

    /**
     * 加载单个菜单分类信息
     * 
     * @return
     */
    public String edit() {
        if (null != id && !"".equals(id.trim())) {
            Category category;
            try {
                category = categoryService.getCategoryById(Long.parseLong(id));
                name = category.getName();
                picPath = category.getPicPath();
            } catch (CategoryNotFoundException e) {
                this.setMessage(MessageUtil.getMessage(
                        "category_not_found_exception", id.toString()));
            }

        }

        // 更新页面数据
        renewPage();

        return SUCCESS;
    }

    /**
     * 更新菜单分类
     * 
     * @return
     */
    public String update() {
        // 更新页面数据
        renewPage();
        try {
            CategoryVO categoryVO = null;
            // 查看用户名是否已存在
            Category category = categoryService.getCategoryById(Long
                    .parseLong(id));
            if (null == category) {
                this.setMessage(MessageUtil
                        .getMessage("category_not_found_exception"));
                return INPUT;
            } else {
                categoryVO = new CategoryVO();
                categoryVO.setId(category.getId());
            }

            if (null != name && !"".equals(name.trim())) {
                categoryVO.setName(name);
            } else {
                this.setMessage(MessageUtil.getMessage("category_name_empty"));
                return INPUT;
            }

            if (null != picPath && !"".equals(picPath.trim())) {
                categoryVO.setPicPath(picPath);
            } else {
                this.setMessage(MessageUtil
                        .getMessage("category_picture_empty"));
                return INPUT;
            }

            categoryService.updateCategory(categoryVO);
        } catch (DuplicateNameException e) {
            this.setMessage(MessageUtil.getMessage("duplicate_name_exception",
                    name));
            return INPUT;
        } catch (CategoryNotFoundException e1) {
            this.setMessage(MessageUtil.getMessage(
                    "category_not_found_exception", id));
            return INPUT;
        }

        this.setMessage(MessageUtil.getMessage("update_success"));
        return SUCCESS;
    }

    /**
     * 删除菜单分类
     * 
     * @return
     */
    public String remove() {
        // 更新页面数据
        refreshPageData();

        if (null != id) {
            try {
                categoryService.deleteCategory(Long.parseLong(id));
            } catch (CategoryNotFoundException e) {
                this.setMessage(MessageUtil.getMessage(
                        "category_not_found_exception", id));
                // 更新记录列表
                refreshDataList();
                return INPUT;
            }
        }

        this.setMessage(MessageUtil.getMessage("delete_success"));

        // 更新记录列表
        refreshDataList();

        return SUCCESS;
    }

    /**
     * 刷新页面数据
     */
    private void refreshPageData() {
        // 当前用户的工具栏
        List<MenuLinkVO> toolbarList = MenuUtil.getToolbarLinkVOList();

        List<MenuLinkVO> menuLink = null;
        if (null != toolbarList && 0 < toolbarList.size()) {
            // 第一个菜单分类对应的菜单
            menuLink = MenuUtil.getMenuLinkVOList(FUNCTION_DESC);
        }

        this.setToolbarList(toolbarList);
        this.setMenuList(menuLink);
        this.setCurrentFunctionDesc(FUNCTION_DESC);
        this.setCurrentToolbar(MenuUtil.getParentFunctionDesc(FUNCTION_DESC));

        EOrderUserDetailVO userDetail = (EOrderUserDetailVO) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        this.setLoginName(userDetail.getUser().getUsername());
    }

    /**
     * 刷新列表
     */
    private void refreshDataList() {
        Integer recordCount = categoryService.count();
        this.setCount(recordCount);
        Integer pageTotal = 1;
        if (0 == recordCount % Constants.PAGE_SIZE) {
            pageTotal = recordCount / Constants.PAGE_SIZE;
        } else {
            pageTotal = recordCount / Constants.PAGE_SIZE + 1;
        }
        this.setPageTotal(pageTotal);

        // 处理用户点击【上一页】和【下一页】边界情况
        if (pageNow > pageTotal) {
            pageNow = pageTotal;
            pageInput = pageNow;
        } else if (pageNow < 1) {
            pageNow = 1;
            pageInput = 1;
        }

        List<Category> categorys = null;
        try {
            if (null != pageInput) {
                if (pageInput > pageTotal) {
                    pageInput = pageTotal;
                    pageNow = pageTotal;
                } else if (pageInput < 1) {
                    pageNow = 1;
                    pageInput = 1;
                }

                categorys = categoryService.getCategoriesByPage(pageInput,
                        Constants.PAGE_SIZE);

                pageNow = pageInput;
            } else {
                categorys = categoryService.getCategoriesByPage(pageNow,
                        Constants.PAGE_SIZE);
            }
        } catch (PageIndexOutOfBoundExcpeiton e) {
            this.setMessage(MessageUtil.getMessage(
                    "page_out_of_bound_exception", pageNow.toString(),
                    pageTotal.toString()));
        } catch (InvalidPageSizeException e) {
            this.setMessage(MessageUtil.getMessage(
                    "invalid_page_size_exception",
                    Constants.PAGE_SIZE.toString()));
        }

        CategoryVO categoryvo = null;
        for (Category category : categorys) {
            categoryvo = new CategoryVO();
            BeanUtils.copyProperties(category, categoryvo);
            categoryvos.add(categoryvo);
        }
    }

    /**
     * 
     */
    private void renewPage() {
        // 更新页面数据
        refreshPageData();

        if (null == picPath || "".equals(picPath)) {
            this.setPicPath(Constants.DEFAULT_CATEGORY_PIC);
        }
    }

    public List<CategoryVO> getCategoryvos() {
        return categoryvos;
    }

    public void setCategoryvos(List<CategoryVO> categoryvos) {
        this.categoryvos = categoryvos;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

}