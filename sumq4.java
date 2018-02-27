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
class sumq4{
    public static int pika(long[] arr,long key,int ini){
        int i=ini;
        while(i<arr.length){
            if (arr[i]>key)return i;
            i++;
        }
        return arr.length;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        try{
        int t=Reader.nextInt();
        while(t-->0){
            int p=Reader.nextInt();
            int q=Reader.nextInt();
            int r=Reader.nextInt();
            long[] a=new long[p];
            for (int i=0;i<p;i++)a[i]=Reader.nextLong();
            long[] b=new long[q];
            for (int i=0;i<q;i++)b[i]=Reader.nextLong();
            long[] c=new long[r];
            for (int i=0;i<r;i++)c[i]=Reader.nextLong();
            long[] suma=new long[p];
            long[] sumc=new long[r];
            long sum1=0;
            long sum3=0;
            Arrays.sort(a);
            Arrays.sort(b);
            Arrays.sort(c);
            for (int i=0;i<p;i++){
                suma[i]=sum1+a[i];
                sum1=suma[i];
            }
            for (int i=0;i<r;i++){
                sumc[i]=sum3+c[i];
                sum3=sumc[i];
            }
            long sum=0;
            int f_ini=0;
            int s_ini=0;
            for (int i=0;i<q;i++){
                int f_index=pika(a,b[i],f_ini);
                int s_index=pika(c,b[i],s_ini);
                f_ini=f_index;
                s_ini=s_index;
                long lf=(long)f_index;
                long sf=(long)s_index;
                if ((f_index!=0)&&(s_index!=0)){
                    long tt1=(b[i]*lf+suma[f_index-1])%1000000007;
                    long tt2=(b[i]*sf+sumc[s_index-1])%1000000007;
                    long pro=(tt1*tt2)%1000000007;
                    sum+=pro;
                }
            }
            sum=sum%1000000007;
            System.out.println(sum);
        }
    }
    catch(Exception e){
        return;
    }
    }
}  