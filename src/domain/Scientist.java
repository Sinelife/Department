package domain;

import java.sql.Date;

;

public class Scientist
{

	private int scientist_id;
	private String surname;
	private String phone;
	
	Scientist(int scientist_id, String surname,String phone)
	{
		this.scientist_id = scientist_id; 
		this.surname = surname; 
		this.phone = phone;
	}
	
	
	public Scientist() 
	{
		
	}


	public int getId()
	{	
		return scientist_id;
	}
	
	public void setId(int scientific_theme_id)
	{	
		this.scientist_id = scientific_theme_id;
	}
	
	public String getSurname() 
	{
		return surname;	
	}
	
	public void setSurname(String surname) 
	{
		this.surname = surname;	
	}
	
	public String getPhone() 
	{
		return phone;	
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;	
	}

}

