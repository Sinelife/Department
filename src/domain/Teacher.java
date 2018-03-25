package domain;

import java.sql.Date;

;

public class Teacher extends Scientist
{

	private int scientist_id;
	private String position;
	private String status;
	private Date start;
	private int cathedra_id;
	
	Teacher(int scientist_id, String position,String status,Date start,int cathedra_id)
	{
		this.scientist_id = scientist_id; 
		this.position = position; 
		this.status = status;
		this.start= start; 
		this.cathedra_id = cathedra_id;
	}
	
	
	public Teacher() 
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
	
	public String getPosition() 
	{
		return position;	
	}
	
	public void setPosition(String position) 
	{
		this.position = position;	
	}
	
	public String getStatus() 
	{
		return status;	
	}
	
	public void setStatus(String status) 
	{
		this.status = status;	
	}
	
	public Date getStart() 
	{
		return start;
	}
	
	public void setStart(Date start) 
	{
		this.start = start;
	}
	
	public int getCathedraId() 
	{
		return cathedra_id; 
	}
	
	public void setCathedraId(int cathedra_id) 
	{
		this.cathedra_id = cathedra_id; 
	}

}
