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
class snake5{
    public static int bsearch(int[] len,int q){
        int low=0;
        int high=len.length-1;
        int pos=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if (len[mid]==q){
                pos=mid;
                break;
            }
            else if (len[mid]>q){
                high=mid-1;
                pos=mid;
            }
            else{
                low=mid+1;
                pos=mid;
            }
        }
        return pos;
    }
    public static int modbsearch(int[] len,int h,int q){
        int low=0;
        int high=h-1;
        int pos=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int t=len[mid]+mid;
            if (q==t){
                pos=mid;
                break;
            }
            else if(q<t){
                high=mid-1;
                pos=mid;
            }
            else{
                low=mid+1;
                pos=mid;
            }
        }
        return pos;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int q=Reader.nextInt();
            int[] len=new int[n];
            int[] k=new int[q];
            for (int i=0;i<n;i++)len[i]=Reader.nextInt();
            Arrays.sort(len);
            for (int i=0;i<n;i++)System.out.print(len[i]+" ");
            System.out.println();
            for (int i=0;i<q;i++){
                int temp=Reader.nextInt();
                int ind=bsearch(len,temp);
                int mod=modbsearch(len,ind,temp);
                int ct=0;
                // if key is less than all values then ind=0 and mod=-1
                // if ind=n-1 either value is greater than all elements or equal to the last
                // if ind=n/2 --> if mod=0 then value is equal to all elements in the array
                //System.out.println(ind+" "+mod);
                if ((ind==0)&&(mod==-1))ct=n;
                /*else if (ind==n-1){
                    if (len[ind]>=temp)ct=1;
                    else ct=0;
                }*/
                else{
                    ct+=(n-mod);
                    if (mod==ind-1){
                        if (len[mod]+mod<temp)ct--;
                    }
                    if (ind==n-1){
                    if (len[ind]+ind<temp)ct--;
                }
                }
                System.out.println(ct);
            }

        }
    }
}