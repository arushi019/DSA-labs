import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
    node next;
    node(int value){
        this.value=value;
        this.next=null;
    }
}
public class t58{
    node head=new node(-1);
    int len;
    t58(int n1)throws IOException{
        int i;
        int value;
        value=Reader.nextInt();
        node n=new node(value);
        this.head.next=n;
        node prev=n;
        for (i=1;i<n1-1;i++){
            value=Reader.nextInt();
            n=new node(value);
            prev.next=n;
            prev=prev.next;
        }
        //prev.next=null;
        this.len=n1;
        node it=this.head.next;
        for (i=0;i<n1;i++){
            System.out.print(it.value+" ");
            it=it.next;
        }
    }
    public static void alt(t58 t1,t58 t2,t58 t3){
         node it1=t1.head.next;
         node it2=t2.head.next;
         node it3=t3.head.next;
         int i=0;
         while((i<t1.len)&&(i<t2.len)){
            if (i%2==1){
                it3=it1;
                it1=it1.next;
                it3.next=new node(0);
                it3=it3.next;
            }
            else{
                it3=it2;
                it2=it2.next;
                it3.next=new node(0);
                it3=it3.next;
            }
            i++;
         }
         while(i<t1.len){
            it3=it1;
            it1=it1.next;
            it3.next=new node(0);
            it3=it3.next;
            i++;
         }
         while (i<t2.len){
            it3=it2;
            it2=it2.next;
            it3.next=new node(0);
            it3=it3.next;
            i++;
         }
        t3.len=i;
        it3=t3.head.next;
        for (i=0;i<t3.len;i++){
            System.out.print(it3.value+" ");
            it3=it3.next;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int s1,s2;
        s1=Reader.nextInt();
        s2=Reader.nextInt();
        t58 t1=new t58(s1);
        t58 t2=new t58(s2);
        t58 t3=new t58(1);
    }
}