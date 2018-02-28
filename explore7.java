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
class explore7{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int[] a=new int[n];
        int[] t=new int[n];
        float[] val=new float[n];
        for(int i=0;i<n;i++)a[i]=Reader.nextInt();
        for(int i=0;i<n;i++){
            t[i]=Reader.nextInt();
            val[i]=t[i]/a[i];
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n-1;j++){
                if (val[j]<val[j+1]){
                    float tem=val[j];
                    val[j]=val[j+1];
                    val[j+1]=tem;
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                }
            }
        }
        int cost=0;
        float value=0;
        for (int i=0;i<n;i++){
            if (cost+a[i]<=k){
                cost=cost+a[i];
                value=value+t[i];
            }
            else if (cost<k){
                int g=k-cost;
                float h=val[i];
                cost+=g;
                value+=h*g;
            }
            else break;
        }
        DecimalFormat df=new DecimalFormat("#.00");
        System.out.println(df.format(value));
    }
}