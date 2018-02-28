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
class ammeat{
    public static int min;
    public static int n;
    public static long am;
    public static long[] arr;
    public static void rec(long nee,int pt,boolean[] check){
        if (pt<=n){
            //for (int i=0;i<n;i++)System.out.print(check[i]+" ");
            //System.out.println();
            //System.out.println(nee);
        if (nee==am){
            int c=0;
            for (int i=0;i<n;i++)if (check[i]==true)c++;
            if (c<min)min=c;
        }
        else if ((nee<am)&&(pt<n)){
            boolean[] c1=new boolean[n];
            boolean[] c2=new boolean[n];
            for (int i=0;i<pt;i++){
                c1[i]=check[i];
                c2[i]=check[i];
            }
            c1[pt]=true;
            rec(nee+arr[pt],pt+1,c1);
            rec(nee,pt+1,c2);
        }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            am=Reader.nextLong();
            arr=new long[n];
            min=Integer.MAX_VALUE;
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextLong();
            }
            Arrays.sort(arr);
            boolean[] check=new boolean[n];
            rec(0,0,check);
            if (min!=Integer.MAX_VALUE)System.out.println(min);
            else System.out.println("-1");
        }
    }
}