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
class brack{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        char[] stack=new char[n];
        String s=Reader.next();
        //System.out.println(s);
        int i=0;
        int top=-1;
        int flag=0;
        while(i<n){
            if ((s.charAt(i)=='{')||(s.charAt(i)=='(')||(s.charAt(i)=='[')){
                top++;
                stack[top]=s.charAt(i);
            }
            else if (top>-1){
                char t=stack[top];
                if (s.charAt(i)=='}'){
                    if (t!='{'){
                        flag=-1;
                        break;
                    }
                }
                else if (s.charAt(i)==')'){
                    if (t!='('){
                        flag=-1;
                        break;
                    }
                }
                else{
                    if (t!='['){
                        flag=-1;
                        break;
                    }
                }
                top--;
            }
            else {flag=-1;}
            i++;
        }
        if ((flag==0)&&(top==-1))System.out.println("YES");
        else System.out.println("NO");
    }
}