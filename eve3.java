import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.*;

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
public class eve3{
	public static void main(String[] args)throws IOException{
		int t,n;
		Reader.init(System.in);
		t=Reader.nextInt();
		while(t-->0){
			n=Reader.nextInt();
			int i;
			int j=n;
			int cnt=1;
			/*for (i=2;i<=n;i++){
				if ((n%i)==0){
					cnt++;
				}
			}*/
			//BigInteger bi1,bi2,bi3;
			//bi2=new BigInteger(n);
			for (i=2;i<=j;i++){
				/*bi1=new BigInteger(i);
				bi3=bi1.gcd(bi2);
				if (bi3>1)cnt++;*/
				n=j;
				int k=i;
				while (k!=0){
					if (n>k)n=n-k;
					else k=k-n;
				}
				if (n>1)cnt++;
			}
			System.out.print(cnt);
			if (t!=0)System.out.println();
		}
}
}