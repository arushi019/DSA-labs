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
class notatri{
    public static int pikachu(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        int mid=(low+high)/2;
        int flag=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            //System.out.print(arr[mid]+" ");
            //if (arr[mid]==key){flag=mid;break;}
            if(arr[mid]>=key){
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
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        while(n!=0){
            int[] arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextInt();
            }
            Arrays.sort(arr);
            long ct=0;
            /*for (int i=1;i<=n-2;i++){
                int pos=pikachu(arr,arr[i-1]+arr[i]);
                System.out.println(pos);
                if((pos!=n)&&(arr[i-1]+arr[i]!=arr[pos])){
                System.out.println(arr[i-1]+" "+arr[i]+" "+arr[pos]);
                ct+=(n-pos);
                }
            }*/
            for (int i=0;i<n-1;i++){
                for (int j=i+1;j<n;j++){
                    int pos=pikachu(arr,arr[i]+arr[j]);
                    //System.out.println(pos);
                    if (pos!=n){

                        if (arr[i]+arr[j]==arr[pos]){
                            while((pos<n)&&(arr[i]+arr[j]==arr[pos]))pos++;
                        }
                        //if (pos!=n)System.out.println(arr[i]+" "+arr[j]+" "+arr[pos]);
                        ct+=(n-pos);
                    }
                }
            }
            System.out.println(ct);
            n=Reader.nextInt();
        }
    }
}