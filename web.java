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
    int[] link;
    node next;
    public node(int value){
        this.value=value;
        this.next=next;
    }
}
public class web{
    static node head;
    static int num;
    static int[] visited;
    static int[] stack;
    static int top;
    static int ctr;
    public static void form(){
        int i=2;
        head=new node(1);
        head.link=new int[num+1];
        node it=head;
        while(i<=num){
            it.next=new node(i);
            it=it.next;
            it.link=new int[num+1];
            i++;
        }
    }
    public static void display(){
        node it=head;
        while(it!=null){
            System.out.print(it.value+"  ");
            for (int i=0;i<num+1;i++)System.out.print(it.link[i]+" ");
            it=it.next;
            System.out.println();
        }
    }
    public static node srch(int val){
        int i=1;
        node it=head;
        while(i<val){
            it=it.next;
            i++;
        }
        return it;
    }
    public static void push(int val){
        if (top<num){
        stack[top]=val;
        top++;
        }
    }
    public static int pop(){
        int temp=-1;
        //for (int i=0;i<top;i++)System.out.print(stack[i]+" ");
        //System.out.println();
        if (top>=0){
            top--;
            temp=stack[top];
        }
        return temp;
    }
    public static boolean is_emp(){
        return (top==0);
    }
    public static boolean visit(){
        int i;
        boolean p=true;
        for (i=1;i<=num;i++){
            if (visited[i]==0){
                p=false;
                break;
            }
        }
        return p;
    } 
    public static boolean srch2(int val){
        int i;
        for (i=0;i<top;i++){
            if (stack[i]==val)break;
        }
        return (i<top);
    }
    public static int connected(int val){
        push(val);
        node p=srch(val);
        node p2;
        int ct=0;
        //ctr=0;
        int i,t;
        for (i=1;i<=num;i++){
            if (p.link[i]==1){
            push(i);
            ct++;
        }
        }
        /*for (i=0;i<top;i++){
            System.out.println(stack[i]+" ");
        }*/
        while(!is_emp()){
            t=pop();
            //System.out.println("popped value "+t);
            p2=srch(t);
            for (i=1;i<=num;i++){
                if ((p2.link[i]==1)&&(visited[i]==0)&&(!srch2(i))){
                    push(i);
                    //ctr++;
                    ct++;
                }
            }
            visited[t]=-1;
        }
        return ct+1;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int d=Reader.nextInt();
        int i=0,x,y;
        node t1,t2;
        num=n;
        visited=new int[num+1];
        stack=new int[num];
        top=0;
        ctr=0;
        form();
        //display();
        while(i<d){
            x=Reader.nextInt();
            y=Reader.nextInt();
            t1=srch(x);
            t1.link[y]=1;
            t2=srch(y);
            t2.link[x]=1;
            i++;
        }
        //display();
        int j=1;
        int[] v=new int[num];
        int k=0;
        while(!visit()){
            //System.out.println(j);
            if (visited[j]==0){
                //System.out.println("checking connected function...");
                v[k]=connected(j);
                k++;
                ctr++;
            }
            j++;
        }
        System.out.println(ctr);
        Arrays.sort(v);
        for (k=0;k<num;k++){
            if (v[k]!=0)System.out.print(v[k]+" ");
        }
    }
}