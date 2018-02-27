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
public class quicksort{
	public static int[] swap(int a[],int size,int piv_pos){
		int left=piv_pos+1;
		int right=piv_pos+size;
		int temp;
		int it;
		int pivot=a[piv_pos];
		while (left!=right){
			if (a[left]<pivot){
				left++;
			}
			else{
				temp=a[left];
				a[left]=a[right];
				a[right]=temp;
			}
			if (a[right]>pivot){
				right--;
			}
			else{
				temp=a[left];
				a[left]=a[right];
				a[right]=temp;
			}
			for (it=0;it<size+1;it++)System.out.print(a[it]+" ");
			System.out.println();
		}
		temp=a[right];
		a[right]=a[piv_pos];
		a[piv_pos]=temp;
		return a;
	}
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
		int n=Reader.nextInt();
		int[] a=new int[n];
		int i;
		for (i=0;i<n;i++)a[i]=Reader.nextInt();
		a=swap(a,n-1,0);
		System.out.println();
		for (i=0;i<n;i++)System.out.print(a[i]+" ");
	}
}