import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.Point;
import java.text.DecimalFormat;
 

 
 
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class nocoding{
    public static int code(char c){
        int ct=(int)c;
        return ct-97;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String s=Reader.next();
            long sum=(long)s.length();
            long cmp=s.length()*11;
            for (int i=0;i<s.length()-1;i++){
                //System.out.println(code(s.charAt(i))+" "+code(s.charAt(i+1)));
                int diff=code(s.charAt(i+1))-code(s.charAt(i));
                if (diff>0)sum+=(long)diff;
                else if (diff<0)sum+=(long)(26+diff);
            }
            System.out.println(sum+1>cmp?"NO":"YES");
        }
    }
}