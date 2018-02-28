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
class bfsi{
    public static int[] dist;
    public static boolean[] visit;
    public static void bfs(int x,int[][] mat,int n){
        int[] q=new int[n];
        dist=new int[n+1];
        //visit=new boolean[n+1];
        int f=0;
        int r=0;
        q[r]=x;
        visit[x]=true;
        r=(r+1)%n;
        while(f!=r){
            int v=q[f];
            f=(f+1)%n;
            visit[v]=true;
            int j;
            for (j=1;j<n+1;j++){
                if (mat[v][j]==1){
                    if ((dist[j]==0)&&(visit[j]==false)){
                    dist[j]=dist[v]+1;
                    q[r]=j;
                    r=(r+1)%n;
                }}
            }
            int k=f;
            while(k!=r){
                System.out.print(q[k]+" ");
                k=(k+1)%n;
            }
            System.out.print("f= "+f+" r= "+r);
            System.out.println();
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[][] mat=new int[n+1][n+1];
        visit=new boolean[n+1];
        int q=Reader.nextInt();
        while(q-->0){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            mat[x][y]=1;
            mat[y][x]=1;
        }
        int i=1;
        while(i<n+1){
            if (visit[i]==false)bfs(i,mat,n);
            i++;
        }
        //bfs(mat,n);
    }
}