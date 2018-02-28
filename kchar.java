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
import java.awt.Point;
import java.text.DecimalFormat;
 
 
 
 
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
       static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class kchar{
    public static int pikachu(long key){
        int low=0;
        int high=64;
        int mid=(low+high)/2;
        int flag=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            long val;
            //System.out.print(arr[mid]+" ");
            val=(long)Math.pow(2,mid+1)-2-mid;
            //System.out.println(mid+" "+val);
            if(val>key){
                high=mid-1;
                flag=low+(high-low)/2;
            }
            else{
                if (val==key){
                    flag=mid;
                    break;
                }
                low=mid+1;
                flag=low+(high-low)/2;
            }
        }
        return flag;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        long ch=1;
        int pt=0;
        for (int i=0;i<5;i++){
            ch=ch<<1|1;
            for (int j=0;j>=pt;j++){
                long bit=(ch>>j)&1;
                System.out.println(Long.toBinaryString(ch>>j));
                System.out.println(bit);
                ch=ch<<1|(1-bit);
            }
            pt=(int)Math.pow(2,i+1)-1;
            System.out.println('*'+" "+Long.toBinaryString(ch));
        }
        while(t-->0){
            long k=Reader.nextLong();
            //System.out.println(pikachu(k));
            int v=pikachu(k);
            if (v>0){
                long rem=(long)Math.pow(2,v)-1-v;
                System.out.println(v+" "+rem);
                k-=rem;
                System.out.println(k);
            }
        }
    }
}