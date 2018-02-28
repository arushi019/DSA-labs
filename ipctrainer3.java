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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class node{
    int day;
    int lec;
    int sad;
    public node(int day,int lec,int sad){
        this.day=day;
        this.lec=lec;
        this.sad=sad;
    }
}
class ipctrainer3{
    public static int n,d,count;
    public static node[] c;
    public static node[] h;
    public static void ins(node pk,int ind){
        if (ind==0)c[1]=pk;
        else if (ind==1){
            c[2]=pk;
            if (c[2].sad>c[1].sad){
                node temp=c[2];
                c[2]=c[1];
                c[1]=temp;
            }
        }
        else{
            int chd=ind+1;
            int par=chd/2;
            c[chd]=pk;
            while(par>=1){
                if (c[chd].sad>c[par].sad){
                    node temp=c[chd];
                    c[chd]=c[par];
                    c[par]=temp;
                }
                else break;
                chd=par;
                par=chd/2;
            }
        }
        //for (int i=1;i<=ind+1;i++)System.out.println(c[i].sad+" "+c[i].day);
        count++;
    }
    public static node getmax(){
        node temp=c[1];
        c[1]=c[count];
        count--;
        //sink down you douchebag
        int par=1;
        while(par<=count){
            if (par*2+1<=count){
                if ((c[par].sad<c[par*2].sad)||(c[par].sad<c[par*2+1].sad)){
                    int anc=c[par*2].sad>c[par*2+1].sad?par*2:par*2+1;
                    node tem=c[anc];
                    c[anc]=c[par];
                    c[par]=tem;
                    par=anc;
                }
                else break;
            }
            else if (par*2<=count){
                if (c[par].sad<c[par*2].sad){
                node tem=c[par];
                c[par]=c[par*2];
                c[par*2]=tem;
                par=par*2;
                }
                else break;
            }
            else break;
        }
        //for (int i=1;i<=count;i++)System.out.println(c[i].sad+" "+c[i].day);
        return temp;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            d=Reader.nextInt();
            c=new node[n+1];
            h=new node[n];
            count=0;
            long pro=0;
            for (int i=0;i<n;i++){
                int di=Reader.nextInt();
                int ti=Reader.nextInt();
                int si=Reader.nextInt();
                pro+=((long)ti*(long)si);
                node temp=new node(di,ti,si);
                h[i]=temp;
            }
            /*for(int i=0;i<n;i++){
                int ch=Reader.nextInt();
                node tem=getmax();
                //System.out.println(tem.sad+" "+tem.day);
            }*/
            Arrays.sort(h,new Comparator<node>(){
            @Override
            public int compare(node a,node b){
                return Integer.compare(a.day,b.day);
            }
            });
            long tank=0;
            //boolean[] sch=new boolean[d+1];
            int ct=1;
            int pt=0;
            while((count>=0)&&(ct<=d)){
                while((pt<n)&&(h[pt].day==ct)){
                    ins(h[pt],count);
                    System.out.println(count);
                    pt++;
                }
                System.out.println()
                if ((pt>0)&&(h[pt-1].day!=ct)){
                    ct++;
                    continue;
                }           
                node temp=getmax();
                System.out.println(temp.sad);
                tank+=(long)temp.sad;
                temp.lec--;
                if (temp.lec!=0)ins(temp,count);
                
                //for (int i=0;i<d+1;i++)System.out.println(sch[i]);
                ct++;
            }
            System.out.println(pro-tank);
        }
    }
}