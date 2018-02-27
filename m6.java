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
    int stat;
    public node(){
        this.key=null;
        a=new node[26];
        stat=0;
    }
    public node(String key,int stat){
        this.key=key;
        a=new node[26];
        this.stat=stat;
    }
}
class m6{
    public static node head;
    public static void ins(String s){
        node it=head;
        int i=0;
        while(i<s.length()){
            int c=(int)(s.charAt(i))-97;
            if (it.a[c]==null){
                node temp=new node(s.substring(0,i+1),1);
                it.a[c]=temp;
            }
            //System.out.println(it+" "+it.key+" "+it.stat);
            it=it.a[c];
            i++;
        }
        it.stat=2;
        //System.out.println(it+" "+it.key+" "+it.stat);
    }
    public static String filter(String s){
        node it=head;
        int i=0;
        while(i<s.length()){
            int c=(int)(s.charAt(i))-97;
            if (it.a[c]==null)return s.substring(0,i+1);
            else it=it.a[c];
            i++;
        }
        return "-1";
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int i=0;
        head=new node();
        String s,temp;
        ArrayList<String> b=new ArrayList<String>();
        while(i<n){
            s=Reader.next();
            temp=Reader.next();
            if (s.charAt(0)=='+')ins(temp);
            else b.add(temp);
            i++;
        }
        ArrayList<String> g=new ArrayList<String>();
        i=0;
        while(i<b.size()){
            temp=filter(b.get(i));
            if (g.contains(temp)==false)g.add(temp);
            i++;
        }
        //System.out.println(g);
        Collections.sort(g);
        if ((g.get(0)=="-1")||(g.size()==0))System.out.println("-1");
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