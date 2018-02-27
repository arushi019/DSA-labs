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
class subset{
	public static int ct;
	public static double t;
	public static void rec(boolean[] b,int pt,long sum,int n){
		boolean[] b1=new boolean[n];
		for (int i=0;i<n;i++){
			b1[i]=b[i];
		}
		if (pt<n){
			b1[pt]=true;
			rec(b1,pt+1,sum+(pt+1),n);
			rec(b,pt+1,sum,n);
		}
		else{
			for (int i=0;i<n;i++){
				if (b[i]==true)System.out.print((i+1)+" ");
			}
			//if (b[n-1]==true)sum+=n;
			System.out.println();
			if (sum>=t)ct++;
			System.out.println(sum);
		}
	}
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
		int n=Reader.nextInt();
		boolean[] b=new boolean[n];
		ct=0;
		t=(double)(n*(n+1));
		t=t/4;
		t=Math.ceil(t);
		System.out.println(t);
		rec(b,0,0,n);
		System.out.println(ct);
		//b[0]=true;
		//rec(b,0,0,n);
	}
}