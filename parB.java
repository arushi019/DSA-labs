import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
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
    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}
class parB{
    public static long gcd(long m,long n){
        long a=m;
        long b=n;
        while(a!=b){
            if (a>b)a=a-b;
            else b=b-a;
        }
        return a;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        long l=Reader.nextLong();
        long r=Reader.nextLong();
        long y=gcd(l,r);
        if (y>1){
            if (r-l>1)System.out.println(l+" "+(l+1)+" "+r);
            else System.out.println("-1");
        }
        else if (r-l<2)System.out.println("-1");
        else{
            double t1=Math.sqrt(l);
            double t2=Math.sqrt(r);
            int j,k;
            for (j=2;j<=t1;j++){
                if (l%j==0)break;
            }
            if (l%j!=0)j=Integer.MAX_VALUE;
            for (k=2;k<=t2;k++){
                if (r%k==0)break;
            }
            if (r%k!=0)k=Integer.MAX_VALUE;
            long b1=Long.MAX_VALUE;
            long b2=Long.MAX_VALUE;
            if (j!=Integer.MAX_VALUE)b1=(l/j+1)*j;
            if (k!=Integer.MAX_VALUE)b2=(l/k+1)*k;
            long b=b1<b2?b1:b2;
            if (b!=Long.MAX_VALUE)System.out.println(l+" "+b+" "+r);
            else System.out.println("-1");
        }
    }
}