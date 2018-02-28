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
class chef4{
    public static int[] build(int[] a,int n,int pt){
        int[] arr=new int[2*n];
        for (int i=0;i<n;i++)arr[i+n]=a[(n-pt+i)%n];
        for (int i=n-1;i>0;i--){
            System.out.println(i+" "+arr[i<<1]+" "+arr[i<<1|1]);
            arr[i]=arr[i<<1]+arr[i<<1|1];}
        for(int i=0;i<2*n;i++)System.out.print(arr[i]+" ");
        System.out.println();    
        return arr;
    }
    /*public static int query(int n,int s,int e,int[] arr){
        if ((s<0)||(e>n-1)||(s>e))return -1;
        else return dquery(arr,0,n-1,s,e,0);
    }
    public static int dquery(int[] arr,int s1,int s2,int s,int e,int root){
        if ((s<=s1)&&(e>=s2))return arr[root];
        if ((s2<s)||(s1>e))return 0;
        int m=(e+s)/2;
        return dquery(arr,s1,m,s,e,2*root)+dquery(arr,m+1,s2,s,e,2*root+1);
    }*/
    public static int query2(int[] arr,int n,int s,int e){
        int c=0;
        for (s+=n,e+=n;s<e;s>>=1,e>>=1){
            if ((s&1)>0) c=c+arr[s++];
            if ((e&1)>0) c=c+arr[--e];
        }
        return c;
    }
    /*public static int[] contruct(int[] a,int n){
        int[] arr=new int[2*n+2];
        int i=n-1;
        int j=2*n+1;
        while(i>=0){
            arr[j]=a[i];
            i--;
            j--;
        }
        System.out.println(j);
        i=j;
        while(i>=0){
            arr[i]=arr[2*i-1]+arr[2*i-2];
            i--;
        }
        //6-10,11
        //5-9,10
        //4-8,9
        i=0;
        while(i<2*n+2){
            System.out.print(arr[i]+" ");
            i++;
        }
        return arr;
    }*/
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int k=Reader.nextInt();
        int p=Reader.nextInt();
        int[] a=new int[n];
        int i=0;
        int sum=0;
        int[] arr=new int[2*n];
        while(i<n){
            a[i]=Reader.nextInt();
            sum+=a[i];
            i++;
        }
        String s=Reader.next();
        arr=build(a,n,0);
        i=0;
        int j;
        int push=0;
        while(i<p){
            if (s.charAt(i)=='!'){
                if (n!=k)push=(push+1)%n;
            }
            else{
                if (n==k){System.out.println(sum);}
                else{
                /*a2=new int[n];
                if (push!=0){
                System.arraycopy(a,n-push,a2,0,push);
                System.arraycopy(a,0,a2,push,n-push);
                //for (j=0;j<n;j++)System.out.print(a2[j]+" ");
                //System.out.println();
                arr=build(a2,n);
                }*/
                if (push!=0){
                    arr=build(a,n,push);
                }
                //System.out.println(max);
                /*int max=0;
                int flag=0;
                for (j=0;j<n;j++){
                    int e=j+k;
                    if (e>n){
                        e=n;
                        if (max>n-j+1)flag=1;
                    }
                    if (flag==0){
                    int c=query2(arr,n,j,e);
                    if (c==k){max=k;break;}
                    else if (c>max)max=c;
                }
                else break;
                }*/
                System.out.println(arr[1]);
                }
            }
            i++;
        }
    }
}