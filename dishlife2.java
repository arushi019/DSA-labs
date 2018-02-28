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
class dishlife2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in); 
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            HashSet<Integer> h=new HashSet<Integer>();
            int flag=-1;
            for (int i=0;i<n;i++){
                int len=Reader.nextInt();
                int ct=0;
                for (int j=0;j<len;j++){
                    int temp=Reader.nextInt();
                    if (h.contains(temp)==false){
                        ct++;
                        h.add(temp);}
                }
                if (ct==0)flag=0;
            }
            if (h.size()!=k)System.out.println("sad");
            else if (flag==-1)System.out.println("all");
            else System.out.println("some");
        }
    }
}