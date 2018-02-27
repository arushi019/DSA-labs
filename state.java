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
class state{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        String[] city=new String[n];
        int i=0;
        while(i<n){
            x[i]=Reader.nextInt();
            y[i]=Reader.nextInt();
            city[i]=Reader.next();
            i++;
        }
        i=0;
        int dist;
        int min=Math.abs(x[0]-x[1])+Math.abs(y[1]-y[0]);
        int flag1=0;
        int flag2=0;
        int j;
        while(i<n){
            j=0;
            while(j<n){
                if (j!=i){
                dist=Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
                if (dist<min){
                    min=dist;
                    flag1=i;
                    flag2=j;
                }
            }
            j++;
            }
            i++;
        }
        if (flag1>flag2)System.out.print(city[flag2]+" "+city[flag1]);
        else System.out.print(city[flag1]+" "+city[flag2]);   
    }
}