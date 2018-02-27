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
class prB{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        long[] arr=new long[n];
        long sum=0;
        for (int i=0;i<n;i++){
            arr[i]=Reader.nextLong();
            sum+=arr[i];
        }
        long ct=0;
        long fs=0; 
        int pt=0; 
        while((pt<n)&&(fs<sum)){
            fs+=arr[pt]+arr[n-1-pt];
            for (int j=pt+1;j<n-1-pt;j++){
                long min=arr[j-1]<arr[j+1]?arr[j-1]:arr[j+1];
                long max=arr[j-1]>arr[j+1]?arr[j-1]:arr[j+1];
                if (max<arr[j]){
                    System.out.println("#1 "+(arr[j]-min));
                    fs+=arr[j]-min;
                    //arr[j]=arr[j]-min;
                }
                else if (min>arr[j]){
                    System.out.println("#2 1");
                    fs++;
                    //arr[j]--;
                }
                else{
                    System.out.println("#3 "+(arr[j]-min));
                    fs+=arr[j]-min;
                    //arr[j]=arr[j]-min;
                }
                System.out.println(j+" "+fs);
            }
            System.out.println();
            pt++;
            ct++;
        }
        System.out.println(ct);

    }
}