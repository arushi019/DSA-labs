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
class zou{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int h=Reader.nextInt();
        int[] k=new int[n];
        int i=0;
        while(i<n){
            k[i]=Reader.nextInt();
            i++;
        }
        int ptr=0;
        boolean hand=false;
        int cmd=-1;
        do{
            cmd=Reader.nextInt();
            if (cmd==1){
                if (ptr!=0)ptr--;
            }
            if (cmd==2){
                if (ptr!=n-1)ptr++;
            }
            if (cmd==3){
                if ((hand==false)&&(k[ptr]>0)){
                    hand=true;
                    k[ptr]--;
                }
            }
            if (cmd==4){
                if ((hand==true)&&(k[ptr]!=h)){
                    hand=false;
                    k[ptr]++;
                }
            }
        }
        while(cmd!=0);
        i=0;
        while(i<n){
            System.out.print(k[i]+" ");
            i++;
        }
    }
}
