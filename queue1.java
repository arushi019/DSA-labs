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
}
public class queue1{
    static node front;
    static node rear;
    static int r=0,f=0;
    static int max;
    public static void add(int val){
        if (r==0){
            r++;
            node temp=new node();
            temp.value=val;
            rear=temp;
            front=rear;
            //System.out.println(rear.value);
            rear.next=null;
        }
        else if (r<max-1){
            r++;
            node temp=new node();
            temp.value=val;
            rear.next=temp;
            rear=temp;
            System.out.println(rear.value);
            rear.next=null;
        }
        disp();
    }
    public static void del(){
        if (f!=r){
            f++;
            front=front.next;
        }
        disp();
    }
    public static void disp(){
        node it=front;
        while(it!=null){
            System.out.print(it.value+" ");
            it=it.next;
        }
        System.out.println();
    }
    public static void main(String[] args)throws IOException{
        front=null;
        rear=null;
        Reader.init(System.in);
        max=Reader.nextInt();
        int ch=Reader.nextInt();
        int v;
        while(ch!=4){
            if (ch==1){
                v=Reader.nextInt();
                add(v);
            }
            if (ch==2){
                del();
            }
            ch=Reader.nextInt();
        }
    }
}