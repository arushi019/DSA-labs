package OOPintro;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private String name;
	private double salary;
	private Date hireDay;
	
	
	public Employee(String name, double s, int year, int month, int day)
	{
	this.name = name;
	salary = s;
	GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
	// GregorianCalendar uses 0 for January
	hireDay = calendar.getTime();
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public void tripleValue(double x) 
	{
	   x = 3 * x;
	}

	public void tripleSalary(Employee e) 
	{
	  e.raiseSalary(300);
	}
	
}
