package com.jheng.app.entity;


public class Employee
{
	private Integer empId;
	private String empName;
	private String empPasswd;
	private String email;
	private ProjectGroup projectGroup;
	public Integer getEmpId()
	{
		return empId;
	}
	public void setEmpId(Integer empId)
	{
		this.empId = empId;
	}
	public String getEmpName()
	{
		return empName;
	}
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getEmpPasswd()
	{
		return empPasswd;
	}
	public void setEmpPasswd(String empPasswd)
	{
		this.empPasswd = empPasswd;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public ProjectGroup getProjectGroup()
	{
		return projectGroup;
	}
	public void setProjectGroup(ProjectGroup projectGroup)
	{
		this.projectGroup = projectGroup;
	}
	
}
