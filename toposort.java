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
class toposort{
    public static int n;
    public static int[] status;
    public static int time;
    public static int[] sstamp;
    public static int[] estamp;
    public static ArrayList<Integer> fin;
    public static void dfs(int[][] mat){
        int i=0;
        while(i<n+1){
            status[i]=-1;
            i++;
        }
        time=0;
        i=1;
        while(i<n+1){
            System.out.println("Visiting "+i);
            if (status[i]==-1)visit(i,mat);
            i++;
        }
    }
    public static void visit(int pos,int[][] mat){
        status[pos]=0;
        time=time+1;
        sstamp[pos]=time;
        int i=1;
        while (i<n+1){
            if (mat[pos][i]==1){
                if (status[i]==-1){
                    System.out.println("From "+pos+"we move to "+i);
                    visit(i,mat);
            }
        }
            i++;
        }
        status[pos]=1;
        time=time+1;
        estamp[pos]=time;
        fin.add(pos);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        int m=Reader.nextInt();
        status=new int[n+1];
        sstamp=new int[n+1];
        estamp=new int[n+1];
        fin=new ArrayList<Integer>();
        time=0;
        int[][] mat=new int[n+1][n+1];
        int i=0;
        int x,y,j;
        //assume directed graph (without weights) with edges x-->y
        while(i<m){
            x=Reader.nextInt();
            y=Reader.nextInt();
            mat[x][y]=1;
            i++;
        }
        i=0;
        j=0;
        //displays the graph in adjacency matrix form
        /*while(i<n+1){
            j=0;
            while(j<n+1){
                System.out.print(mat[i][j]+" ");
                j++;
            }
            System.out.println(" ");
            i++;
        }*/
        dfs(mat);
        i=1;
        while(i<n+1){
            System.out.print(sstamp[i]+" ");
            i++;
        }
        i=1;
        while(i<n+1){
            System.out.print(estamp[i]+" ");
            i++;
        }
        System.out.println();
        System.out.println(fin);
    }
}