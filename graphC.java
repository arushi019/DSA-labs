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
}
class graphC{
    public static int[] arr;
    public static int[] freq;
    public static int n;
    public static void update(int value,int index){
        arr[index]=value;
        int val=value;
        int newf=0;
        if (val==0)newf=1;
        else{
        while(val!=0){
            if (val%10==0)newf++;
            val=val/10;
        }}
        int f2;
        if (index>0)f2=freq[index]-freq[index-1];
        else f2=freq[index];
        int diff=f2-newf;
        //System.out.println(diff);
        for (int i=index;i<n;i++){
            //System.out.println(freq[i]);
            freq[i]=freq[i]-diff;
        }
        //for (int i=0;i<n;i++)System.out.println(freq[i]);
    }
    public static int get_index(int k){
        int flag=-1;
        for (int i=0;i<n;i++){
            if (freq[i]>=k){
                flag=i;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        arr=new int[n];
        freq=new int[n];
        int f=0;
        for (int i=0;i<n;i++){
            arr[i]=Reader.nextInt();
            int val=arr[i];
            if (val==0){
                f++;
                freq[i]=f;
            }
            else{
            while(val!=0){
                if (val%10==0)f++;
                val=val/10;
            }
            freq[i]=f;
        }
        }
        //for (int i=0;i<n;i++)System.out.println(freq[i]);
        int q=Reader.nextInt();
        for (int i=0;i<q;i++){
            int ch=Reader.nextInt();
            if (ch==1){
                int k=Reader.nextInt();
                System.out.println(get_index(k));
            }
            else if (ch==0){
                int ind=Reader.nextInt();
                int val=Reader.nextInt();
                update(val,ind);
                //for (int j=0;j<n;j++)System.out.println(freq[j]);
            }
        }
    }
}