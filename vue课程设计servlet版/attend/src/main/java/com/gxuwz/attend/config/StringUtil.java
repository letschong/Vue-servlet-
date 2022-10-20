package com.gxuwz.attend.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理操作类
 * @author amu_1115@126.com
 * @version 1.0
 */
public class StringUtil {

    /**
     * 正则去除字符串空格
     * @param s
     * @return
     */
    public static String trim(String s){
          if(s==null){
             return "";
          }
          Pattern p = Pattern.compile("\\s+");
          Matcher  m =p.matcher(s);
          return m.replaceAll("");
    }

    /**
     * 是否空字符串
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
          return "".equals(trim(s));
    }
}
