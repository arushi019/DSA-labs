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
class templela{
    public static boolean c1(int[] h,int n){
        if (n%2==0)return false;
        else return true;
    }
    public static boolean c2(int[] h){
        if (h[0]==1)return true;
        else return false;
    }
    public static boolean c3(int[] h,int n){
        if ((c1(h,n)==true)&&(c2(h)==true)){
            for (int i=0;i<=n/2;i++){
                if (h[i]!=i+1)return false;
            }
            for (int i=n/2+1;i<n;i++){
                if (h[i]!=h[n-1-i])return false;
            }
            return true;
        }
        else return false;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int s=Reader.nextInt();
        int n;
        int[] h;
        while(s-->0){
            n=Reader.nextInt();
            h=new int[n];
            for (int i=0;i<n;i++)h[i]=Reader.nextInt();
            if (c3(h,n))System.out.println("yes");
            else System.out.println("no");
        }
    }
}