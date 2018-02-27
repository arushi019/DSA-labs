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
class probF{
    public static int[] xc;
    public static int[] yc;
    public static int len;
    public static boolean check(int x,int y){
        int i=0;
        while(i<len){
            if ((x==xc[i])&&(y==yc[i]))return true;
            i++;
        }
        return false;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        len=0;
        int ct=0;
        xc=new int[200005];
        yc=new int[200005];
        Integer sum=0;
        HashMap<Integer,Integer> x=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> y=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> d=new HashMap<Integer,Integer>();
        Integer temp=0;
        for (int i=0;i<n;i++){
            Integer t1=Reader.nextInt();
            Integer t2=Reader.nextInt();
            if (check(t1,t2)==false){
                xc[len]=t1;
                yc[len]=t2;
                len++;
            }
            else ct++;
            if (x.containsKey(t1)){
                temp=x.get(t1);
                temp++;
                x.put(t1,temp);
            }
            else{
                x.put(t1,1);
            }
            if (y.containsKey(t2)){
                temp=y.get(t2);
                temp++;
                y.put(t2,temp);
            }
            else{
                y.put(t2,1);
            }
        }
        for (Integer k:x.keySet()){
            temp=x.get(k);
            if (temp>1)sum+=(temp)*(temp-1)/2;
        }
        for (Integer k:y.keySet()){
            temp=y.get(k);
            if (temp>1)sum+=(temp)*(temp-1)/2;
        }
        
        System.out.println(sum-ct);
    }
}