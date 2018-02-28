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
class chefsign{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String s=Reader.next();
            int i=1;
            int max=0;
            int flag=0;
            int ct=1;
            if (s.charAt(0)=='<')flag=-1;
            else if (s.charAt(0)=='>')flag=1;
            while(i<s.length()){
                if (flag==-1){
                    if (s.charAt(i)=='>'){
                        if (ct>max)max=ct;
                        ct=1;
                        flag=1;
                    }
                    else{
                        if (s.charAt(i)=='<')ct++;
                    }
                }
                else if (flag==1){
                    if (s.charAt(i)=='<'){
                        if (ct>max)max=ct;
                        ct=1;
                        flag=-1;
                    }
                    else{
                        if (s.charAt(i)=='>')ct++;
                    }
                }
                System.out.println(flag);
                i++;                
            }
            System.out.println(max+1);
        }
    }
}