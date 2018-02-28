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
class choco{
    public static int getchoc(int n){
        int[] dp=new int[n+1];
        int i;
        dp[1]=0;
        for (i=2;i<=n;i++){
            dp[i]=1+dp[i-1];
            if (i%2==0)dp[i]=dp[i]<(1+dp[i/2])?dp[i]:1+dp[i/2];
            if (i%3==0)dp[i]=dp[i]<(1+dp[i/3])?dp[i]:1+dp[i/3];
        }
                return dp[n];
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        System.out.println(getchoc(n));

    }
}