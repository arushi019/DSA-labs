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
class hmgn{
    public static int n;
    public static long s;
    public static int[] arr;
    public static long[] sum;


    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            s=Reader.nextLong();
            arr=new int[n];
            sum=new long[n];
            long st=0;
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextInt();
            }
            Arrays.sort(arr);
            //create();
            /*for (int i=0;i<n;i++){
                System.out.println(arr[i]);
            }*/
            int flag=-1;
            for (int i=0;i<n;i++){
                sum[i]=st+(long)((long)arr[i]*(long)(n-i));
                st+=arr[i];
                if ((sum[i]==s)&&(flag==-1)){
                    flag=i;
                    break;
                }
            }
            //for (int i=0;i<n;i++)System.out.println(sum[i]);
            if (flag==-1)System.out.println("-1");
            else{
                System.out.println(arr[flag]);
            //if (h<n-1)System.out.println(sum[h]+" "+arr[h+1]*(n-1-h));
            
        }
            //if ((h<n-1)&&(sum[h]+arr[h+1]*(n-1-h)==s))System.out.println(arr[h]);
            //else if (sum[h]==s)System.out.println(arr[h]);
        }
    }
}