package com.innovaee.eorder.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.innovaee.eorder.entity.Role;
import com.innovaee.eorder.exception.DuplicateNameException;
import com.innovaee.eorder.utils.MessageUtil;
import com.innovaee.eorder.vo.RoleVO;

/**
 * @Title: RoleServiceTest
 * @Description: 角色服务测试类
 * @version V1.0
 */
public class RoleServiceTest extends BaseSpringTestCase {

    /** 角色服务类对象 */
    @Autowired
    private RoleService roleService;

    /** 角色名称 */
    private String roleName = "RoleName1";

    /** 角色描述 */
    private String roleDesc = "RoleDesc1";

    /** 角色状态 */
    private Boolean roleStatus = true;

    /**
     * 测试返回所有用户值对象
     */
    @Test
    public void getAllRoles() {
        List<RoleVO> allRoleVOs = roleService.findAllRoleVOs();
        Assert.assertNotNull(allRoleVOs);
        for (RoleVO rolevo : allRoleVOs) {
            LOGGER.debug(rolevo);
        }
    }

    /**
     * 先增加，再查找，再删除，再查找
     */
    @Test
    public void operateRole() {
        // 更新属性
        String newRoleName = "RoleName2";
        String newRoleDesc = "RoleDesc2";
        try { // 先新增一个对象
            Role role = new Role(roleName, roleDesc, roleStatus);

            // 1. 保存
            Role roleNew = roleService.addRole(role);

            roleNew.setRoleName(newRoleName);
            roleNew.setRoleDesc(newRoleDesc);
            // 2. 更新
            roleService.updateRole(roleNew);

            // 3. 查找
            // 3.1 根据角色名称查找角色
            Role roleDB = roleService.findRoleByRoleName(newRoleName);
            Assert.assertNotNull(roleDB);
            Assert.assertEquals(newRoleName, roleDB.getRoleName());
            Assert.assertEquals(newRoleDesc, roleDB.getRoleDesc());

            // 4. 移除
            roleService.deleteRole(roleNew.getId());

            // 3.2 通过角色ID查找角色
            // 得到新增后的ID
            Long newRoleId = roleNew.getId();
            roleDB = roleService.loadRole(newRoleId);
            Assert.assertNull(roleDB);
        } catch (DuplicateNameException e) {
            LOGGER.error(MessageUtil.getMessage("duplicate_name_exception",
                    newRoleName));
        }
    }

    /**
     * 查找（根据角色名称查找角色）
     */
    @Test
    public void findRoleByRoleName() {
        // 查找（根据角色名称查找角色）
        Role roleDB = roleService.findRoleByRoleName(roleName);
        Assert.assertNull(roleDB);
    }

}