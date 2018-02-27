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
// JAVA program to print all 
// paths from a source to
// destination

// A directed graph using
// adjacency list representation
class adalab3 {

    // No. of vertices in graph
    private int v; 
    
    // adjacency list 
    private ArrayList<Integer>[] adjList; 
    
    //Constructor
    public adalab3(int vertices){
        
        //initialise vertex count
        this.v = vertices;
        
        // initialise adjacency list
        adjList = new ArrayList[v];
        
        for(int i = 0; i < v; i++)
        {
            adjList[i] = new ArrayList<>();
        }
    }
    
    // add edge from u to v
    public void addEdge(int u, int v)
    {
        // Add v to u's list.
        adjList[u].add(v); 
    }
    
    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d) 
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
        //add source to path[]
        pathList.add(s);
        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d,
                                    boolean[] isVisited,
                            List<Integer> localPathList) {
        
        // Mark the current node
        isVisited[u] = true;
        //System.out.println(u);
        if (u.equals(d)) 
        {
            System.out.println(localPathList);
        }
        
        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) 
        {
            if (!isVisited[i])
            {
                // store current node 
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                
                // remove current node
                // in path[]
                //localPathList.remove(i);
            }
        }
        
        // Mark the current node
        isVisited[u] = false;
        System.out.println(localPathList);
    }

    // Driver program
    public static void main(String[] args)throws IOException 
    {
        Reader.init(System.in);
        int n=Reader.nextInt();
        int p=Reader.nextInt();
        adalab3 g = new adalab3(n);
        for (int i=0;i<p;i++){
            int x=Reader.nextInt()-1;
            int y=Reader.nextInt()-1;
            g.adjList[x].add(y);
        }
        g.printAllPaths(0, n-1);
    }
}

