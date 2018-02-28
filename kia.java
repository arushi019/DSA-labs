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
class kia{
    public static int n;
    public static int k;
    public static int p;
    public static int[] a;
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        k=Reader.nextInt();
        p=Reader.nextInt();
        a=new int[n]; 
        int i=0;
        while(i<n){
            a[i]=Reader.nextInt();
            i++;
        }
        String s=Reader.next();
        i=0;
        int sum=0;
        int flag=0;
        if (k>=n){
            while(i<n){
                sum+=a[i];
                i++;
            }
        }
        else{
            while(i<n){
                int temp=0;
                int j=0;
                while((j<k)&&(i+j<n)){
                    temp+=a[i+j];
                    j++;
                }
                if (temp>sum){sum=temp;flag=i;}
                i++;
            }   
        }
        int pt=0;
        i=0;
        while(i<p){
            if (s.charAt(i)=='!'){
                if (k<n){
                    pt++;
                }
            }
            else if(s.charAt(i)=='?'){
                if (k>=n){
                    System.out.println(sum);
                }
                else{
                    //-----------------------
                    int finflag=flag+pt;
                    //System.out.println(flag+" "+pt);
                    //System.out.println(finflag+k-1);
                    if (finflag+k-1<n)System.out.println(sum);
                    else{
                        int t=0;
                        sum=0;
                        while(t<n){
                            int temp=0;
                            int j=0;
                            while((j<k)&&(t+j<n)){
                                temp+=a[(t+j+pt)%n];
                                j++;
                            }
                            if (temp>sum)sum=temp;
                            t++;
                        }
                        System.out.println(sum);
                        
                    }
                }
            }
            i++;
        }
    }
}