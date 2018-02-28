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
class CP17A{
    public static int n;
    public static int m;
    public static int bin(int[] h,int mid){
        int sum=0;
        for (int i=0;i<n;i++){
            if (h[i]%mid!=0)sum+=h[i]/mid+1;
            else sum+=h[i]/mid;
        }
        if (sum==m)return 0;
        else if (sum>m)return 1;
        else return -1;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        m=Reader.nextInt();
        int[] h=new int[n];
        for (int i=0;i<n;i++)h[i]=Reader.nextInt();
        int low=1;
        int high=m;
        while(low<=high){
            System.out.println(low+" "+high);
            int mid=low+(high-low)/2;
            System.out.println(mid);
            int f=bin(h,mid);
            if (f==1){
                low=mid+1;
            }
            else if (f==-1){
                high=mid-1;
            }
            else{
                int max=0;
                for (int i=0;i<n;i++){
                    
                }
                System.out.println(max);
                break;
            }
        }
    }
}