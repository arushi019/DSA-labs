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
class julA{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        BigInteger con=BigInteger.valueOf(1000000007);
        while(t-->0){
            int n=Reader.nextInt();
            BigInteger pro=BigInteger.ONE;
            long[] a=new long[n];
            BigInteger p2=BigInteger.ONE;
            long pr=1;
            for (int i=0;i<n;i++){
                a[i]=Reader.nextLong();
                BigInteger p1=BigInteger.valueOf(a[i]);
                if (i!=0){
                    if (p2!=BigInteger.ONE)p2=p2.gcd(p1);
                }
                else p2=p1;
                //pr=(pr*(p1.longValue()%1000000007))%1000000007;
            }
            for (int i=0;i<n;i++){
                BigInteger temp=BigInteger.valueOf(a[i]).divide(p2);
                pro=pro.multiply(temp);
                pro=pro.mod(con);
            }
            pro=pro.mod(con);
            System.out.println(pro.longValue());
        }
    }
}