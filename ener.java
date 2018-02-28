import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
 
 
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
class ener{
    public static int count(BigInteger num){
        int ct=0;
        while(!(num.equals(BigInteger.ZERO))){
            num=(num.and((num.divide(BigInteger.valueOf(2)))));
            ct++;
        }
        return ct;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int i=0;
        String s=new String();
        while(i<n){
            int temp=Reader.nextInt();
            s=s+(char)(temp+48);
            i++;
        }
        //System.out.println(s);
        String s2=Reader.next();
        i=0;
        int push=0;
        int c=Arrays.stream(s.split("0+")).mapToInt(String::length).max().orElse(0);
        while(i<p){
            if (s2.charAt(i)=='!'){
                push++;
                }
            else{
                push=push%n;
                String dup=s.substring(n-push,n)+s.substring(0,n-push);
                s=dup;
                //
                //BigInteger num=new BigInteger(s,2);
                //int c=count(num);
                //int c=Arrays.stream(s.split("0+")).mapToInt(String::length).max().orElse(0);
                if (c>k)System.out.println(k);
                else System.out.println(c);
            }
            i++;
        }
    }
}