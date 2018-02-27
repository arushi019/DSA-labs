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
class zop{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        int i=0;
        int max=0;
        int temp;
        int flag=0;
        int sum1=0;
        int sum2=0;
        while(i<n){
            a[i]=Reader.nextInt();
            b[i]=Reader.nextInt();
            sum1+=a[i];
            sum2+=b[i];
            temp=Math.abs(sum1-sum2);
            if (temp>max){
                max=temp;
                if (sum1>sum2)flag=1;
                else flag=2;
            }
            i++;
        }
        System.out.println(flag+" "+max);

    }
}