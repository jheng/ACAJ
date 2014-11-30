package com.jheng.app.entity;

import java.util.HashSet;
import java.util.Set;

public class ProjectGroup
{
	private Integer groupId;
	private String groupName;
	private Set<Employee> employeeList = new HashSet<Employee>();
	public Integer getGroupId()
	{
		return groupId;
	}
	public void setGroupId(Integer groupId)
	{
		this.groupId = groupId;
	}
	public String getGroupName()
	{
		return groupName;
	}
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public Set<Employee> getEmployeeList()
	{
		return employeeList;
	}
	public void setEmployeeList(Set<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}
	
}
