import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
 
 
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
class m8{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
        long n=(long)Reader.nextDouble();
        long k=(long)Reader.nextDouble();
        int m=Reader.nextInt();
        long temp=n/k;
        long i=0;
        long num;
        long ways=0;
        if (n%k==0){
            num=temp;
            ways=1;
        }
        else{
            num=temp+1;
            long p=n%k+k;
            //System.out.println(p);
            if(p%2==0)ways=2*num;
            else ways=num;
            
        }
        System.out.println(num+" "+(ways%m));
        }
    }
}