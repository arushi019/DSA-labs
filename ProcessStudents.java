//Name:Arushi Chauhan
//Roll no.2016019
//Btech CSE 1st year
//Day3 Java Refresher
class Student{
	String Rollnumber;
	String FullName;
	String Program;
	double CGPA;
	Student(String Rollnumber,String FullName,String Program,double CGPA){
		this.Rollnumber=Rollnumber;
		this.FullName=FullName;
		this.Program=Program;
		this.CGPA=CGPA;
	}
}

public class ProcessStudents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students=new Student[10];
		students[0]=new Student("2016123","Mehak Saha","B.Tech-CSE", 6.7);
		students[1]=new Student("2016021","Krishna Kumar","B.Tech-CSM", 8.7);
		students[2]=new Student("2016103","Balaram","B.Tech-CSE", 6.7);
		students[3]=new Student("2016211","Pooja Jain","B.Tech-ECE", 8.9);
		students[4]=new Student("2016120","Tanya Gupta","B.Tech-CSE", 4.5);
		students[5]=new Student("2016003","Prerna Saha","B.Tech-ECE", 8.7);
		students[6]=new Student("2016113","Valari Sinha","B.Tech-CSM", 8.3);
		students[7]=new Student("2016013","Mona Roy","B.Tech-CSE", 6.7);
		students[8]=new Student("2016112","Pulkit Saha","B.Tech-ECE", 9.7);
		students[9]=new Student("2016223","Pheona James","B.Tech-CSE", 9.3);
		ProcessStudents ps=new ProcessStudents();
		Student[] sortedlist=ps.SortStudents(students);
		ps.display(sortedlist);
	}

	private Student[] SortStudents(Student[] students) {
		int i,j,small,cmp;
		for (i=0;i<10;i++){
			small=i;
			for (j=(i+1);j<10;j++){
				if ((students[j].CGPA)<(students[small].CGPA))
					small=j;
				else if ((students[j].CGPA)==(students[small].CGPA)){
					cmp=students[j].Rollnumber.compareTo(students[small].Rollnumber);
					if (cmp<0)
						small=j;
				}}
				if (small!=i){
				Student temp=students[i];
				students[i]=students[small];
				students[small]=temp;}
			}
		
		return (students);
	}

	private void display(Student[] sortedlist) {
		int i;
		for (i=0;i<10;i++){
			System.out.print(sortedlist[i].Rollnumber);
			System.out.print(" ");
			System.out.print(sortedlist[i].FullName);
			System.out.print(" ");
			System.out.print(sortedlist[i].Program);
			System.out.print(" ");
			System.out.print(sortedlist[i].CGPA);
			System.out.println("");
		}
		
	}

}
