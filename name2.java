import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.Point;
import java.text.DecimalFormat;
 

 
 
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class name2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String m=Reader.next();
            String w=Reader.next();
            int pt1=0;
            int pt2=0;
            int flag=0;
            while((pt1<m.length())&&(pt2<w.length())){
                if (m.charAt(pt1)==w.charAt(pt2)){
                    flag++;
                    pt1++;
                }
                pt2++;
            }
            if (flag==m.length())System.out.println("YES");
            else{
                pt1=0;
                pt2=0;
                flag=0;
                while((pt1<m.length())&&(pt2<w.length())){
                    if (w.charAt(pt2)==m.charAt(pt1)){
                        flag++;
                        pt2++;
                    }
                    pt1++;
                }
                if (flag==w.length())System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}