//Arushi Chauhan 2016019 Btech 1st year
import java.io.*;
class inp{
	public String getUserInput(String prompt){
		String inputLine=null;
		System.out.print(prompt+" ");
		try{
			BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
			inputLine=is.readLine();
			if (inputLine.length()==0){
				return null;
			}
		}
		catch (IOException e){
			System.out.println("IOException: "+e);
		}
		return inputLine;
	}
}
public class practice{
	public static void main(String[] args){
	inp i=new inp();
	String s=i.getUserInput("Enter number denoting day of week");
	int k=Integer.parseInt(s);
	//implementation using switch case
	switch(k){
		case 1:System.out.println("Monday");
				break;
		case 2:System.out.println("Tuesday");
				break;		
		case 3:System.out.println("Wednesday");
				break;
		case 4:System.out.println("Thursday");
				break;
		case 5:System.out.println("Friday");
				break;
		case 6:System.out.println("Saturday");
				break;
		case 7:System.out.println("Sunday");
				break;
		default:System.out.println("Not valid");
	}
	//implementation using if-else
	/*
	if (k==1){
	System.out.println("Monday");
	}
	else if (k==2){
	System.out.println("Tuesday");
	} 
	else if (k==3){
	System.out.println("Wednesday");
	}
	else if (k==4){
	System.out.println("Thursday");
	}
	else if (k==5){
	System.out.println("Friday");
	}
	else if (k==6){
	System.out.println("Saturday");
	}
	else if (k==7){
	System.out.println("Sunday");
	}
	else{
	System.out.println("not valid");
	}*/
}
}