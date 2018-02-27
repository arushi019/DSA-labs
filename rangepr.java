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
class rangepr{
    public static int a;
    public static int b;
    public static int k;
    public static int[] prime;
    public static ArrayList<Integer> lst;
    public static void assign(){
        int i=2;
        while(i<b+1){
            if (prime[i]==0){
                if ((i>=a)&&(i<=b))lst.add(i);
                prime[i]=1;
                for (int j=i*2;j<b+1;j=j+i)
                    prime[j]=-1;
            }
            i++;
        }
        for (i=0;i<b+1;i++)if (prime[i]==-1)prime[i]=0;
        int sum=0;
        //assigns prime[i] the value of number of primes upto i(including i)
        for (i=0;i<b+1;i++)
            sum=sum+prime[i];
            prime[i]=sum;
        }
        //for (i=0;i<b+1;i++)System.out.print(prime[i]+" ");
    }
    public static int if_suff(int len){
        //function to determine if every contiguous subset of length 
        //len has at least k primes
        //if number of primes in an interval is exactly k then return 1
        //if number of primes in an interval is less than k then return -1
        //else return 1 (every interval has >k primes)
        System.out.println(len);
        for (int i=b;i>len-1;i--){
            int sum=prime[i]-prime[i-len+1];
            if (lst.contains(i-len+1))sum++;
            //System.out.println((i-len+1)+" "+i+" "+sum);
            if (sum<k)return -1;
            if (sum==k)return 0;
        }
        return 1;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        a=Reader.nextInt();
        b=Reader.nextInt();
        k=Reader.nextInt();
        prime=new int[b+1];
        lst=new ArrayList<Integer>();
        prime[0]=-1;
        prime[1]=-1;
        assign();
        int max=-1;
        /*for (int i=a-1;i<b-k+1;i++){
            int diff=lst.get(i+k-1)-lst.get(i);
            System.out.println(diff);
            if (diff>max)max=diff;
        }*/
        /*for (int i=0;i<lst.size()-k+1;i++){
            int diff=lst.get(i+k-1)-lst.get(i);
            System.out.println(diff);
            if (diff>max)max=diff;
        }*/
        /*if (lst.size()>=k){
            int len=lst.get(k-1)-a+1;
            int i=1;
            while(i+len-1<lst.size()){
                int j=0;
                int ct=0;
                int flag=0;
                while(j<len){
                    if (lst.contains(i+j)){
                        flag=i+j;
                        ct++;
                    }
                    j++;
                }
                if (ct<k){
                    len=len+lst.get(flag+ct-k)-i;
                }
                i++;
            }
            max=len;
        }
        else max=-1;
        //if (max!=-1)max=1+max+(lst.get(0)-a)+(b-lst.get(lst.size()-1));
        System.out.println(lst);
        System.out.println(max);*/
        //System.out.println(lst);
        int len=-1;
        int low=1;
        int high=b-a+1;
        int mid=low+(high-low)/2;
        //perform binary search here
        //for every mid, do if_suff(mid)
        //if value returned is -1, length=mid is not sufficient so low=mid+1;
        //if value returned is 0, length=mid is the length required
        //else length=mid is not the minimum length so high=mid
        while(low<=high){
            mid=low+(high-low)/2;
            //System.out.println(mid);
            int t=if_suff(mid);
            if (t==1){
                high=mid;
            }
            else if (t==-1){
                low=mid+1;
            }
            else{
                len=mid;
                break;
            }
        }
        System.out.println(len);              
    }
}