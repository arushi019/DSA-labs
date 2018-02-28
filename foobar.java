import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
public class foobar{
    public static void main(String[] args) throws IOException{
        int t,i,min;
        int x;
        char arr[]=new char[10000];
        String s=new String();
        Reader.init(System.in);
        t=Reader.nextInt();
        while(t-->0){
            int a[]={0,0,0,0,0};
            s=Reader.next();
            s.getChars(0,s.length(),arr,0);
            for (x=0;x<s.length();x++){
                if (arr[x]=='f')a[0]++;
                if (arr[x]=='o')a[1]++;
                if (arr[x]=='b')a[2]++;
                if (arr[x]=='a')a[3]++;
                if (arr[x]=='r')a[4]++;
            }
            if (a[1]%2==0)a[1]=(int)a[1]/2;
            else a[1]=(int)(a[1]-1)/2;
            min=a[0];
            for(i=0;i<5;i++){
                //System.out.print(a[i]);
                if (min>a[i])min=a[i];
            }
            System.out.println(min);
        }

    }
}