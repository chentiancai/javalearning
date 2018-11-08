package com.starseaing.reflecttest;

import java.lang.reflect.Method;

public class ObjectClassReflectionTest {

	public static void main(String[] args) throws Exception {
		// 获得Class
		DisPlay display= new DisPlay();
		Class<?> cls = display.getClass();
		// 通过Class获得DisPlay类的show方法
		Method method = cls.getMethod("show", String.class);
		// 调用show方法
		method.invoke(display, "小明");
		method.invoke(display, "小红");
	}
}

class DisPlay{
    public void show(String name) {
        System.out.println("Hello :" + name);
    }
}
