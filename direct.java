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
class direct{
    public static int[] arr;
    public static int[] h;
    public static void ng(int[] nx,char id){
        ArrayList<Integer> stack=new ArrayList<Integer>();
        for (int i=h.length-1;i>=0;i--){
            while((stack.size()!=0)&&((id=='g')?h[stack.size()-1]<=h[i]:h[stack.size()-1]>=h[i])){
                stack.remove(stack.size()-1);
            }
            if (stack.size()!=0)nx[i]=stack.get(stack.size()-1);
            else nx[i]=-1;
            stack.add(i);
        }
    }
    public static void nsmallng(){
        int[] ngr=new int[h.length];
        int[] ns=new int[h.length];
        ng(ngr,'g');
        ng(ns,'s');
        for (int i=0;i<h.length;i++){
            if ((ngr[i]!=-1)&&(ns[ngr[i]]!=-1)){
                arr[i]=h[ns[ngr[i]]];}
            else arr[i]=-1;
            
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        h=new int[n];
        for (int i=0;i<n;i++)h[i]=Reader.nextInt();
        arr=new int[n];
        nsmallng();
        for (int i=0;i<n;i++)System.out.print(arr[i]+" ");
        }
} 