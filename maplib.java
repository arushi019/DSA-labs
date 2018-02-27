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
class maplib{
    public static int[][] mat;
    public static boolean[] visit;
    public static long t;
    public static void dfs_visit(int x,int n){
        t++;
        visit[x-1]=true;
        int i=1;
        while(i<n+1){
            if (mat[x][i]==1){
                if (visit[i-1]==false)dfs_visit(x,n);
            }
            i++;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int q=Reader.nextInt();
        int n,m,croad,clib,x,y;
        long cost;
        while(q-->0){
            n=Reader.nextInt();
            m=Reader.nextInt();
            croad=Reader.nextInt();
            clib=Reader.nextInt();
            mat=new int[n+1][n+1];
            visit=new boolean[n];
            int i=0;
            while(i<m){
                x=Reader.nextInt();
                y=Reader.nextInt();
                mat[x][y]=1;
                mat[y][x]=1;
                i++;
            }
            i=0;
            while(i<n){
                visit[i]=false;
                i++;
            }
            cost=0;
            for (i=1;i<n+1;i++){
                if (visit[i-1]==false){
                    t=0;
                    System.out.println(i);
                    dfs_visit(i,n);
                    cost=cost+clib;
                    if (clib>croad)cost+=croad*(t-1);
                    else cost+=clib*(t-1);
                }
            }
            System.out.println(cost);
        }
    }
}