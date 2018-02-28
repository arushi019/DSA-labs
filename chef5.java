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
class chef5{
    public static int[] arr;
    public static int[] a;
    public static int n;
    /*public static void build(int index,int s,int e,int pt){
        int s2=(n-pt+s)%n;
        int e2=(n-pt+e)%n;
        if ((Math.abs(e2-s2))<2){
            arr[index]=a
        }
        else{
            int m=(e+s)/2;
            build(2*index,s,m,pt);
            build(2*index+1,m,e,pt);
            arr[index]=arr[2*index]+arr[2*index+1];
        }
    }*/
    public static void build2(int s,int e,int index,int pt){
        if (s==e){
            System.out.print(s+" "+((n-pt+s)%n)+" "+index+"/  ");
            arr[index]=a[(n-pt+s)%n];
        }
        else{
            int m=(s+e)/2;
            build2(s,m,index*2,pt);
            build2(m+1,e,index*2+1,pt);
            arr[index]=arr[index*2]+arr[index*2+1];
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int i;
        a=new int[n];
        arr=new int[2*n];
        int push=0;
        for(i=0;i<n;i++)a[i]=Reader.nextInt();
        String s=Reader.next();
        for (i=0;i<p;i++){
            if (s.charAt(i)=='!'){
                push=(push+1)%n;
            }
            else{
                build2(0,n-1,1,push);
                //System.out.println();
                for (int j=0;j<2*n;j++)System.out.print(arr[j]+" ");
                System.out.println();
                System.out.println(arr[1]);
            }
        }
    }
}