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
class dfsi{
    public static boolean[] visit;
    public static void dfs(int[][] mat,int n){
        int i;
        for (i=1;i<n+1;i++){
            if (visit[i-1]==false)dfs_visit(mat,n,i);
        }
    }
    public static void dfs_visit(int[][] mat,int n,int x){
        System.out.print(x+" ");
        visit[x-1]=true;
        int i;
        for (i=1;i<n+1;i++){
            if (mat[x][i]==1){
                if (visit[i-1]==false)dfs_visit(mat,n,i);
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[][] mat=new int[n+1][n+1];
        int q=Reader.nextInt();
        visit=new boolean[n];
        while(q-->0){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            mat[x][y]=1;
            mat[y][x]=1;
        }
        dfs(mat,n);
    }
}