package domain;

import java.sql.Date;

;

public class Aspirant extends Scientist
{

	private int scientist_id;
	private String theme_aspirant;
	private Date protection;
	private Date start;
	private Date end;
	private int cathedra_id;
	private int teacher_scientist_id;
	
	Aspirant(int scientist_id, String theme_aspirant,Date protection,Date start,Date end,int cathedra_id,int teacher_scientist_id)
	{
		this.scientist_id = scientist_id; 
		this.theme_aspirant = theme_aspirant; 
		this.protection = protection;
		this.start= start; 
		this.end = end;
		this.cathedra_id = cathedra_id;
		this.teacher_scientist_id = teacher_scientist_id;
	}
	
	
	public Aspirant() 
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
	
	public String getThemeAspirant() 
	{
		return theme_aspirant;	
	}
	
	public void setThemeAspirant(String theme_aspirant) 
	{
		this.theme_aspirant = theme_aspirant;	
	}
	
	public Date getProtection() 
	{
		return protection;	
	}
	
	public void setProtection(Date protection) 
	{
		this.protection = protection;	
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
	
	public String toString()
	{
		return scientist_id +  theme_aspirant + start + end;
	}
}
