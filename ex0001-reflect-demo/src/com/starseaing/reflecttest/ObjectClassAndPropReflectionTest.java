package com.starseaing.reflecttest;

import java.lang.reflect.Field;

public class ObjectClassAndPropReflectionTest {

	public static void main(String[] args) throws Exception {
		Student A = new Student();
		A.setStuName("С��");
		A.setStuAge(20);

		Student B = new Student();
		copyBean(A, B);
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
	private static void copyBean(Object from, Object dest) throws Exception {
		// ȡ�ÿ���Դ�����Class����
		Class<?> fromClass = from.getClass();
		// ȡ�ÿ���Դ����������б�
		Field[] fromFields = fromClass.getDeclaredFields();
		// ȡ�ÿ���Ŀ������Class����
		Class<?> destClass = dest.getClass();
		Field destField = null;
		for (Field fromField : fromFields) {
			// ȡ�ÿ���Դ�������������
			String name = fromField.getName();
			// ȡ�ÿ���Ŀ��������ͬ���Ƶ�����
			destField = destClass.getDeclaredField(name);
			// �������ԵĿɷ�����
			fromField.setAccessible(true);
			destField.setAccessible(true);
			// ������Դ��������Ե�ֵ��������Ŀ�������Ӧ������
			destField.set(dest, fromField.get(from));
		}
	}

}

