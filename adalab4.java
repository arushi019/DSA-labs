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
class adalab4{
    public static int p,q,t,v;
    public static double[] x_s;
    public static double[] y_s;
    public static double[] x_h;
    public static double[] y_h;
    //public static boolean[][] mat;
    //public static int[] match;
    /*public static void gen(){
        double w=(double)v*t;
        w=w*w;
        for (int i=0;i<p;i++){
            for (int j=0;j<q;j++){
                double dist=(double)(x_s[i]-x_h[j])*(double)(x_s[i]-x_h[j])+(double)(y_s[i]-y_h[j])*(double)(y_s[i]-y_h[j]);
                if (dist>=w)mat[i][j]=false;
                else mat[i][j]=true;
                //System.out.print(mat[i][j]+"  ");
            }
        }
    }*/
    public static boolean bpm(int u,boolean[] seen,int[] match){
        double w=(double)v*t;
        w=w*w;
        for (int i=0;i<q;i++){
            boolean matr=false;
            double dist=(x_s[u]-x_h[i])*(x_s[u]-x_h[i])+(y_s[u]-y_h[i])*(y_s[u]-y_h[i]);
                if (dist>w)matr=false;
                else matr=true;
            if ((matr==true)&&(seen[i]==false)){
                seen[i]=true;
                if ((match[i]==-1)||(bpm(match[i],seen,match))){
                    match[i]=u;
                    return true;
                }
            }
        }
        return false;
    }
    public static int maxbpm(){
        int[] match=new int[q];
        for (int i=0;i<q;i++){
            match[i]=-1;
        }
        int ct=0;
        for (int i=0;i<p;i++){
            boolean[] seen=new boolean[q];
            if(bpm(i,seen,match)==false)ct++;
        }
        return ct;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        p=Reader.nextInt();
        q=Reader.nextInt();
        t=Reader.nextInt();
        v=Reader.nextInt();
        x_s=new double[p];
        y_s=new double[p];
        x_h=new double[q];
        y_h=new double[q];
        //mat=new boolean[p][q];
        for (int i=0;i<p;i++){
            x_s[i]=Reader.nextDouble();
            y_s[i]=Reader.nextDouble();
        }
        for (int i=0;i<q;i++){
            x_h[i]=Reader.nextDouble();
            y_h[i]=Reader.nextDouble();
        }
        //gen();
        System.out.println(maxbpm());
        //System.out.println(1);
    }
}