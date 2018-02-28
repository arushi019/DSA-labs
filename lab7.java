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
class stack{
    int[] a=new int[4000];
    int top;
    public stack(){
        top=-1;
    }
    void push(int val){
        top++;
        a[top]=val;
    }
    int pop(){
        int temp=a[top];
        top--;
        return temp;
    }
}
public class stacktest{
    static stack a1,a2,s1;
    public static void add(){
        int i=(a1.top>=a2.top)?a1.top:a2.top;
        i=i+1;
        int t=i;
        int p1=a1.top;
        int p2=a2.top;
        while((p1>=0)&&(p2>=0)){
            int temp=a1[p1]+a2[p2];
            if (temp<10){
                s1[i]+=temp;
                p1--;
                p2--;
                i--;
            }
            else{
                s1[i]+=temp-10;
                s1[i-1]+=1;
                p1--;
                p2--;
                i--;
            }
        }
        for (int j=t;j>=0;j--)System.out.print(s1[j]);
    }
    public static void main(String[] args)throws IOException{
        a1=new stack();
        a2=new stack();
        s1=new stack();
        a1.push(4);
        a1.push(5);
        a2.push(3);
        a2.push(3);
        add();
    }
}