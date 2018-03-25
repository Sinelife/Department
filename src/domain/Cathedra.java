package domain;



;

public class Cathedra
{

	private int cathedra_id;
	private String name;
	private String phone;
	
	Cathedra(int cathedra_id, String name,String phone)
	{
		this.cathedra_id = cathedra_id; 
		this.name = name; 
		this.phone = phone;
	}
	
	
	public Cathedra() 
	{
		
	}


	public int getId()
	{	
		return cathedra_id;
	}
	
	public void setId(int scientific_theme_id)
	{	
		this.cathedra_id = scientific_theme_id;
	}
	
	public String getName() 
	{
		return name;	
	}
	
	public void setName(String name) 
	{
		this.name = name;	
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
