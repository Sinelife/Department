package domain;

import java.sql.Date;

public class Magister extends Scientist
{

	private int scientist_id;
	private String theme_magister;
	private String reason;
	private Date start;
	private Date end;
	private int cathedra_id;
	private int teacher_scientist_id;
	
	Magister(int scientist_id, String theme_magister,String reason,Date start,Date end,int cathedra_id,int teacher_scientist_id)
	{
		this.scientist_id = scientist_id; 
		this.theme_magister = theme_magister; 
		this.reason = reason;
		this.start= start; 
		this.end = end;
		this.cathedra_id = cathedra_id;
		this.teacher_scientist_id = teacher_scientist_id;
	}
	
	
	public Magister() 
	{
		
	}


	public int getId()
	{	
		return scientist_id;
	}
	
	public void setId(int scientist_id)
	{	
		this.scientist_id = scientist_id;
	}
	
	public String getThemeMagister() 
	{
		return theme_magister;	
	}
	
	public void setThemeMagister(String theme_magister) 
	{
		this.theme_magister = theme_magister;	
	}
	
	public String getReason() 
	{
		return reason;	
	}
	
	public void setReason(String reason) 
	{
		this.reason = reason;	
	}
	
	public Date getStart() 
	{
		return start;
	}
	
	public void setStart(Date start) 
	{
		this.start = start;
	}
	
	public Date getEnd() 
	{
		return end; 
	}
	
	public void setEnd(Date end) 
	{
		this.end = end;
	}
	
	public int getCathedraId() 
	{
		return cathedra_id; 
	}
	
	public void setCathedraId(int cathedra_id) 
	{
		this.cathedra_id = cathedra_id; 
	}
	
	public int getTeacherScientistId() 
	{
		return teacher_scientist_id; 
	}
	
	public void setTeacherScientistId(int teacher_scientist_id) 
	{
		this.teacher_scientist_id = teacher_scientist_id; 
	}
}
