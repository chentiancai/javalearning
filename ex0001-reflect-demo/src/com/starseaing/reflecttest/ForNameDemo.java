package com.starseaing.reflecttest;

import java.lang.reflect.Method;

public class ForNameDemo {

    /**
     * ��ں�����
     * 
     * @param args
     *            ����
     * @throws Exception
     *             ������Ϣ
     */
    public static void main(String[] args) throws Exception {
    	String s="java.lang.String";
        // ���Class
        Class<?> cls = Class.forName(s);
        // ͨ��Class�������Ӧ����ķ���
        Method[] methods = cls.getMethods();
        // ���ÿ��������
        for (Method method : methods) {
            System.out.println(method);
        }
    }

}
