import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
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
class fin{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] h=new int[n];
        boolean[] b=new boolean[n];
        int[] max=new int[n];
        for (int i=0;i<n;i++)max[i]=-1;
        int flag;
        int next;
        flag=0;
        int t=0;
        for (int i=0;i<n;i++){
            next=Reader.nextInt();
            //System.out.println(next);
            int j=i-1;
            while(j>=flag){
                //if (next==2)System.out.println(h[j]);
                if ((h[j]<next)&&(max[j]==-1)){
                    max[j]=i;
                    b[j]=true;
                    //flag=j;
                }
                j--;
            }
            j=flag;
            while(b[flag]==true){
                flag++;
            } 
            //flag=Integer.highestOneBit(t);
            h[i]=next;
            //for (int k=0;k<n;k++)System.out.print(max[k]+" ");
            //System.out.println();
            System.out.println(j+" "+flag);
        }
        int min=h[n-1];
        int[] m=new int[n];
        long sum=0;
        for (int i=n-1;i>=0;i--){
            if (min>h[i])min=h[i];
            m[i]=min;
        }
        //for (int i=0;i<n;i++)System.out.print(max[i]+" ");
        //System.out.println();
        //for (int i=0;i<n;i++)System.out.print(m[i]+" ");
        //System.out.println();
        for (int i=0;i<n;i++){
                if (max[i]==-1)sum+=15;
                else if (m[max[i]]==h[max[i]]){
                    //System.out.println(h[i]+" ");
                    sum+=10;
                }
                else sum+=5;
        }
        System.out.println(sum);
    }
}