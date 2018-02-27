import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.lang.*;
 

 
 
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
class unusual{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        ArrayList<Integer> h=new ArrayList<Integer>();
        ArrayList<Integer> k=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> s=new HashMap<Integer,ArrayList<Integer>>();
        int[] ng=new int[n];
        int[] nl=new int[n];
        for (int i=0;i<n;i++)h.add(Reader.nextInt());
        int min=h.get(n-1);
        int[] m=new int[n];
        for (int i=n-1;i>=0;i--){
            if (h.get(i)<min)min=h.get(i);
            m[i]=min;
        }
        long sum=0;
        int cmp=0;
        for (int i=0;i<n;i++)System.out.print(m[i]+" ");
        ArrayList<Integer> stack=new ArrayList<Integer>();
        stack.add(h.get(0));
        for (int i=1;i<n;i++){
            int next=h.get(i);
            System.out.println("next= "+next);
            if (stack.size()!=0){
                int temp=stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                while(temp<next){
                    System.out.println("temp= "+temp);
                    int flag=0;
                    for (int j=cmp;j<n;j++)if (h.get(j)==temp){flag=j;break;}
                    ng[flag]=next;
                    k.add(next);
                    cmp++;
                    if (stack.size()==0)break;
                    temp=stack.get(stack.size()-1);
                    stack.remove(stack.size()-1);
                    System.out.println(stack);
                }
                if (temp>next){
                    stack.add(temp);
                }
            }
            stack.add(next);
        }
        while(stack.size()!=0){
            int temp=stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            int next=-1;
            //ng[h.indexOf(temp)]=next;
            k.add(next);
        }
        sum+=15*stack.size();
    for (int i=0;i<n;i++)System.out.print(ng[i]+" ");
    System.out.println(k);

}
}