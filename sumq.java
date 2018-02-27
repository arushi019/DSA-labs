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
class sumq{
    public static int pikachu(long[] arr,long key){
        //returns the index that has the least greatest or equal to the key
        int low=0;
        int high=arr.length-1;
        int mid=(low+high)/2;
        int flag=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            System.out.print(arr[mid]+" ");
            if (arr[mid]==key){flag=mid;break;}
            else if(arr[mid]>key){
                high=mid-1;
                flag=low+(high-low)/2;
            }
            else{
                low=mid+1;
                flag=low+(high-low)/2;
            }
        }
        return flag;
    }
    public static int pika(long[] arr,long key){
        int i=0;
        while(i<arr.length){
            if (arr[i]>key)return i;
            i++;
        }
        return arr.length;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int p=Reader.nextInt();
            int q=Reader.nextInt();
            int r=Reader.nextInt();
            long[] a=new long[p];
            long[] b=new long[q];
            long[] c=new long[r];
            for (int i=0;i<p;i++)a[i]=(long)Reader.nextInt();
            for (int j=0;j<q;j++)b[j]=(long)Reader.nextInt();
            for (int k=0;k<r;k++)c[k]=(long)Reader.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            Arrays.sort(c);
            //double sum=0;
            BigInteger sum=BigInteger.ZERO;
            /*for (int i=0;i<p;i++){
                //System.out.println(f_index);
                for (int j=0;j<q;j++){
                    //System.out.println(s_index);
                    for (int k=0;k<r;k++){
                        //System.out.println((a[i]+b[j])*(b[j]+c[k]));
                        //System.out.println(a[i]+" "+b[j]+" "+c[k]);
                            BigInteger temp=new BigInteger(String.valueOf((a[i]+b[j])*(b[j]+c[k])));
                            sum=sum.add(temp);
                        
                    }
                }
            }*/
            BigInteger sum1=BigInteger.ZERO;
            BigInteger sum2=BigInteger.ZERO;
            for (int i=0;i<q;i++){
                int f_index=pika(a,b[i]);
                for (int j=0;j<f_index;j++){
                    if ((j<p)&&(a[j]<=b[i])){
                        BigInteger temp=new BigInteger(String.valueOf(a[j]));
                        sum2=sum2.add(temp);
                    }
                }
                BigInteger temp=new BigInteger(String.valueOf(b[i]*f_index));
                sum2=sum2.add(temp);
            }
            for (int i=0;i<q;i++){
                int s_index=pika(c,b[i]);
                for (int j=0;j<s_index;j++){
                    if ((j<r)&&(c[j]<=b[i])){
                        BigInteger temp=new BigInteger(String.valueOf(c[j]));
                        sum1=sum1.add(temp);
                    }
                }
                BigInteger temp=new BigInteger(String.valueOf(b[i]*s_index));
                sum1=sum1.add(temp);
            }
            //System.out.println(sum);
            //double fin=sum%1000000007;
            //DecimalFormat df=new DecimalFormat("#");
            //System.out.println(df.format(fin));
            sum=sum1.multiply(sum2);
            BigInteger temp=new BigInteger("1000000007");
            System.out.println(sum.mod(temp).longValue());
        }

    }
}