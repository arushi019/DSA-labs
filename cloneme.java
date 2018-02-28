import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.Point;
import java.text.DecimalFormat;
 

 
 
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
class cloneme{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int q=Reader.nextInt();
            int[] p=new int[n];
            for (int i=0;i<n;i++)p[i]=Reader.nextInt();
            while(q-->0){
                int a=Reader.nextInt();
                int b=Reader.nextInt();
                int c=Reader.nextInt();
                int d=Reader.nextInt();
                a--;
                b--;
                c--;
                d--;
                int[] d1=new int[b-a+1];
                int[] d2=new int[d-c+1];
                System.arraycopy(p,a,d1,0,b-a+1);
                System.arraycopy(p,c,d2,0,d-c+1);
                //Arrays.sort(d1);
                //Arrays.sort(d2);
                int[] a1=new int[100001];
                int[] a2=new int[100001];
                for (int i=0;i<b-a+1;i++){
                    a1[d1[i]]++;
                    a2[d2[i]]++;
                }
                boolean idc=false;
                int end_flag=-1;
                int start_flag=-1;
                for (int i=100000;i>=0;i--){
                    if (a1[i]!=a2[i]){end_flag=i;break;}
                }
                //System.out.println(end_flag);
                if (end_flag==-1)idc=true;
                else{
                    for (int i=0;i<end_flag;i++){
                        if (a1[i]!=a2[i]){start_flag=i;break;}
                    }
                    //System.out.println(start_flag);
                    if (start_flag==-1)idc=false;
                    else{
                        int f=0;
                        for (int j=start_flag+1;j<end_flag;j++){
                            if ((a1[j]!=0)||(a2[j]!=0))f=-1;
                        }
                        if (f==-1)idc=false;
                        else idc=true;
                    }
                }
                if (idc==true)System.out.println("YES");
                else System.out.println("NO");
                /*long sign1=0;
                HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
                for (int i=0;i<b-a+1;i++){
                    h1.put(i,d1[i]);
                    Integer temp=d1[i];
                    sign1=CommutativeOperation(sign1,d1[i].getHashCode());
                }
                System.out.println(sign1);
                int flag=0;
                for (int i=0;i<b-a+1;i++){
                    //System.out.println(i+" "+h1.get(i));
                    if (flag==0){
                        if (h1.get(i)!=d2[i]){flag++;continue;}
                    }
                    if (flag==1){
                        if (h1.get(i)!=d2[i]){flag=-1;break;}
                    }
                }*/
                /*int flag=0;
                for (int i=0;i<b-a+1;i++){
                    if (flag==0){
                        if (d1[i]!=d2[i]){flag++;continue;}
                    }
                    if (flag==1){
                        if (d1[i]!=d2[i]){flag=-1;break;}
                    }
                }
                if (flag==-1)System.out.println("NO");
                else System.out.println("YES");*/
            }
            }
    }
}