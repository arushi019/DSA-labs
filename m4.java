import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
 
 
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
class m4{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n,k,p;
        n=Reader.nextInt();
        k=Reader.nextInt();
        p=Reader.nextInt();
        int i=0;
        int[] a=new int[n];
        ArrayList<Integer> loc=new ArrayList<Integer>();
        int[] cntnr;
        while(i<n){
            a[i]=Reader.nextInt();
            if (a[i]==1)loc.add(i);
            i++;
        }
        //System.out.println(loc);
        String s=Reader.next();
        i=-1;
        int pt=0;
        int max=0;
        while(i<p){
            char c='?';
            if (i!=-1)c=s.charAt(i);
            if ((c=='!')||(i==-1)){
                //-----------------
                int j=0;
                cntnr=new int[n];
                while(j<loc.size()){
                    loc.set(j,(loc.get(j)+1)%n);
                    int temp=loc.get(j);
                    //
                    int h=0;
                    while(h<k){
                        if (temp+h<n)cntnr[temp+h]++;
                        //else break;
                        h++;
                    }
                    j++;
                }
                //System.out.println(loc);
                /*j=0;
                while(j<n){
                    System.out.print(cntnr[j]+" ");
                    j++;
                }*/
                //System.out.println();
                Arrays.sort(cntnr);
                max=cntnr[n-1];
            }
            else{
                System.out.println(max);
            }
            i++;
        }
    }
}