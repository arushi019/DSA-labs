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
class ceildist{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            double n1=Reader.nextDouble();
            double n2=Reader.nextDouble();
            double n3=Reader.nextDouble();
            if (n1+n2<n3)System.out.println(n3-n1-n2);
            else{
                if (n1>n2){
                    if (n3<n1-n2)System.out.println(n1-n3-n2);
                    else System.out.println("0.0");
                }
                else{
                    if (n3<n2-n1)System.out.println(n2-n3-n1);
                    else System.out.println("0.0");
                }
            }
        }
    }
}