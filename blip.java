import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;

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
class blip{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int[] a=new int[n];
        int i=0;
        while(i<n){
            a[i]=Reader.nextInt();
            i++;
        }
        String s=Reader.next();
        i=0;
        while(i<p){
            if (s.charAt(i)=='!'){
                //---------------------
                int temp=a[n-1];
                int j=n-2;
                while(j>=0){
                    a[j+1]=a[j];
                    /*int t=0;
                    while(t<n){
                        System.out.print(a[t]+" ");
                        t++;
                    }
                    System.out.println();*/
                    j--;
                }
                a[0]=temp;
                /*j=0;
                while(j<n){
                    System.out.print(a[j]+" ");
                    j++;
                }
                System.out.println();*/
            }
            else{
                int max=0;
                int j=0;
                while(j<=n-k){
                    int t=0;
                    int sum=0;
                    while(t<k){
                        sum=sum+a[j+t];
                        t++;
                    }
                    if (sum>max)max=sum;
                    j++;
                }
                System.out.println(max);
            }
        i++;
        }
    }
}