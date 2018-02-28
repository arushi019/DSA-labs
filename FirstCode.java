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
public class FirstCode{
	public static void main(String[] args){
		System.out.println("Hello world");
		findfactorial();
	}
 	static void findfactorial(){
	inp i=new inp();
	String s=new String();
	s=i.getUserInput("Enter a number");
	//System.out.println(s);
	int j=Integer.parseInt(s);
	//System.out.println(i);
	int pro=1;
	while(j>0){
		pro=pro*j;
		j--;
	}
	System.out.println(pro);
}
}