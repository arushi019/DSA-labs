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
class ipctrainer{
    public static int n;
    public static int d;
    public static coach[] c;
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            d=Reader.nextInt();
            c=new coach[n];
            long pro=0;
            PriorityQueue<coach> queue=new PriorityQueue<coach>(n);
            for (int i=0;i<n;i++){
                int t1=Reader.nextInt();
                int t2=Reader.nextInt();
                int t3=Reader.nextInt();
                pro+=(long)((long)t3*(long)t2);
                c[i]=new coach(i,t1,t2,t3);
            }
            Arrays.sort(c,new Comparator<coach>(){
            @Override
            public int compare(coach a,coach b){
                return Integer.compare(a.sad,b.sad);
            }
        });
            for (int i=n-1;i>=0;i--){
                queue.add(c[i]);
            }
            long tank=0;
            int i=1;
            while((i<=d)&&(queue.size()!=0)){
                coach temp=queue.peek();
                System.out.println(temp.sad+" "+temp.lec+" "+temp.day);
                if ((temp.lec!=0)&&(temp.day<=i)){
                    int dstay=n-temp.day+1;
                    System.out.println(dstay+" "+temp.lec);
                    if ((temp.lec<dstay)&&(i+temp.lec<=d+1)){
                        tank+=(long)temp.lec*(long)temp.sad;
                        temp.lec=0;
                        i+=temp.lec;
                    }
                    else if (i+dstay<=d+1){
                        tank+=(long)dstay*(long)temp.sad;
                        temp.lec-=dstay;
                        temp.day=-1;
                        i+=dstay;
                    }
                    else{
                        tank+=(long)temp.sad*(long)(n-i+1);
                        i=d+1;
                    }
                }else{
                    queue.remove(temp);
                }
                while((temp.lec==0)||(temp.day==-1)){
                    queue.remove(temp);
                    if (queue.size()!=0)temp=queue.peek();
                    else break;
                }
            }
            /*int pt=n-1;
            for (int i=1;i<=d;i++){
                int it=pt;
                while(it>=0){
                    if ((c[it].day<=i)&&(c[it].lec!=0)){
                        tank+=c[it].sad;
                        c[it].lec--;
                        break;
                    }
                    else it--;
                }
                it=pt;
                while((it>=0)&&(c[it].lec==0)){pt--;it--;}
                //System.out.println(tank);
            }*/
            /*int dy=0;
            for (int i=n-1;i>=0;i--){
                if (dy<d){
                    int dys=d-c[i].day+1;
                    int l=c[i].lec;
                    if (l>dys){
                        if (dys+dy<d){
                        dy+=dys;
                        tank+=(long)((long)c[i].sad*(long)dys);}
                        else{
                            tank+=(long)((long)c[i].sad*(long)(d-dy));
                            dy=d;
                        }
                    }
                    else{
                        if (dy+l<d){
                        dy+=l;
                        tank+=(long)((long)c[i].lec*(long)c[i].sad);}
                        else{
                            tank+=(long)((long)c[i].sad*(d-dy));
                            dy=d;
                        }
                    }
                }
                else{
                    break;
                }
            }*/

            System.out.println(pro-tank);
        }
    }
}