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
class alienata{
    public static BigInteger[] at;
    public static BigInteger r_fib(int n){
        if (at[n].equals(BigInteger.ZERO)==false)return at[n];
        else{
            BigInteger temp=r_fib(n-1);
            BigInteger temp2=r_fib(n-2);
            at[n]=temp.add(temp2);
            BigInteger t=new BigInteger("1000000007");
            return at[n].mod(t);
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n;
        at=new BigInteger[100000000];
        at[0]=new BigInteger("2");
        at[1]=new BigInteger("7");
        while(t-->0){
            n=Reader.nextInt();
            BigInteger res=r_fib(n-1);
            //for (int i=0;i<n;i++)System.out.print(at[i]+" ");
            //System.out.println();
            System.out.println(res.longValue());
        }
    }
}