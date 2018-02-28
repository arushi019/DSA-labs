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
class graphA{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int e=Reader.nextInt();
        int[][] mat=new int[n][n];
        //HashMap<Integer,HashSet<Integer>> list=new HashMap<Integer,HashSet<Integer>>();
        /*for(int i=0;i<n;i++){
            HashSet<Integer> h=new HashSet<Integer>();
            //put buffer character if you cannot put empty hashset
            list.put(i,h);
        }*/
        for(int i=0;i<e;i++){
            int x=Reader.nextInt();
            x--;
            int y=Reader.nextInt();
            y--;
            mat[x][y]=1;
            mat[y][x]=1;
            //HashSet<Integer> temp=list.get(x);
            //temp.add(y);
            //list.put(x,temp);
            //temp=list.get(y);
            //temp.add(x);
            //list.put(y,temp);
        }
        HashSet<Integer> red=new HashSet<Integer>();
        HashSet<Integer> blue=new HashSet<Integer>();
        HashSet<Integer> visit=new HashSet<Integer>(); 
        HashSet<Integer> notvisit=new HashSet<Integer>();
        for (int i=0;i<n;i++)notvisit.add(i);
        ArrayList<Integer> queue=new ArrayList<Integer>();
        queue.add(0);
        visit.add(0);
        notvisit.remove(0);
        red.add(0);
        int ct=0;
        int flag=0;
        while(queue.size()!=0){
            int v=queue.get(0);
            queue.remove(0);
            for (int i=0;i<n;i++){
                if (mat[v][i]==1){
                    if (visit.contains(i)==false){
                        queue.add(i);
                        visit.add(i);
                        notvisit.remove(i);
                    }
                    if (red.contains(v)){
                            if (red.contains(i)==true){
                                flag=-1;
                                //System.out.println("red "+v+" "+i);
                            }
                            else blue.add(i);
                        }
                        else if (blue.contains(v)){
                            if (blue.contains(i)==true){
                                flag=-1;
                                //System.out.println("blue "+v+" "+i);
                            }
                            else red.add(i);
                        }
                }
            }
            //System.out.println(queue);
            //System.out.println(red);
            //System.out.println(blue);
        }
        int[] notv=new int[notvisit.size()];
        int t=0;
        Iterator it=notvisit.iterator();
        while(it.hasNext()){
            notv[t]=(Integer)it.next();
            //System.out.println(notv[t]);
            t++;
        }
        if ((notvisit.size()!=0)&&(flag==0)){
            t=0;
            while(t<notvisit.size()){
                int v=notv[t];
                //System.out.println(notv[t]);
                if (v!=-1){
                queue.add(v);
                visit.add(v);
                //notvisit.remove(v);
                notv[t]=-1;
                for(int j=0;j<notvisit.size();j++)System.out.println(notv[j]+" ");
                red.add(v);
                while(queue.size()!=0){
                    int ver=queue.get(0);
                    queue.remove(0);
                    for (int i=0;i<n;i++){
                        if (mat[ver][i]==1){
                            if (visit.contains(i)==false){
                                queue.add(i);
                                visit.add(i);
                                //notvisit.remove(i);
                                notv[t]=-1;
                            }
                            if (red.contains(ver)){
                                if (red.contains(i)==true)flag=-1;
                                else blue.add(i);
                            }
                            else if (blue.contains(ver)){
                                if (blue.contains(i)==true)flag=-1;
                                else red.add(i);
                            }
                        }
                    }
                }

            }
            t++;
        }
        }
        if (flag==-1)System.out.println(flag);
        else{
            System.out.println(red.size());
            for (int i=0;i<n;i++){
                if (red.contains(i))System.out.print((i+1)+" ");
            }
            System.out.println();
            System.out.println(blue.size());
            for (int i=0;i<n;i++){
                if (blue.contains(i))System.out.print((i+1)+" ");
            }
        }
    }
    
}