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
class graph{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        HashMap<String,Long> pt=new HashMap<String,Long>();
        HashMap<Integer,Long> x=new HashMap<Integer,Long>();
        HashMap<Integer,Long> y=new HashMap<Integer,Long>();
        for (int i=0;i<n;i++){
            int x1=Reader.nextInt();
            int y1=Reader.nextInt();
            Point p=new Point(x1,y1);
            String s=p.toString();
            if (pt.containsKey(s)){
                Long temp=pt.get(s);
                temp++;
                pt.put(s,temp);
            }
            else{
                long t=1;
                pt.put(s,t);
            }
            if (x.containsKey(x1)){
                Long temp=x.get(x1);
                temp++;
                x.put(x1,temp);
            }
            else{
                long t=1;
                x.put(x1,t);
            }
            if (y.containsKey(y1)){
                Long temp=y.get(y1);
                temp++;
                y.put(y1,temp);
            }
            else{
                long t=1;
                y.put(y1,t);
            }
        }
    long sum=0;
     Set set = y.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         //System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue());
         Long p=(long)me.getValue();
         long pro=(p)*(p-1)/2;
         sum+=pro;
      }
      set = x.entrySet();
      
      // Get an iterator
      i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         //System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue());
         Long p=(long)me.getValue();
         long pro=(p)*(p-1)/2;
         sum+=pro;
      }
      set = pt.entrySet();
      
      // Get an iterator
      i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         //System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue().getClass());
         Long p=(long)me.getValue();
         long pro=(p)*(p-1)/2;
         sum-=pro;
      }
      System.out.println(sum);
    }
}