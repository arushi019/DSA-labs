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
class coach implements Comparable<coach>{
    int index;
    int day;
    int lec;
    int sad;
    public coach(int index,int day,int lec,int sad){
        this.index=index;
        this.day=day;
        this.lec=lec;
        this.sad=sad;
    }
    public int compareTo(coach c){
        return this.sad-c.sad;
    }
}
class ipctrainer2{
    public static int n;
    public static int d;
    public static int count;
    //public static coach[] c;
    public static coach[] heap;
    public static void ins(coach a,int pt){
        if (pt==0){
            heap[1]=a;
        }
        else if (pt==1){
            heap[2]=a;
            if (heap[2].sad>heap[1].sad){
                coach temp=heap[2];
                heap[2]=heap[1];
                heap[1]=temp;
            }
        }
        else{
            heap[pt+1]=a;
            int par=(pt+1)/2;
            int chd=pt+1;
            while(par>=1){
                System.out.println(par+" "+chd);
                if (heap[par].sad<heap[chd].sad){
                    coach temp=heap[par];
                    heap[par]=heap[chd];
                    heap[chd]=temp;
                }
                else break;
                chd=par;
                par=chd/2;
            }
        }
        /*for (int i=1;i<=pt+1;i++){
                System.out.println(heap[i].sad+" "+heap[i].lec+" "+heap[i].day);
            }*/
    }
    public static coach getmax(){
        coach tem=heap[1];
        heap[1]=heap[count];
        int node=1;
        count--;
        while(node<count+1){
            if ((count>=node*2-1)&&(heap[node].sad<heap[node*2].sad)){
                coach temp=heap[node];
                heap[node]=heap[node*2];
                heap[node*2]=temp;
                node=2*node;
                continue;
            }
            else if ((count>=node*2)&&(heap[node].sad<heap[node*2+1].sad)){
                coach temp=heap[node];
                heap[node]=heap[node*2+1];
                heap[node*2+1]=temp;
                node=2*node+1;
                continue;
            }
            else break;
        }

        return tem;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            d=Reader.nextInt();
            //c=new coach[n];
            heap=new coach[n+1];
            long pro=0;
            count=n;
            for (int i=0;i<n;i++){
                int t1=Reader.nextInt();
                int t2=Reader.nextInt();
                int t3=Reader.nextInt();
                pro+=(long)t2*(long)t3;
                coach temp=new coach(i,t1,t2,t3);
                ins(temp,i);
            }
            for (int i=1;i<n+1;i++){
                System.out.println(heap[i].sad+" "+heap[i].lec+" "+heap[i].day);
            }
            for (int i=0;i<n;i++){
                coach temp=getmax();
                int ch=Reader.nextInt();
                System.out.println(temp.sad);
                for (int j=1;j<=count+1;j++){
                System.out.println(heap[j].sad+" "+heap[j].lec+" "+heap[j].day);
            }
            }

        }
    }
}