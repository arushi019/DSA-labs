import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class adtri{
	public static HashSet<Long> sq;
	public static void init(){
		sq=new HashSet<Long>();
		for (int i=1;i<500005;i++){
			long pr=(long)i*(long)i;
			sq.add(pr);
		}
	}
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
		int t=Reader.nextInt();
		init();
		while(t-->0){
			long n=Reader.nextLong();
			long hp=n*n;
			int flag=0;
			for (int i=(int)n-1;i>0;i--){
				long d=hp-(long)i*(long)i;
				if (sq.contains(d)){
					flag=-1;
					System.out.println("YES");
					break;
				}
			}
			if (flag==0)System.out.println("NO");
		}
	}
}