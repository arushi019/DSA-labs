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
class chinki{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        String s;
        int flag;
        while(t-->0){
            s=Reader.next();
            flag=0;
            int i=0;
            while(i<s.length()-1){
                if ((s.charAt(i)=='E')&&(s.charAt(i+1)=='C')){
                    flag=-1;
                    break;
                }
                else if ((s.charAt(i)=='S')&&(s.charAt(i+1)!='S')){
                    flag=-1;
                    break;
                }
                i++;
            }
            if (flag==-1)System.out.println("no");
            else System.out.println("yes");
        }
    }
}