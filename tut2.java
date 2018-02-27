import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.*;


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
public class tut2{
    public static int rsum(int sum, int n){
        if (n==0)return sum;
        else return rsum(sum+n,n-1);
    }
    public static int rsrch(int key, int[] a,int pos){
        if (key==a[0])return pos;
        else{
            //System.out.println(a[0]);
            if (a.length!=1){
            int[] adup=new int[a.length-1];
            int i;
            for (i=1;i<a.length;i++)adup[i-1]=a[i];
            pos++;
            return rsrch(key,adup,pos);
        }
        else return -1;
        }
        //return -1;
    }
    public static int rsq(int sum, int n){
        if (n==0)return sum;
        return rsq(sum+n*n,n-1);
    }
    public static double rnrev(int num,double newnum,int num_digits){
        if (num_digits>0){
        newnum=newnum+(num%10)*(Math.pow(10,num_digits-1));
        num=num/10;
        num_digits--;
        return rnrev(num,newnum,num_digits);
    }
    else return newnum;
    }
    public static void strev(String st){
        if (st.length()>0){
        System.out.print(st.charAt(st.length()-1));
        st=st.substring(0,st.length()-1);
        strev(st);
    }
    else System.out.print(st);
    }
    public static int rgcd(int n1,int n2,int lev){
        if (lev>0){
        if ((n1%lev==0)&&(n2%lev==0))return lev;
        else return rgcd(n1,n2,lev-1);
    }
    return 1;
    }
    public static void rbin(int num){
        if (num>0){
        int k=1;
        while ((int)num/Math.pow(2,k)>=1)k++;
        System.out.print(num%((int)Math.pow(2,k-1)));
        rbin((int)num/2);
    }
    }
    public static void main(String[] args)throws IOException{
        //System.out.println(rsum(0,10));
        /*int[] a={12,67,34,90,23};
        System.out.println(rsrch(35,a,0));*/
        //System.out.println(rsq(0,8));
        //System.out.println((int)rnrev(8527,0,4));
        //strev("Hello");
        //System.out.print(rgcd(96,54,54));
        rbin(32);
    }
}