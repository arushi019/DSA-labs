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
class chefzot{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        ArrayList<Integer> loc=new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            int temp=Reader.nextInt();
            if (temp==0)loc.add(i);
        }
        if (loc.size()==0)System.out.println(n);
        else if (loc.size()==1){
            int p1=loc.get(0);
            int p2=n-1-p1;
            if (p1>p2)System.out.println(p1);
            else System.out.println(p2);
        }
        else{
            int max=0;
            for (int i=1;i<loc.size();i++){
                int p1=loc.get(i);
                int p2=loc.get(i-1);
                if ((p1-p2-1)>max)max=p1-p2-1;
            }
            System.out.println(max);
        }
    }
}