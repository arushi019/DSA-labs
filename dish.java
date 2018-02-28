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
class dish{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int i;
        while(n-->0){
            String[] a=new String[4];
            String temp;
            i=0;
            while(i<4){
                a[i]=Reader.next();
                i++;
            }
            i=0;
            int j,flag=-1,ct=0;
            while(i<4){
                flag=-1;
                temp=Reader.next();
                //System.out.println(temp);
                j=0;
                while(j<4){
                    if (a[j].equals(temp)){
                        //System.out.println(a[j]);
                        flag=0;
                        break;
                    }
                    j++;
                }
                if (flag==0)ct++;
                i++;
            }
            if (ct>=2)System.out.println("similar");
            else System.out.println("dissimilar");
        }
    }
}