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
class ps{
    public static int n,flag;
    public static HashMap<Integer,ArrayList<Integer>> nb;
    public static HashMap<Long,Integer> edge;
    public static int[] parent;
    public static ArrayList<Integer> p1;
    public static ArrayList<Integer> p2;
    public static HashSet<Integer> h1;
    public static HashSet<Integer> h2;
    public static void bfs(){
        ArrayList<Integer> q=new ArrayList<Integer>();
        HashSet<Integer> visit= new HashSet<Integer>();
        q.add(1);
        visit.add(1);
        while(q.size()!=0){
            int pt=q.get(0);
            q.remove(0);
            ArrayList<Integer> temp=nb.get(pt);
            for (int i=0;i<temp.size();i=i+2){
                int v=temp.get(i);
                if (visit.contains(v)==false){
                q.add(v);
                visit.add(v);
                parent[v]=pt;
            }
            }
            System.out.println(q);
        }
    }
    public static void path1(int x){
        if (x!=1){
            p1.add(x);
            h1.add(x);
            path1(parent[x]);
        }
        else{
            p1.add(1);
            h1.add(1);
        }
    }
    public static void path2(int y){
        if ((y!=1)&&(flag<0)){
            System.out.println(flag+" "+y);
            if (h1.contains(y))flag=y;
            p2.add(y);
            //h2.add(y);
            path2(parent[y]);
        }
        else if ((y==1)&&(flag<0)){
            p2.add(1);
            //h2.add(1);
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            edge=new HashMap<Long,Integer>();
            parent=new int[n+1];
            nb=new HashMap<Integer,ArrayList<Integer>>();
            for (int i=0;i<n-1;i++){
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                int c=Reader.nextInt();
                long key=(((long)x+(long)y)*((long)x+(long)y+1))*1/2+(long)y;
                //System.out.println(key);
                edge.put(key,c);
                if (nb.containsKey(x)==false){
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(y);
                    //temp.add(c);
                    nb.put(x,temp);
                }
                else{
                    ArrayList<Integer> temp=nb.get(x);
                    temp.add(y);
                    //temp.add(c);
                    nb.put(x,temp);
                }
                if (nb.containsKey(y)==false){
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(x);
                    //temp.add(c);
                    nb.put(y,temp);
                }
                else{
                    ArrayList<Integer> temp=nb.get(y);
                    temp.add(x);
                    //temp.add(c);
                    nb.put(y,temp);
                }
            }
            int m=Reader.nextInt();
            bfs();
            //for (int i=0;i<n+1;i++)System.out.print(parent[i]+" ");
            for (int i=0;i<m;i++){
                p1=new ArrayList<Integer>();
                p2=new ArrayList<Integer>();
                h1=new HashSet<Integer>();
                //h2=new HashSet<Integer>();
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                int k=Reader.nextInt();
                flag=-1;
                path1(x);
                path2(y);
                int x1=0;
                int pt1=0;
                for (int j=0;j<p1.size()-1;j++){
                    int k1=p2.get(i);
                    int k2=p2.get(i+1);
                    long pro=(((long)k1+(long)k2)*((long)k1+(long)k2+1))*1/2+(long)k2;
                    int wt=edge.get(pro);
                    if (wt<=k)x1=x1^wt;
                }
                int j=0;
                while((j<p1.size()-1)&&(p1.get(j)!=p2.get(p2.size()-1))){
                    int k1=p1.get(j);
                    int k2=p1.get(j+1);
                    long pr=(((long)k1+(long)k2)*((long)k1+(long)k2+1))*1/2+(long)k2;
                    int wt=edge.get(pr);
                    if (wt<=k)x1=x1^wt;
                }
                System.out.println(x1);
            }
                //System.out.println(p2);
            
        }
    }
}