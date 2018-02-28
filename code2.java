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
class code2{
    public static BigDecimal pr(double[] a){
        int i=0;
        BigDecimal pro=BigDecimal.ONE;
        while(i<a.length){
            pro=pro.multiply(BigDecimal.valueOf(a[i]));
            i++;
        }
        return pro;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        double k=Reader.nextInt();
        double[] a=new double[n];
        double[] b=new double[n/2];
        double[] c=new double[n-n/2];
        int i=0;
        while(i<n){
            a[i]=Reader.nextDouble();
            i++;
        }
        Arrays.sort(a);
        System.arraycopy(a,0,b,0,n/2);
        System.arraycopy(a,n/2,c,0,n-n/2);
        /*i=0;
        System.out.println();
        while(i<b.length){
            System.out.print(b[i]+" ");
            i++;
        }
        System.out.println();
        i=0;
        while(i<c.length){
            System.out.print(c[i]+" ");
            i++;
        }
        System.out.println();*/
        BigDecimal t1=pr(b);
        BigDecimal t2=pr(c);
        //System.out.println(t1.doubleValue()==k);
    }
}