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
public class stack{
    int a[]=new int[100];
    int top;
    int max;
    stack(int max){
        top=-1;
        this.max=max;
    }
    public void insert(int key){
        if (top!=(max-1)){
            top++;
            a[top]=key;
        }else System.out.println("Stack is full!");
        display();
    }
    public void delete(){
        if (top!=-1){
            a[top]=0;
            top--;
        }else System.out.println("Stack is empty!");
        display();
    }
    public void display(){
        int i;
        for (i=0;i<(top+1);i++)
            System.out.print(a[i]+" ");
    }
    public static void main(String[] args) throws IOException{
        int ch,k;
        Reader.init(System.in);
        System.out.println("Enter max size of stack ");
        k=Reader.nextInt();
        stack s=new stack(k);
        do{
            System.out.println("Enter what do you want to do-1.insert,2.delete,3.display,4.exit ");
            ch=Reader.nextInt();
            switch(ch){
                case 1:System.out.println("Enter value to be inserted ");
                        k=Reader.nextInt();
                        s.insert(k);
                        break;
                case 2:s.delete();
                        break;
                case 3:s.display();
                        break;
            }
        }while(ch!=4);
    }
}