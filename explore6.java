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
class explore6{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        String x=Reader.next();
        String y=Reader.next();
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        if (x.length()==y.length()){
            int flag=0;
            for (int i=0;i<x.length();i++){
                if (h.containsKey(x.charAt(i))==false)h.put(x.charAt(i),1);
                else {
                    int temp=h.get(x.charAt(i));
                    temp++;
                    h.put(x.charAt(i),temp);
                }
            }
            for (int i=0;i<y.length();i++){
                if (h.containsKey(y.charAt(i))==false){
                    flag=-1;
                    break;
                }
                else{
                    if (h.get(y.charAt(i))!=1){
                        int temp=h.get(y.charAt(i));
                        temp--;
                        h.put(y.charAt(i),temp);
                    }
                    else h.remove(y.charAt(i));
                }
            }
            if (flag==-1)System.out.println("Not Anagram");
            else System.out.println("Y is Anagram of X");
        }
        else System.out.println("Not Anagram");

    }
}