import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;

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
    int freq;
    node next;
    public node(int value,int freq){
        this.value=value;
        this.freq=freq;
        this.next=null;
    }
}
public class pri{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        int n2=Reader.nextInt();
        int[] v=new int[256];
        int m=n1*n2;
        int i=0,temp;
        while(i<m){
            temp=Reader.nextInt();
            v[temp]++;
            i++;
        }
        int node_ct=0;
        node it=null;
        node nw=null;
        node head=null;
        for (i=0;i<256;i++){
            if (v[i]>0){
                if (node_ct==0){
                    it=new node(i,v[i]);
                    head=it;
                    node_ct++;
                }
                else if (node_ct==1){
                    it=new node(i,v[i]);
                    head.next=it;
                    node_ct++;
                } 
                else{
                    nw=new node(i,v[i]);
                    it.next=nw;
                    it=nw;
                    node_ct++;
                }
            }
        }
        it=head;
        while(it!=null){
            System.out.println(it.value+" "+it.freq);
            it=it.next;
        }

    }
}