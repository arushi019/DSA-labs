import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
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
    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}
class palingam{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String s1=Reader.next();
            String s2=Reader.next();
            char[] c1=new char[26];
            char[] c2=new char[26];
            if (s1.length()==1){
                System.out.println("B");
            }
            else{
            for (int i=0;i<s1.length();i++){
                int ch=(int)s1.charAt(i)-97;
                c1[ch]++;
                ch=(int)s2.charAt(i)-97;
                c2[ch]++;
            }
            int flag1=-1;
            int flag2=-1;
            for (int i=0;i<26;i++){
                if (c1[i]==s1.length())flag1=i;
                if (c2[i]==s2.length())flag2=i;
            }
            if ((flag1==flag2)&&(flag1!=-1))System.out.println("B");
            else if ((flag1!=-1)&&(flag2!=-1)&&(flag1!=flag2))System.out.println("A");
            else{
                int flag3=-1;
                for (int i=0;i<26;i++){
                    if ((c1[i]>=2)&&(c2[i]==0))flag3=i;
                }
                if (flag3!=-1)System.out.println("A");
                else System.out.println("B");
            }
        }
        }
    }
}