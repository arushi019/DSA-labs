import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
public class acstr{
    public static void main(String[] args) throws IOException{
        int t,i;
        char x;
        String s1=new String();
        String s2=new String();
        char[] c1=new char[100000];
        char[] c2=new char[100000];
        Reader.init(System.in);
        t=Reader.nextInt();
        while (t-->0){
        int[] count1={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] count2={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            s1=Reader.next();
            s2=Reader.next();
            s1.getChars(0,s1.length(),c1,0);
            s2.getChars(0,s2.length(),c2,0);
            //for (i=0;i<c1.length;i++){System.out.print(c1[i]);}
            for (i=0;i<s1.length();i++){
                //System.out.print((int)c1[i]+" ");
                count1[(int)c1[i]-97]++;
            }
            for (i=0;i<s2.length();i++){
                count2[(int)c2[i]-97]++;
            }
            for (i=0;i<26;i++){
                if (count1[i]>=count2[i]){
                    while(count2[i]-->0)System.out.print((char)(i+97));}
                else {while(count1[i]-->0)System.out.print((char)(i+97));}
                
            }
            if (t!=0)
            System.out.println();
        }
    }
}