import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
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
class may4{
    public static int n,k,p;
    public static int[] a;
    public static ArrayList<Integer> d;
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        k=Reader.nextInt();
        p=Reader.nextInt();
        a=new int[n];
        d=new ArrayList<Integer>();
        /*int i=0;
        while(i<n){
            a[i]=-1;
            i++;
        }*/
        int i=0;
        int temp;
        //int pt=0;
        while(i<n){
            temp=Reader.nextInt();
            if (temp==1){
                d.add(i);
                //pt++;
            }
            i++;
        }
        /*i=0;
        while(i<n){
            System.out.print(a[i]+" ");
            i++;
        }*/
        //System.out.println(d);
        String s=Reader.next();
        i=0;
        while(i<p){
            if (s.charAt(i)=='!'){
                int j=0;
                int t=d.size();
                while(j<t){
                    temp=d.get(j);
                    temp=(temp+1)%n;
                    d.set(j,temp);
                    j++;
                }
                //Collections.sort(d);
                b++;
                e++;
                if (e==n){
                    
                }
                //System.out.println(d);
            }
            if (s.charAt(i)=='?'){
                int b=0;
                int e=b+k-1;
                int max=0;
                int t=d.size();
                while(b<n){
                    e=b+k-1;
                    if (e>=n)e=n-1;
                    temp=0;
                    int j=0;
                    while(j<t){
                        if ((d.get(j)>=b)&&(d.get(j)<=e))temp++;
                        else if (d.get(j)>e)break;
                        j++;
                    }
                    if (temp>max)max=temp;
                    b++;
                }
                System.out.println(max);
            }
            i++;
        }
    }
}
