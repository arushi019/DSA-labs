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
}class ada1{
    static int current;
    static int add;
    static int f_hr;
    public static void recur(int hrs){
        if (hrs%add==0)current++;
        if (current==1)f_hr=hrs;
        else{
            current--;
            recur(hrs+1);
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int m=Reader.nextInt();
            add=m;
            current=n;
            if (add==1)System.out.println("No Sleep");
            else {recur(0);
            System.out.println(f_hr);}
        }
    }
}