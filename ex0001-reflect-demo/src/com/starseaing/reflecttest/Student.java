package com.starseaing.reflecttest;

/**
 * 学生类
 */
public class Student {
	/** 姓名 */
	private String stuName;
	/** 年龄 */
	private int stuAge;

	/**
	 * 获取学生姓名。
	 * 
	 * @return 学生姓名
	 */
	public String getStuName() {
		return stuName;
	}

	/**
	 * 设置学生姓名
	 * 
	 * @param stuName
	 *            学生姓名
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * 获取学生年龄
	 * 
	 * @return 学生年龄
	 */
	public int getStuAge() {
		return stuAge;
	}

	/**
	 * 设置学生年龄
	 * 
	 * @param stuAge
	 *            学生年龄
	 */
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
}