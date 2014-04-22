package com.iti.jets.carpoolingV1.common;

// This object holds the user's information e.g.phone,name 

public class User {

	private String name,phone;
	private int userId;
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPhone(String phone)
	{
		this.phone = phone; 
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public int getUserId()
	{
		return this.userId;
	}
}
