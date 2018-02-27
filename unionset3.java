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
class unionset3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            int ct=0;
            HashMap<HashSet<Integer>,Integer> h=new HashMap<HashSet<Integer>,Integer>();
            for (int i=0;i<n;i++){
                int len=Reader.nextInt();
                int[] temp=new int[k];
                ArrayList<Integer> has=new ArrayList<Integer>();
                HashSet<Integer> wants=new HashSet<Integer>();
                for (int j=0;j<len;j++){
                    int tt=Reader.nextInt();
                    temp[tt-1]=1;
                }
                for (int j=0;j<k;j++){
                    if (temp[j]==1){
                        has.add(j+1);
                        wants.add(j+1);}
                    //else wants.add(j+1);
                }
                Set set=h.entrySet();
                Iterator it=set.iterator();
                while(it.hasNext()){
                    Map.Entry me=(Map.Entry)it.next();
                    HashSet<Integer> tt1=(HashSet)me.getKey();
                    if ((tt1.size()+has.size())>=k){
                        //System.out.println(has);
                        //System.out.println(tt1);
                        int t_ct=0;
                        for (int j=0;j<has.size();j++){
                            if (tt1.contains(has.get(j)))t_ct++;
                        }
                        if ((tt1.size()+has.size()-t_ct)==k){
                            //System.out.println(tt1);
                            ct+=h.get(tt1);}
                    }
                }
                if (h.containsKey(wants)==false)h.put(wants,1);
                else{
                    int tt=h.get(wants);
                    tt++;
                    h.put(wants,tt);
                }
                //System.out.println(has);
                //System.out.println(wants);

            }
            System.out.println(ct);
        }
    }
}