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
//Q3 refresher module-Arushi Chauhan-2016019-sec-a
 
 
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
class waste2{
		int three=3;
		waste2(){
			three=5;
			System.out.println(three);
		}
		waste2(int t){
			waste2 w=new waste2();
			w.three=t;
			System.out.println(w.three);
		}
	} 
class waste{
	int zero=0;
	public static void main(String[] args)throws IOException{
		waste w=new waste();
		waste2 w2=new waste2(10);
		w2.three++;
		w.zero++;
		System.out.println(w.zero+" "+w2.three);
	}
}