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
class primelen{
    public static int[] prime;
    public static ArrayList<Integer> arr;
    public static void primearray(){
        int i=2;
        while(i<1000001){
            if (prime[i]==0){
                prime[i]=1;
                arr.add(i);
                for (int j=i*2;j<1000001;j=j+i){
                    prime[i]=-1;
                }
            }
            i++;
        }
        System.out.println(arr);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        prime=new int[1000001];
        prime[0]=-1;
        prime[1]=-1;
        arr=new ArrayList<Integer>();
        primearray();

    }
}