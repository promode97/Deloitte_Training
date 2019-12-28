package test;

import java.util.ArrayList;

public class Association 
{
	
	private static ArrayList<Employee> emps;


	public static void main(String[] args)
	{
		generateEmployees();
		listAllEmployees();
		listEmployeesWithManager(emps.get(1));
		listEmployeesWithRole("dev");
		listEmployeesWithDept("dept2");
		
		

	}


	private static void listEmployeesWithManager(Employee emp) 
	{
		System.out.println();
		System.out.println("Employees manager "+emp.getName()+" ");
		for(Employee e: emps) {
			if(e.getManager()==emp) {
				System.out.println(e);
			}
		}
	}

	

	private static void listEmployeesWithDept(String dept)
	{
		for(Employee e: emps) {
			if(e.getDept().getName().equals(dept)) {
				System.out.println("Employee belonging to " +dept+ " "+e);
			}
		}
	}
	
	private static void listEmployeesWithRole(String role)
	{
		for(Employee e: emps) {
			if(e.getRole().getName().equals(role)) {
				System.out.println("Employee with role as "+role+" "+e);
			}
		}
	}

	private static void listAllEmployees()
	{
		for(Employee e:emps) {
			System.out.println(e);
		}
		
		
	}

	private static void generateEmployees() 
	{
		
		Role[] roles = generateRoles();
		Department[] dept  =generateDepartments();
		emps = new ArrayList<>();
		
		Employee e1 = new Employee("emp1",236,87500,roles[0],dept[0],null);
		Employee e2 = new Employee("emp2",543,19876,roles[0],dept[1],e1);
		Employee e3 = new Employee("emp3",999,32456,roles[1],dept[2],e2);
		Employee e4 = new Employee("emp4",879,98760,roles[1],dept[3],null);
		Employee e5 = new Employee("emp5",987,13579,roles[2],dept[0],e2);
		Employee e6 = new Employee("mp6",123,23456,roles[2],dept[1],null);
		
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		emps.add(e6);
	}

	private static Department[] generateDepartments()
	{
		Department[] dept = new Department[4];
		dept[0] = new Department("dept1","chn");
		dept[1] = new Department("dept2","hyd");
		dept[2] = new Department("dept3","blr");
		dept[3] = new Department("dept4","salem");
		return dept;
	}
	
	private static Role[] generateRoles() 
	{
		Role[] roles = new Role[3];
		roles[0] = new Role("manager");
		roles[1] = new Role("dev");
		roles[2] = new Role("testing");
		return roles;
	}

}
