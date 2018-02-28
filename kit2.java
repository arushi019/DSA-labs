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
class node{
    String key;
    node[] a;
    int f;
    public node(){
        this.key=null;
        f=0;
        a=new node[26];
    }
    public node(String key){
        this.key=key;
        f=0;
        a=new node[26];
    }
}
class kit2{
    public static node head;
    public static void ins(String s){
        int i=0;
        node it=head;
        int c;
        node prev;
        while(i<s.length()){
            c=(int)(s.charAt(i))-97;
            //System.out.println(c);
            if (it.a[c]==null){
                //System.out.println(s.substring(0,i+1)+" "+it);
                node temp=new node(s.substring(0,i+1));
                it.a[c]=temp;
                if (i!=s.length()-1)prev=it.a[c];
                it=it.a[c];
            }
            else if (i!=s.length()-1){
                prev=it.a[c];
                it=it.a[c];
            }
            i++;
        }
        it.f++;
        //System.out.println(it+" "+it.f);
    }
    public static void disp(node r){
        node it=r;
        if (r.key!=null)System.out.println(r.key);
        else System.out.println("null");
        int i=0;
        while(i<26){
            if (it.a[i]!=null)disp(it.a[i]);
            i++;
        }
    }
    public static String filter(String s){
        node it=head;
        int i=0;
        int c;
        while(i<s.length()){
            c=(int)(s.charAt(i))-97;
            System.out.println(it.key);
            if (((it.a[c]==null)&&(it.f==0))||((it.f>0)&&(s.length()>it.key.length())))return s.substring(0,i+1);
            else {
                if (it.f>0){
                    //System.out.println("hi "+s);
                    return "-1";
                }
                else it=it.a[c];
            }
            i++;
        }
        return "-1";
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        ArrayList<String> b=new ArrayList<String>();
        ArrayList<String> g=new ArrayList<String>();
        head=new node();
        String s,temp;
        int i=0;
        while(i<n){
            s=Reader.next();
            temp=Reader.next();
            if (s.charAt(0)=='+')ins(temp);
            else b.add(temp);
            i++;
        }
        //disp(head);
        //System.out.println(b);
        i=0;
        while(i<b.size()){
            String t=filter(b.get(i));
            if (g.contains(t)==false)g.add(t);
            i++;
        }
        Collections.sort(g);
        if ((g.size()==0)||(g.get(0)=="-1"))System.out.println("-1");
        else{
            System.out.println(g.size());
            i=0;
            while(i<g.size()){
                System.out.println(g.get(i));
                i++;
            }
        }
    }
}  