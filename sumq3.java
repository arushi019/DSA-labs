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
}
class sumq3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int p=Reader.nextInt();
            int q=Reader.nextInt();
            int r=Reader.nextInt();
            long[] a=new long[p];
            for (int i=0;i<p;i++)a[i]=(long)Reader.nextInt();
            long[] b=new long[q];
            for (int i=0;i<q;i++)b[i]=(long)Reader.nextInt();
            long[] c=new long[r];
            long[][] sum=new long[r][p];
            long[][] product=new long[r][p];
            for (int i=0;i<r;i++){
                c[i]=(long)Reader.nextInt();
                for (int j=0;j<p;j++){
                    sum[i][j]=c[i]+a[j];
                    product[i][j]=c[i]*a[j];
                }
            }
            for (int i=0;i<r;i++){
                for (int j=0;j<p;j++){
                    System.out.print(sum[i][j]+" ");
                }
                System.out.println();
            }
        
        for (int i=0;i<r;i++){
            for (int j=0;j<p;j++){
                System.out.print(product[i][j]+" ");
            }
            System.out.println();
        }
        //-----------------------------------------------
        for (int i=0;i<q;i++){
            int f_index=pika(a,b[i]);
            int s_index=pika(c,b[i]);
            
        }
    }
    }
}