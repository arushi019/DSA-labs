import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
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
    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}
class rainbowb{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int[] a=new int[n];
            int flag=0;
            for (int i=0;i<n;i++){
                a[i]=Reader.nextInt();
                if (a[i]>7)flag=-1;
            }
            if (flag==-1)System.out.println("no");
            else{
                ArrayList<Integer> h=new ArrayList<Integer>();
                for (int i=0;i<n;i++){
                    if (a[i]==7)h.add(i);
                }
                Iterator it=h.iterator();
                int prev=-1;
                while(it.hasNext()){
                    int pres=(Integer)it.next();
                    if (prev==-1)prev=pres;
                    else{
                        if (pres-prev>1)flag=-1;
                        prev=pres;
                    }
                }
                if (flag==-1)System.out.println("no");
                else{
                    boolean[] ch=new boolean[7];
                    for (int i=0;i<n;i++){
                        if (a[i]!=a[n-1-i])flag=-1;
                        if (ch[a[i]-1]==false)ch[a[i]-1]=true;
                    }
                    for (int i=0;i<7;i++){
                        if (ch[i]==false)flag=-1;
                    }
                    if (flag==-1)System.out.println("no");
                    else{
                        int i=0;
                        while(a[i]<7){
                            if ((a[i+1]-a[i]>1)||(a[i+1]-a[i]<0))flag=-1;
                            i++;
                        }
                        if (flag==-1)System.out.println("no");
                        else{
                            int j=n-1;
                            while(a[j]<7){
                                if ((a[j-1]-a[j]>1)||(a[j-1]-a[j]<0))flag=-1;
                                //System.out.println(a[i-1]-a[i]);
                                j--;
                            }
                            if (flag==-1)System.out.println("no");
                            else System.out.println("yes");
                        }
                    }
                }
                }
            }

        }
    }
