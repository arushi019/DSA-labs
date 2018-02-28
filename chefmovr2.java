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
class chefmovr2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int d=Reader.nextInt();
            int[] a=new int[n];
            long sum=0;
            long step=0;
            boolean fin=true;
            HashSet<Integer> index=new HashSet<Integer>();
            for (int i=0;i<n;i++){
                a[i]=Reader.nextInt();
                sum+=(long)a[i];
                index.add(i);
            }
            long mid=sum/(long)n;
            for (int i=0;i<n;i++){
                if (index.contains(i)){
                    long check=0;
                    for (int j=i;j<n;j=j+d){
                        check+=mid-a[j];
                        if (mid-a[j]>0)step+=(long)(mid-a[j]);
                        index.remove(j);
                    }
                    if (check!=0){fin=false;break;}
                }
            }
            if (fin==false)System.out.println("-1");
            else System.out.println(step);
            }
        }
    }
