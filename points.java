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
class pt implements Comparable<pt>{
    int x;
    int y;
    public pt(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int compareTo(pt p1){
        if (this.x!=p1.x){return this.x-p1.x;}
        else return p1.y-this.y;
    }
}
class points{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            pt[] pp=new pt[n];
            for (int i=0;i<n;i++){
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                pp[i]=new pt(x,y);
            }
            Arrays.sort(pp);
            double dist=0.0;
            for (int i=0;i<n-1;i++){
                double d=Math.sqrt(Math.pow(pp[i].x-pp[i+1].x,2)+Math.pow(pp[i].y-pp[i+1].y,2));
                dist+=d;
            }
            DecimalFormat df=new DecimalFormat("0.00");
            System.out.println(df.format(dist));           
        }
    }
}