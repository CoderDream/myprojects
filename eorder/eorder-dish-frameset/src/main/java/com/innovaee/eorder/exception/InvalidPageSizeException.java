/***********************************************
 * Filename       : InvalidPageSizeException.java
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.innovaee.eorder.exception;

import com.innovaee.eorder.utils.MessageUtil;

/**
 * @Title: CategoryServiceImpl
 * @Description: 非法分页大小异常。 分页大小必须大于0
 * 
 * @version V1.0
 */
public class InvalidPageSizeException extends BaseException {

    /**  */
    private static final long serialVersionUID = -5620691314368641941L;

    static {
        exceptionKey = "invalid_page_size_exception";
    }

    private int invalidPageSize;

    public InvalidPageSizeException(int invalidPageSize) {
        super();
        this.invalidPageSize = invalidPageSize;
    }

    public String getMessage() {
        return MessageUtil.getMessage(exceptionKey, "" + invalidPageSize);
    }
}
