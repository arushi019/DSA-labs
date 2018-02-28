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
class chefsuba{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int[] a=new int[n];
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int i=0;
        while(i<n){
            a[i]=Reader.nextInt();
            if (a[i]==1){
                arr.add(i);
            }
            i++;
        }
        String s=Reader.next();
        int max=0;
        int ct=1;
        int j=0;
        while(j<arr.size()){
            int pt=arr.get(j);
            int t=j+1;
            while((t<arr.size())&&(arr.get(t)<pt+k)){
                ct++;
                t++;
            }
            if (ct>max)max=ct;
            j++;
        }
        
        i=0;
        int c1=0;
        int flag=a[n-1];
        //System.out.println(arr);    
        while(i<p){
            if (s.charAt(i)=='!'){
                j=0;
                c1++;
                flag=a[(n-1-c1)%n];
                while(j<arr.size()){
                    arr.set(j,(arr.get(j)+1)%n);
                    j++;
                }
                Collections.sort(arr);
                //System.out.println(arr);
            }
            else{
                if (flag==0){
                    //System.out.println(i);
                max=0;
                ct=0;
                j=0;
                while(j<arr.size()){
                    int pt=arr.get(j);
                    int t=j+1;
                    ct=1;
                    while((t<arr.size())&&(arr.get(t)<pt+k)){
                        ct++;
                        t++;
                    }
                    if (ct>max)max=ct;
                    j++;
                }
                System.out.println(max);
            }
            else{
                System.out.println(max);
            }
            }
            i++;
        }

    }
}