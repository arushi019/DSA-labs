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
class stack{
    int[] a=new int[4000];
    int top;
    int num;
    public stack(){
        top=-1;
    }
    stack push(int val){
        top++;
        a[top]=val;
        return this;
    }
    int pop(){
        //int temp=-1;
        //if (top!=0){
        int temp=a[top];
        top--;
        return temp;
    }
    int peek(){
        return a[top];
    }
    /*int peeknext(){
        return a[top+1];
    }*/
}
public class stacktest{
    //static stack a1,a2,s1,pro;
    public static stack add(stack a1,stack a2,stack s1){
        disp(a1);
        disp(a2);
        int len2=(a1.top>=a2.top)?a1.top:a2.top;
        int len=(a1.top>=a2.top)?a2.top:a1.top;
        //System.out.println(a1.top+" "+a2.top);
        len++;
        int i=0;
        int onebit;
        int flag=0;
        while(i<len){
            //onebit=a1.pop()+a2.pop();
            onebit=a1.a[a1.top-i]+a2.a[a2.top-i];
            //System.out.println(onebit);
            if (flag==0){
            if (onebit<10)
            s1.push(onebit);
            else{
                s1.push(onebit-10);
                flag=1;
            }
        }
        else if (flag==1){
            if (onebit<9){
                s1.push(1+onebit);
                flag=0;
            }
            else{
                s1.push(onebit-9);
                flag=1;
            }
        }
        i++;
    }
        //System.out.println("s1.top= "+s1.top+" a1.top= "+a1.top+" a2.top= "+a2.top);
        int pt=(a1.top>=a2.top)?a1.top:a2.top;
        int f2;
        if (pt==a1.top)f2=1;
        else f2=2;
        //pt++;
        int n=len2; 
        int j=len-1;
        //System.out.println("j= "+j+" n= "+n);
        while(j<n){
            if (f2==1){
                //onebit=a1.pop();
                onebit=a1.a[n-j-1];
                //System.out.println("j= "+j+" n= "+n);
                //System.out.println("aye aye "+onebit+" "+flag);
                if (onebit<9){
                    s1.push(flag+onebit);
                    flag=0;
                }
                else if ((onebit==9)&&(flag==0)){
                    s1.push(9);
                    flag=0;
                }
                else if ((onebit==9)&&(flag==1)){
                    s1.push(0);
                    flag=1;
                }
            }
            else if (f2==2){
                //onebit=a2.pop();
                onebit=a2.a[n-j-1];
                //System.out.println("j= "+j+" n= "+n);
                //System.out.println(onebit+" aye aye");
                if (onebit<9){
                    s1.push(flag+onebit);
                    flag=0;
                }
                else if ((onebit==9)&&(flag==0)){
                    s1.push(9);
                    flag=0;
                }
                else if ((onebit==9)&&(flag==1)){
                    s1.push(0);
                    flag=1;
                }
            }
            j++;
        }
        if (flag==1){
            s1.push(1);
            flag=0;
        }
        //System.out.println("j= "+j+" n= "+n);
        /*int temp=a1.peek()+a2.peek();
        System.out.println(a1.top+" "+a2.top);
        int len=(a1.top>=a2.top)?a2.top:a1.top;
        len++;
        int i=0;
        int flag=0;
        while(i<len){
            temp=a1.peek()+a2.peek();
            if ((temp<10)&&(flag==0))s1.push(temp);
            else if ((temp>10)&&(flag==0)){
                s1.push(temp-10);
                flag=1; 
            }
            else if ((temp<9)&&(flag==1)){
                s1.push(temp+1);
                flag=0;
            }
            else if ((temp>9)&&(flag==1)){
                s1.push(temp-9);
                flag=1;
            }
            i++;
        }
        while(i<=a1.top){
            if ((a1.peek()<9)&&(flag==0))s1.push(a1.peek());
            else if ((a1.peek()<9)&&(flag==1)){
                s1.push(a1.peek()+1);
            }
        }*/
        //for (int j=0;j<len;j++)System.out.print(s1.a[j]+" ");
        //disp(s1);
        //s1=revstack(s1);
        System.out.print("s1= ");
        disp(s1);
        return s1;
    }
    public static void multiply(int n1,stack n2){
        int i;
        stack pro=new stack();
        stack temp=new stack();
        //stack temp=revstack(n2);
        int bit;
        for (i=0;i<n1;i++){
            /*add(n2,n2,temp);
            add(temp,pro,pro);
            temp=new stack();*/
            add(pro,n2,temp);
            add(temp,pro,pro);
            //disp(pro);
        }
        //stack temp=numtostack(n2.num);
        //stack temp=n2;
        //disp(n2.push(0));
        //disp(temp);
        /*for (i=0;i<n1;i++){
            //temp.push(0);
            //disp(temp);
            disp(n2);
            pro=add(n2,n2,pro);
        }
        disp(pro);*/

    } 
    public static stack revstack(stack t){
        int i=t.top;
        //disp(t);
        stack r=new stack();
        while(i>=0){
            r.a[t.top-i]=t.a[i];
            r.top++;
            i--;
        }
        //disp(r);
        return r;
    }
    public static stack numtostack(int num){
        //string opertions are time expensive
        stack t=new stack();
        String st=new String();
        st=String.valueOf(num);
        int len=st.length();
        t.top=len-1;
        t.num=num;
        while (len-->0){
            t.a[len]=num%10;
            num=num/10;
        }
        //t.num=num;
        return t;
    }
    public static void disp(stack t){
        for (int i=0;i<=t.top;i++)System.out.print(t.a[i]);
        System.out.println();
    }
    public static void main(String[] args)throws IOException{
        stack aa1,aa2,s1;
        aa1=new stack();
        aa2=new stack();
        s1=new stack();
        Reader.init(System.in);
        int n1=Reader.nextInt();
        aa1=numtostack(n1);
        /*int n2=Reader.nextInt();
        aa2=numtostack(n2);*/
        //disp(aa1);
        //disp(aa2);
        //a1.push(4);
        //a1.push(5);
        //a2.push(3);
        //a2.push(3);
        //add(aa1,aa2,s1);
        multiply(5,aa1);
        //revstack(numtostack(5600));
    }
}