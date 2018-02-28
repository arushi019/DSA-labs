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
class graphA2{
    public static int[][] mat;
    public static int n;
    public static HashSet<Integer> visit;
    public static HashSet<Integer> red;
    public static HashSet<Integer> blue;
    public static int flag;
    public static void bfs(int src){
        ArrayList<Integer> queue=new ArrayList<Integer>();
        queue.add(src);
        visit.add(src);
        red.add(src);
        while(queue.size()!=0){
            int v=queue.get(0);
            queue.remove(0);
            for (int i=0;i<n;i++){
                if (mat[v][i]==1){
                    if (visit.contains(i)==false){
                        queue.add(i);
                        visit.add(i);
                    }
                    if (red.contains(v)){
                        if (red.contains(i))flag=-1;
                        else blue.add(i);
                    }
                    else if (blue.contains(v)){
                        if (blue.contains(i))flag=-1;
                        else red.add(i);
                    }
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        int e=Reader.nextInt();
        flag=0;
        visit=new HashSet<Integer>();
        blue=new HashSet<Integer>();
        red=new HashSet<Integer>();
        mat=new int[n][n];
        for (int i=0;i<e;i++){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            x--;
            y--;
                mat[x][y]=1;
                mat[y][x]=1;
            
        }
        int i=0;
        while((visit.size()!=n)&&(flag!=-1)){
            if (visit.contains(i)==false){
                bfs(i);
            }
            i++;
        }
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