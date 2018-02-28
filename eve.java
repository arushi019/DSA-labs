import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
public class eve{
	public static void main(String[] args)throws IOException{
		int a,b,n,l,r;
		Reader.init(System.in);
		a=Reader.nextInt();
		b=Reader.nextInt();
		int i=1;
		int flag=1;
		while ((i<=a)&&(i<=b)){
			if ((a%i==0)&&(b%i==0))flag=i;
			i++;
		}
		n=Reader.nextInt();
		while(n-->0){
			l=Reader.nextInt();
			r=Reader.nextInt();
			int j=l;
			int val=-1;
			while (j<=r){
				if (flag%j==0)val=j;
				j++;
			}
			System.out.println(val);
			if (n!=0)System.out.println();
		}


	}
}