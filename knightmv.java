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
class knightmv{
    public static void main(String[] args)throws IOException{
        Scanner in=new Scanner(System.in);
        int t=Integer.parseInt(in.nextLine());
        while(t-->0){
            String temp=in.nextLine().trim();
            if (temp.isEmpty())continue;
            if (temp.length()>5)System.out.println("Error");
            else{
                if (temp.charAt(2)!='-')System.out.println("Error");
                else{
                    int n1=(int)temp.charAt(1);
                    int n2=(int)temp.charAt(4);
                    int a1=(int)temp.charAt(0);
                    int a2=(int)temp.charAt(3);
                    if ((a1>96)&&(a1<105)&&(a2>96)&&(a2<105)&&(n1>48)&&(n1<57)&&(n2>48)&&(n2<57)){
                        int d1=Math.abs(n1-n2);
                        int d2=Math.abs(a1-a2);
                        if (d1+d2!=3)System.out.println("No");
                        else{
                            if ((d1==0)||(d2==0))System.out.println("No");
                            else System.out.println("Yes");
                        }
                    }
                    else System.out.println("Error");
                }
            }
        }
    }
}