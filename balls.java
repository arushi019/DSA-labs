import java.io.*;
import java.util.*;
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
public class balls{
	String color;
	float radius;
	balls(String color, float radius){
		this.color=color;
		this.radius=radius;
	}
	public static void main(String[] args){
		balls b[]=new balls[100];
		int i,n;
		inp ip=new inp();
		float r;
		String c;
		char s1;
		String s;
		n=Integer.parseInt(ip.getUserInput("enter number of balls"));
		for(i=0;i<n;i++){
			s=ip.getUserInput("enter radius and color");
			s1=s.charAt(0);
			//r=Integer.parseInt(s1);
			r=Character.getNumericValue(s1);
			c=s.substring(2);
			/*System.out.println(r);
			System.out.println(c);*/
			b[i]=new balls(c,r);
			//System.out.println(b[i].color);

		}
		int cr,cb;
		cr=0;
		cb=0;
		for (i=0;i<n;i++){
			if (b[i].color=="red"){
				cr++;
				System.out.print("r");
			}
			if (b[i].color=="blue")cb++;
		}
		System.out.println(cr);
		System.out.println(cb);
	}
}