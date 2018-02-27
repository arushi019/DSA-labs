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
class adalab2{
    public static int[][] a;
    public static int r,c;
    public static int recur_cost(){
        int p=r-1;
        int q=c-1;
        int[][] b=new int[r+1][c+1];
        b[0][0]=a[0][0];
        for (int i=1;i<=p;i++){
            b[i][0]=b[i-1][0]+a[i][0];
        }
        for (int j=1;j<=q;j++){
            b[0][j]=b[0][j-1]+a[0][j];
        }
        for (int i=1;i<=p;i++){
            for (int j=1;j<=q;j++){
                int min=0;
                int p1,p2,p3,p4;
                if (i-1>=0)p1=b[i-1][j];
                else p1=Integer.MAX_VALUE;
                if (i+1>r)p2=b[i+1][j];
                else p2=Integer.MAX_VALUE;
                if (j-1>=0)p3=b[i][j-1];
                else p3=Integer.MAX_VALUE;
                if (j+1<c)p4=b[i][j+1];
                else p4=Integer.MAX_VALUE;
                if ((p1<p2)&&(p1<p3)&&(p1<p4))min=p1;
                else if ((p2<p1)&&(p2<p3)&&(p2<p4))min=p2;
                else if ((p3<p1)&&(p3<p2)&&(p3<p4))min=p3;
                else min=p4;
                //System.out.println(min);
                b[i][j]=a[i][j]+min;
            }
        }
        return b[p][q];
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            r=Reader.nextInt();
            c=Reader.nextInt();
            a=new int[r][c];
            for (int i=0;i<r;i++){
                for (int j=0;j<c;j++)a[i][j]=Reader.nextInt();
            }
        int val=recur_cost();
        System.out.println(val);
        }

    }
}