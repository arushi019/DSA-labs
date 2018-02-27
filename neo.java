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
class neo{
    public static int[] a;
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            a=new int[n];
            int i=0;
            for (i=0;i<n;i++)a[i]=Reader.nextInt();
            Arrays.sort(a);
            long pos_sum=0;
            int pos_ct=0;
            int neg_ct=0;
            for(i=n-1;i>=0;i--){
                if (a[i]>=0){
                    pos_sum+=a[i];
                    pos_ct++;
                }
                else break;
            }
            long sum=pos_sum;
            long neg_sum=0;
            for (int j=i;j>=0;j--){
                if ((sum+a[j])*(pos_ct+neg_ct+1)>sum*(pos_ct+neg_ct)){
                    //System.out.println(a[j]);
                    sum=sum+a[j];
                    neg_ct++;
                }
                else neg_sum+=a[j];
            }
            System.out.println((long)(sum*(pos_ct+neg_ct)+neg_sum));
        }
    }
}