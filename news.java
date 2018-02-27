import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
public class news{
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        String s=new String();
        char a[]=new char[100];
        char a2[]=new char[100];
        s=Reader.next();
        s.getChars(0,s.length(),a,0);
        int t,n;
        int k,i,ct,flag,l,prev_flag;
        String s2=new String();
        t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            s2=Reader.next();
            s2.getChars(0,s2.length(),a2,0);
            ct=0;
            prev_flag=0;
            while(prev_flag!=-1){
                prev_flag=s.indexOf(s2,prev_flag);
                if (prev_flag!=-1){
                    ct++;
                    prev_flag+=n;
                }
            }
            /*prev_flag=-900;
            for (i=0;i<s.length();i++){
                if (a[i]==a2[0]){
                    flag=i;
                    for (k=0;k<s2.length();k++){
                        if((a[i+k]!=a2[k])&&((i+k)<s.length())){
                            flag=-1;
                            break;
                        }
                        else if ((i+k)>=s.length()){
                            flag=-1;
                            break;
                        }

                    }
                    if ((flag>=0)&&(!(flag<=(prev_flag+s2.length())))&&((prev_flag+s2.length())<s.length())){
                        prev_flag=i;
                        ct++;
                }
            }}*/
            //n=s2.length();
            /*k=(int)s.length()/n;
            i=0;
            ct=0;
            for(l=0;l<(s.length()-n);l++){
            while(i<k){
                start=i*n+l;
                end=(i+1)*n+l;
                //System.out.println(s.substring(start,end));
                if ((s2.equals(s.substring(start,end)))&&(start>=0)&&(end<s.length())){
                    s3=s.substring(0,start)+s.substring(end,s.length());
                    s=s3;
                    System.out.println(s);
                    ct++;
                }
                    i++;}
            }*/
            System.out.println(ct);
        }
    }
}