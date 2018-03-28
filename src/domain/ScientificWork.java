package domain;

public class ScientificWork 
{
	private int scientific_work_id;
	private String title;
	private String type;
	private int year;
	private int scientist_id;
	
	
	
	ScientificWork(int scientific_work_id, String title, String type, int scientist_id, int year)
	{
		this.scientific_work_id = scientific_work_id; 
		this.title = title; 
		this.type = type;
		this.scientist_id = scientist_id;
		this.year = year;
	}
	
	
	public ScientificWork() 
	{
		
	}
	
	
	public int getId() 
	{
		return scientific_work_id;
	}
	
	public void setId(int scientific_work_id) 
	{
		this.scientific_work_id = scientific_work_id;
	}
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public int getScientistId() 
	{
		return scientist_id;
	}
	
	public void setScientistId(int scientist_id) 
	{
		this.scientist_id = scientist_id;
	}

	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		this.year = year;
	}

}
