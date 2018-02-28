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
class cp2b{
    public static int n;
    public static int m;
    public static int bus_num;
    public static int bank;
    public static int g;
    public static int h;
    public static int[][] mat;
    public static int[] dist1;
    public static int[] dist2;
    public static int[] dist3;
    public static int mindis(int[] dist,boolean[] check){
        int mini=-1;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if ((check[i]==false)&&(dist[i]<=min)){
                min=dist[i];
                mini=i;
            }
        }
        return mini;
    }
    public static void dijk(int[] dist,int src){
        boolean[] check=new boolean[n];
        for (int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        for (int i=0;i<n-1;i++){
            int v=mindis(dist,check);
            check[v]=true;
            for (int j=0;j<n;j++){
                if ((check[j]==false)&&(mat[v][j]>0)&&(dist[v]!=Integer.MAX_VALUE)&&(dist[v]+mat[v][j]<dist[j]))
                dist[j]=dist[v]+mat[v][j];
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            m=Reader.nextInt();
            bus_num=Reader.nextInt();
            bank=Reader.nextInt();
            mat=new int[n][n];
            bank--;
            g=Reader.nextInt();
            g--;
            h=Reader.nextInt();
            h--;
            for (int i=0;i<m;i++){
                int x1=Reader.nextInt();
                int y1=Reader.nextInt();
                x1--;
                y1--;
                mat[x1][y1]=Reader.nextInt();
                mat[y1][x1]=mat[x1][y1];
            }
            for (int i=0;i<bus_num;i++){
                int temp=Reader.nextInt();
                temp--;
                mat[temp][temp]=1;
            }
            dist1=new int[n];
            dijk(dist1,bank);
            //for (int i=0;i<n;i++)System.out.print(dist1[i]+" ");
            //System.out.println();
            dist2=new int[n];
            dijk(dist2,g);
            //for (int i=0;i<n;i++)System.out.print(dist2[i]+" ");
            //System.out.println();
            dist3=new int[n];
            dijk(dist3,h);
            //for (int i=0;i<n;i++)System.out.print(dist3[i]+" ");
            //System.out.println();
            for (int i=0;i<n;i++){
                if (mat[i][i]==1){
                    int d1=dist1[g]+mat[g][h]+dist3[i];
                    int d2=dist1[h]+mat[g][h]+dist2[i];
                    if (!((d1==dist1[i])||(d2==dist1[i])))mat[i][i]=-1;
                }
            }
            for (int i=0;i<n;i++){
                if (mat[i][i]==1)System.out.print((i+1)+" ");
            }
            System.out.println();
        }
    }
}