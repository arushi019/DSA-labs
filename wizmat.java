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
class wizmat{
    public static int[][] mat;
    public static int n;
    public static void row(int val){
        for (int i=0;i<n/2;i++){
            int temp=mat[val][i];
            mat[val][i]=mat[val][n-i-1];
            mat[val][n-i-1]=temp;
        }
        //for(int i=0;i<n;i++)System.out.print(mat[val][i]+" ");
        //System.out.println();
    }
    public static void col(int val){
        for (int i=0;i<n/2;i++){
            int temp=mat[i][val];
            mat[i][val]=mat[n-i-1][val];
            mat[n-i-1][val]=temp;
        }
        //for(int i=0;i<n;i++)System.out.print(mat[i][val]+" ");
        //System.out.println();
    }
    public static int dotp(){
        int ct=0;
        int pt1=0;
        for (int i=0;i<n;i++){
            pt1=0;
            while(pt1<n){
                if ((mat[i][pt1]==mat[pt1][i])&&(mat[i][pt1]==1))ct++;
                pt1++;
            }
        }
        //System.out.println(ct);
        
        return ct%2;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        mat=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++)mat[i][j]=Reader.nextInt();
        }
        int q=Reader.nextInt();
        while(q-->0){
            char ch=Reader.next().charAt(0);
            int val=Reader.nextInt();
            if (ch=='r'){
                row(val);
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++)System.out.print(mat[i][j]+" ");
                    System.out.println();
                }
                System.out.println(dotp());
            }
            else{
                col(val);
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++)System.out.print(mat[i][j]+" ");
                    System.out.println();
                }
                System.out.println(dotp());
            }   
        }
    }
}