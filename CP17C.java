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
class CP17C{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] h=new int[n];
        int[] ng=new int[n];
        for (int i=0;i<n;i++)h[i]=Reader.nextInt();
        Stack s=new Stack();
        s.push(new Integer(0));
        for (int i=1;i<n;i++){
            int next=i;
            if (s.empty()==false){
                Integer temp=(Integer)s.pop();
                while(h[temp]<h[next]){
                    ng[temp]=next;
                    if (s.empty()==true)break;
                    temp=(Integer)s.pop();
                }
                if (h[temp]>=h[next]){
                    s.push(new Integer(temp));
                }
            }
            s.push(new Integer(next));
        }
        while(s.empty()==false){
            Integer temp=(Integer)s.pop();
            ng[temp]=-1;
        }
        //for (int i=0;i<n;i++)System.out.print(ng[i]+" ");
        int[] nsm=new int[n];
        int min=h[n-1];
        for (int i=n-1;i>=0;i--){
            if (h[i]<min)min=h[i];
            nsm[i]=min;
        }
        int sum=0;
        for (int i=0;i<n;i++){
            if (ng[i]==-1)sum+=15;
            else{
                if (h[ng[i]]==nsm[ng[i]])sum+=10;
                else sum+=5;
            }
        }
        System.out.println(sum);
    }
}