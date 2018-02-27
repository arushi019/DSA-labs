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
class trip{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int x1,y1,x2,y2,x3,y3;
        double s1,s2,s3;
        int cnt=0;
        while(t-->0){
            x1=Reader.nextInt();
            y1=Reader.nextInt();
            x2=Reader.nextInt();
            y2=Reader.nextInt();
            x3=Reader.nextInt();
            y3=Reader.nextInt();
            /*s1=(y1-y2)/(x1=x2);
            s2=(y2-y3)/(x2-x3);
            s3=(y3-y1)/(x3-x1);*/
            s1=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            s2=Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
            s3=Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
            double h;
            cnt=0;
            h=s1>s2?(s1>s3?s1:s3):(s2>s3?s1:s3);
            if (h==s1){
                if (h==Math.sqrt(s2*s2+s3*s3))cnt++;
            }
            if (h==s2){
                if (h==Math.sqrt(s1*s1+s3*s3))cnt++;
            }
            if (h==s3){
                if(h==Math.sqrt(s1*s1+s2*s2))cnt++;
            }
        }
        System.out.print(cnt);
    }
}