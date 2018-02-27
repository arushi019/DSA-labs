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
class may6{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int i=0;
        String temp,s;
        ArrayList<String> u=new ArrayList<String>();
        ArrayList<String> b=new ArrayList<String>();
        while(i<n){
            s=Reader.next();
            temp=Reader.next();
            if (s.charAt(0)=='+')u.add(temp);
            else b.add(temp);
            i++;
        }
        //System.out.println(u);
        //System.out.println(b);
        Collections.sort(u);
        Collections.sort(b);
        i=0;
        ArrayList<String> g=new ArrayList<String>();
        int j;
        while(i<b.size()){
            //byte[] b1=b.get(i).getBytes("UTF-16");
            String b1=b.get(i);
            j=0;
            int max=0;
            while(j<u.size()){
                //byte[] b2=u.get(j).getBytes("UTF-16");
                String b2=u.get(j);
                int k=0;
                int flag=0;
                while((k<b1.length())&&(k<b2.length())){
                    if (!(b1.charAt(k)==b2.charAt(k))){
                        flag=k;
                        break;

                    }
                    k++;
                }
                if (flag>max)max=flag;
                j++;
            }
            int p=0;
            //System.out.println(max);
            String tem=b1.substring(0,max+1);
            g.add(tem);
            /*while(p<=max){
                System.out.print(b1.charAt(p));
                p++;
            }*/
            //System.out.println();
            i++;
        }
        if (g.size()==0)System.out.println("-1");
        else{
            System.out.println(g.size());
            int h=0;
            while(h<g.size()){
                System.out.println(g.get(h));
                h++;
            }
        }
    }
}