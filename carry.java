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
class carry{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n,k;
        int j;
        int[] wt;
        int sum1,sum2,sum3,sum4;
        while(t-->0){
            n=Reader.nextInt();
            k=Reader.nextInt();
            wt=new int[n];
            j=0;
            while(j<n){
                wt[j]=Reader.nextInt();
                j++;
            }
            Arrays.sort(wt);
            j=0;
            /*while(j<n){
                System.out.print(wt[j]+" ");
                j++;
            }*/
            j=0;
            sum1=0;
            sum2=0;
            sum3=0;
            sum4=0;
            while(j<n){
                if (j<k)sum1=sum1+wt[j];
                else sum2=sum2+wt[j];
                j++;
            }
            j=0;
            while(j<n){
                if (j<n-k)sum3=sum3+wt[j];
                else sum4=sum4+wt[j];
                j++;
            }
            if ((Math.abs(sum2-sum1))>Math.abs(sum3-sum4))System.out.println(Math.abs(sum2-sum1));
            else System.out.println(Math.abs(sum3-sum4));
            //System.out.println(sum2-sum1);
        }
    }
}