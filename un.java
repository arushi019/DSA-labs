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
class un{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] h=new int[n];
        for (int i=0;i<n;i++)h[i]=Reader.nextInt();
        int[] max=new int[n];
        int[] min=new int[n];
        int[] loc=new int[n];
        int cmp=-1;
        int flag=-1;
        for (int i=1;i<n;i++){
            int pivot=h[i];
            int j=i-1;
            cmp=j-1;
            while(j>cmp){
                if (h[j]<pivot){
                max[j]=pivot;
                loc[j]=i;
                }
                j--;
            }
            if (cmp>=0){
                if (max[cmp]==0){
                    flag=cmp;
                }
            }
            if ((flag>=0)&&(h[flag]<pivot)){
                max[flag]=pivot;
                loc[flag]=i;
                flag=-1;
            }
            /*while(j>=0){
                if ((max[j]==0)&&(pivot>h[j])){
                    max[j]=pivot;
                    loc[j]=i;
                }
                j--;
            }*/
        }
        int m=h[n-1];
        ArrayList<Integer> k=new ArrayList<Integer>();
        for (int i=n-1;i>=0;i--){
            if (h[i]<m)m=h[i];
            min[i]=m;
            if (min[i]==h[i])k.add(i);
        }
        long sum=0;
        for (int i=0;i<n;i++){
            System.out.print(loc[i]+" ");
            if (max[i]==0)sum+=15;
            else{
                if (k.contains(loc[i])){
                    //System.out.println(h[i]+" +10");
                    sum+=10;
                }
                else
                    sum+=5;
        }}
        System.out.println(sum);
    }
}