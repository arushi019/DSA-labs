import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by raghav on 16/1/17.
 */
public class lab3_ifib {
    public static void main(String args[])
            throws IOException
    {

        Reader.init(System.in);
        System.out.println("Enter the number.");
        long n=Long.parseLong(Reader.next());
        long startTime = System.currentTimeMillis();
        if(n==0)
        {
            System.out.println(0);
        }
        else if(n==1)
        {
            System.out.println(1);
        }
        else
        {
            long a=0;
            long b=1;
            long c=0;
            for(long i=2;i<=n;i++)
            {
                c=a+b;
                a=b;
                b=c;
            }
            System.out.println(c%2014);

        }
        long endTime = System.currentTimeMillis();
        double TimeElapsed= ((endTime-startTime)/1000.0);
        System.out.println(TimeElapsed);
    }
}
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