import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


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
class bytes2{
    public static boolean modfd_sum(int m,int[] a,int ptr,int sum){
        if (sum+a[ptr]==m){
            //System.out.println("Yes");
            return true;
        }
        else if (ptr>0){
            return((modfd_sum(m,a,ptr-1,sum))||(modfd_sum(m,a,ptr-1,sum+a[ptr])));
        }
        else return false;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n,m;
        int[] a;
        int i;
        while(t-->0){
            n=Reader.nextInt();
            m=Reader.nextInt();
            a=new int[n];
            for (i=0;i<n;i++){
                a[i]=Reader.nextInt();
            }
            boolean val=modfd_sum(m,a,n-1,0);
            if (val==true)System.out.println("Yes");
            else if (val==false)System.out.println("No");

        }
    }
}