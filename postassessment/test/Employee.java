package test;

import java.util.ArrayList;

public class Employee
{
	
	private String name;
	private int id;
	private double salary;
	private Role role;
	private Department department;
	private Employee manager;
	private int salaryIncreased;
	
	
	public Employee(String name, int id, double salary, Role role, Department dept, Employee manager)
	{
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.role = role;
		this.department = dept;
		this.manager = manager;
		
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	public Role getRole()
	{
		return role;
	}
	public void setRole(Role role) 
	{
		this.role = role;
	}
	public Department getDept()
	{
		return department;
	}
	public void setDept(Department dept) 
	{
		this.department = dept;
	}
	public Employee getManager()
	{
		return manager;
	}
	public void setManager(Employee manager)
	{
		this.manager = manager;
	}
	@Override
	public String toString() 
	{
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + ", role=" + role + ", department=" + department
				+ ", manager=" + manager + "]";
	}
	
	

}
