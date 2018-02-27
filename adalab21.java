import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
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
class adalab21{
    public static int[][] wt;
    public static int[][] adj;
    public static int[] d;
    public static int r;
    public static int c;
    public static int v;
    public static int min_dis(Boolean valid[],int[] d)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE; 
        int min_index=-1;
 
        for (int i = 0; i < v; i++)
            if ((valid[i] == false) && (d[i] <= min))
            {
                min = d[i];
                min_index = i;
            }
 
        return min_index;
    }
    public static void dijkstra()
    { 
        Boolean valid[] = new Boolean[v];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < v; i++)
        {
            d[i] = Integer.MAX_VALUE;
            valid[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        d[0] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < v-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int w = min_dis(valid,d);
 
            // Mark the picked vertex as processed
            valid[w] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int i = 0; i < v; i++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!valid[i] && adj[w][i]>=0 &&
                        d[w] != Integer.MAX_VALUE &&
                        d[w]+adj[w][i] < d[i])
                    d[i] = d[w] + adj[w][i];
        }
 
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            r=Reader.nextInt();
            c=Reader.nextInt();
            v=r*c;
            d=new int[v];
            adj=new int[v][v];
            wt=new int[r][c];
            for (int i=0;i<v;i++){
                for (int j=0;j<v;j++){
                    adj[i][j]=-1;
                }
            }
            for (int i=0;i<r;i++){
                for (int j=0;j<c;j++){
                    wt[i][j]=Reader.nextInt();
                }
            }
            for (int i=0;i<r;i++){
                for (int j=0;j<c;j++){
                    if (i-1>=0)adj[i*c+j][i*c+j-c]=wt[i-1][j];
                    if (j-1>=0)adj[i*c+j][i*c+j-1]=wt[i][j-1];
                    if (i+1<r)adj[i*c+j][i*c+j+c]=wt[i+1][j];
                    if (j+1<c)adj[i*c+j][i*c+j+1]=wt[i][j+1];
                }
            }
            dijkstra();

            System.out.println(wt[0][0]+d[v-1]);
        }
    }
}