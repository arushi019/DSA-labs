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
class histosim{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String s1=Reader.next();
            String s2=Reader.next();
            int[] a1=new int[26];
            int[] a2=new int[26];
            for (int i=0;i<s1.length();i++){
                int c1=(int)s1.charAt(i)-97;
                int c2=(int)s2.charAt(i)-97;
                a1[c1]++;
                a2[c2]++;
            }
            HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
            for (int i=0;i<26;i++){
                if (a1[i]!=0){
                if (hs.containsKey(a1[i])==false)hs.put(a1[i],1);
                else hs.put(a1[i],hs.get(a1[i])+1);
            }
            }
            int flag=0;
            for (int i=0;i<26;i++){
                if (a2[i]!=0){
                    if (hs.containsKey(a2[i])){
                        if (hs.get(a2[i])!=1)hs.put(a2[i],hs.get(a2[i])-1);
                        else hs.remove(a2[i]);
                    }
                    else {flag=-1;break;}
                }
            }
            if (flag==-1)System.out.println("NO");
            else System.out.println("YES");
        }
    }
}