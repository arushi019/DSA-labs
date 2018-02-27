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
class prB2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] arr=new int[n];
        int[] amt=new int[n];
        long sum=0;
        for (int i=0;i<n;i++){
            arr[i]=Reader.nextInt();
            amt[i]=arr[i];
            sum+=(long)arr[i];
        }
        long fsum=0;
        int ct=0;
        int pt=0;
        ArrayList<Integer> ch=new ArrayList<Integer>();
        while((pt<n)&&(fsum<sum)){
            if (pt!=n-1-pt)fsum+=arr[pt]+arr[n-1-pt];
            else fsum+=arr[pt];
            amt[pt]=0;
            amt[n-1-pt]=0;
            ch.add(pt);
            ch.add(n-1-pt);
            for (int j=pt+1;j<n-1-pt;j++){
                if (arr[j]!=0){
                int min=arr[j+1]<arr[j-1]?arr[j+1]:arr[j-1];
                int max=arr[j+1]>arr[j-1]?arr[j+1]:arr[j-1];
                if (max<arr[j]){
                    fsum+=arr[j]-min;
                    amt[j]=min;
                    ch.add(j);
                }
                else if (min>arr[j]){
                    fsum++;
                    amt[j]--;
                    ch.add(j);
                }
                else{
                    fsum+=arr[j]-min;
                    amt[j]=min;
                    ch.add(j);
                }
            }
            }
            //for (int i=0;i<n;i++)System.out.print(amt[i]+"  ");
            //System.out.println();
            for (int i=0;i<ch.size();i++){
                arr[ch.get(i)]=amt[ch.get(i)];
            }
            //System.out.println(fsum);
            pt++;
            ct++;
        }
        System.out.println(ct);
    }
}