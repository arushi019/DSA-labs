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
 //Q2 refresher module-Arushi Chauhan-2016019-sec-a

 
 
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
class p1{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        String s1=Reader.next();
        String s2=Reader.next();
        int[] a1=new int[26];
        int[] a2=new int[26];
        if (s1.length()!=s2.length()){
            System.out.println("No");
        }
        else{
            for (int i=0;i<s1.length();i++){
                int t1=(int)s1.charAt(i);
                int t2=(int)s2.charAt(i);
                a1[t1-97]++;
                a2[t2-97]++;
            }
            int flag=0;
            for (int i=0;i<26;i++){
                if (a1[i]!=a2[i]){flag=-1;break;}
            }
            if (flag==0)System.out.println("Yes");
            else System.out.println("No");
        }
    }
}