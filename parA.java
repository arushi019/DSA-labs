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
class parA{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n];
        //int[] b=new int[n-1];
        for (int i=0;i<n;i++){
            a[i]=Reader.nextInt();
        }
        long sum=0;
        Arrays.sort(a);
        for (int i=0;i<n-1;i++){
            sum+=(long)a[i+1]-(long)a[i];
        }
        sum+=(long)a[n-1]-(long)a[0];
        System.out.println(sum);
    }
}