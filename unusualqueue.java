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
class unusualqueue{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] h=new int[n];
        int[] great=new int[n];
        int[] low=new int[n];
        for (int i=0;i<n;i++)h[i]=Reader.nextInt();
        int max=h[n-1];
        int min=h[n-1];
        int sum=0;
        for (int i=n-1;i>=0;i--){
            if (h[i]>max)max=h[i];
            great[i]=max;
            if (h[i]<min)min=h[i];
            low[i]=min;
        }
        for (int i=0;i<n;i++){
            System.out.print(great[i]+" ");
            if (great[i]==h[i]){
                System.out.println("+15 "+h[i]);
                sum+=15;
            }
            else if ((great[i]>h[i])&&(low[i]==h[i])){
            System.out.println("+10 "+h[i]);
            sum+=10;
        }
            else {
                System.out.println("+5 "+h[i]);
                sum+=5;
            }
        }
        System.out.println();
        for (int i=0;i<n;i++)System.out.print(low[i]+" ");
    }   
}