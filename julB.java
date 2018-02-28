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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class julB{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        //int[][] mat=new int[n][n];
        long[] inp=new long[n];
        long[] out=new long[n];
        //int[] net=new int[n];
        int m=Reader.nextInt();
        for (int i=0;i<m;i++){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            x--;
            y--;
            long temp=Reader.nextLong();
            inp[y]+=temp;
            out[x]+=temp;
        }
        long ct1=0;
        //long ct2=0;
        for (int i=0;i<n;i++){
            //System.out.println(inp[i]+" "+out[i]);
            if (inp[i]-out[i]>0)ct1+=inp[i]-out[i];
        }
        //long ct=ct1<ct2?ct1:ct2;
        System.out.println(ct1);
    }
}