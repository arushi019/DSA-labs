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
public class sort_ins{
    int[] a=new int[100];
    int maxn,n;
    public int bin_srch(int key){
        int low,high,mid;
        low=0;
        high=n;
        mid=-1;
        while (low<=high){
            mid=(low+high)/2;
            if (key==a[mid])break;
            else if (key>a[mid]){
                low=mid+1;
            }
            else if (key<a[mid]){
                high=mid-1;
            }
        }
        //System.out.println(mid);
        return mid;
    }
    public void ins(int num){
        int i,pos;
        if (n<maxn){
            i=0;
            pos=n;
            while (i<n){
                if (a[i]>num){pos=i;break;}
                i++;

            }
            for (i=n-1;i>=pos;i--){
                a[i+1]=a[i];
            }
            a[pos]=num;
            n++;
            System.out.println(n+" "+(n-pos-1));
        }
        else{
            System.out.println(n+" "+0);
        }
    }
    public void del(int num){
        int i,pos;
        if (n!=0){
            i=0;
            pos=bin_srch(num);
            for (i=(pos+1);i<n;i++)
                a[i-1]=a[i];
            n--;
            System.out.println(n+" "+(n-pos));
        }
    }
    public void display(){
        int i=0;
        while (i<n){System.out.print(a[i]+" ");i++;}
        System.out.println();
    }
    public static void main(String[] args) throws IOException{
        sort_ins s=new sort_ins();
        Reader.init(System.in);
        int q,c,key;
        s.maxn=Reader.nextInt();
        s.n=Reader.nextInt();
        q=Reader.nextInt();
        int i;
        for (i=0;i<s.n;i++)s.a[i]=Reader.nextInt();
        while (q-->0){
            c=Reader.nextInt();
            if (c==1){key=Reader.nextInt();s.ins(key);}
            else if (c==2){key=Reader.nextInt();s.del(key);}
            else if (c==3)s.display();
        }
        
    }
}