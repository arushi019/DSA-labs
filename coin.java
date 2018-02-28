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
class coin{
    public static void main(String[] args)throws IOException{
        /*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st="";
        ArrayList<Integer> a=new ArrayList<Integer>();
        while((st=br.readLine())!=null){
            int t=Integer.parseInt(br.readLine());
            if ((t/2+t/4+t/3)>t)System.out.println(t/4+t/3+t/2);
            else System.out.println(t);
        }
        br.close();*/
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            int t=s.nextInt();
            int temp=t/4+t/2+t/3;
            if (t>temp)System.out.println(t);
            else System.out.println(temp);
        }
    }
}