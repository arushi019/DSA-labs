import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class directi{
    public static void main(String[] args)throws IOException{
        Scanner in=new Scanner(System.in);
        int t=Integer.parseInt(in.nextLine());
        while(t-->0){
            int n=Integer.parseInt(in.nextLine());
            String[] dir=new String[n];
            int[] flag=new int[n];
            for (int i=0;i<n;i++){
                String temp=in.nextLine().trim();
                if (temp.isEmpty())continue;
                //in.close();
                String temp2=new String();
                //System.out.println(dir[i]);
                char c=temp.charAt(0);
                if (c=='B'){
                    temp2=temp.substring(5);
                }
                if (c=='L'){
                    flag[i]=1;
                    temp2=temp.substring(4);
                }
                if (c=='R'){
                    flag[i]=2;
                    temp2=temp.substring(5);
                }
                //System.out.println(dir[i]);
                dir[i]=temp2;
            } 
            //in.close();
            System.out.println("Begin"+dir[n-1]);
            for (int i=n-2;i>=0;i--){
                if (flag[i+1]==1)System.out.println("Right"+dir[i]);
                else System.out.println("Left"+dir[i]);
            }
        }
    }
}