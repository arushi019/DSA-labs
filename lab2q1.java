import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.Point;
import java.text.DecimalFormat;
 //Q1 refresher module-Arushi Chauhan-2016019-sec-a

 
 
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class triangle{
    int s1;
    int s2;
    int s3;
    public triangle(){
        //
    }
    public triangle(int s1,int s2,int s3){
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
    }
    public int getSide1(){
        return this.s1;
    }
    public int getSide2(){
        return this.s2;
    }
    public int getSide3(){
        return this.s3;
    }
    public void setSide1(int s1){
        this.s1=s1;
    }
    public void setSide2(int s2){
        this.s2=s2;
    }
    public void setSide3(int s3){
        this.s3=s3;
    }
    public boolean isitright(){
        int h=this.getSide1()>this.getSide2()?(this.getSide1()>this.getSide3()?this.getSide1():this.getSide3()):(this.getSide2()>this.getSide3()?this.getSide2():this.getSide3());
        if (h==this.getSide1()){
            double h1=h*h;
            double l1=this.getSide2()*this.getSide2()+this.getSide3()*this.getSide3();
            if (h1==l1)return true;
            else return false;
        }
        if (h==this.getSide2()){
            double h1=h*h;
            double l1=this.getSide1()*this.getSide1()+this.getSide3()*this.getSide3();
            if (h1==l1)return true;
            else return false;
        }
        if (h==this.getSide3()){
            double h1=h*h;
            double l1=this.getSide2()*this.getSide2()+this.getSide1()*this.getSide1();
            if (h1==l1)return true;
            else return false;
        }
        return false;
    }
    public void typeoftriangle(){
        if (this.isitright()==true)System.out.println("right triangle");
        if ((this.getSide1()!=this.getSide2())&&(this.getSide2()!=this.getSide3()))System.out.println("scalene");    
        else if ((this.getSide1()==this.getSide2())&&(this.getSide2()==this.getSide3()))System.out.println("equilateral");    
        else System.out.println("isosceles");
    }   
}
class lab2q1{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        System.out.println("Enter 3 sides of triangle");
        int s1=Reader.nextInt();
        int s2=Reader.nextInt();
        int s3=Reader.nextInt();
        triangle t1=new triangle(s1,s2,s3);
        t1.typeoftriangle();
    }
}