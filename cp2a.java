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
}
class cp2a{
    public static int n;
    public static int m;
    public static HashMap<Integer,ArrayList<Integer>> graph;
    public static HashSet<Integer> red;
    public static HashSet<Integer> blue;
    public static int[] stat;
    public static int flag;
    public static void dfs_out(){
        for (int i=0;i<n;i++){
            if (stat[i]==0){
                red.add(i);
                dfs_in(i);
            }
        }
    }
    public static void dfs_in(int node){
        stat[node]=-1;
        //System.out.println(node);
        if (graph.containsKey(node)){                   //checks if a node has neighobours so that the arraylist is not empty
        ArrayList<Integer> temp=graph.get(node);
        for (int i=0;i<temp.size();i++){
            if ((red.contains(node))&&(red.contains(temp.get(i))))flag=-1;
            else if ((blue.contains(node))&&(blue.contains(temp.get(i))))flag=-1;
            if (stat[temp.get(i)]==0){
                if (red.contains(node))blue.add(temp.get(i));
                else red.add(temp.get(i));
                dfs_in(temp.get(i));
        }
    }
        stat[node]=1;
    }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        m=Reader.nextInt();
        graph=new HashMap<Integer,ArrayList<Integer>>();
        flag=0;
        for (int i=0;i<m;i++){
            int x=Reader.nextInt();
            x--;
            int y=Reader.nextInt();
            y--;
            if (graph.containsKey(x)==false){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(y);
                graph.put(x,temp);
             }
            else{
                ArrayList<Integer> temp=graph.get(x);
                temp.add(y);
                graph.put(x,temp);
            }
            if (graph.containsKey(y)==false){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(x);
                graph.put(y,temp);
            }
            else{
                ArrayList<Integer> temp=graph.get(y);
                temp.add(x);
                graph.put(y,temp);
            }
        }
        stat=new int[n];
        red=new HashSet<Integer>();
        blue=new HashSet<Integer>();
        dfs_out();
        if (flag==-1)System.out.println(flag);
        else{
            System.out.println(red.size());
            Iterator it=red.iterator();
            while(it.hasNext()){
                System.out.print(((Integer)it.next()+1)+" ");
            }
            System.out.println();
            System.out.println(blue.size());
            it=blue.iterator();
            while(it.hasNext()){
                System.out.print(((Integer)it.next()+1)+" ");
            }
        }
    }
}