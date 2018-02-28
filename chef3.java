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
class chef3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int[] a=new int[n];
        ArrayList<Integer> arr=new ArrayList<Integer>();
        ArrayList<Integer> ar;
        int i=0;
        while(i<n){
            a[i]=Reader.nextInt();
            if (a[i]==1)arr.add(i);
            i++;
        }
        i=0;
        int max=0;
        int ct=1;
        int flag=0;
        int t;
        while(i<arr.size()){
            int pt=arr.get(i);
            t=i+1;
            ct=1;
            while((t<arr.size())&&(arr.get(t)<pt+k)){
                ct++;
                t++;
            }
            //System.out.println(pt+" "+ct);
            if (ct>max){
                max=ct;
                flag=pt;
            }
            i++;
        }
        //flag is location in the array
        //System.out.println(flag);
        int push=0;
        String s=Reader.next();
        i=0;
        while(i<p){
            if (s.charAt(i)=='!'){
                push++;
            }
            else{
                ar=new ArrayList<Integer>();
                int j=0;
                while(j<arr.size()){
                    ar.add(j,(arr.get(j)+push)%n);
                    j++;
                }
                Collections.sort(ar);
                //System.out.println(ar);
                //System.out.println((flag+push)%n);
                int newfl=(flag+push)%n;
                //newfl is shifted postion of flag in array
                int ind=ar.indexOf(newfl);
                t=ind+1;
                int c=1;
                while((t<ar.size())&&(arr.get(t)<newfl+k)){
                    c++;
                    t++;
                }
                if (c>max)System.out.println(c);
                else{
                    t=0;
                    int c3=1;
                    while(t<ind){
                        int h=t+1;
                        c3=1;
                        int pt2=ar.get(t);
                        while((h<ar.size())&&(ar.get(h)<pt2+k)){
                            c3++;
                            h++;
                        }
                        if (c3>max){
                            max=c3;
                            flag=pt2;
                        }
                        t++;
                    }
                    System.out.println(max);
                }
            }
            i++;
        }
    }
}