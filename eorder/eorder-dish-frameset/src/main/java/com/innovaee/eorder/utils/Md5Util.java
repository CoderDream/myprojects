/***********************************************
 * Filename        : Md5Util.java 
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.innovaee.eorder.utils;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Title: Md5Util
 * @Description: MD5工具类
 *
 * @version V1.0
 */
public class Md5Util {

    /** 日志对象 */
    private static final Logger LOGGER = Logger.getLogger(Md5Util.class);

    /** 最大的两位十六进制 */
    public static final Integer HEX_MAX = 0xFF;

    /**
     * 私有的默认构造函数
     */
    private Md5Util() {
    }

    /**
     * 获取MD5编码
     * 
     * @param str
     *            带编码的字符串
     * @return MD5编码结果
     */
    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException caught!");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("UnsupportedEncodingException caught!");
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(HEX_MAX & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(
                        Integer.toHexString(HEX_MAX & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(HEX_MAX & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }

}