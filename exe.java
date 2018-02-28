import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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
public class exe{
    public static void main(String[] args)throws IOException{
        ArrayList<String> output=new ArrayList<String>();
        ArrayList<String> operator=new ArrayList<String>();
        Reader.init(System.in);
        int n;
        n=Reader.nextInt();
        int cn;
        while(n-->0){
            String ch=Reader.next();
            char c=ch.charAt(0);
            //System.out.println(c);
            cn=(int)c;
            //System.out.println(cn);
            //if entered character is a number
            if ((cn>47)&&(cn<59))output.add(ch);
        }
            System.out.print(output);

    }
}