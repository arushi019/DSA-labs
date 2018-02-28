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
class game1{
    public static boolean checker(int[] tr,int n){
        int i=0;
        while(i<n){
            if (tr[i]!=tr[0])return false;
            i++;
        }
        return true;
    }
    public static void game(int[] tr,int n){
        int i,j;
        while(checker(tr,n)==false){
            Arrays.sort(tr);
            i=n-1;
            while(i>0){
                if ((tr[i]-tr[i-1])!=0){
                    tr[i]=tr[i]-tr[i-1];
                    j=0;
                    /*while(j<n){
                        System.out.print(tr[j]+" ");
                        j++;
                    }*
                    System.out.println();*/
                    break;
                }
                i--;
            }
        }
        System.out.println(tr[0]);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n;
        int[] tr;
        int i;
        while(t-->0){
            n=Reader.nextInt();
            tr=new int[n];
            i=0;
            while(i<n){
                tr[i]=Reader.nextInt();
                i++;
            }
            game(tr,n);
        }
    }
}