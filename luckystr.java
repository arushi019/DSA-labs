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
class luckystr{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int k=Reader.nextInt();
        int n=Reader.nextInt();
        String[] fav=new String[k];
        for (int i=0;i<k;i++){
            fav[i]=Reader.next();
        }
        //String[] find=new String[n];
        for (int i=0;i<n;i++){
            int flag=0;
            String temp=Reader.next();
            if (temp.length()>=47)System.out.println("Good");
            else{
                int j=0; 
                while(j<k){
                    if (temp.length()<fav[j].length())j++;
                    else{
                        if (temp.indexOf(fav[j])!=-1){
                            flag=-1;
                            break;
                        }
                        else j++;
                    }
                }
                if (flag==-1)System.out.println("Good");
            else System.out.println("Bad");
            }
            
        }
    }
}