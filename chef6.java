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
class chef6{
        public static int[] arr;
        public static int n;
        public static int buildout(int[] a,int s,int e,int index,int push){
            if (s==e){
                //System.out.println(index+" "+((index+push-1)%n));
                arr[index]=a[(index+1-push)%n];
                return arr[index];
            }
            int mid=s+(e-s)/2;
            //System.out.print(index);
            arr[index]=buildout(a,s,mid,index*2+1,push)+buildout(a,mid+1,e,index*2+2,push);
            return arr[index];
        }
        public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int[] a=new int[n];
        int i=0;
        int sum=0;
        int push=0;
        int t=(int)(Math.ceil(Math.log(n)/Math.log(2)));
        int h=2*(int)Math.pow(2,t)-1;
        arr=new int[h];
        while(i<n){
            a[i]=Reader.nextInt();
            sum+=a[i];
            i++;
        }
        String s=Reader.next();
        buildout(a,0,n-1,0,0);
        i=0;
        while(i<p){
            if (s.charAt(i)=='!'){
                push=(push+1)%n;
            }
            else{
                buildout(a,0,n-1,0,push);
                //for (int j=0;j<2*n;j++)System.out.print(arr[j]+" ");
                //System.out.println();
                System.out.println(arr[0]);
            }
            i++;
        }
    }
}