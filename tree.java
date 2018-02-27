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
    int val;
    node left;
    node right;
    public node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class tree{
    node root;
    public static void disp(node n){
        if (n!=null){System.out.println(n.val);
        //else System.out.println("over");
        disp(n.left);
        disp(n.right);}
    }
    public static boolean search(int key,node n){
        //recursive method
        if (n!=null){
        if (n.val==key)return true;
        else {
            if (key>n.val)return(search(key,n.right));
            else if(key<n.val)return(search(key,n.left));
        }
    }
    return false;
        //iterative method
        /*while (n!=null){
        if (key==n.val){return true;}
        else{
            if (n.val>key)n=n.left;
            else if (n.val<key)n=n.right;
        }
    }
    return false;*/
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int ch,roo,rt,lt;
        tree t=new tree();
        System.out.println("Enter values of root, right and left");
        roo=Reader.nextInt();
        rt=Reader.nextInt();
        lt=Reader.nextInt();
        t.root=new node(roo);
        t.root.right=new node(rt);
        t.root.left=new node(lt);
        System.out.println("What do you want to do?");
        System.out.println("1.Display");
        System.out.println("2.Search");
        System.out.println("3.Insert");
        System.out.println("4.Delete");
        ch=Reader.nextInt();
        if (ch==1)disp(t.root);
        if (ch==2){
            int v;
            System.out.println("Enter value to be searched");
            v=Reader.nextInt();
            System.out.println(search(v,t.root));
        }
    }   
}