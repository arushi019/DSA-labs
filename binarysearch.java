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
class binarysearch{
    public static int pikachu(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        int mid=(low+high)/2;
        int flag=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            System.out.print(arr[mid]+" ");
            if (arr[mid]==key){flag=mid;break;}
            else if(arr[mid]>key){
                high=mid-1;
                flag=low+(high-low)/2;
            }
            else{
                low=mid+1;
                flag=low+(high-low)/2;
            }
        }
        return flag;
    }
    public static int pika(int[] arr,int key){
        int i=0;
        while(i<arr.length){
            if (arr[i]>key)return i;
            i++;
        }
        return arr.length;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++)a[i]=Reader.nextInt();
        int t=Reader.nextInt();
        while(t-->0){
        int key=Reader.nextInt();
        System.out.println(pika(a,key));
    }
    }
}