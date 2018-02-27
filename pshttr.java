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
class pshttr{
    public static HashSet<Integer> visit;
    public static int[][] mat;
    public static int n;
    public static long xro;
    public static ArrayList<Integer> path;
    public static void bfs(int src,int dest,int w){
        ArrayList<Integer> queue=new ArrayList<Integer>();
        visit=new HashSet<Integer>();
        path=new ArrayList<Integer>();
        xro=0;
        queue.add(src);
        visit.add(src);
        int flag=0;
        int prev=src;
        while(queue.size()!=0){
            int pt=queue.get(0);
            queue.remove(0);
            path.add(pt);
            if (mat[prev][pt]<=w){
                xro=xro^mat[prev][pt];
                System.out.println(mat[prev][pt]);
            }
            if (mat[pt][dest]>0){
                if (mat[pt][dest]<=w){
                    xro=xro^mat[pt][dest];
                    System.out.println(mat[pt][dest]);
                }
                path.add(dest);
                break;
            }
            else{
            for (int i=0;i<n;i++){
                if ((mat[pt][i]>0)&&(!visit.contains(i))){
                    queue.add(i);
                    visit.add(i);
                
                    }
            }
            }
            prev=pt;
        }
        System.out.println(path);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            mat=new int[n][n];
            for (int i=0;i<n-1;i++){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            int c=Reader.nextInt();
            x--;
            y--;
            mat[x][y]=c;
            mat[y][x]=c;
        }
        int r=Reader.nextInt();
        for (int i=0;i<r;i++){
            int x=Reader.nextInt();
            x--;
            int y=Reader.nextInt();
            y--;
            int w=Reader.nextInt();
            bfs(x,y,w);
            System.out.println(xro);
        }
        }
    }
}