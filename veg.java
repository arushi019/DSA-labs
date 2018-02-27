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
    int prio;
    node left;
    node right;
    node(int value){
        this.value=value;
        this.prio=0;
        this.left=null;
        this.right=null;
    }
}
public class veg{
    public static void ins(int val,int[] a,int n,int cur){
        int pos,parent;
        if (cur<=n){
        cur++;
        pos=cur;
        a[cur]=val;
        parent=pos/2;
        while(val<a[parent]){
            parent=pos/2;
            System.out.println(a[pos]+" "+a[parent]);
            int temp=a[parent];
            a[parent]=a[pos];
            a[pos]=temp;
            pos=parent;
        }
    }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int[] a;
        int t=Reader.nextInt();
        int n;
        //int i;
        while(t-->0){
            n=Reader.nextInt();
            a=new int[n+1];
            a[1]=Reader.nextInt();
            for (int i=2;i<=n;i++){
                int temp=Reader.nextInt();
                ins(temp,a,n,i-1);
            
            for (int j=1;j<=n;j++)
                System.out.print(a[j]+" ");
            System.out.println("");
            }
        }
    }
}