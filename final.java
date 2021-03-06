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
class fin{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] h=new int[n];
        boolean[] b=new int[n];
        int[] max=new int[n];
        for (int i=0;i<n;i++)max[i]=-1;
        int flag;
        int next;
        flag=0;
        for (int i=0;i<n;i++){
            next=Reader.nextInt();
            int j=i-1;
            while(j>=flag){
                if (h[j]<next){
                    max[j]=i;
                    b[j]=true;
                }
                j--;
            }
            System.out.println(j+" "+flag);
        }
        for (int i=0;i<n;i++)System.out.print(max[i]+" ");
    }
}