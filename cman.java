import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;



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
public class cman{
    public static void main(String[] args) throws IOException{
    int t;
    String s=new String();
    String s2=new String();
    String s3=new String();
    int x,y,x1,y1,c1,c2,flag,flag1;
    char a[]=new char[100000];
    char a2[]=new char[100000];
    char a3[]=new char[100000];
    int al[]=new int[26];
    int a4[]=new int[26];
    Reader.init(System.in);
    t=Reader.nextInt();
    while(t-->0){
        s=Reader.next();
        s2=Reader.next();
        s.getChars(0,s.length(),a,0);
        s2.getChars(0,s2.length(),a2,0);
        flag=0;
        //s.length=s2.length
        for(x=0;x<s.length();x++){
            a1[(int)s.charAt(x)-97]++;}
        for(x=0;x<s2.length();x++){
            a3[(int)s2.charAt(x)-97]++;
        }
        for (x=0;x<s.length();x++){
            if (a1[x]>=a4[x]){
                for (y1=0;y1<a4[x];y1++){System.out.print((char)x+97);}
            }
        else{
            for (y1=0;y1<a1[x];y1++){System.out.print((char)x+97);}
        }
        }*/
          c1=0;
            c2=0;
            flag1=0;
            for (x1=0;x1<a3.length;x1++){
                if (a3[x1]==a[x]){
                    flag1=-1;
                    break;
                }
            }
            if (flag1==0){
            for (x1=0;x1<s.length();x1++){
                        if (a[x]==a[x1])c1++;
                    }
            //c1=StringUtils.countMatches(s,a[x]);
                    for (y1=0;y1<s2.length();y1++){
                        if (a[x]==a2[y1])c2++;
                }
            //c2=StringUtils.countMatches(s2,a[x]);

            if (c1>=c2){
                        while(c2-->0){
                            a3[flag]=a[x];
                            flag++;
                        }
                    }else{
                        while(c1-->0){
                            a3[flag]=a[x];
                            flag++;
                        }
                    }


            
        }}
        /*for(x=0;x<s.length();x++){
            for(y=0;y<s2.length();y++){
                if ((a[x]==a2[y])&&(flag1==0)){
                    c1=0;
                    c2=0;
                    for (x1=0;x1<s.length();x1++){
                        if (a[x]==a[x1])c1++;
                    }
                    for (y1=0;y1<s2.length();y1++){
                        if (a2[y]==a2[y1])c2++;
                    }
                    if (c1>=c2){
                        while(c2-->0){
                            a3[flag]=a2[y];
                            flag++;
                        }
                    }else{
                        while(c1-->0){
                            a3[flag]=a2[y];
                            flag++;
                        }
                    }

                }
            }
        }*/
        Arrays.sort(a3);
        s3=String.valueOf(a3);
        s3=s3.replaceAll("\u0000","");
        System.out.println(s3.length());
        System.out.println();

    }
}
}