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
public class tut1{
    static int[] a;
    static int n;
    tut1()throws IOException{
        Reader.init(System.in);
        n=Reader.nextInt();
        a=new int[1000];
        for (int i=0;i<n;i++)this.a[i]=Reader.nextInt();
    }
    public static int search(int key){
        //use binary search
        int i;
        int low=0;
        int high=n-1;
        int mid;
        int pos=-1;
        mid=(low+high)/2;
        while (low<=high){
            //mid=(low+high)/2;
            if (a[mid]==key){
                System.out.println("found");
                return mid;
            }
            else if (key>a[mid]){
                System.out.println("case 1 "+key+" "+a[mid]);
                low=mid+1;
                mid=(low+high)/2;
                System.out.println("mid now "+a[mid]);
            }
            else if(key<a[mid]){
                System.out.println("case 2 "+key+" "+a[mid]);
                high=mid-1;
                mid=(low+high)/2;
                System.out.println("mid now "+a[mid]);
            }

        }
        return -1;
    }
    public static void disp(){
        int i;
        for (i=0;i<n;i++)System.out.print(a[i]+" ");
        System.out.println();
    }
    public static void ins(int key,int pos){
        int i,temp;
        for (i=n-1;i>=pos;i--){
            temp=a[i+1];
            a[i+1]=a[i];
            a[i]=temp;
        }
        a[pos]=key;
    }
    public static void del(int key){
        if (search(key)!=-1){
            int i,temp;
            for (i=search(key);i<n-1;i++){
                temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
            a[n-1]=0;
        }
        else System.out.println("Number not found");

    }
    public static void main(String[] args)throws IOException{
    Reader.init(System.in);
    tut1 t=new tut1();
    int ch;
    int key,pos;
    do{
        System.out.println("Enter choice");
        ch=Reader.nextInt();
        switch(ch){
            case 1:key=Reader.nextInt();
                    System.out.println(t.search(key));
                    break;
            case 2:t.disp();
                    break;
            case 3:key=Reader.nextInt();
                    pos=Reader.nextInt();
                    t.ins(key,pos);
                    break;
            case 4:key=Reader.nextInt();
                    t.del(key);
                    break;
        }
    }
    while (ch!=5);

    }
    
}                                                                                                                                                
