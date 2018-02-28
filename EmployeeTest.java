package OOPintro;

public class EmployeeTest {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		// raise everyone's salary by 5%
		for (Employee e : staff)
			e.raiseSalary(5);
		
		// print out information about all Employee objects
		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() );
		
		
		int val=2;
		staff[0].tripleValue(val);
		System.out.println("Val is: "+ val);
		
		staff[0].tripleSalary(staff[0]);
		System.out.println("Salary is: "+ staff[0].getSalary());
		
	
	}
	
	
}
