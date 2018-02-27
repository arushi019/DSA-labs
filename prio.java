import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;

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
public class prio{
    static int[] a;
    static int m;
    static int pt;
    public static void form(int val,int ptr){
        int par,pos;
        if(ptr<=m){
            a[ptr]=val;
            par=ptr/2;
            pos=ptr;
            while(val>a[par]){
                //par=ptr/2;
                //pos=ptr;
                System.out.println(par+" "+pos);
                int temp=a[par];
                a[par]=a[pos];
                a[pos]=temp;
                pos=par;
                par=par/2;
                //disp();
            }
        }
    }
    public static int rem(){
        int pos,chd;
        int temp=a[1];
        a[1]=a[pt];
        a[pt]=temp;
        int t2=a[pt];
        pt--;
        pos=1;
        chd=(a[2]>a[3])?2:3;
        while((chd<=pt)&&(pos<=pt)&&(a[pos]<a[chd])){
            int t1=a[pos];
            a[pos]=a[chd];
            a[chd]=t1;
            System.out.println(pos+" "+chd);
            pos=chd;
            if ((2*pos+1)<=pt)
            chd=(a[2*pos]>a[2*pos+1])?2*pos:2*pos+1;
            else chd=2*pos;
        }
        disp();
        return t2;
    }
    public static void disp(){
        for(int i=1;i<=m;i++)System.out.print(a[i]+" ");
        System.out.println();
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        int n2=Reader.nextInt();
        m=n1*n2;
        pt=m;
        int i=1;
        int temp;
        a=new int[m+1];
        while(i<=m){
            temp=Reader.nextInt();
            if (i==1){
                a[1]=temp;
            }
            else{
                form(temp,i);
            }
            //disp();
            i++;
        }
        disp();
        //System.out.println(rem());
    }
}