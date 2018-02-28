//Arushi Chauhan 
//2016019
//Sec-A Grp-2
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
public class clever_algo{
    public static long[][] mp(long a[][],long n){
        long c[][]=new long[2][2];
        long[][] fin=new long[2][2];
        if (n==1)fin=a;
        else if (n>1){
        if (n%2==0){
            long[][] b=new long[2][2];
            b=mp(a,n/2);
            /*int b[][]={
                {1,1},
                {1,0}
            };*/
            c[0][0]=b[0][0]*b[0][0]+b[0][1]*b[1][0];
            c[0][1]=b[0][0]*b[0][1]+b[0][1]*b[1][1];
            c[1][0]=b[1][0]*b[0][0]+b[1][1]*b[1][0];
            c[1][1]=b[1][0]*b[0][1]+b[1][1]*b[1][1];
            //System.out.println(c[0][0]+" "+c[0][1]+" "+c[1][0]+" "+c[1][1]);
            fin=c;
        }
        else{
            long[][] b=new long[2][2];
            b=mp(a,n/2);
            /*int b[][]={
                {1,1},
                {1,0}
            };*/
            long[][] d=new long[2][2];
            c[0][0]=b[0][0]*b[0][0]+b[0][1]*b[1][0];
            c[0][1]=b[0][0]*b[0][1]+b[0][1]*b[1][1];
            c[1][0]=b[1][0]*b[0][0]+b[1][1]*b[1][0];
            c[1][1]=b[1][0]*b[0][1]+b[1][1]*b[1][1];
            d[0][0]=c[0][0]*a[0][0]+c[0][1]*a[1][0];
            d[0][1]=c[0][0]*a[0][1]+c[0][1]*a[1][1];
            d[1][0]=c[1][0]*a[0][0]+c[1][1]*a[1][0];
            d[1][1]=c[1][0]*a[0][1]+c[1][1]*a[1][1];
            //System.out.println(d[0][0]+" "+d[0][1]+" "+d[1][0]+" "+d[1][1]);
            fin=d;
        }
    }
    return fin;
    }
    public static long cafb(long n){
        if (n==0)return 0;
        else if(n==1)return 1;
        else if(n==2)return 1;
        else{
        long[][] a={{1,1},{1,0}};
        long b[][]=new long[2][2];
        b=mp(a,n-1);
        long c[]={b[0][0],b[0][1]};
        return c[0]%2014;
    }
    }   
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        long n1,m;
        n1=Long.parseLong(Reader.next());
        //m=Long.parseLong(Reader.next());
        int a[][]={
            {1,1},
            {1,0}
        };
        long startTime=System.nanoTime();
        
        //System.out.print(mp(a,5));
        System.out.print(cafb(n1));
        long endTime=System.nanoTime();
        double TimeElapsed=(endTime-startTime);
        System.out.print(" "+TimeElapsed);
    }
}