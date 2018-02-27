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
class voter3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        int n2=Reader.nextInt();
        int n3=Reader.nextInt();
        int[] a1=new int[n1];
        int[] a2=new int[n2];
        int[] a3=new int[n3];
        int p1=0;
        int p2=0;
        int p3=0;
        int i=0;
        while(i<n1){
            a1[i]=Reader.nextInt();
            i++;
        }
        i=0;
        while(i<n2){
            a2[i]=Reader.nextInt();
            i++;
        }
        i=0;
        while(i<n3){
            a3[i]=Reader.nextInt();
            i++;
        }
        ArrayList<Integer> a=new ArrayList<Integer>();
        while((p1<n1)||(p2<n2)||(p3<n3)){
            int i1=Integer.MAX_VALUE;
            int i2=Integer.MAX_VALUE;
            int i3=Integer.MAX_VALUE;
            if (p1<n1)i1=a1[p1];
            if (p2<n2)i2=a2[p2];
            if (p3<n3)i3=a3[p3];
            int min,ct=0;
            if ((i1<=i2)&&(i1<=i3))min=i1;
            else if ((i2<=i3)&&(i2<=i1))min=i2;
            else min=i3;
            if (min==i1){ct++;p1++;}
            if (min==i2){ct++;p2++;}
            if (min==i3){ct++;p3++;}
            if (ct>=2)a.add(min);
        }
        System.out.println(a.size());
        i=0;
        while(i<a.size()){
            System.out.println(a.get(i));
            i++;
        }
    }
}