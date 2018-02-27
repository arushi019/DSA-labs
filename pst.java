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
    int index;
    int parent;
    HashMap<Integer,Integer> ver;
    public node(int index){
        this.index=index;
        this.parent=-1;
        this.ver=new HashMap<Integer,Integer>();
    }
}
class pst{
    public static node[] graph;
    public static int[] visit;
    public static int xro,k,n;
    public static void bfs(){
        ArrayList<Integer> q=new ArrayList<Integer>();
        HashSet<Integer> visit=new HashSet<Integer>();
        q.add(0);
        visit.add(0);
        graph[0].parent=-1;
        while(q.size()!=0){
            int pt=q.get(0);
            q.remove(0);
            for (int i=0;i<n;i++){
                if ((graph[pt].ver.containsKey(i))&&(visit.contains(i)==false)){
                    q.add(i);
                    graph[i].parent=pt;
                    visit.add(i);
                }
            }
        }
    }
    public static void findpath(int src,int dest){
        if ((graph[src].parent!=graph[dest].parent)&&(src!=dest)){
            if (src==0){
                int p=graph[dest].parent;
                int w=graph[dest].ver.get(p);
                if (w<=k)xro=xro^w;
                findpath(0,p);
            }
            else if (dest==0){
                int p=graph[src].parent;
                int w=graph[src].ver.get(p);
                if (w<=k)xro=xro^w;
                findpath(p,0);
            }
            else{
                int p=graph[dest].parent;
                int w=graph[dest].ver.get(p);
                if (w<=k)xro=xro^w;
                findpath(src,p);
            }
        }
        else if ((src!=dest)&&(graph[src].parent==graph[dest].parent)){
            int w1=graph[src].ver.get(graph[src].parent);
            int w2=graph[dest].ver.get(graph[dest].parent);
            if (w1<=k)xro=xro^w1;
            if (w2<=k)xro=xro^w2;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            graph=new node[n];
            for (int i=0;i<n;i++){
                graph[i]=new node(i);
            }
            for (int i=0;i<n-1;i++){
                int x=Reader.nextInt();
                x--;
                int y=Reader.nextInt();
                y--;
                int wt=Reader.nextInt();
                graph[x].ver.put(y,wt);
                graph[y].ver.put(x,wt);
            }
            bfs();
            /*for (int i=0;i<n;i++){
                System.out.print(graph[i].parent);
            }*/
            System.out.println();
            int m=Reader.nextInt();
            for (int i=0;i<m;i++){
                int x=Reader.nextInt();
                x--;
                int y=Reader.nextInt();
                y--;
                k=Reader.nextInt();
                visit=new int[n];
                xro=0;
                findpath(x,y);
                System.out.println(xro);
            }
        }
    }
}