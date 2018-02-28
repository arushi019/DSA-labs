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
class cloneme3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
        int n,q;
        n=Reader.nextInt();
        q=Reader.nextInt();
        int[] a1=new int[100001];
        int[] a2=new int[n];
        for (int i=0;i<n;i++){
            int temp=Reader.nextInt();
            a2[i]=temp;
            a1[temp]++;
        }
        while(q-->0){
            int a=Reader.nextInt();
            int b=Reader.nextInt();
            int c=Reader.nextInt();
            int d=Reader.nextInt();
            HashSet<Integer> h=new HashSet<Integer>();
            HashSet<Integer> g=new HashSet<Integer>();
            for (int i=a-1;i<b;i++){
                h.add(a2[i]);
                g.add(a2[i]);
            }
            int ct=0;
            int flag=-1;
            int rank2=0;
            int rank1=0;
            for (int i=c-1;i<d;i++){
                if (h.contains(a2[i])==true){ct++;g.remove(a2[i]);}
                else{
                    if (flag==-1)flag=a2[i];
                }
            }
            for (int i=c-1;i<d;i++){
                if (a2[i]<=flag)rank2++;
            }
            //System.out.println(flag+" "+rank2);
            int emp=b-a+1;
            if (ct==emp)System.out.println("YES");
            else if ((emp-ct)>1)System.out.println("NO");
            else{
                    Iterator it=g.iterator();
                    int tem=(Integer)it.next();
                    for (int j=a-1;j<b;j++){
                        if (a2[j]<=tem)rank1++;
                    }
                    if (rank1==rank2)System.out.println("YES");
                    else System.out.println("NO");
                }
        }}
    }
}