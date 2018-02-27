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
class node{
    int ver;
    long[] magic;
    public node(int ver,int n){
        this.ver=ver;
        this.magic=new long[n];
    }
}
class pishty{
    public static int n; 
    public static node[] graph;
    public static long pro;
    public static void bfs(int src,int dest,long k){
        pro=0;
        ArrayList<Integer> q=new ArrayList<Integer>();
        HashSet<Integer> visit=new HashSet<Integer>();
        int prev=src;
        q.add(src);
        visit.add(src);
        while(q.size()!=0){
            int pt=q.get(0);
            q.remove(0);
            if (graph[prev].magic[pt]<=k){
                //System.out.println(graph[prev].magic[pt]);
                pro=pro^graph[prev].magic[pt];
            }
            if (graph[pt].magic[dest]>0){
                if (graph[pt].magic[dest]<=k)pro=pro^graph[pt].magic[dest];
                break;
            }
            else{
                for (int i=0;i<n;i++){
                    if ((graph[pt].magic[i]>0)&&(visit.contains(i)==false)){
                        q.add(i);
                        visit.add(i);
                    }
                }
            }
            prev=pt;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            graph=new node[n];
            for (int i=0;i<n;i++){
                graph[i]=new node(i,n);
            }
            for (int i=0;i<n-1;i++){
                int x=Reader.nextInt();
                x--;
                int y=Reader.nextInt();
                y--;
                long c=Reader.nextLong();
                graph[x].magic[y]=c;
                graph[y].magic[x]=c;
            }
            int m=Reader.nextInt();
            for (int i=0;i<m;i++){
                int x=Reader.nextInt();
                x--;
                int y=Reader.nextInt();
                y--;
                long k=Reader.nextInt();
                bfs(x,y,k);
                System.out.println(pro);
            }
        }
    }
}