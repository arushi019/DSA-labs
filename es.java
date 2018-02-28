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
}
class es{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        String s=Reader.next();
        BigInteger k=new BigInteger(s);
        //System.out.println(k.longValue());
        BigInteger[] g=k.divideAndRemainder(BigInteger.valueOf(7));
        //System.out.println(g[1].longValue());
        BigInteger n=g[0].multiply(BigInteger.valueOf(7));
        BigInteger sum=(n.multiply(BigInteger.valueOf(19)));
        sum=sum.subtract(g[0].multiply(BigInteger.valueOf(60)));
        int r=g[1].intValue();
        if (r==1)sum=sum.add(BigInteger.valueOf(2));
        else if (r==2)sum=sum.add(BigInteger.valueOf(7));
        else if (r==3)sum=sum.add(BigInteger.valueOf(15));
        else if (r==4)sum=sum.add(BigInteger.valueOf(25));
        else if (r==5)sum=sum.add(BigInteger.valueOf(38));
        else if (r==6)sum=sum.add(BigInteger.valueOf(54));
        double d=sum.doubleValue();
        DecimalFormat df=new DecimalFormat("#");
        System.out.println(df.format(d));
    }
}