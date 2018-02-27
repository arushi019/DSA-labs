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
class prob1{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int c=1;
        while(t-->0){
            int k=Reader.nextInt();
            int[] arr=new int[k];
            for (int i=0;i<k;i++){
                arr[i]=Reader.nextInt();
            }
            Arrays.sort(arr);
            long error=0;
            int ct=0;
            double up=Math.floor(k/2);
            while(ct<up){
                error+=(long)(arr[ct]-ct)*(long)(arr[ct]-ct);
                //System.out.println(ct);
                ct++;
            }
            if (k%2==0)ct=1;
            else ct=0;
            while(ct<=up){
                error+=(long)(arr[k-ct-1]-(up-ct))*(long)(arr[k-ct-1]-(up-ct));
                //System.out.println(up-ct);
                ct++;
            }
            System.out.println("Case #"+c+": "+error);
            c++;
        }
    }
}