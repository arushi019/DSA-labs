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
class stackmin{
    public static int[] stack;
    public static int top;
    public static int n;
    public static int min;
    public static void push(int val){
        if (top<n-1){
        top++;
        //System.out.println(top);
        stack[top]=val;
    }
    }
    public static int pop(){
        int temp=-1;
        if (top!=-1){
            temp=stack[top];
            top--;
            return temp;
        }
        else return -1;
    }
    public static int findmin(){
        int[] tem=new int[n];
        int top2=-1;
        if (top!=-1){
        min=stack[top];
        while(top!=-1){
            top2++;
            tem[top2]=pop();
            if (min>tem[top2])min=tem[top2];
        }
        while(top2!=-1){
            push(tem[top2]);
            top2--;
        }
        return min;
    }
    else return -1;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int q=Reader.nextInt();
        n=Reader.nextInt();
        stack=new int[n];
        top=-1;
        int ch=-1;
        int v=-1;
        while(q-->0){
            ch=Reader.nextInt();
            if (ch==1){
                v=Reader.nextInt();
                push(v);
            }
            else if (ch==2){
                System.out.println(pop());
            }
            else{
                System.out.println(findmin());
            }
        }
    }
}