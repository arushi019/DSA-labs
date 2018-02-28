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
class level{
    public static void heapify(int i,int[] a){
        int k=(a.length-1)/2;
        boolean flag=true;
        int min;
        while((i<k)&&(flag==true)){
            if ((a[i]>a[2*i+1])&&(a[i]>a[2*i+2])){
                if (a[2*i+1]>a[2*i+2]){
                    int temp=a[2*i+2];
                    a[2*i+2]=a[i];
                    a[i]=temp;
                    i=2*i+2;
                }
                else{
                    int temp=a[2*i+1];
                    a[2*i+1]=a[i];
                    a[i]=temp;
                    i=2*i+1;
                }
            }
            else if ((a[i]>a[2*i+1])&&(a[i]<a[2*i+2])){
                int temp=a[2*i+1];
                a[2*i+1]=a[i];
                a[i]=temp;
                i=2*i+1;
            }
            else if ((a[i]>a[2*i+2])&&(a[i]<a[2*i+1])){
                int temp=a[2*i+2];
                a[2*i+2]=a[i];
                a[i]=temp;
                i=2*i+2;
            }
            else flag=false;
        }
    }
    //make a heap and do a level order traversal
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int i=0;
        int[] a=new int[n];
        while(i<n){
            a[i]=Reader.nextInt();
            i++;
        }
        i=0;
        while(i<(n-1)/2){
        heapify(i,a);
        i++;
        }
        while(i<n){
            System.out.print(a[i]+" ");
            i++;
        }
        System.out.println();

    }
}