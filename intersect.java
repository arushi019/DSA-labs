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
class intersect{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int m=Reader.nextInt();
        int n=Reader.nextInt();
        int i=0;
        int[] a=new int[m];
        int[] b=new int[n];
        int[] c=new int[m+n];
        int i1,i2,i3;
        while(i<m){
            a[i]=Reader.nextInt();
            i++;
        }
        i=0;
        while(i<n){
            b[i]=Reader.nextInt();
            i++;
        }
        i1=0;
        i2=0;
        i3=0;
        while((i1<m)&&(i2<n)){
            if (a[i1]==b[i2]){
                c[i3]=a[i1];
                i3++;
                i1++;
                i2++;
            }
            else if (a[i1]>b[i2]){
                i2++;
            }
            else{
                i1++;
            }
        }
        i=0;
        while(i<m+n){
            if (c[i]!=0){
            System.out.print(c[i]+" ");
            i++;
        }
        else {
            if (i==0)System.out.print("NULL");
            break;
        }
        }
    }
}