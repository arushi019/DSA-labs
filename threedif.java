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
class threedif{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            long[] n=new long[3];
            for (int i=0;i<3;i++){
                n[i]=Reader.nextLong();
            }
            Arrays.sort(n);
            n[1]--;
            n[2]-=2;
            long pro=1;
            for (int i=0;i<3;i++){
                n[i]=n[i]%1000000007;
                pro=pro*n[i];
                pro=pro%1000000007;
            }
            pro=pro%1000000007;
            System.out.println(pro);
        }
    }
}