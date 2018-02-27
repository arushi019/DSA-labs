import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
 
 
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
class voter{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        int n2=Reader.nextInt();
        int n3=Reader.nextInt();
        int[] a1=new int[n1];
        int[] a2=new int[n2];
        int[] a3=new int[n3];
        int p1=0;
        int p2=0;
        int p3=0;
        int i=0;
        while(i<n1){
            a1[i]=Reader.nextInt();
            i++;
        }
        i=0;
        while(i<n2){
            a2[i]=Reader.nextInt();
            i++;
        }
        i=0;
        while(i<n3){
            a3[i]=Reader.nextInt();
            i++;
        }
        ArrayList<Integer> a=new ArrayList<Integer>();
        while((p1<n1)&&(p2<n2)&&(p3<n3)){
            boolean b1=(a1[p1]==a2[p2]);
            boolean b2=(a2[p2]==a3[p3]);
            boolean b3=(a3[p3]==a1[p1]);
            if (b1&&b2&&b3){
                //System.out.println("condition 1");
                a.add(a1[p1]);
                p1++;
                p2++;
                p3++;
            }
            else if (b1||b2||b3){
                //System.out.println("condition 2");
                if (b1){
                    a.add(a1[p1]);
                    p1++;
                    p2++;
                    while((p3<n3)&&(a3[p3]<a1[p1])){
                        p3++;
                    }
                }
                if (b2){
                    a.add(a2[p2]);
                    p3++;
                    p2++;
                    while((p1<n1)&&(a1[p1]<a2[p2])){
                        p1++;
                    }
                }
                if (b3){
                    a.add(a3[p3]);
                    p1++;
                    p3++;
                    while((p2<n2)&&(a2[p2]<a1[p1])){
                        p2++;
                    }
                }
            }
            else{
                //System.out.println("condition 3");
                int flag=0;
                while((p1<n1)&&(a1[p1]<a2[p2])&&(a1[p1]<a3[p3])){
                    p1++;
                    flag=1;
                }
                if (flag==1){
                //    System.out.println(a1[p1]+" "+a2[p2]+" "+a3[p3]);
                    continue;
                }
                flag=0;
                while((p2<n2)&&(a2[p2]<a1[p1])&&(a2[p2]<a3[p3])){
                    p2++;
                    flag=1;
                }
                if (flag==1){
                //    System.out.println(a1[p1]+" "+a2[p2]+" "+a3[p3]);
                    continue;
                }
                flag=0;
                while((p3<n3)&&(a3[p3]<a1[p1])&&(a3[p3]<a2[p2])){
                    p3++;
                }
                if (flag==1){
                //    System.out.println(a1[p1]+" "+a2[p2]+" "+a3[p3]);
                    continue;
                }
            }
            //System.out.println(a);
            //if ((p1<n1)&&(p2<n2)&&(p3<n3))System.out.println(a1[p1]+" "+a2[p2]+" "+a3[p3]);
           } 
           while((p1<n1)&&(p2<n2)){
            if (a1[p1]==a2[p2]){
                a.add(a1[p1]);
                p1++;
                p2++;
            }
            else if(a1[p1]<a2[p2]){
                while((p1<n1)&&(p2<n2)&&(a1[p1]<a2[p2]))p1++;
            }
            else{
                while((p1<n1)&&(p2<n2)&&(a2[p2]<a1[p1]))p2++;
            }
           }
           while((p2<n2)&&(p3<n3)){
            if (a3[p3]==a2[p2]){
                a.add(a3[p3]);
                p3++;
                p2++;
            }
            else if(a3[p3]<a2[p2]){
                while((p3<n3)&&(p2<n2)&&(a3[p3]<a2[p2]))p3++;
            }
            else{
                while((p3<n3)&&(p2<n2)&&(a2[p2]<a3[p3]))p2++;
            }
           }           
           while((p1<n1)&&(p3<n3)){
            if (a1[p1]==a3[p3]){
                a.add(a1[p1]);
                p1++;
                p3++;
            }
            else if(a1[p1]<a3[p3]){
                while((p1<n1)&&(p3<n3)&&(a1[p1]<a3[p3]))p1++;
            }
            else{
                while((p1<n1)&&(p3<n3)&&(a3[p3]<a1[p1]))p3++;
            }
           }
           System.out.println(a.size());
           i=0;
           while(i<a.size()){
            System.out.println(a.get(i));
            i++;
           }
        }
    }
