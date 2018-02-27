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
public class mergeysort{
    static int[] num;
    static int[] aux;
    static int len;
    public static void sort(int[] num){
        this.num=num;
        this.len=num.length;
        this.aux=new int[len];
        mergesort(0,n-1);
    }
    public static void mergesort(int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergesort(low,mid);
            mergesort(mid+1,high);
            merge(low,mid,high);
        }
    }
    public static void merge(int low,int mid,int high){
        int i;
        for (i=low;i<high;i++){
            this.aux[i]=this.num[i];
        }
        i=low;
        int j=mid+1;
        int k=low;
        while ((i<=mid)&&(k<=high)){
            if (this.aux[i]>this.aux[j]){
                this.num[k]=this.aux[i];
                k++;
                i++;
            }
            else{
                this.num[k]=this.aux[j];
                j++;
                k++;
            }
        }
        while ((i<=mid)&&(k<=high)){
            this.num[k]=this.aux[i];
            k++;
            i++;
        }
        while ((j<=high)&&(k<=high)){
            this.num[k]=this.aux[j];
            k++;
            j++;
        }
        }
        public static void main(String[] args)throws IOException{
            int i,n;
            Reader.init(System.in);
            n=Reader.nextInt();
            int[] num=new int[n];
            for (i=0;i<n;i++){
                num[i]=Reader.nextInt();
            }
            mergeysort m=new mergeysort();
            m.sort(num);
            for (i=0;i<n;i++){
                System.out.print(m.num[i]+" ");
            }
        }
    }
    