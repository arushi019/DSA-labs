//Arushi Chauhan 2016019
//Day2 Java Refresher 
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
public class mystr{
	String s;
	mystr(String s){
		this.s=s;
	}
	public boolean palin(){
		//mastam mast
		int n,i;
		int flag=0;
		n=s.length();
		i=0;
		while(i<((int)n/2)){
			if (s.charAt(i)!=s.charAt(n-i-1)){
				return false;
			}
			i++;
		}
		return true;
	}
	public String sorto(){
		int i,j,temp;
		String t;
		int arr[]=new int[100];
		char ar[]=new char[100]; 
		for (i=0;i<s.length();i++){
			/*System.out.print((int)s.charAt(i));
			System.out.print(" ");*/
			arr[i]=(int)s.charAt(i);
		}
		for (i=0;i<s.length();i++){
			for (j=i;j<s.length();j++){
				if (arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for (i=0;i<s.length();i++){
			ar[i]=(char)arr[i];
		}
		t=String.valueOf(ar);
		/*for (i=0;i<s.length();i++){
			t.charAt(i)=(char)arr[i];
		}*/
		//System.out.print(t);
		return(t);

	}
	public String caesar(){
		int i,j;
		String t;
		char ar[]=new char[100];
		int arr[]=new int[100];
		for(i=0;i<s.length();i++){
			arr[i]=(int)s.charAt(i);
			arr[i]+=3;
		}
		for (i=0;i<s.length();i++){
			ar[i]=(char)arr[i];
		}
		t=String.valueOf(ar);
		/*for (i=0;i<s.length();i++){
			System.out.print((char)arr[i]);
		}*/
		return(t);
	}
	public static void main(String[] args){
		inp i=new inp();
		mystr m1=new mystr(i.getUserInput("enter a string"));
		mystr m2=new mystr(i.getUserInput("enter another string"));
		mystr m3=new mystr(i.getUserInput("enter third string"));
		System.out.println(m1.palin());
		System.out.println(m2.sorto());
		System.out.print(m3.caesar());
	}
}