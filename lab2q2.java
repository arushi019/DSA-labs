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
 //Q2 refresher module-Arushi Chauhan-2016019-sec-a

 
 
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
class account{
    String name;
    String addr;
    double balance;
    long num;
    public static int ct;
    public account(String name,String addr,double balance,long num){
        this.name=name;
        this.addr=addr;
        this.balance=balance;
        this.num=num;
        ct++;
    }
    public String toString(){
        return (this.name+" "+this.addr+" "+this.balance+" "+this.num);
    }
    public void debit(double deb){
        if (deb>=this.balance)System.out.println("insufficient balance");
        else{
            if ((this.balance<=500)||(this.balance-deb<=500)){
                this.balance=this.balance-deb-5;
            }
            else{
                this.balance=this.balance-deb;
            }
        }
    }
    public void credit(double cred){
        this.balance+=cred;
    }
    public void checkbal(){
        System.out.println("Rs. "+this.balance);
    }
}
class lab2q2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        account[] ac=new account[20];
        for (int i=0;i<20;i++){
            ac[i]=new account("xyz","def",1000,(long)i);
        }
        System.out.println("Enter account number");
        int ac1=Reader.nextInt();
        System.out.println("\nMenu\n1.Credit\n2.Debit\n3.Check Balance\n4.Enter another account\n5.Exit");
        System.out.println("Select option number: ");
        int ch=Reader.nextInt();
        while(ch!=5){
            if (ch==1){
                System.out.println("Enter amount to deposit");
                double cred=Reader.nextDouble();
                ac[ac1].credit(cred);
            }
            else if (ch==2){
                System.out.println("Enter amount to withdraw");
                double deb=Reader.nextDouble();
                ac[ac1].debit(deb);
            }
            else if (ch==3){
                ac[ac1].checkbal();
            }
            else if (ch==4){
                System.out.println("Enter account number");
                ac1=Reader.nextInt();
                System.out.println("\nMenu\n1.Credit\n2.Debit\n3.Check Balance\n4.Enter another account\n5.Exit");
                //System.out.println("Select option number: ");
                //int ch=Reader.nextInt();
            }
            System.out.println("Select option number");
            ch=Reader.nextInt();
        }
    }
}