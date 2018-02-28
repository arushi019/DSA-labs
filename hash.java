import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.util.Arrays;

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
public class hash{
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int t;
        String s=new String();
        String s2=new String();
        Hashtable a=new Hashtable();
        Hashtable a2=new Hashtable();
        Enumeration name1;
        Enumeration name2;
        String s3=new String();
        char a3[]=new char[100000];
        char key1,key2;
        int flag,i;
        t=Reader.nextInt();
        while(t-->0){
            s=Reader.next();
            s2=Reader.next();
            flag=0;
            for (i=0;i<s.length();i++){
                a.put(s.charAt(i),false);
                a2.put(s2.charAt(i),false);
            }
            name1=a.keys();
            name2=a2.keys();
            while (name1.hasMoreElements()){
                key1=(char)name1.nextElement();
                while(name2.hasMoreElements()){
                    key2=(char)name2.nextElement();
                    if ((key1==key2)&&(a.get(key1)==false)&&(a2.get(key2)==false)){
                        a3[flag]=key2;
                        a.put(key1,true);
                        a2.put(key2,true);
                        flag++;
                    }
                }
            }
            Arrays.sort(a3);
            s3=String.valueOf(a3);
            s3=s3.replaceAll("\u0000","");
            System.out.println(s3);
        }
    }
}