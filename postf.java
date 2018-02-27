import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;

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
class postf{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n];
        int top=-1;
        int i=0;
        String s=new String();
        char c;
        while(i<n){
            s=Reader.next();
            c=s.charAt(0);
            if(((int)c>47)&&((int)c<58)){
                top++;
                a[top]=Integer.parseInt(s);
            }
            else{
                int x=a[top];
                top--;
                int y=a[top];
                top--;
                if (c=='+'){
                    top++;
                    a[top]=x+y;
                    //System.out.println(x+" + "+y);
                }
                else if (c=='-'){
                    top++;
                    a[top]=y-x;
                    //System.out.println(x+" - "+y);
                }
                else if (c=='*'){
                    top++;
                    a[top]=x*y;
                    //System.out.println(x+" * "+y);
                }
                else{
                    top++;
                    a[top]=y/x;
                    //System.out.println(x+" / "+y);
                }
            }
            i++;
        }
        System.out.print(a[0]);
    }
}