import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.lang.*;
import java.awt.Point;
 

 
 
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
class SNCOUP{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            String r1=Reader.next();
            int[] a1=new int[n];
            String r2=Reader.next();
            int[] a2=new int[n];
            ArrayList<Integer> s1=new ArrayList<Integer>();
            ArrayList<Integer> s2=new ArrayList<Integer>();
            int sum1=0;
            int sum2=0;
            int flag=0;
            int ct=0;
            for (int i=n-1;i>=0;i--){
                if (r1.charAt(i)=='*'){sum1++;s1.add(i);}
                a1[i]=sum1;
                if (r2.charAt(i)=='*'){sum2++;s2.add(i);}
                a2[i]=sum2;
                if ((r1.charAt(i)=='*')&&(r2.charAt(i)=='*')){flag=1;ct++;}
            }
            int fence=0;
            System.out.println(s1);
            System.out.println(s2);
            for (int h=0;h<n;h++)System.out.print(a1[h]+" ");
                System.out.println();
            for (int h=0;h<n;h++)System.out.print(a2[h]+" ");
                System.out.println(); 
            if ((a1[0]==0)&&(a2[0]==0))fence=0;
            else if (a2[0]==0)fence=s1.size()-1;
            else if (a1[0]==0)fence=s2.size()-1;
            else{
                fence++;
                if (s1.size()>s2.size()){
                    fence+=s1.size()-1;
                    int f1=0;
                    for (int h=s1.size()-1;h>=0;h--){
                        System.out.println(s1.get(h)+" "+f1);
                        if (a2[f1]-a2[s1.get(h)]>1)fence+=a2[f1]-a2[s1.get(h)]-1;
                        f1=s1.get(h);
                    }
                    if (a2[f1]-a2[n-1]>1)fence+=a2[f1]-a2[n-1];
                }
                else{
                    fence+=s2.size()-1;
                    int f1=0;
                    for (int h=s2.size()-1;h>=0;h--){
                        System.out.println(s2.get(h)+" "+f1+" "+(a1[f1]-a1[s2.get(h)]));
                        if (a1[f1]-a1[s2.get(h)]>1)fence+=a1[f1]-a1[s2.get(h)]-1;
                        f1=s2.get(h);
                    }
                    if (a1[f1]-a1[n-1]>1)fence+=a1[f1]-a1[n-1];
                }
            }
            System.out.println(fence);
        }
    }
}