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
class nuke{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int a=Reader.nextInt();
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int i;
        int[] rt=new int[k];
        for (i=0;i<k;i++){
            //System.out.println(Math.pow(n+1,i));
            rt[i]=((int)a/(int)Math.pow(n+1,i))%(int)Math.pow(n+1,1);
        }
        for (i=0;i<k;i++){
            System.out.print(rt[i]+" ");
        }
    }
}