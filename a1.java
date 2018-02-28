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
class a1{
    public static int m,n;
    public static int[] arr;
    public static boolean check;
    public static void rec(boolean[] cc,int pt,int pres){
        if (pres==m)check=true;
        else if ((pres<m)&&(pt<n)){
            boolean[] b1=new boolean[n];
            for (int i=0;i<pt;i++){
                b1[i]=cc[i];
            }
            b1[pt]=true;
            rec(b1,pt+1,pres+arr[pt]);
            rec(cc,pt+1,pres);
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            m=Reader.nextInt();
            arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextInt();
            }
            Arrays.sort(arr);
            check=false;
            boolean[] b=new boolean[n];
            rec(b,0,0);
            if (check==true)System.out.println("Yes");
            else System.out.println("No");
        }
    }
}