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
class dijk{
    public static boolean[] visit;
    public static int[] dist;
    public static int mindis(int n,int[] a){
        int min=dist[1];
        int f=1;
        int i=1;
        while(i<n+1){
            if ((min>dist[i])&&(a[i]!=-1)){
                min=dist[i];
                f=i;
            }
            i++;
        }
        return f;
    }
    public static boolean emp(int[] a,int n){
        int i=1;
        while(i<n+1){
            if (a[i]==-1)break;
            i++;
        }
        return i<n+1;
    }
    public static void dij(int[][] mat,int n,int src){
        int[] a=new int[n+1];
        int i=1;
        while(i<n+1){
            a[i]=i;
            i++;
        }
        dist[src]=0;
        a[src]=-1;
        int dis=0;
        int prev=src;
        while(emp(a,n)){
            int u=mindis(n,a);
            //for(i=1;i<n+1;i++)System.out.print(dist[i]+" ");
            System.out.println(u);
            a[u]=-1;
            int j=1;
            dist[u]=dis+mat[prev][u];
            dis=dist[u];
            prev=u;
            while(j<n+1){
                if (mat[u][j]>=1){
                    System.out.println(dist[j]+" "+dist[u]+" "+mat[u][j]);
                    if (dist[j]>dist[u]+mat[u][j]){
                        System.out.println(j+"*");
                        dist[j]=dist[u]+mat[u][j];
                        a[j]=-1;
                    }
                }
                j++;
            }
        }

    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[][] mat=new int[n+1][n+1];
        int q=Reader.nextInt();
        int src=Reader.nextInt();
        while(q-->0){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            mat[x][y]=Reader.nextInt();
            mat[y][x]=mat[x][y];
        }
        dist=new int[n+1];
        visit=new boolean[n+1];
        int i=0;
        while(i<n+1){
            dist[i]=1001;
            i++;
        }
        dij(mat,n,src);
        i=1;
        while(i<n+1){
            System.out.print(dist[i]+" ");
            i++;
        }
    }
}