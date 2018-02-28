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
class julD{
    public static int[][] multip2(int[][] a,int n){
        int[][] b=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                b[i][j]+=
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        long k=Reader.nextLong();
        int[][] a=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                a[i][j]=Reader.nextInt();
            }
        }
    }
}