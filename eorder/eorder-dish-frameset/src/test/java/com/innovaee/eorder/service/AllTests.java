package com.innovaee.eorder.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @Title: AllTests
 * @Description: 单元测试包
 * @version V1.0
 */
@RunWith(Suite.class)
@SuiteClasses({ FunctionServiceTest.class, RoleServiceTest.class,
        UserServiceTest.class })
public class AllTests {

}