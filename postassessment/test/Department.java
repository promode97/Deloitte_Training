package test;

public class Department
{
	
	private String name;
	private String area;
	public Department(String name, String area) 
	{
		super();
		this.name = name;
		this.area = area;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getLocation()
	{
		return area;
	}
	public void setLocation(String location)
	{
		this.area = area;
	}
	@Override
	public String toString() 
	{
		return "Department [name=" + name + ", area=" + area + "]";
	}
	
	

}
