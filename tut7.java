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
    node left;
    node right;
    public node(int value){
        this.value=value;
    }
}
public class tut7{
    static node root;
    public static node ins(node root,int val){
        if (root==null){
            root=new node(val);
            return root;
        }
        else{
            if (val>root.value)root.right=ins(root.right,val);
            else if (val<root.value)root.left=ins(root.left,val);
        }
        return root;
    }
    public static void disp(node root){
        if (root!=null){
        System.out.print(root.value+" ");
        System.out.print("left ");
        disp(root.left);
        System.out.print("right ");
        disp(root.right);
    }
    }
    public static node create(int[] a){
        root=new node(a[0]);
        int i;
        for (i=1;i<a.length;i++){
            root=ins(root,a[i]);
    }
        //disp(root);
        return root;
        //System.out.println(counts(root));
    }
    public static int count(node root){
        if (root==null)return 0;
        if ((root.left==null)&&(root.right==null))return 1;
        else return count(root.left)+count(root.right);
    }   
    public static int countf(node root){
        if (root==null)return 0;
        if ((root.left!=null)&&(root.right!=null))return 1+countf(root.left)+countf(root.right);
        //else return countf(root.left)+countf(root.right);
        else if (root.left!=null)return countf(root.left);
        else return countf(root.right);
    }
    public static int counts(node root){
        if (root==null)return 0;
        if ((root.left==null)&&(root.right!=null))return 1+counts(root.right);
        else if ((root.left!=null)&&(root.right==null))return 1+counts(root.left);
        else return counts(root.right)+counts(root.left);
    }
    public static int sum(node root){
        if (root==null)return 0;
        else return root.value+sum(root.left)+sum(root.right);
    }
    public static boolean same(node root1, node root2){
        if ((root1!=null)&&(root2!=null)){
            if (root1.value!=root2.value)return false;
            else return (same(root1.left,root2.left)&&same(root1.right,root2.right));
        }
        else if ((root1==null)&&(root2==null))return true;
        else return false;

    }
    public static node dup(node root){
        if (root!=null){
            node r2=new node(root.value);
            r2.right=dup(root.right);
            r2.left=dup(root.left);
            return r2;
        }
        else return null;
    }
    public static void main(String[] args)throws IOException{
        int[] a={23,48,20,14,66,78,10,56,34};
        int[] b={1,2,23,10,14,20,5};
        disp(dup(create(a)));
    }
}