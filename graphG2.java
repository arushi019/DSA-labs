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
class ed{
    int e1;
    int e2;
    int wt;
    int ind;
    public ed(int e1,int e2,int wt,int ind){
        this.e1=e1;
        this.e2=e2;
        this.wt=wt;
        this.ind=ind;
    }
}
class graphG2{
    public static int n;
    public static int m;
    public static int[] des;
    public static int ufind(int ind){
        if (des[ind]==ind)return ind;
        else return des[ind]=ufind(des[ind]);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        m=Reader.nextInt();
        des=new int[n];
        int i=0;
        while(i<n){
            des[i]=i;
            i++;
        }
        //color=new int[n+1];
        ed[] line=new ed[m];
        for (i=0;i<m;i++){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            x--;
            y--;
            int wt=Reader.nextInt();
            line[i]=new ed(x,y,wt,i);
        }
        Arrays.sort(line,new Comparator<ed>(){
            @Override
            public int compare(ed a,ed b){
                return Integer.compare(a.wt,b.wt);
            }
        });
        /*for (int i=0;i<m;i++){
            System.out.println(e1[i]+" "+e2[i]);
        }*/
        i=0;
        int flag=0;
        while(i<m){
            int j;
            j=i;
            while((j<m)&&(line[j].wt==line[i].wt))j++;
            int k=i;
            while (k<j){
                if (ufind(line[k].e1)==ufind(line[k].e2))flag++;
                k++;
            }
            k=i;
            while(k<j){
                if (ufind(line[k].e1)!=ufind(line[k].e2))des[des[line[k].e1]]=des[line[k].e2];
                k++;
            }
            i=j;
        }
        System.out.println(flag);
    }
}