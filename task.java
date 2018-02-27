import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;

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
class task{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n;
        int[] a1;
        int[] a2;
        while(t-->0){
            n=Reader.nextInt();
            //a1=new int[n];
            //a2=new int[n];
            int i=0;
            int sum11=0,sum12=0,sum21=0,sum22=0;
            while(i<n){
                //a1[i]=Reader.nextInt();
                if (i%2==0)sum11+=Reader.nextInt();
                else sum12+=Reader.nextInt();
                i++;
            }
            i=0;
            while(i<n){
                //a2[i]=Reader.nextInt();
                if (i%2==0)sum21+=Reader.nextInt();
                else sum22+=Reader.nextInt();
                i++;
            }
            System.out.println((sum11+sum22)>(sum21+sum12)?sum12+sum21:sum11+sum22);
        }
    }
}