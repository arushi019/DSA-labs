import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;

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
class tidy{
    static int len;
    public static int[] place(long n){
        int[] p=new int[20];
        int i=0;
        long k=n;
        while(k>0){
            p[i]=(int)k%10;
            k=k/10;
            i++;
        }
        return p;
    }
    public static boolean check(int[] r){
        int i=0;
        while (i<len-1){
            if (r[i]<r[i+1])return false;
            i++;
        }
        return true;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int i=1;
        long n;
        int[] place=new int[20];
        while(i<=t){
            String s=Reader.next();
            len=s.length();
            //System.out.println(len);
            n=Long.parseLong(s);
            long u=n;
            int[] q=place(u);
            //while((u>=0)&&(check(q)==false)){
                int j=0;
                while(j<19){
                    //System.out.println("q values "+q[j]+" "+q[j+1]);
                if ((j<len-1)&&(q[j]==q[j+1])&&(q[j]==0)){
                    //System.out.println("Case 1");
                    q[j]=9;
                    q[j+1]=9;
                    int f=j+2;
                    while((f<len-1)&&(q[f]==0)){
                        q[f]=9;
                        f++;
                    }
                    q[f]--;
                    int g=0;
                    while(g<f){
                        q[g]=9;
                        g++;
                    }
                    //if (q[j+2]!=0)q[j+2]--;
                    /*int f=j+2;
                    while(f<len-2){
                        q[f]=9;
                        f++;
                    }*/
                    //for (int y=0;y<20;y++)System.out.print(q[y]+" ");
                    j=f-1;
                }
                else if ((j<len-1)&&(q[j]==0)){
                    //System.out.println("Case 2");
                    q[j]=9;
                    q[j+1]--;
                    int g=0;
                    while(g<j){
                        q[g]=9;
                        g++;
                    }
                    //for (int y=0;y<20;y++)System.out.print(q[y]+" ");
                    j=g;
                }
                
                else if (q[j]<q[j+1]){
                    //System.out.println("Case 3 j= "+j);
                    q[j]=9;
                    q[j+1]--;
                    int g=0;
                    while(g<j){
                        q[g]=9;
                        g++;
                    }
                    //for (int y=0;y<20;y++)System.out.print(q[y]+" ");
                }
                j++;
            }
        //}
            long fin=0;
            for (int h=0;h<20;h++){
                //System.out.println(q[h]);
                fin=fin+(long)q[h]*(long)Math.pow(10,h);
            }
            /*int last1=(int)fin%10;
            int last2=(int)(fin%100-10*last1);
            if (last1<last2){
                fin=fin-last1+9;
            }*/
            //System.out.println(n);
            System.out.println("Case #"+i+": "+fin);
            i++;
        }
    }
}