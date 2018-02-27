import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class prosum{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            long n=Reader.nextLong();
            long ct=0;
            ArrayList<Integer> l1=new ArrayList<Integer>();
            ArrayList<Integer> l2=new ArrayList<Integer>();
            long ct0=0;
            for (int i=0;i<n;i++){
                int temp=Reader.nextInt();
                if (temp==0){ct+=(long)(n-1);ct0++;}
                else if (temp==1)l1.add(i);
                else if (temp==2)l2.add(i);
            }
            ct-=(ct0*(ct0-1))/2;
            //System.out.println(ct);
            //System.out.println(l1);
            //System.out.println(l2);
            int len1=l1.size();
            int len2=l2.size();
            ct+=(long)(((long)len1*(long)(len1-1))/2);
            //System.out.println(ct);
            ct+=(long)(((long)len2*(long)(len2-1))/2);
            //System.out.println(ct);
            if (len2!=0){
                for (int i=0;i<len1;i++){
                    for (int j=0;j<len2;j++){
                        if (l1.get(i)<l2.get(j)){
                            ct+=len2-j;
                            break;
                        }
                    }
                }
                //System.out.println(ct);
                for (int j=0;j<len2;j++){
                    for (int i=0;i<len1;i++){
                        if (l2.get(j)<l1.get(i)){
                            ct+=len1-i;
                            break;
                        }
                    }
                }
                //System.out.println(ct);
            }
            long pro=n*(n-1);
            pro=pro/2;
            System.out.println(pro-ct);
        }
    }
}