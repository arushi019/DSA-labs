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
class may6_2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int i=0;
        ArrayList<String> u=new ArrayList<String>();
        ArrayList<String> b=new ArrayList<String>();
        while(i<n){
            String c=Reader.next();
            String temp=Reader.next();
            if (c.charAt(0)=='+')u.add(temp);
            else b.add(temp);
            i++;
        }
        Collections.sort(u);
        Collections.sort(b);
        i=0;
        int flag=-1;
        ArrayList<String> g=new ArrayList<String>();
        while(i<b.size()){
            String s1=b.get(i);
            int j=0;
            flag=-1;
            int max=0;
            while(j<u.size()){
                String s2=u.get(j);
                int k=0;
                flag=-1;
                while ((k<s1.length())&&(k<s2.length())){
                    if (!(s1.charAt(k)==s2.charAt(k))){
                        flag=k;
                        break;
                    }
                    k++;
                }
                if (flag==-1){
                    break;
                }
                else if (flag>max)max=flag;
                j++;
            }
            if (flag==-1){
                g.add("-1");
            }
            else{
                g.add(s1.substring(0,max+1));
            }
            i++;
        }
        //System.out.println(flag);
        Collections.sort(g);
        if (g.get(0).equals("-1"))System.out.println("-1");
        else{
        System.out.println(g.size());
        i=0;
        while(i<g.size()){
            System.out.println(g.get(i));
            i++;
        }
    }
    }
}