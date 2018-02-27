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
class prmq{
    public static int[] a;
    public static int[] prime;
    public static int[] small;
    public static byte[][] every;
    public static void assign(){
        prime[0]=-1;
        prime[1]=-1;
        for (int i=2;i<1000001;i++){
            if (prime[i]==0){
                //System.out.println(i);
                prime[i]=1;
                for (int j=i*2;j<1000001;j=j+i)prime[j]=-1;
            }
        }
    }
    public static void func3(int index){
        int val=a[index];
        while(small[val]!=val){
            every[index][small[val]]++;
            val=val/small[val];
        }
        every[index][small[val]]++;
    }
    public static void assign2(){
        for (int i=2;i<1000001;i=i+2)small[i]=2;
        for (int i=3;i<1000001;i++){
            if (prime[i]==1){
            for (int j=i;j<1000001;j=j+i){
                if (small[j]==0)small[j]=i;
            }
        }
        }
        //for (int i=2;i<100;i++)System.out.print(small[i]+" ");
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        prime=new int[1000001];
        assign();
        small=new int[1000001];
        assign2();
        a=new int[n];
        every=new byte[n][1000001];
        for (int i=0;i<n;i++)a[i]=Reader.nextInt();
            for (int i=0;i<n;i++){
                //func2(a[i]);
                func3(i);
            }
        int q=Reader.nextInt();
        while(q-->0){
            int l=Reader.nextInt();
            int r=Reader.nextInt();
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            int ct=0;
            for (int i=l-1;i<r;i++){
                /*ArrayList<Integer> ori=values.get(a[i]);
                for (int j=0;j<ori.size();j++){
                    int g=ori.get(j);
                    if ((g<=y)&&(g>=x))ct++;
                }*/
                for (int j=x;j<=y;j++)ct+=every[i][j];
 
            }
            System.out.println(ct);
            
        }
    }
} 