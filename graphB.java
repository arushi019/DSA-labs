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
class graphB{
    public static int n;
    public static int e;
    public static int bus_num;
    public static int bank;
    public static int i1;
    public static int i2;
    public static int[][] mat;
    public static HashSet<Integer> bus;
    public static int[] dist;
    public static int min(HashSet<Integer> q){
        int ind=0;
        for (int i=1;i<=n;i++){
            if ((dist[i]<dist[ind])&&(q.contains(i)))ind=i;
        }
        return ind;
    }
    public static void dik(int src){
        dist[src]=0;
        HashSet<Integer> q=new HashSet<Integer>();
        for (int i=1;i<n+1;i++){
            if (i!=src)dist[i]=Integer.MAX_VALUE;
            q.add(i);
        }
        HashSet<Integer> visit=new HashSet<Integer>();
        while(q.size()!=0){
            System.out.println(q);
            int m=min(q);
            q.remove(m);
            System.out.println(m);
            for (int i=1;i<=n;i++){
                if (mat[m][i]>0){
                    int tem=dist[m]+mat[m][i];
                    if (tem<dist[i])dist[i]=tem;
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            e=Reader.nextInt();
            bus_num=Reader.nextInt();
            bank=Reader.nextInt();
            i1=Reader.nextInt();
            i2=Reader.nextInt();
            mat=new int[n+1][n+1];
            bus=new HashSet<Integer>();
            for (int i=0;i<e;i++){
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                int temp=Reader.nextInt();
                mat[x][y]=temp;
                mat[y][x]=temp;
            }
            for (int i=0;i<bus_num;i++){
                int temp=Reader.nextInt();
                bus.add(temp);
            }
            dist=new int[n+1];
            dik(bank);
            for (int i=1;i<=n+1;i++){
                System.out.print(dist[i]+" ");
            }
        }
    }
}