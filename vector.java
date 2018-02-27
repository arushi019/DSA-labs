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
class vector{
    public static int[] ini;
    public static void start(){
        int i=2;
        ini[0]=-1;
        ini[1]=-1;
        while(i<301){
            if (ini[i]==0){
                int j=2*i;
                while ((j<301)&&(j%i==0)){ini[j]=-1;j=j+i;}
                }
            i++;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        ini=new int[301];
        start();
        /*int k=1;
        while(k<301){
            if (ini[k]==0)System.out.print(k+" ");
            k++;
        }*/
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int[] sum=new int[3];
            int i=0;
            while(i<n*3){
                int temp=Reader.nextInt();
                sum[i%3]+=temp;
                i++;
            }
            /*i=0;
            while(i<3){
                System.out.print(sum[i]+" ");
                i++;
            }*/
            int f=0;
            i=0;
            while(i<3){
                if (ini[sum[i]]==-1){
                    System.out.println("NO");
                    f=-1;
                    break;
                }
                i++;
            }
            if (f==0)System.out.println("YES");
        }
    }
}