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
class subgcd{
    public static int[] smprime;
    public static void fillin(){
        smprime=new int[100001];
        smprime[0]=-1;
        smprime[1]=-1;
        for (int i=2;i<100001;i++){
            if (smprime[i]==0){
                for (int j=i;j<100001;j=j+i)
                    {if(smprime[j]==0)smprime[j]=i;}
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        fillin();
        while(t-->0){
            int n=Reader.nextInt();
            int[] arr=new int[n];
            HashSet<Integer> hs=new HashSet<Integer>();
            int maxlen=0;
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextInt();
                //System.out.println(smprime[arr[i]]);
            }
            int ct=0;
            for (int i=0;i<n;i++){
                if (hs.size()==0){
                    int a=arr[i];
                    hs.add(smprime[arr[i]]);
                    while(a!=smprime[a]){
                        a=a/smprime[a];
                        if (hs.contains(smprime[a])==false)hs.add(smprime[a]);
                    }
                    ct++;
                }
                else{
                    int a=arr[i];
                    int flag=0;
                    while(a!=smprime[a]){
                        if (hs.contains(smprime[a])){
                            flag=-1;
                            break;
                        }
                        else{
                            hs.add(smprime[a]);
                            a=a/smprime[a];
                        }
                    }
                    if (flag==-1){
                        if (maxlen<ct)maxlen=ct;
                        hs=new HashSet<Integer>();
                        ct=0;
                        int g=arr[i];
                        hs.add(smprime[g]);
                        while(g!=smprime[g]){
                            g=g/smprime[g];
                            hs.add(smprime[g]);
                        }
                    }
                    else{
                        ct++;
                    }
                }
                System.out.println(hs);
            }
            if (ct>maxlen)maxlen=ct;
            if (maxlen<=1)System.out.println("-1");
            else System.out.println(maxlen);

        }
    }
}