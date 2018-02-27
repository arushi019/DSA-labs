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
public class shop{
    public static int gcd(int a,int b){
        int m,n,temp1,temp2;
        m=a;
        n=b;
        while(m%n>0){
            temp1=m>n?m:n;
            temp2=m>n?n:m;
            m=temp2;
            n=temp1-temp2;
            //System.out.println(m+" "+n);
        }
        return n;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n,i,cnt;
        while (t-->0){
            n=Reader.nextInt();
            int[] a=new int[n];
            cnt=1;
            /*if (n%2==0){
                cnt+=n/2-1;
            //int k=(int)Math.sqrt(n)+1;
            //System.out.print(k);
            for (i=3;i<n;i=i+2){
                if (gcd(n,i)>1)cnt++;
            }
        }
            else{
                //cnt+=n/2;
                for (i=3;i<n;i=i+2){
                    if (gcd(n,i)>1)cnt++;
                }
            }*/
            i=1;
            while(i<=n){
                if (i==1){
                    a[0]=-1;
                }
                else if(i<n){
                    if (a[i-1]!=-1){
                        if (gcd(n,i)>1){
                            int j=i;
                            while(j<n){
                                //System.out.println(j);
                                if (a[j-1]!=-1){
                                a[j-1]=-1;
                                cnt++;
                            }
                            j=j+i;
                        }
                        }
                    }
                }
                else if (i==n)a[i-1]=-1;    
                
                i++;
            }
            System.out.print(cnt);
            if (t!=0)System.out.println();
        }
        //int n=Reader.nextInt();
        //System.out.print(gcd(a,b));
    }
}