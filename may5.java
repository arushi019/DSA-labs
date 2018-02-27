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
class may5{
    public static int ct;
    public static ArrayList<Double> d;
    public static void rec(boolean[] b,double[] a,double pro,int pt,double k,int n){
        int j=0;
        double sum=0;
        while(j<n){
            //System.out.print(b[j]+" ");
            if (b[j]==true)sum+=Math.pow(2,j);
            j++;
        }
        //System.out.println();
        if (d.contains(sum)==false){
            d.add(sum);
            //System.out.println(sum+" "+pro);
            if (pro>k)ct++;
        }
        //System.out.println();
        if (pt<n){
        //if (pt==n-1)System.out.println("yes");
        //if (pro<=k)ct++;
        int i;
        boolean[] b1=new boolean[n];
        /*while(i<n){
            System.out.print(b[i]+" ");
            i++;
        }
        System.out.println();*/
        i=0;
        while(i<pt){
            b1[i]=b[i];
            i++;
        }
        b1[pt]=true;
        /*System.out.println("b1 array");
        i=0;
        while(i<n){
            System.out.print(b1[i]+" ");
            i++;
        }
        System.out.println();*/
        rec(b,a,pro,pt+1,k,n);
        rec(b1,a,pro*a[pt],pt+1,k,n);
    }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        double k=Reader.nextDouble();
        double[] a=new double[n];
        d=new ArrayList<Double>();
        int i=0;
        while(i<n){
            a[i]=Reader.nextDouble();
            i++;
        }
        ct=0;
        boolean[] b=new boolean[n];
        rec(b,a,1,0,k,n);
        System.out.println((long)(Math.pow(2,n)-ct-1));
    }
}

