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
    node left;
    node right;
    node parent;
    public node(int val){
        this.value=val;
        this.left=null;
        this.right=null;
        this.parent=null;
    }
}
class probB{
    public static node head;
    public static int x,y;
    public static ArrayList<Integer> path1;
    public static ArrayList<Integer> path2;
    public static node ins(int val,node root){
        node it=root;
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
        if (root.parent!=null)System.out.println(root.value+" child of "+root.parent.value);
        if (root.left!=null){
            System.out.println("going left from "+root.value);
            disp(root.left);
        }
        if (root.right!=null){
            System.out.println("going right from "+root.value);
            disp(root.right);
        }
    }
    public static void assign_parent(node root){
        if (root.right!=null){
            root.right.parent=root;
            assign_parent(root.right);
        }
        if (root.left!=null){
            root.left.parent=root;
            assign_parent(root.left);
        }
    }
    public static void trace_to_parent(int val,node root){
        if (root!=null){
            if (root.value!=val){
            path1.add(root.value);
            if (val>root.value)trace_to_parent(val,root.right);
            if (val<root.value)trace_to_parent(val,root.left);
        }}
    }

    public static void trace_to_parent2(int val,node root){
        if (root!=null){
            if (root.value!=val){
            path2.add(root.value);
            if (val>root.value)trace_to_parent2(val,root.right);
            if (val<root.value)trace_to_parent2(val,root.left);
        }}
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int val=Reader.nextInt();
        head=new node(val);
        for (int i=1;i<n;i++){
            val=Reader.nextInt();
            head=ins(val,head);
        }
        assign_parent(head);
        //disp(head);
        x=Reader.nextInt();
        path1=new ArrayList<Integer>();
        path2=new ArrayList<Integer>();
        trace_to_parent(x,head);
        System.out.println(path1);
        y=Reader.nextInt();
        trace_to_parent2(y,head);
        System.out.println(path2);
        //disp(head);
        int sum=0;
        int temp=path1.size()-1;
        if ((path1.size()!=0)&&(path2.size()!=0)){
        for (int i=path1.size()-1;i>=0;i--){
            temp=path1.get(i);
            if (path2.contains(temp)==false){
                //System.out.println(temp);
                sum+=temp;
            }
            else break;
        }
        int ind=path2.indexOf(temp);
        for (int i=ind;i<path2.size();i++){
            //System.out.println(path2.get(i));
            sum+=path2.get(i);
        }
    }
        else if ((path1.size()==0)&&(path2.size()!=0)){
            for (int i=path2.size()-1;i>0;i--){
                sum+=path2.get(i);
            }
        }
        else if ((path2.size()==0)&&(path1.size()!=0)){
            for (int i=path1.size()-1;i>0;i--){
                sum+=path1.get(i);
            }
        }
        else{
            sum=-head.value;
        }
        if (x!=y){
        System.out.println(sum+x+y);}
        else System.out.println(x);
    }
}