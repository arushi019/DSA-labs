import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
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
class aloo{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int[] q=new int[n];
        int i=0;
        int top=0;
        int rear=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(i<n){
            int temp=Reader.nextInt();
            if (top!=rear+k){
                sum=sum+temp;
                q[top]=temp;
                top++;
            }
            else{
                sum=sum-q[rear]+temp;
                rear++;
                q[top]=temp;
                top++;
            }
            if (sum>max)max=sum;
            int j=rear;
            while(j<top){
                System.out.print(q[j]+" ");
                j++;
            }
            System.out.println();
            i++;   
        }
        System.out.println(max);
    }
}