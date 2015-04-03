/***********************************************
 * Filename        : UserDetailsVo.java 
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.innovaee.eorder.vo;

import com.innovaee.eorder.entity.User;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title: UserDetailsVo
 * @Description: 用户详细信息值对象
 *
 * @version V1.0
 */
public class EOrderUserDetailVO extends BaseVO implements UserDetails {

    /** 对象序列化ID */
    private static final long serialVersionUID = -8100868011194735627L;

    /** 角色名称集合 */
    private Set<String> rolesName = new HashSet<String>();

    /** 用户 */
    private User user;

    /** 用户功能值对象列表 */
    private List<UserFunctionVO> userFunctions;

    public List<UserFunctionVO> getUserFunctions() {
        return userFunctions;
    }

    /**
     * 设置用户功能列表
     * 
     * @param userFunctions
     *            用户功能列表
     */
    public void setUserFunctions(List<UserFunctionVO> userFunctions) {
        this.userFunctions = userFunctions;

        if (!userFunctions.isEmpty()) {
            user = userFunctions.get(0).getUser();

            rolesName.clear();
            for (UserFunctionVO userFunctionVo : userFunctions) {
                rolesName.add(userFunctionVo.getRole().getRoleName());
            }
        }
    }

    /**
     * 获得所有授权
     * 
     * @return 授权信息集合
     */
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        for (UserFunctionVO ufv : userFunctions) {
            if (!StringUtils.isEmpty(ufv.getFunction().getFunctionPath())) {
                GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(
                        ufv.getFunction().getFunctionPath());
                grantedAuthorities.add(grantedAuthority);
            }
        }

        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.getUserStatus();
    }

    public Set<String> getRolesName() {
        return rolesName;
    }

    public User getUser() {
        return user;
    }

}