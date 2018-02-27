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
class unionset{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            HashMap<HashSet<Integer>,Integer> h=new HashMap<HashSet<Integer>,Integer>();
            long sum=0;
            int ct=0;
            for (int i=0;i<n;i++){
                HashSet<Integer> has=new HashSet<Integer>();
                HashSet<Integer> wants=new HashSet<Integer>();
                int[] arr=new int[k];
                int len=Reader.nextInt();
                for (int j=0;j<len;j++){
                    int temp=Reader.nextInt();
                    arr[temp-1]=1;
                }
                for (int j=0;j<k;j++){
                    if (arr[j]==0)wants.add(j+1);
                    if (arr[j]==1)has.add(j+1);
                }
                //System.out.println(has);
                //System.out.println(wants);
                //if (wants.size()!=0){
                    
                
            //long prod=(long)(sum*(sum-1))/2;
            //System.out.println(sum);
            Set set=h.entrySet();
            Iterator it=set.iterator();
            while(it.hasNext()){
                Map.Entry me=(Map.Entry)it.next();
                HashSet tem=(HashSet)me.getKey();
                if (has.containsAll(tem)){
                    //System.out.println(has);
                    //System.out.println(tem);
                    sum+=h.get(tem);}
            }
            //else ct++;
            if (h.containsKey(wants)==false)h.put(wants,1);
                    else{
                        int g=h.get(wants);
                        g++;
                        h.put(wants,g);
                    }
        }
        System.out.println(sum);
    }
}}