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
class ed{
    int e1;
    int e2;
    int wt;
    public ed(int e1,int e2,int wt){
        this.e1=e1;
        this.e2=e2;
        this.wt=wt;
    }
}
class ver{
    HashSet<Integer> nbr;
    int[] wt;
}
class graphB2{
    public static int n;
    public static int m;
    public static int bus;
    public static int bank;
    public static int g;
    public static int h;
    public static ver[] line;
    public static HashSet<Integer> buss;
    public static int[] dist;
    public static int mindis(boolean[] check){
        int min=1001;
        int mini=-1;
        for (int i=0;i<n;i++){
            if ((check[i]==false)&&(dist[i]<=min)){
                mini=i;
                min=dist[i];
            }
        }
        return mini;
    }
    public static void dijk(){
        boolean[] check=new boolean[n];
        int[] c=new int[n];
        for (int i=0;i<n;i++){
            dist[i]=1001;
            check[i]=false;
        }
        int flag=0;
        dist[bank]=0;
        for (int i=0;i<n;i++){
            int k=mindis(check);
            check[k]=true;
            int j=0;
            while(j<n){
                if ((check[j]==false)&&(line[k].wt[j]>0)&&(dist[k]!=1001)&&(dist[j]>dist[k]+line[k].wt[j])){ 
                    dist[j]=dist[k]+line[k].wt[j];
                    if ((check[g]==true)&&(check[h]==true))
                    if ((k==g)||(k==h))c[j]=k;
                }
                j++;
            }
            for(int it=0;it<n;it++){
                if (buss.contains(it)){
                    if ((c[it]!=g)||(c[it]!=h))buss.remove(it);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            m=Reader.nextInt();
            bus=Reader.nextInt();
            bank=Reader.nextInt();
            bank--;
            g=Reader.nextInt();
            g--;
            h=Reader.nextInt();
            h--;
            dist=new int[n];
            line=new ver[n];
            for(int i=0;i<n;i++){
                line[i]=new ver();
                line[i].nbr=new HashSet<Integer>();
                line[i].wt=new int[n];
            }
            for (int i=0;i<m;i++){
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                x--;
                y--;
                int temp=Reader.nextInt();
                line[x].nbr.add(y);
                line[x].wt[y]=temp;
                line[y].nbr.add(x);
                line[y].wt[x]=temp;
            }
            buss=new HashSet<Integer>();
            for (int i=0;i<bus;i++)buss.add(Reader.nextInt());
            dijk();
            //for (int i=0;i<n;i++)System.out.print(dist[i]+" ");
            Iterator it=buss.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+" ");
            }
            System.out.println();
        }
    }
}