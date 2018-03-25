package domain;

import java.sql.Date;

;

public class ScientificTheme 
{

	private int scientific_theme_id;
	private String title;
	private String customer;
	private Date start;
	private Date end;
	private int cathedra_id;
	
	ScientificTheme(int scientific_theme_id, String title,String customer,Date start,Date end,int cathedra_id)
	{
		this.scientific_theme_id = scientific_theme_id; 
		this.title = title; 
		this.customer = customer;
		this.start= start; 
		this.end = end;
		this.cathedra_id = cathedra_id;
	}
	
	
	public ScientificTheme() 
	{
		
	}


	public int getId()
	{	
		return scientific_theme_id;
	}
	
	public void setId(int scientific_theme_id)
	{	
		this.scientific_theme_id = scientific_theme_id;
	}
	
	public String getTitle() 
	{
		return title;	
	}
	
	public void setTitle(String title) 
	{
		this.title = title;	
	}
	
	public String getCustomer() 
	{
		return customer;	
	}
	
	public void setCustomer(String customer) 
	{
		this.customer = customer;	
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

}
