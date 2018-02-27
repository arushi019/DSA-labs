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
class node{
    node[] a;
    int num_set;
    String val;
    public node(int size){
        this.a=new node[size];
        this.num_set=0;
        val=new String();
    }
}
class unionset2{
    public static node head;
    public static void ins(ArrayList<Integer> s,node root,int k,String st){
        if (s.size()!=0){
            //System.out.println(s);
        int t=s.get(0);
        if (root.a[t-1]==null){
            root.a[t-1]=new node(k);
            //w.add(t);
            String st2=st+" "+t;
            root.a[t-1].val=st2;
            if (s.size()==1)root.a[t-1].num_set++;
            s.remove(0);
            ins(s,root.a[t-1],k,st2);
        }
        else{
            if (s.size()==1)root.num_set++;
            s.remove(0);
            String st2=st+" "+t;
            ins(s,root.a[t-1],k,st2);
        }
    }
    }
    public static void traversal(node root,int k){
        System.out.println(root);
        System.out.println(root.val);
        System.out.println(root.num_set);
        for (int i=0;i<k;i++){
            if (root.a[i]!=null)traversal(root.a[i],k);
        }
    }
    public static int search(int k,HashSet<Integer> has,node root,int num){
        int pt=num;
        for (int i=0;i<k;i++){
            if (root.a[i]!=null){
                if (has.contains(i+1)){
                    num+=search(k,has,root.a[i],num);
                }
            }
        }
        return num;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            head=new node(k);
            //System.out.println(head);
            for (int i=0;i<n;i++){
                int len=Reader.nextInt();
                HashSet<Integer> has=new HashSet<Integer>();
                ArrayList<Integer> wants=new ArrayList<Integer>();
                int[] tem=new int[k];
                for (int j=0;j<len;j++){
                    int temp=Reader.nextInt();
                    tem[temp-1]++;
                }
                for (int j=0;j<k;j++){
                    if (tem[j]==0)wants.add(j+1);
                    if (tem[j]==1)has.add(j+1);
                }
                if (head!=null){int nim=search(k,has,head,0);
                System.out.println(nim);}
                //System.out.println(has);
                //System.out.println(wants);
                String st=new String();
                ins(wants,head,k,st);
            }
            //traversal(head,k);
        }
    }
}