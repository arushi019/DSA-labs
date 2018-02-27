import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.lang.*;
 

 
 
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
}
class probC{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=Reader.nextInt();
        }
        int sum=15;
        for (int i=n-2;i>=0;i--){
            int j=i+1;
            while(a[j]>a[i])j++;
            System.out.println(a[j]);
        }
    }
}