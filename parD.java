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
class parD{
    public static int n;
    public static long[] tr;
    public static void build(){
        for (int i=n-1;i>0;i--){
            BigInteger t1=BigInteger.valueOf(tr[i<<1]);
            t1=t1.multiply(BigInteger.valueOf(tr[i<<1|1]));
            t1=t1.mod(BigInteger.valueOf(1000000007));
            tr[i]=t1.longValue();
        }
    }
    public static void query(int l,int r){
        long pro=1;
        l+=n;
        r+=n;
        while(l<=r){
            //System.out.println(pro);
            if (l%2==1){pro*=tr[l++];pro=pro%1000000007;}
            if (r%2==0){pro*=tr[r--];pro=pro%1000000007;}
            l=l/2;
            r=r/2;
        }
        System.out.println(pro%1000000007);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int q;
        n=Reader.nextInt();
        q=Reader.nextInt();
        tr=new long[2*n];
        for (int i=0;i<n;i++){
            tr[i+n]=Reader.nextLong();
            long temp=tr[i+n];
            int sum=0;
            while(temp!=0){
                sum+=temp%10;
                temp=temp/10;
            }
            double t=Math.sqrt(sum);
            if ((sum%2==0)&&(tr[i+n]!=2))tr[i+n]=1;
            else{
                for (int j=3;j<t;j++){
                    if (sum%j==0)tr[i+n]=1;
                }
            }
            //System.out.println(tr[i+n]);
        }
        build();
        for (int i=0;i<q;i++){
            int l=Reader.nextInt();
            int r=Reader.nextInt();
            l--;
            r--;
            query(l,r);
        }
    }
}