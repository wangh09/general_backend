package com.whgb.utils;

import sun.misc.BASE64Decoder;

import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangh09 on 2017/6/16.
 */
public class TextUtils {
    public static BASE64Decoder base64Decoder = new BASE64Decoder();
    public static String base64Decode(String s) {
        String result = null;
        if (s != null) {
            try {
                byte[] b = base64Decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String  getIdByUUID(){
        String id = UUID.randomUUID().toString();
        id=id.replaceAll("-", "");
        return id;
    }
    public static String underline2Camel(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        //    StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("((_)[a-z])+?");

        Matcher matcher=pattern.matcher(line);
        while(matcher.find()) {
            String word = matcher.group();
            line = line.replace(word, word.toUpperCase().replace("_",""));
        }
        return line;
    }

    public static Date getNowTime() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8:00");
        Date dateTime = new Date();
        long chineseMills = dateTime.getTime() + timeZone.getRawOffset();
        Date chineseDateTime = new Date(chineseMills);
        return chineseDateTime;
    }

    public static Map<String,Object> buildControllerResult(int status, Object result) {
        Map<String,Object> res = new HashMap<String,Object>();
        if(status == 1) {
            res.put("status", 200);
            res.put("message", "成功!");
            if(result != null) {
                res.put("result",result);
            }
        }
        else if(status == 2){
            res.put("status", 210);
            res.put("message", "失败！");
        }
        return res;
    }
    public static Map<String,Object> catchControllerError(Exception e) {
        Map<String,Object> res = new HashMap<String,Object>();
        e.printStackTrace();
        res.put("status",210);
        res.put("message", TextUtils.underline2Camel(e.getCause().getMessage()));
        return res;
    }
}
