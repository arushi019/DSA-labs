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
class eatsnake{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n,q;
        int[] len;
        int[] k;
        while(t-->0){
            n=Reader.nextInt();
            q=Reader.nextInt();
            len=new int[n];
            k=new int[q];
            for (int i=0;i<n;i++)len[i]=Reader.nextInt();
            for (int i=0;i<q;i++)k[i]=Reader.nextInt();
            Arrays.sort(len);
            int i,j;
            for (i=0;i<q;i++){
                int ct=0;
                int flag=0;
                for (j=n-1;j>=0;j--){
                    if (len[j]>=k[i])ct++;
                    else{
                        if (flag==0){
                            flag=1;
                            if ((k[i]-len[j])<=j)ct++;
                            else break;
                    }
                }
            }
            System.out.println(ct);
        }
    }
}
}