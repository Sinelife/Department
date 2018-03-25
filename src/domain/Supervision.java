package domain;

import java.sql.Date;

public class Supervision 
{
	private Date start;
	private Date end;
	private int scientist_id;
	private int scientific_theme_id;
	
	Supervision(Date start,Date end,int scientist_id,int scientific_theme_id)
	{
		this.start = start;
		this.end = end;
		this.scientist_id = scientist_id;
		this.scientific_theme_id = scientific_theme_id;
	}

	public Supervision()
	{
		
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
	
	public int getScientistId()
	{	
		return scientist_id;
	}
	
	public void setScientistId(int scientist_id)
	{	
		this.scientist_id = scientist_id;
	}
	
	public int getScientificThemeId()
	{	
		return scientific_theme_id;
	}
	
	public void setScientificThemeId(int scientific_theme_id)
	{	
		this.scientific_theme_id = scientific_theme_id;
	}
	
}
