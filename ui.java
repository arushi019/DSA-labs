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
class ui{
    public static int n;
    public static double k;
    public static double ct;
    public static ArrayList<Integer> d;
      public static void rec(boolean[] b,double[] a,int pt,double pro){
        //System.out.print(pro+" ");
        //if (pro>k)ct++;
        if (pt<n){
        if (pro>k)ct++;
        boolean[] b1=new boolean[n];
        //boolean[] b2=new boolean[n];
        int i=0;
        while(i<pt){
            b1[i]=b[i];
            //b2[i]=b[i];
            i++;
        }
        b1[pt]=true;
        //b2[pt]=false;
        rec(b1,a,pt+1,pro*a[pt]);
        rec(b,a,pt+1,pro);
    }
    }
    /*public static void rec(boolean[] b,double[] a,int pt,double pro){
        if (pt<n){
        int j=0;
        int temp=0;
        if (pro>k)ct++;
        System.out.print(pro+" ");
        while(j<n){
            if (b[j]==true)temp+=(int)Math.pow(2,j);
            j++;
        }
        //if (d.contains(temp)==false){ 
            //d.add(temp);
            //System.out.println("c1");
            //System.out.println(d);
            rec(b,a,pt+1,pro);
        
        int t=temp+(int)Math.pow(2,pt);
        //if (d.contains(t)==false){
            boolean[] b1=new boolean[n];
            //temp+=Math.pow(2,pt);
            //if (d.contains(t)==false){
            //System.out.println("c2");
            //d.add(t);
            //System.out.println(d);
            int i=0;
            while(i<pt){
                b1[i]=b[i];
                i++;
            }
            b1[pt]=true;
            rec(b1,a,pt+1,pro*a[pt]);
        //}
        }
        /*System.out.println(pro+" ");
        int j=0;
        int temp=0;
        while(j<n){
            System.out.print(b[j]+" ");
            if (b[j]==true)temp+=(int)Math.pow(2,j);
            j++;
        }
        System.out.println();
        if (d.contains(temp)==false){
        if (pro>k)ct++;
        if (pt<n){
        boolean[] b1=new boolean[n];
        boolean[] b2=new boolean[n];
        int i=0;
        int temp=0;
        while(i<pt){
            b1[i]=b[i];
            b2[i]=b[i];
            if(b[i]==true)temp+=(int)Math.pow(2,i);
            i++;
        }
        d.add(temp);
        b1[pt]=true;
        b2[pt]=false;
        rec(b2,a,pt+1,pro);
        int t=temp+(int)Math.pow(2,pt);
        if(d.contains(t)==false)rec(b1,a,pt+1,pro*a[pt]);
    }}
    }*/
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        k=Reader.nextDouble();
        double[] a=new double[n];
        d=new ArrayList<Integer>();
        int i=0;
        while(i<n){
            a[i]=Reader.nextDouble();
            i++;
        }
        ct=0;
        boolean[] b=new boolean[n];
        rec(b,a,0,1);
        System.out.println(ct);
    }
}
//1000000000000000000