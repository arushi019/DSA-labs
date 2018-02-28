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
    public static ArrayList<Integer> p1;
    public static ArrayList<Integer> p2;
    public static node ins(int val,node root){
        node it=head;
        if (root==null){
            root=new node(val);
        }
        else if (val>root.value){
            root.right=ins(val,root.right);
        }
        else{
            root.left=ins(val,root.left);
        }
        return root;
    }
    public static void disp(node root){
        if (root!=head)System.out.println(root.value+" "+root.parent.value);
        if (root.right!=null){
            System.out.println("going right from "+root.value);
            disp(root.right);
        }
        if (root.left!=null){
            System.out.println("going left from "+root.value);
            disp(root.left);
        }
    }
    public static void assign(node root){
        if (root.right!=null){
            root.right.parent=root;
            assign(root.right);
        }
        if (root.left!=null){
            root.left.parent=root;
            assign(root.left);
        }
    }
    public static void path1(int val,node root){
        p1.add(root.value);
        if (val>root.value){
            path1(val,root.right);
        }
        else if (val<root.value){
            path1(val,root.left);
        }
    }
    public static void path2(int val,node root){
        p2.add(root.value);
        if (val>root.value){
            path2(val,root.right);
        }
        else if (val<root.value){
            path2(val,root.left);
        }
    }
    public static void main(String[] main)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int val=Reader.nextInt();
        p1=new ArrayList<Integer>();
        p2=new ArrayList<Integer>();
        head=new node(val);
        for (int i=1;i<n;i++){
            val=Reader.nextInt();
            head=ins(val,head);
        }
        assign(head);
        //disp(head);
        int x=Reader.nextInt();
        int y=Reader.nextInt();
        path1(x,head);
        path2(y,head);
        //System.out.println(p1);
        //System.out.println(p2);
        int sum=0;
        int temp;
        int flag=head.value;
        for (int i=p1.size()-1;i>=0;i--){
            temp=p1.get(i);
            if (p2.contains(temp)){
                flag=temp;
                break;
            }
            else sum+=temp;
        }
        //System.out.println(sum+" "+flag);
        sum+=flag;  
        int index=p2.indexOf(flag);
        for (int i=index+1;i<p2.size();i++){
            sum+=p2.get(i);
        }
        System.out.println(sum); 
    }
}