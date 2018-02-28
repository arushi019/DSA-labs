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
class abrepeat{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            long k=(long)Reader.nextInt();
            String s=Reader.next();
            long[] arr=new long[n];
            long ct=0;
            ArrayList<Integer> pos=new ArrayList<Integer>();
            for (int i=n-1;i>=0;i--){
                if (s.charAt(i)=='b')ct++;
                arr[i]=ct;
                if(s.charAt(i)=='a')pos.add(i);
            }
            //for (int i=0;i<n;i++)System.out.print(arr[i]+" ");
            //System.out.println();
            ct=0;
            for (int i=pos.size()-1;i>=0;i--){
                ct+=arr[pos.get(i)];
            }
            //System.out.println(ct);
            ct=ct*(long)k;
            long dt=arr[0]*pos.size()*(long)(k*(k-1)/2);
            System.out.println(ct+dt);
        }
    }
}