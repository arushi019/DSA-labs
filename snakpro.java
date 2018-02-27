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
class snakpro{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int r=Reader.nextInt();
        while(r-->0){
            int m=Reader.nextInt();
            if (m!=0){
            String s=Reader.next();
            int i=0;
            int flag1=0;
            while(i<m){
                if (s.charAt(i)=='H'){
                    if (flag1==0)flag1=1;
                    else {
                        flag1=-1;
                        break;
                    }
                }
                if (s.charAt(i)=='T'){
                    if (flag1!=1){
                        flag1=-1;
                        break;
                    }
                    if (flag1==1){
                        flag1=0;
                    }
                }
                i++;
            }
            if (flag1==0)System.out.println("Valid");
            else System.out.println("Invalid");}
            else System.out.println("Valid");
        }
    }
}
