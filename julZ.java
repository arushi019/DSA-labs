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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class julZ{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            int[] a=new int[n];
            int num0=0;
            int min=Integer.MAX_VALUE;
            for (int i=0;i<n;i++){
                a[i]=Reader.nextInt();
                if (a[i]==0)num0++;
                if (Math.abs(a[i])<min)min=Math.abs(a[i]);
            }
            Arrays.sort(a);
            long sum=0;
            int ct=0;
            int i=0;
            while((i<n)&&(ct<k)&&(a[i]<0)){
                sum+=(long)(a[i]*(-1));
                i++;
                ct++;
            }
            if (num0!=0){
                for (int j=n-1;j>=i;j--){
                    sum+=(long)a[j];
                }
            }
            else{
                for (int j=i;j<n;j++){
                    sum+=(long)a[j];
                }
                if ((k-ct)%2==1)sum-=(long)min*2;
            }
            System.out.println(sum);

        }
    }
}