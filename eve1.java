import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


/** Class for buffered reading int and double values */
class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(
					 new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO add check for eof if necessary
			tokenizer = new StringTokenizer(
				   reader.readLine() );
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}
	
	static double nextDouble() throws IOException {
		return Double.parseDouble( next() );
	}
}
public class eve1{
	public static void main(String[] args)throws IOException{
		int n;
		String st=new String();
		Reader.init(System.in);
		st=Reader.next();
		int sum=0;
		for (n=0;n<st.length()-1;n++){
			if ((st.charAt(n)=='C')||(st.charAt(n)=='H')||(st.charAt(n)=='O')){
			if (Character.isDigit(st.charAt(n+1))==true){
			if (st.charAt(n)=='C')sum+=12*Integer.parseInt(String.valueOf(st.charAt(n+1)));
			else if (st.charAt(n)=='H')sum+=1*Integer.parseInt(String.valueOf(st.charAt(n+1)));
			else if (st.charAt(n)=='O')sum+=16*Integer.parseInt(String.valueOf(st.charAt(n+1)));
		}
		else {
			if (st.charAt(n)=='C')sum+=12;
			else if (st.charAt(n)=='H')sum+=1;
			else if (st.charAt(n)=='O')sum+=16;
		}
		}
		else if (st.charAt(n)=='(')
		{
			int i=n;
			int sum1=0;
			while (st.charAt(i)!=')'){
				if ((st.charAt(n)=='C')||(st.charAt(n)=='H')||(st.charAt(n)=='O')){
			if (Character.isDigit(st.charAt(n+1))==true){
			if (st.charAt(n)=='C')sum+=12*Integer.parseInt(String.valueOf(st.charAt(n+1)));
			else if (st.charAt(n)=='H')sum+=1*Integer.parseInt(String.valueOf(st.charAt(n+1)));
			else if (st.charAt(n)=='O')sum+=16*Integer.parseInt(String.valueOf(st.charAt(n+1)));
		}
		else {
			if (st.charAt(n)=='C')sum+=12;
			else if (st.charAt(n)=='H')sum+=1;
			else if (st.charAt(n)=='O')sum+=16;
		}
			}
			i++;
		}
		sum=sum+sum1*st.charAt(n+1);
		}
		System.out.print(sum);

	}
}
}