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
public class cody{
    static int[] p;
    static int top;
    public static int position(int n){
        int low=0;
        int high=top-1;
        int mid;
        while (low<high){
            mid=(low+high)/2;
            if (n==p[mid]){
                System.out.println(mid);
                return mid;
            }
            else if (n>p[mid]){
                System.out.println("low changed");
                low=mid+1;
                System.out.println(low);
            }
            else{
                high=mid-1;
                System.out.println("High changed"+high);
            }
        }
        System.out.print(n+" not found");
        return -1;
    }
    public static boolean check(int n){
        int t=n*4/3;
        int pos1=position(t);
        int pos2=position(n);
        if (pos2==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String[] args)throws IOException{
        int t,i,dup;
        Reader.init(System.in);
        t=Reader.nextInt();
        dup=t;
        while(t-->0){
            top=2*Reader.nextInt();
            i=0;
            p=new int[top];
            while (i<top){
                p[i]=Reader.nextInt();
                i++;
            }
            i=0;
            System.out.print("Case #"+(dup-t)+":");
            while (i<top-1){
                if (check(p[i])==true)System.out.print(" "+p[i]);
                i++;
            }
        }
    }
}