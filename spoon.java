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
class spoon{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int m=Reader.nextInt();
            int n=Reader.nextInt();
            char[][] c=new char[m][n];
            boolean flag=false;
            for (int i=0;i<m;i++){
                String s=Reader.next();
                String s1=new String();
                for (int j=0;j<n;j++){
                    c[i][j]=Character.toLowerCase(s.charAt(j));
                    s1=s1+c[i][j];
                }
                if (flag==false)flag=s1.contains("spoon");
            }
            for (int i=0;i<n;i++){
                String s1=new String();
                for (int j=0;j<m;j++){
                    s1=s1+c[j][i];
                }
                if (flag==false)flag=s1.contains("spoon");
            }
            if (flag==true)System.out.println("There is a spoon!");
            else System.out.println("There is indeed no spoon!");
        }
    }
}