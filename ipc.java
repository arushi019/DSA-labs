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
class ipc{
    public static int n,d;
    public static node[] heap;
    public static int count;
    public static HashMap<Integer,ArrayList<node>> mapp;
    public static void ins(node it){
        if (count==0){
            heap[1]=it;
        }
        else if (count==1){
            heap[2]=it;
            if (heap[2].sad>heap[1].sad){
                node temp=heap[2];
                heap[2]=heap[1];
                heap[1]=temp;
            }
        }
        else{
            int chd=count+1;
            int par=chd/2;
            heap[chd]=it;
            while(chd>1){
                if (heap[chd].sad>heap[par].sad){
                    node temp=heap[chd];
                    heap[chd]=heap[par];
                    heap[par]=temp;
                }
                else break;
                chd=par;
                par=par/2;
            }
        }
        count++;
        //count now points to last index where there is valid node
    }
    public static node getmax(){
        node it=heap[1];
        heap[1]=heap[count];
        count--;
        //count points to last valid node index
        int pt=1;
        while(pt<=count){
            if (pt*2+1<=count){
                int anc=heap[pt*2].sad>heap[pt*2+1].sad?pt*2:pt*2+1;
                if (heap[pt].sad<heap[anc].sad){
                node temp=heap[anc];
                heap[anc]=heap[pt];
                heap[pt]=temp;
                pt=anc;
                }
                else break;
            }
            else if (pt*2<=count){
                if (heap[pt].sad<heap[pt*2].sad){
                    node temp=heap[pt];
                    heap[pt]=heap[pt*2];
                    heap[pt*2]=temp;
                }
                else break;
            }
            else break;
        }
        return it;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            d=Reader.nextInt();
            long pro=0;
            heap=new node[n+1];
            mapp=new HashMap<Integer,ArrayList<node>>();
            heap[0]=new node(0,0,0);
            for (int i=0;i<n;i++){
                int t1=Reader.nextInt();
                int t2=Reader.nextInt();
                int t3=Reader.nextInt();
                pro+=(long)t2*(long)t3;
                node temp=new node(t1,t2,t3);
                if (mapp.containsKey(t1)==false){
                    ArrayList<node> tem=new ArrayList<node>();
                    tem.add(temp);
                    mapp.put(t1,tem);
                }
                else{
                    ArrayList<node> tem=mapp.get(t1);
                    tem.add(temp);
                    mapp.put(t1,tem);
                }
            }
            int ct=1;
            count=0;
            long tank=0;
            while(ct<=d){
                if ((mapp.containsKey(ct)==false)&&(count==0)){
                    ct++;
                    continue;
                }
                else{
                    if (mapp.containsKey(ct)){ArrayList<node> temp=mapp.get(ct);
                    for (int i=0;i<temp.size();i++){
                        ins(temp.get(i));
                    }
                    }
                    node gr=getmax();
                    tank+=(long)gr.sad;
                    //System.out.println(ct+" "+gr.sad);
                    gr.lec--;
                    if (gr.lec!=0)ins(gr);
                    ct++;
                }
            }
            System.out.println(pro-tank);
        }
    }
}