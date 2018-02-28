import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.Point;
import java.text.DecimalFormat;
 

 
 
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
class cloneme2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int q=Reader.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++)arr[i]=Reader.nextInt();
            for (int i=0;i<q;i++){
                int a=Reader.nextInt();
                int b=Reader.nextInt();
                int c=Reader.nextInt();
                int d=Reader.nextInt();
                TreeSet<Integer> t1=new TreeSet<Integer>();
                TreeSet<Integer> t2=new TreeSet<Integer>();
                for (int j=a-1;j<b;j++)t1.add(arr[j]);
                for (int j=c-1;j<d;j++)t2.add(arr[j]);
                Iterator it1=t1.iterator();
                Iterator it2=t2.iterator();
                int ct=0;
                int flag=0;
                System.out.println(t1);
                System.out.println(t2);
                while((it1.hasNext())&&(it2.hasNext())){
                    int n1=(Integer)it1.next();
                    int n2=(Integer)it2.next();
                    if (n1!=n2){
                        ct++;
                        if (ct==2){break;}
                    }
                }
                if (ct>1)System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }
}