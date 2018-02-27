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
class perm{
    public static boolean[] visit;
    public static String cycle(int pos,int[] a){
        String s=new String();
        //System.out.print((pos+1)+" ");
        s=s+(pos+1)+" ";
        int i=a[pos]-1;
        while(a[i]!=a[pos]){
            visit[i]=true;
            //System.out.print((i+1)+" ");
            s=s+(i+1)+" ";
            i=a[i]-1;
        }
        //System.out.print((pos+1)+" ");
        s=s+(pos+1)+" ";
        return s;
        //System.out.println();
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n]; 
        visit=new boolean[n];
        int i=0;
        int start=0;
        while(i<n){
            a[i]=Reader.nextInt();
            if (a[i]==1)start=i;
            i++;
        }
        i=0;
        int cnt=0;
        String[] st=new String[n];
        while(i<n){
            //System.out.print(cnt+'\r');
            if (visit[i]==false){
            cnt++;
            //System.out.print('\r');
            //System.out.print(cnt+" ");
            st[cnt-1]=cycle(i,a);
            //System.out.println();
        }
            i++;
        }
        i=0;
        System.out.println(cnt);
        while(i<cnt){
            System.out.println(st[i]);
            i++;
        }
        //two cycles are distinct in the sense that an element can belong
        //to only one cycle at a time
        

        /*i=0;
        int start=0;
        int it=start;
        while(i<n){
            if (visit[i]==false){
                visit[i]=true;
                start=a[i];
                it=a[a[i]];
            }
        }*/

    }
}