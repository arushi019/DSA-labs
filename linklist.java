import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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
 class linklistnode{
    public String st=new String();
    public linklistnode next;
    public linklistnode(String st,linklistnode next){
        this.st=st;
        this.next=next;
    }
}
public class linklist{
    public static void main(String[] args) throws IOException{
        int m,q,p;
        int i,chc,j;
        String v=new String();
        String s1=new String();
        Reader.init(System.in);
        //m=number of nodes in linked list
        //q=number of queries
        m=Reader.nextInt();
        q=Reader.nextInt();
        //linklistnode next=null;
        linklistnode n1=null,n2=null;
        linklistnode head=new linklistnode("",null);
        //take the initial linked list as input
        for (i=0;i<m;i++){
            s1=Reader.next();
            n1=new linklistnode(s1,n1);
            n1.next=n1;
            if (i==0)head=n1;
            //System.out.println("-->"+n1.next);
            if (i==(m-1))n1.next=null;
            System.out.println(n1.st+"-->"+n1.next);
        }
        //System.out.println(head.st+"-->"+head.next+"-->"+n1.st+"-->"+n1.next);
        for (i=0;i<q;i++){
            chc=Reader.nextInt();
            if (chc==1){
                v=Reader.next();
                p=Reader.nextInt();
                if (p<=(m+1)){
                    n2=head.next;
                    //System.out.println(n1.st+"--->"+n1.next);
                    for (j=0;j<p;j++){
                    n2=n2.next.next;
                    System.out.println(n2.st+"<-->"+n2.next);
                }
                }
            }
        }

    }
}