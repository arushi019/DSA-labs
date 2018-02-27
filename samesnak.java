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
class samesnak{
    public static int xs1,ys1,xe1,ye1,xs2,ys2,xe2,ye2;
    public static int s1(){
        if (ys1==ye1)return 1;
        else if (xs1==xe1)return -1;
        else return 0;
    }
    public static int s2(){
        if (ys2==ye2)return 1;
        else if (xs2==xe2)return -1;
        else return 0;
    }
    public static boolean vers1(){
        int s1=(ys1>ye1)?ys1:ye1;
        int e1=(ys1+ye1)-s1;
        int s2=(xe2>xs2)?xs2:xe2;
        int e2=(xe2+xs2)-s2;
        if ((s2==xs1)&&(ys2==e1))return true;
        else if ((e2==xs1)&&(ys2==e1))return true;
        else if ((xs1==s2)&&(ys2==s1))return true;
        else if ((e2==xs1)&&(ys2==s1))return true;
        else return false;
    }
    public static boolean vers2(){
        int s1=(xs1>xe1)?xe1:xs1;
        int e1=(xs1+xe1)-s1;
        int s2=(ys2>ye2)?ys2:ye2;
        int e2=(ys2+ye2)-s2;
        if ((s1==xs2)&&(e2==ys1))return true;
        else if ((xs2==e1)&&(e2==ys1))return true;
        else if ((s1==xs2)&&(ys1==s2))return true;
        else if ((e1==xs2)&&(s2==ys1))return true;
        else return false;
    }
    public static boolean xaxis(){
            int s1=(xs1>xe1)?xe1:xs1;
            int s2=(xs2>xe2)?xe2:xs2;
            int e1=(xs1+xe1)-s1;
            int e2=(xs2+xe2)-s2;
            if ((s1==s2)&&(e1==e2))return true;
            else if ((s1<s2)&&(s2<e1)&&(e1<e2))return true;
            else if ((s2<s1)&&(s1<e2)&&(e2<e1))return true;
            else if ((s1<s2)&&(s2<e2)&&(e2<e1))return true;
            else if ((s2<s1)&&(s1<e1)&&(e1<e2))return true;
            else return false;
        
    }
    public static boolean yaxis(){
            int s1=(ys1>ye1)?ye1:ys1;
            int s2=(ys2>ye2)?ye2:ys2;
            int e1=(ys1+ye1)-s1;
            int e2=(ys2+ye2)-s2;
            if ((s1==s2)&&(e1==e2))return true;
            else if ((s1<s2)&&(s2<e1)&&(e1<e2))return true;
            else if ((s2<s1)&&(s1<e2)&&(e2<e1))return true;
            else if ((s1<s2)&&(s2<e2)&&(e2<e1))return true;
            else if ((s2<s1)&&(s1<e1)&&(e1<e2))return true;
            else return false;   
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            xs1=Reader.nextInt();
            ys1=Reader.nextInt();
            xe1=Reader.nextInt();
            ye1=Reader.nextInt();
            xs2=Reader.nextInt();
            ys2=Reader.nextInt();
            xe2=Reader.nextInt();
            ye2=Reader.nextInt();        
            //System.out.println(yaxis());
            if ((xs1==xe1)&&(ys1==ye1)&&(xs2==xe2)&&(ys2==ye2)){
                if ((xs1==xs2)&&(ys1==ys2))System.out.println("yes");
                else System.out.println("no");

            }
            else if ((xs1==xe1)&&(ys1==ye1)){
                int p=s2();
                if (p==1){
                    int s2=(xs2>xe2)?xe2:xs2;
                    int e2=(xs2+xe2)-s2;
                    if ((ys1==ys2)&&(xs1>=s2)&&(xs1<=e2))System.out.println("yes");
                    else System.out.println("no");
                }
                else if (p==-1){
                    int s2=(ys2>ye2)?ys2:ye2;
                    int e2=(ys2+ye2)-s2;
                    if ((xs1==xs2)&&(ys1>=s2)&&(ys1<=e2))System.out.println("yes");
                    else System.out.println("no");
                }
            }
            else if ((xs2==xe2)&&(ys2==ye2)){
                int p=s1();
                if (p==1){
                    int s1=(xs1>xe1)?xe1:xs1;
                    int e1=(xs1+xe1)-s1;
                    if((ys2==ys1)&&(xs2>=s1)&&(xs2<=e1))System.out.println("yes");
                    else System.out.println("no"); 
                }
                else if (p==-1){
                    int s1=(ys1>ye1)?ys1:ye1;
                    int e1=(ys1+ye1)-s1;
                    if ((xs1==xs2)&&(ys2>=s1)&&(ys2<=e1))System.out.println("yes");
                    else System.out.println("no");
                }
            }
            else{
                int o1=s1();
                int o2=s2();
                //System.out.println(o1+" "+o2);
                if ((o1==1)&&(o2==1)){
                    if (xaxis()==true)System.out.println("yes");
                    else System.out.println("no");
                }
                else if ((o1==-1)&&(o2==-1)){
                    if (yaxis()==true)System.out.println("yes");
                    else System.out.println("no");
                }
                else if ((o1==-1)&&(o2==1)){
                    if (vers1()==true)System.out.println("yes");
                    else System.out.println("no");
                }
                else if ((o1==1)&&(o2==-1)){
                    if (vers2()==true)System.out.println("yes");
                    else System.out.println("no");
                }
            }
        }
    }
}