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
class snake{
    public static int xs1,ys1,xe1,ye1,xs2,ys2,xe2,ye2;
    public static boolean p1(){
        if ((xs1==xe1)&&(ys1==ye1))return true;
        else return false;
    }
    public static boolean p2(){
        if ((xs2==xe2)&&(ys2==ye2))return true;
        else return false;
    }
    public static boolean o1(){
        if (xs1==xe1)return true;       //s1 is vertical
        else return false;              //s1 is horizontal
    }
    public static boolean o2(){
        if (xs2==xe2)return true;       //s2 is vertical
        else return false;              //s2 is horizontal
    }
    public static void yaxis(){
        //for s1
        int yst1=(ys1>ye1)?ys1:ye1;
        int yen1=(ys1+ye1)-yst1;
        int x1=xs1;
        //for s2
        int yst2=(ys2>ye2)?ys2:ye2;
        int yen2=(ys2+ye2)-yst2;
        int x2=xs2;
        if (x1==x2){
            if ((yst1>ys2)&&(yst2>yen1)&&(yen1>yen2))System.out.println("yes");
            else if ((yst2>yst1)&&(yst1>yen2)&&(yen2>yen1))System.out.println("yes");
            else if ((yst1>yst2)&&(yst2>yen2)&&(yen2>yen1))System.out.println("yes");           
            else if ((yst2>yst1)&&(yst1>yen1)&&(yen1>yen2))System.out.println("yes");
            else if (yst1==yst2)System.out.println("yes");
            else if (yen1==yen2)System.out.println("yes");
            else if (yst1==yen2)System.out.println("yes");
            else if (yst2==yen1)System.out.println("yes");
            else System.out.println("no");
        }
        else System.out.println("no");
    }
    public static void xaxis(){
        //for s1
        int xst1=(xs1<xe1)?xs1:xe1;
        int xen1=(xs1+xe1)-xst1;
        int y1=ys1;
        //for s2
        int xst2=(xs2<xe2)?xs2:xe2;
        int xen2=(xs2+xe2)-xst2;
        int y2=ys2;
        if (y1==y2){
            if ((xst1<xst2)&&(xst2<xen1)&&(xen1<xen2))System.out.println("yes");
            else if ((xst2<xst1)&&(xst1<xen2)&&(xen2<xen1))System.out.println("yes");
            else if ((xst1<xst2)&&(xst2<xen2)&&(xen2<xen1))System.out.println("yes");
            else if ((xst2<xst1)&&(xst1<xen1)&&(xen1<xen2))System.out.println("yes");
            else if (xst1==xst2)System.out.println("yes");
            else if (xst1==xen2)System.out.println("yes");
            else if (xst2==xen1)System.out.println("yes");
            else if (xen1==xen2)System.out.println("yes");
            else System.out.println("no");            
        }
        else System.out.println("no");
    }
    public static void vers2(){
        //s1 is horizontal and s2 is vertical
        //for s1
        int xst1=(xs1<xe1)?xs1:xe1;
        int xen1=(xs1+xe1)-xst1;
        int y1=ys1;
        //for s2
        int yst2=(ys2>ye2)?ys2:ye2;
        int yen2=(ys2+ye2)-yst2;
        int x2=xs2;
        if ((xst1==x2)&&(y1==yen2))System.out.println("yes");
        else if ((xst1==x2)&&(y1==yst2))System.out.println("yes");
        else if ((xen1==x2)&&(y1==yen2))System.out.println("yes");
        else if ((xen1==x2)&&(y1==yst2))System.out.println("yes");
        else System.out.println("no");
    }
    public static void vers1(){
        //s1 is vertical and s2 is horizontal
        //for s1
        int yst1=(ys1>ye1)?ys1:ye1;
        int yen1=(ys1+ye1)-yst1;
        int x1=xs1;
        //for s2
        int xst2=(xs2<xe2)?xs2:xe2;
        int xen2=(xs2+xe2)-xst2;
        int y2=ys2;
        if ((xst2==x1)&&(y2==yen1))System.out.println("yes");
        else if ((x1==xen2)&&(yen1==y2))System.out.println("yes");
        else if ((xst2==x1)&&(y2==yst1))System.out.println("yes");
        else if ((x1==xen2)&&(yst1==y2))System.out.println("yes");
        else System.out.println("no");
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
            if (p1()&&p2()){
                //if both are points
                if ((xs1==xs2)&&(ys1==ys2))System.out.println("yes");
                else System.out.println("no");
            }
            else if (p1()){
                //if s1 is a point 
                boolean b=o2();
                if (b==true){
                    //if s2 is vertical
                    int ys=(ys2>ye2)?ys2:ye2;
                    int ye=(ys2+ye2)-ys;
                    if ((ys1>=ye)&&(ys1<=ys)&&(xs1==xs2))System.out.println("yes");
                    else System.out.println("no");
                }
                else{
                    //if s2 is horizontal
                    int xs=(xs2<xe2)?xs2:xe2;
                    int xe=(xs2+xe2)-xs;
                    if ((xs1>=xs)&&(xs1<=xe)&&(ys1==ys2))System.out.println("yes");
                    else System.out.println("no");
                }
            }
            else if (p2()){
                //if s2 is a point
                boolean b=o1();
                if (b==true){
                    //if s1 is vertical
                    int ys=(ys1>ye1)?ys1:ye1;
                    int ye=(ys1+ye1)-ys;
                    if ((ys2>=ye)&&(ys2<=ys)&&(xs1==xs2))System.out.println("yes");
                    else System.out.println("no");
                }
                else{
                    //if s1 is horizontal
                    int xs=(xs1<xe1)?xs1:xe1;
                    int xe=(xs1+xe1)-xs;
                    if ((xs2>=xs)&&(xs2<=xe)&&(ys1==ys2))System.out.println("yes");
                    else System.out.println("no");
                }
            }
            else{
                //none of s1,s2 are points
                boolean b1=o1();
                boolean b2=o2();
                if (b1&&b2){
                    //if both are vertical
                    yaxis();
                }
                else if ((!b1)&&(!b2)){
                    //if both are horizontal
                    xaxis();
                }
                else if ((!b1)&&(b2)){
                    //if s1 is horizontal and s2 vertical
                    vers2();
                }
                else{
                    vers1();
                }
            }

        }
    }
}