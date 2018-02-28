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
}	
class divitest{
    //public static int[] arr;
    public static int n;
    public static int[] tr;
    public static void build(){
        //for (int i=0;i<n;i++)tr[i+n]=arr[i];
        for (int i=n-1;i>0;i--)tr[i]=tr[i<<1]+tr[i<<1|1];
    }
    public static int query(int l,int r){
        int res=0;
        l+=n;
        r+=n;
        while(l<=r){
            if (l%2==1)res+=tr[l++];
            if (r%2==0)res+=tr[r--];
            l=l/2;
            r=r/2;
        }
        return res;
    }
    public static void renew(int ind,int val){
        //arr[ind]=val;
        ind+=n;
        tr[ind]=val;
        for (int i=ind/2;i>0;i=i/2)tr[i]=tr[i*2]+tr[i*2+1];
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            String s=Reader.next();
            n=s.length();
            //arr=new int[n];
            tr=new int[2*n];
            for (int i=0;i<n;i++){
                tr[i+n]=(int)s.charAt(i)-48;
            }
            build();
            int q=Reader.nextInt();
            for (int i=0;i<q;i++){
                int l=Reader.nextInt();
                int r=Reader.nextInt();
                int sum=query(l-1,r-1);
                if (sum%9==0)System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}