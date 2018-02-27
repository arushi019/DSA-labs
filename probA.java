import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.lang.*;
 

 
 
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
class probA{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int m=Reader.nextInt();
        ArrayList<Integer> grp=new ArrayList<Integer>();
        for (int i=0;i<n;i++)grp.add(Reader.nextInt());
        for (int i=n;i<m;i++){
            Collections.sort(grp);
            int temp=grp.get(grp.size()-1);
            grp.remove(grp.size()-1);
            grp.add(temp/2);
            grp.add(temp-temp/2);
            //System.out.println(grp);
        }
        Collections.sort(grp);
        System.out.println(grp.get(grp.size()-1));

    }
}