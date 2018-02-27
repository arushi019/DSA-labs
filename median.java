import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


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
public class median{
    public static void main(String[] args) throws IOException{
        int n,x,i,flag=-1;
        Reader.init(System.in);
        n=Reader.nextInt();
        x=Reader.nextInt();
        int[] a=new int[n];
        //int[] b=new int[500];
        for (i=0;i<n;i++){a[i]=Reader.nextInt();}
        Arrays.sort(a);
        //for (i=0;i<n;i++)System.out.print(a[i]+" ");
        for (i=0;i<n;i++){
            if (a[i]==x){
                flag=0;
                break;
            }
            if (a[i]>x){
                flag=1;
                break;
            }
        }
        //i is the index of the place where x should be placed
        int mid,it=0;
        mid=i;
        if (flag==1){n++;mid=i-1;}
        //System.out.println(mid);
        while (mid<(int)((n-1)/2)){
            it++;
            n++;
            mid++;
            //System.out.println("While 1: "+n+" "+mid);
        }
        while (mid>(int)((n-1)/2)){
            it++;
            n++;
            //System.out.println("While 2: "+n+" "+mid);
        }
        System.out.print(it);
    


}
}