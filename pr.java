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
    node right;
    node left;
    public node(int value,int freq){
        this.value=value;
        this.freq=freq;
        this.next=null;
        this.right=null;
        this.left=null;
    }
    public node(int freq){
        this.value=0;
        this.freq=freq;
        this.next=null;
        this.right=null;
        this.left=null;
    }
}
class pr{
    public static node min(node head){
        node it=head;
        node mn=it;
        while(it!=null){
            if (it.freq<mn.freq)mn=it;
            it=it.next;
        }
        return mn;
    }
    public static node min2(node head){
        node it=head;
        node mn2=it;
        node mn=min(head);
        while(it!=null){
            if ((it.freq<mn2.freq)&&(it.value!=mn.value))mn2=it;
            it=it.next;
        }
        return mn2;
    }
    public static node rem(node head,node n){
        node it=head;
        node prev=head;
        node nex=head;
        if (n!=head){
            it=it.next;
            nex=it.next;
            while((it!=null)&&(it!=n)){
                it=it.next;
                prev=prev.next;
                nex=nex.next;
            }
            prev.next=nex;
        }
        else{
            it=it.next;
            while(it!=null){
                it=it.next;
                prev=prev.next;
            }
            prev.next=head.next;
            head=head.next;
        }
        return head;
    }
    public static node cmb2(node head){
        node mn1=min(head);
        node mn2=min2(head);
        node p=new node(mn1.freq+mn2.freq);
        p.right=mn2;
        p.left=mn1;
        return head;
    }
    public static node cmb(node head){
        node it=head;
        node it2=null;
        return null;
    }
    public static void disp(node head){
        node it=head;
        while(it!=null){
            System.out.println(it.value+" "+it.freq);
            it=it.next;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        int n2=Reader.nextInt();
        int m=n1*n2;
        int i,temp;
        int[] fr=new int[256];
        for (i=0;i<m;i++){
            temp=Reader.nextInt();
            fr[temp]++;
        }
        node head,it,nw;
        head=null;
        it=null;
        nw=null;
        int node_ct=0;
        for (i=1;i<256;i++){
            if (fr[i]>0){
                if (node_ct==0){
                    it=new node(i,fr[i]);
                    head=it;
                    node_ct++;
                }
                else if (node_ct==1){
                    it=new node(i,fr[i]);
                    head.next=it;
                    node_ct++;
                } 
                else{
                    nw=new node(i,fr[i]);
                    it.next=nw;
                    it=nw;
                    node_ct++;
                }
            }
        }
        /*it=head;
        while(it!=null){
            System.out.println(it.value+" "+it.freq);
            it=it.next;
        }*/
        System.out.println(min(head).value+" "+min(head).freq);
        System.out.println(min2(head).value+" "+min2(head).freq);
        head=rem(head,head);
        disp(head);
    }
}