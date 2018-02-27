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
import java.awt.Point;
 

 
 
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
class SNSOCIAL{
    public static boolean all_equal(int[][] a,int n,int m){
        int i,j;
        int prev=a[0][0];
        for (i=0;i<n;i++){
            for(j=0;j<m;j++){
                if (a[i][j]!=prev)return false;
            }
        }
        return true;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int i,j;
        while(t-->0){
            int n=Reader.nextInt();
            int m=Reader.nextInt();
            int[][] a=new int[n][m];
            for (i=0;i<n;i++){
                for (j=0;j<m;j++){
                    a[i][j]=Reader.nextInt();
                }
            }
            int ct=0;
            while(all_equal(a,n,m)==false){
                int[][] tem=new int[n][m];
                for (i=0;i<n;i++){
                    for (j=0;j<m;j++){
                        tem[i][j]=a[i][j];
                        ArrayList<Integer> temp=new ArrayList<Integer>();
                        if (i+1<n){
                            if (j+1<m)temp.add(a[i+1][j+1]);
                            temp.add(a[i+1][j]);
                            if (j-1>=0)temp.add(a[i+1][j-1]);
                        }
                        if (j+1<m)temp.add(a[i][j+1]);
                        if (j-1>=0)temp.add(a[i][j-1]);
                        if (i-1>=0){
                            if (j+1<m)temp.add(a[i-1][j+1]);
                            temp.add(a[i-1][j]);
                            if (j-1>=0)temp.add(a[i-1][j-1]);
                        }
                        //System.out.println(i+" "+j);
                        //System.out.println(temp);
                        Collections.sort(temp);
                        tem[i][j]=temp.get(temp.size()-1);
                        /*int v=temp.get(temp.size()-1);
                        if (v>a[i][j]){
                            Point p=new Point(i,j);
                            h.put(p,v);
                        }*/
                    }
                }
                ct++;
                a=tem;
                /*Set set=h.entrySet();
                Iterator it=set.iterator();
                while(it.hasNext()){
                    Map.Entry me=(Map.Entry)it.next();
                    Point p1=(Point)me.getKey();
                    Integer t1=(int)me.getValue();
                    a[(int)p1.getX()][(int)p1.getY()]=t1;
                    //h.remove(me.getKey());
                }
                //System.out.println("hour= "+ct);*/
            /*for (i=0;i<n;i++){
                for (j=0;j<m;j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }*/    
            }
            System.out.println(ct);
        }
    }
}