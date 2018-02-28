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
class explore2{
    public static int[] prime;
    public static void initi(){
        prime[0]=-1;
        prime[1]=-1;
        for (int i=2;i<1001;i++){
            if (prime[i]==0){
                for (int j=i*2;j<1001;j=j+i)prime[j]=-1;
                prime[i]=1;
        }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        prime=new int[1001];
        initi();
        String s=Reader.next();
        char c=Reader.next().charAt(0);
        int len=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==c)len++;
        }
        if (len==2)System.out.println("evenprime");
        else if (prime[len]==1)System.out.println("oddprime");
        else System.out.println("notprime");
    }
}