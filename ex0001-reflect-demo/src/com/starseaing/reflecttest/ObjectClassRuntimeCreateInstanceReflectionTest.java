package com.starseaing.reflecttest;

import java.lang.reflect.Field;

public class ObjectClassRuntimeCreateInstanceReflectionTest {

	public static void main(String[] args) throws Exception {
		Student A = new Student();
		A.setStuName("小明");
		A.setStuAge(20);

		Student B = (Student) copyBean(A);
		System.out.println(B.getStuName() + ":" + B.getStuAge());

	}

	/**
	 * 拷贝学生对象信息。
	 * 
	 * @param from
	 *            拷贝源对象
	 * @param dest
	 *            拷贝目标对象
	 * @throws Exception
	 *             例外
	 */
	private static Object copyBean(Object from) throws Exception {
		// 取得拷贝源对象的Class对象
		Class<?> fromClass = from.getClass();
		// 取得拷贝源对象的属性列表
		Field[] fromFields = fromClass.getDeclaredFields();
		// 取得拷贝目标对象的Class对象
		Object ints = fromClass.newInstance();
		for (Field fromField : fromFields) {
			// 设置属性的可访问性
			fromField.setAccessible(true);
			// 将拷贝源对象的属性的值赋给拷贝目标对象相应的属性
			fromField.set(ints, fromField.get(from));
		}

		return ints;
	}

}
