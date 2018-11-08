package com.starseaing.reflecttest;

import java.lang.reflect.Field;

public class ObjectClassRuntimeCreateInstanceReflectionTest {

	public static void main(String[] args) throws Exception {
		Student A = new Student();
		A.setStuName("С��");
		A.setStuAge(20);

		Student B = (Student) copyBean(A);
		System.out.println(B.getStuName() + ":" + B.getStuAge());

	}

	/**
	 * ����ѧ��������Ϣ��
	 * 
	 * @param from
	 *            ����Դ����
	 * @param dest
	 *            ����Ŀ�����
	 * @throws Exception
	 *             ����
	 */
	private static Object copyBean(Object from) throws Exception {
		// ȡ�ÿ���Դ�����Class����
		Class<?> fromClass = from.getClass();
		// ȡ�ÿ���Դ����������б�
		Field[] fromFields = fromClass.getDeclaredFields();
		// ȡ�ÿ���Ŀ������Class����
		Object ints = fromClass.newInstance();
		for (Field fromField : fromFields) {
			// �������ԵĿɷ�����
			fromField.setAccessible(true);
			// ������Դ��������Ե�ֵ��������Ŀ�������Ӧ������
			fromField.set(ints, fromField.get(from));
		}

		return ints;
	}

}
