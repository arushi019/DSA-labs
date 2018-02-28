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
class feb{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int x,y;
        int[] sieve=new int[2100];
        int i=2;
        while(i<2100){
            if (sieve[i]==0){
                int j=i*2;
                while(j<2100){
                    //System.out.println(j);  
                    sieve[j]=-1;
                    j=j+i;
                }
            }
            i++;
        }

        while(t-->0){
            x=Reader.nextInt();
            y=Reader.nextInt();
            int k=x+y+1;
            while((k<2100)&&(sieve[k]!=0))k++;
            System.out.println(k-x-y);
        }
    }
}