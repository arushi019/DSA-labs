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
public class circ_list{
    node head=new node(1);
    int len=1;
    //constructor to form circular list of nodes
    circ_list(int n1){
        int i;
        node prev=new node(2);
        this.head.next=prev;
        for (i=2;i<n1-1;i++){
            node nd=new node(i+1);
            prev.next=nd;
            prev=nd;
        }
        node last=new node(n1);
        prev.next=last;
        last.next=this.head;
        this.len+=n1-1;
    }
    public static void disp(int n1,circ_list c){
        //has the job of iterating over the circ_list and displaying values stored
        node it=c.head;
        node aage=it.next;
        int i;
        for (i=0;i<n1;i++){
            System.out.println(it.value+" "+aage.value);
            it=it.next;
            aage=aage.next;
        }

        System.out.println();
    }
    public static circ_list del(int n1,circ_list c){
        //why not pass the node??
        node it=c.head;
        if (n1==1)c.head=it.next;
        int i;
        for (i=1;i<n1-2;i++)it=it.next;
        node pre=it;
        node curr=it.next;
        //System.out.println(curr.value);
        node aage=curr.next;
        pre.next=aage;
        aage=aage.next;
        c.len--;
        disp(c.len+8,c);
        return c;
    }
    public static int game(int n1,circ_list c){
        node it=c.head;
        int temp=n1;
        node tem=it;
        while (c.len>1){
            tem=it;
            tem=tem.next;
            c=del(tem.value,c);
            temp--;
            //it=it.next;
            disp(temp,c);
            }
        return it.value;
    }
    public static void main(String[] args) throws IOException{
        //remember that each new node declared points to null
        int t,n;
        int q;
        Reader.init(System.in);
        t=Reader.nextInt();
        while (t-->0){
            n=Reader.nextInt();
            circ_list c1=new circ_list(n);
            disp(n,c1);
            //System.out.println(game(n,c1));
            //disp(n,c1);
            q=Reader.nextInt();
            del(q,c1);
            //disp(n+8,c1);
        }
    }
}