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
class prA{
    public static int n,k,ans;
    public static int[][] d;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        k=Reader.nextInt();
        ans=0;
        d=new int[n+1][k+1];
        graph=new ArrayList[n+1];
        for (int i=0;i<n+1;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for (int i=0;i<n-1;i++){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(1,-1);
        System.out.println(ans);
    }
    public static void dfs(int u,int h){
        d[u][0]=1;
        for (int i=0;i<graph[u].size();i++){
            int v=graph[u].get(i);
            if (v!=h){
            dfs(v,u);
            for (int j=1;j<=k;j++){
                ans+=d[u][j-1]*d[v][k-j];
            }
            for (int j=1;j<=k;j++){
                d[u][j]+=d[v][j-1];
            }
        }
        }
    }
}