package com.starseaing.reflecttest;

import java.lang.reflect.Method;

public class ForNameDemo {

    /**
     * 入口函数。
     * 
     * @param args
     *            参数
     * @throws Exception
     *             错误信息
     */
    public static void main(String[] args) throws Exception {
    	String s="java.lang.String";
        // 获得Class
        Class<?> cls = Class.forName(s);
        // 通过Class获得所对应对象的方法
        Method[] methods = cls.getMethods();
        // 输出每个方法名
        for (Method method : methods) {
            System.out.println(method);
        }
    }

}
