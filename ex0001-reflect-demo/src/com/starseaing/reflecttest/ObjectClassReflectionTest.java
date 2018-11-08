package com.starseaing.reflecttest;

import java.lang.reflect.Method;

public class ObjectClassReflectionTest {

	public static void main(String[] args) throws Exception {
		// ���Class
		DisPlay display= new DisPlay();
		Class<?> cls = display.getClass();
		// ͨ��Class���DisPlay���show����
		Method method = cls.getMethod("show", String.class);
		// ����show����
		method.invoke(display, "С��");
		method.invoke(display, "С��");
	}
}

class DisPlay{
    public void show(String name) {
        System.out.println("Hello :" + name);
    }
}
