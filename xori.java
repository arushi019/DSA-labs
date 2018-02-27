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
class node{
    int value;
    node right;
    node left;
    public node(int value){
        this.value=value;
        this.right=null;
        this.left=null;
    }
}
class xori{
    public static node head;
    public static void ins(int value,node root,int bit){
        node it=head;
        
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        head=new node(0);
        ArrayList<Integer> score=new ArrayList<Integer>();
        int n=Reader.nextInt();
        score.add(0);
        for (int i=0;i<n;i++){
            String ch=Reader.next();
            if (ch.charAt(0)=='+'){
                int t=Reader.nextInt();
                score.add(t);
            }
            else if (ch.charAt(0)=='-'){
                int t=Reader.nextInt();
                int ind=score.indexOf(t);
                score.remove(ind);
            }
            else{
                int t=Reader.nextInt();
                int max=0^t;
                for (int j=1;j<score.size();j++){
                    int y=score.get(j)^t;
                    if (y>max)max=y;
                }
                System.out.println(max);
            }
        }
    }
}