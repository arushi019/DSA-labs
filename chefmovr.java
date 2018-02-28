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
class chefmovr{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int d=Reader.nextInt();
            int[] a=new int[n];
            long sum=0;
            for (int i=0;i<n;i++){
                a[i]=Reader.nextInt();
                sum+=(long)a[i];
            }
            if (sum%n!=0)System.out.println("-1");
            else{
                long mid=sum/(long)n;
                long mid2=mid*2;
                long mid3=mid*3;
                int flag=0;
                long num=0;
                for (int i=d;i<n-d;i++){
                    //long temp=(long)a[i]+(long)a[i+d];
                    //if ((temp==mid2)||(a[i]==mid)||(a[i+d]==mid))flag=0;
                    //else flag=-1;
                    //if (temp==mid2)num+=(long)(Math.abs(mid-a[i]));
                    long temp=(long)a[i+d]+(long)a[i-d]+(long)a[i];
                    if (temp==mid3)flag=0;
                    else flag=-1;
                    if (temp==mid3)num+=(long)(Math.abs(a[i]-a[i+d]));
                }
                for (int i=0;i<d;i++){
                    long temp=(long)a[i]+(long)a[i+d];
                    if (temp==mid2){flag=0;num+=(long)(Math.abs(a[i]-a[i+d]));}
                    else flag=-1;
                }
                if (flag==-1)System.out.println("-1");
                else System.out.println(num);
            }
            
            
        }
    }
}