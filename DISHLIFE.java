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
class DISHLIFE{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int i,j;
        while(t-->0){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            int[] islands=new int[k];
            for (i=0;i<n;i++){
                int num=Reader.nextInt();
                for (j=0;j<num;j++){
                    islands[Reader.nextInt()-1]++;
                }
            }
            int flag=0;
            Arrays.sort(islands);
            for(i=0;i<k;i++){
                if (islands[i]==0){
                    flag=-1;
                    break;
                }
                
            }
            if (flag==-1)System.out.println("sad");

        }
    }
}