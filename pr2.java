//Arushi Chauhan 2016019 Btech 1st year
import java.lang.*;
import java.util.*;
public class pr2{
	public static void main(String[] args){
		int i,j,h,l;
		for (i=1;i<=5;i++){
			for (j=0;j<i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		for (i=1;i<=5;i++){
			h=1;
			int line=0;
			l=5-i;
			for (j=0;j<l;j++){
				System.out.print(" ");
			}
			for(j=0;j<i;j++){
				System.out.print(String.format("%d%s",i," "));
			}
			System.out.println("");
			/*l=(int)((5-i)/2);
			for (j=0;j<l;j++){
				System.out.print(" ");
			}
			System.out.print(line);
			for(j=0;j<l;j++){
				System.out.print(" ");
			}
			System.out.println("");*/
			//System.out.println(String.format("%5d",line));
		}
	}
}