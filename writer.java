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
class writer{
public static void main(String[] args)throws IOException{
Reader.init(System.in);
int m=Reader.nextInt();
int n=Reader.nextInt();
String s=Reader.next();
int len=s.length();
while(n-->0){
String ch=Reader.next();
if (ch.charAt(0)=='T'){
String temp=Reader.next();
//s=s+temp;
len=len+temp.length();
}
if (ch.charAt(0)=='W'){
int t=Reader.nextInt();
len=len-t;
//s=s.substring(0,s.length()-t+1);
}
if (ch.charAt(0)=='C'){
System.out.println(len);
}
}
}
}

































