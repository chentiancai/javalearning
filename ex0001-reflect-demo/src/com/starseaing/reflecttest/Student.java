package com.starseaing.reflecttest;

/**
 * ѧ����
 */
public class Student {
	/** ���� */
	private String stuName;
	/** ���� */
	private int stuAge;

	/**
	 * ��ȡѧ��������
	 * 
	 * @return ѧ������
	 */
	public String getStuName() {
		return stuName;
	}

	/**
	 * ����ѧ������
	 * 
	 * @param stuName
	 *            ѧ������
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * ��ȡѧ������
	 * 
	 * @return ѧ������
	 */
	public int getStuAge() {
		return stuAge;
	}

	/**
	 * ����ѧ������
	 * 
	 * @param stuAge
	 *            ѧ������
	 */
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
}