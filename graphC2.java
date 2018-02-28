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
class graphC2{
    public static int[] arr;
    public static int[] freq;
    public static int n;
    public static int[] tr;
    public static int num;
    public static void build(){
        for (int i=0;i<n;i++)tr[i+n]=freq[i];
        for (int i=n-1;i>0;i--)tr[i]=tr[i<<1]+tr[i<<1|1];
    }
    public static void renew(int ind,int val){
        int temp=0;
        if (val==0)temp=1;
        else{
            while(val!=0){
                if (val%10==0)temp++;
                val=val/10;
            }
        }
        freq[ind]=temp;
        ind+=n;
        tr[ind]=temp;
        for (int i=ind/2;i>0;i=i/2)tr[i]=tr[i*2]+tr[i*2+1];
    }
    public static int qq(int l,int r){
        int res=0;
        l=l+n;
        r=r+n;
        while(l<=r){
            //System.out.println(l+" "+r);
            if (l%2==1)res+=tr[l++];
            if (r%2==0)res+=tr[r--];
            l=l/2;
            r=r/2;
        }
        return res;
    }
    public static void qq2(int val){
        if (val>tr[1])System.out.println("-1");
        else{
            for (int i=1;;){
                if (tr[i*2]<val){val=val-tr[i*2];
                i=2*i+1;
                }
                else{
                    i=i*2;
                }
                if (i>=n){
                    System.out.println(i-n);
                    break;
                }
            }
        }
    }
    public static int pikachu(int key){
        int low=0;
        int high=arr.length-1;
        int mid=(low+high)/2;
        int flag=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            int v=qq(0,mid);
            //System.out.print(qq[mid]+" ");
            //if (v==key){flag=mid;break;}
            if(v>=key){
                high=mid-1;
                flag=low+(high-low)/2;
            }
            else if (v<key){
                low=mid+1;
                flag=low+(high-low)/2;
            }
        }
        return flag;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        arr=new int[n];
        freq=new int[n];
        tr=new int[2*n];
        for (int i=0;i<n;i++){
            int temp=Reader.nextInt();
            arr[i]=temp;
            int v=temp;
            if (v==0)freq[i]=1;
            else{
                int f=0;
                while(v!=0){
                    if (v%10==0)f++;
                    v=v/10;
                }
                freq[i]=f;
            }
        }
        build();
        //for (int i=0;i<2*n;i++)System.out.print(tr[i]+" ");
        int q=Reader.nextInt();
        while(q-->0){
            int ch=Reader.nextInt();
            if (ch==0){
                int ind=Reader.nextInt();
                int val=Reader.nextInt();
                arr[ind]=val;
                renew(ind,val);
                //for (int i=0;i<n;i++)System.out.print(arr[i]+" ");
                //System.out.println();
                //for (int i=0;i<2*n;i++)System.out.print(tr[i]+" ");
                //System.out.println();
            }
            else{
                int k=Reader.nextInt();
                //if (k<=tr[1])System.out.println(qq(0,k));
                qq2(k);
            }
        }
    }
}