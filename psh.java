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
    int[] num;
    public node(int ver,int n){
        this.ver=ver;
        this.num=new int[n];
    }
}
class psh{
    public static int n;
    //public static int[][] mat;
    public static node[] c;
    public static int[] par;
    public static long xro;
    public static void bfs(){
        ArrayList<Integer> q=new ArrayList<Integer>();
        HashSet<Integer> visit=new HashSet<Integer>();
        q.add(0);
        visit.add(0);
        par[0]=-1;
        while(q.size()!=0){
            int pt=q.get(0);
            q.remove(0);
            for (int i=0;i<n;i++){
                if ((c[pt].num[i]>0)&&(visit.contains(i)==false)){
                    q.add(i);
                    visit.add(i);
                    par[i]=pt;
                }
            }
        }
        /*for (int i=0;i<n;i++){
            System.out.print(par[i]+" ");
        }*/
    }
    public static void findpath(int x,int y,long k){
        
        if (par[y]!=x){
        if (par[x]!=par[y]){
            if (c[y].num[par[y]]<=k){
                xro=xro^c[y].num[par[y]];
                //System.out.println(mat[y][par[y]]);
            }
            findpath(x,par[y],k);
        }
        else{
            if (c[y].num[par[y]]<=k){
                xro=xro^c[y].num[par[y]];
                //System.out.println(mat[y][par[y]]);
            }
            if (c[x].num[par[x]]<=k){
                xro=xro^c[x].num[par[x]];
                //System.out.println(mat[x][par[x]]);
            }
        }
        }
        else{
            if (c[y].num[x]<=k){
                xro=xro^c[y].num[x];
                //System.out.println(mat[y][x]);
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        try{
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            //mat=new int[n][n];
            c=new node[n];
            for (int i=0;i<n;i++){
                c[i]=new node(i,n);
            }
            par=new int[n];
            for (int i=0;i<n-1;i++){
                int x=Reader.nextInt();
                x--;
                int y=Reader.nextInt();
                y--;
                int cm=Reader.nextInt();
                //mat[x][y]=c;
                //mat[y][x]=c;
                c[x].num[y]=cm;
                c[y].num[x]=cm;
            }
            bfs();
            int m=Reader.nextInt();
            for (int i=0;i<m;i++){
                int x=Reader.nextInt();
                x--;
                int y=Reader.nextInt();
                y--;
                int k=Reader.nextInt();
                xro=0;
                if (x!=y){
                if (par[y]>par[x])findpath(x,y,k);
                else findpath(y,x,k);
                System.out.println(xro);
                }
                else System.out.println("0");
            }
        }
    }
    catch(Exception e){
        System.out.println(e);
        e.printStackTrace();
    }
    }
}
