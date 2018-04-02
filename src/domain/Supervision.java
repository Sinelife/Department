package domain;

import java.sql.Date;

public class Supervision implements Comparable
{
	private int supervisor_id;
	private Date start;
	private Date end;
	private int scientist_id;
	private int scientific_theme_id;
	private boolean ruler;
	
	Supervision(Date start,Date end,int scientist_id,int scientific_theme_id, boolean ruler, int supervisor_id)
	{
		this.start = start;
		this.end = end;
		this.scientist_id = scientist_id;
		this.scientific_theme_id = scientific_theme_id;
		this.ruler = ruler;
		this.supervisor_id = supervisor_id;
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

	public boolean isRuler() 
	{
		return ruler;
	}

	public void setRuler(boolean ruler) 
	{
		this.ruler = ruler;
	}

	public int getSupervisorId() 
	{
		return supervisor_id;
	}

	public void setSupervisorId(int supervisor_id) 
	{
		this.supervisor_id = supervisor_id;
	}

	
	
	
	public int compareTo(Object s) {
		int compare_id = ((Supervision) s).getSupervisorId();

		return this.supervisor_id - compare_id;
		/* For Descending order do like this */
		// return compareage-this.studentage;
	}
	
}
