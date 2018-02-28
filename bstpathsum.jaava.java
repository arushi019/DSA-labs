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
    node parent;
    public node(int value){
        this.value=value;
        this.right=null;
        this.left=null;
        this.parent=null;
    }
}
class bstpathsum{
    public static node head;
    public static node ins(int val,node root){
        node it=head;
        if (root==null){
            root=new node(val);
        }
        else if (val>root.value){
            root=ins(val,root.right);
        }
        else{
            root=ins(val,root.left);
        }
        return root;
    }
    public static void disp(node root){
        System.out.println(root.value);
        if (root.right!=null){
            System.out.println("going right from "+root.value);
            disp(root.right);
        }
        if (root.left!=null){
            System.out.println("going left from "+root.value);
            disp(root.left);
        }
    }
    public static void main(String[] main)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int val=Reader.nextInt();
        head.value=val;
        for (int i=1;i<n;i++){
            val=Reader.nextInt();
            head=ins(val,head);
        }
        disp(head);
    }
}