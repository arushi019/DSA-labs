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
class lupin{
    public static String sorts(String s){
        int i=0;
        int j=0;
        char[] arr=new char[s.length()];
        arr=s.toCharArray();
        Arrays.sort(arr);
        String s2=new String(arr);
        //System.out.println(s2);
        return s2;
    }
    public static boolean check(String s){
        int i=0;
        int len=s.length();
        String s1=s.substring(0,len/2);
        String s2;
        if (len%2==0)s2=s.substring(len/2);
        else s2=s.substring(len/2+1);
        s1=sorts(s1);
        s2=sorts(s2);
        return s1.equals(s2);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while (t-->0){
            String s=Reader.next();
            if (check(s)==true)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}