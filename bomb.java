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
class bomb{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
        int n=Reader.nextInt();
        String s=Reader.next();
        //System.out.println(s);
        boolean[] b=new boolean[n];
        int i=1;
        int ct=0;
        if ((n>1)&&(s.charAt(0)=='1')){
            b[0]=true;
            b[1]=true;
            ct+=2;
        }
        else if ((n==1)&&(s.charAt(0)=='1')){
            ct++;
        }
        else ct=0;
        while(i<n-1){
            if (s.charAt(i)=='1'){
                if (b[i]==false){
                    b[i]=true;
                    ct++;
                }
                if (b[i-1]==false){
                    b[i-1]=true;
                    ct++;
                }
                if (b[i+1]==false){
                    b[i+1]=true;
                    ct++;
                }
            }
            i++;
        }
        if ((n>2)&&(s.charAt(n-1)=='1')){
            if (b[n-1]==false)ct++;
            if (b[n-2]==false)ct++;
        }
        int j=0;
        /*while(j<n){
            System.out.print(b[j]+" ");
            j++;
        }*/
        System.out.println(n-ct);
    }}
}