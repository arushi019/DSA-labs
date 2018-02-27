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
public class queue{
    int a[]=new int[100];
    int fr;
    int rr;
    int max;
    queue(int max){
        this.max=max;
        fr=0;
        rr=-1;
    }
    
    public void insert(int key){
        if (rr!=(max-1)){
            rr++;
            a[rr]=key;
        }else {
            System.out.println("Queue full!");
        }
        display();
    }
    public void delete(){
        if (fr!=rr){
            a[fr]=0;
            fr++;
        }else System.out.println("Queue empty");
        display();
    }
    public void display(){
        int i;
        for (i=fr;i<=rr;i++)System.out.print(a[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) throws IOException{
        int ch,k;
        Reader.init(System.in);
        System.out.println("Enter max size of queue ");
        k=Reader.nextInt();
        queue q=new queue(k);
        do{
            System.out.println("Enter what do you want to do-1.insert,2.delete,3.display,4.exit ");
            ch=Reader.nextInt();
            switch(ch){
                case 1:System.out.println("Enter value to be inserted ");
                        k=Reader.nextInt();
                        q.insert(k);
                        break;
                case 2:q.delete();
                        break;
                case 3:q.display();
                        break;
            }
        }while(ch!=4);
    }
}