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
class race{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n;
        int[] a;
        while(t-->0){
            n=Reader.nextInt();
            a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=Reader.nextInt();
            }
            int cnt=n;
            for (int i=0;i<n-1;i++){
                if (a[i]>a[i+1]){
                    a[i]=a[i+1];
                    cnt--;
                }
                int j=i;
                while(j>0){
                    if (a[j]<a[j-1]){
                        a[j-1]=a[j];
                        cnt--;
                    }
                    j--;
                }
            }
            System.out.println(cnt);
        }
    }
}