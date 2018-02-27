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
class probD{
    public static int[] prime;
    public static void initi(){
        prime[0]=0;
        prime[1]=0;
        int i=2;
        while(i<1000001){
            if (prime[i]==0){
                prime[i]=1;
                //System.out.print(i+" ");
                int j=i*2;
                while(j<1000001){
                    prime[j]=-1;
                    j=j+i;
                }
            }
            i++;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        prime=new int[1000001];
        initi();
        int a=Reader.nextInt();
        int b=Reader.nextInt();
        int k=Reader.nextInt();
        int i,j,len,min;
        min=-1;
        for (i=a;i<=b;i++){
            len=0;
        }
    }
}