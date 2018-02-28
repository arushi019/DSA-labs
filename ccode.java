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
class ccode{
    public static double pro1;
    public static double pro2;
    public static void product(double[] t,int flag){
        double pro=1;
        for (int i=0;i<t.length;i++)pro=pro*t[i];
        if (flag==1)pro1=pro;
        if (flag==2)pro2=pro;
    }
    public static double pro(double[] t,int pt){
        double pr=1;
        for (int i=0;i<pt;i++)pr=pr*t[i];
        return pr;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        double k=Reader.nextDouble();
        double[] t=new double[n];
        for (int i=0;i<n;i++)t[i]=Reader.nextDouble();
        Arrays.sort(t);
        double[] t1=new double[n/2];
        double[] t2=new double[n-n/2];
        for (int i=0;i<n/2;i++)t1[i]=t[i];
        for (int i=0;i<n-n/2;i++)t2[i]=t[n/2+i];
        product(t1,1);
        product(t2,2);
        int flag=0;
        //System.out.println(pro1+" "+pro2);
        if (pro1>k){
            for (int i=0;i<n/2;i++){
                if (pro(t1,i)>k){
                    flag=i;
                    break;
                }
            }
            System.out.println("flag1 "+flag);
            System.out.println((long)(Math.pow(2,flag)-1));
        }
        else{
            double c=k/pro1;
            for (int i=0;i<n-n/2;i++){
                //System.out.println(pro(t2,i));
                if (pro(t2,i)>c){
                    flag=i;
                    break;
                }
            }
            System.out.println("flag2 "+flag);
            System.out.println((long)(Math.pow(2,flag+n/2-1)-1));
        }
    }
}