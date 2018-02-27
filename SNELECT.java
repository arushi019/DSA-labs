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
class SNELECT{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String s=Reader.next();
            char[] st=s.toCharArray();
            int sn=0;
            int m=0;
            for (int i=0;i<st.length;i++){
                if(st[i]=='m'){
                    m++;
                    if ((i>0)&&(st[i-1]=='s')){
                        st[i-1]='n';
                    }
                    else if ((i<st.length-1)&&(st[i+1]=='s')){
                        st[i+1]='n';
                }
            }
            }
            for (int i=0;i<st.length;i++)if (st[i]=='s')sn++;
            System.out.println(st);
            //System.out.println(sn+" "+m);
            if (sn>m)System.out.println("snakes");
            else if(m>sn)System.out.println("mongooses");
            else System.out.println("tie");
        }
    }
}