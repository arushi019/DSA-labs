//Arushi Chauhan
//2016019
//Sec-A Grp-2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;

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
    //defines a stack consisting of integers
    int[] a=new int[20000];
    int num;
    int top;
    stack(){
        top=0;
    }
    public void push(int val){
        //pushes a value at the top of stack
        a[top]=val;
        top++;
    }
    public int pop(){
        //pops a value at the top of the stack
        if (top!=0){
        top--;
        int temp=a[top];
        //a[top]=0;
        return temp;
    }
    else return -1;
    }
}
public class fact{
    public static stack numstck(int n){
        //converts a given integer to a stack in which each digit is a node in the stack
        stack st=new stack();
        st.num=n;
        while(n>0){
            st.push(n%10);
            n=n/10;
        }
        return st;
        //returns stack in reverse order i.e. ones in a[0], tens in a[1] and so on
    }
    public static void disp(stack s){
        //displays number stored in stack by popping each digit
        /*int i;
        for (i=0;i<s.top;i++)System.out.print(s.a[i]);
        System.out.println();*/
        //stack c1=new stack();
        int v1;
        while (s.top!=0){
            v1=s.pop();
            //c1.push(v1);
            System.out.print(v1);
        }
        //s=revstack(c1);
        //System.out.println();
    }
    public static stack add(stack s1,stack s2){
        //takes two stacks, adds them and stores the results in an empty stack
        //the empty stack stores values as reverse i.e. ones in a[0], tens in a[1] etc. and returns the same stack
        stack r1=revstack(s1);
        stack r2=revstack(s2);
        stack cc1=new stack();
        stack cc2=new stack();
        stack sum=new stack();
        int il=(r1.top>=r2.top)?r2.top:r1.top;
        int ih=(r1.top>=r2.top)?r1.top:r2.top;
        int dh=ih;
        int dl=il;
        int onebit,flag=0,v1,v2;
        //flag corresponds to carry over generated after adding two digits
        while (dl-->0){
            v1=r1.pop();
            v2=r2.pop();
            cc1.push(v1);
            cc2.push(v2);
            onebit=v1+v2;
            if (flag==0){
                if (onebit<10){
                    sum.push(onebit);
                    flag=0;
                }
                else{
                    sum.push(onebit-10);
                    flag=1;
                }
            }
            else if (flag==1){
                if (onebit<9){
                    sum.push(onebit+1);
                    flag=0;
                }
                else{
                    sum.push(onebit-9);
                    flag=1;
                }
            }
        }
    int n1=r1.top;
    int n2=r2.top;
    int c1=n1;
    int c2=n2;
        if (n1>0){
        while (c1-->0){
            v1=r1.pop();
            cc1.push(v1);
            onebit=v1;
            if (flag==0){
                sum.push(onebit);
                flag=0;
            }
            else if (flag==1){
                if (onebit<9){
                    sum.push(onebit+1);
                    flag=0;
                }
                else{
                    sum.push(onebit-9);
                    flag=1;
                }
            }
        
        }
    }
       //disp(r1);
       //disp(r2);
    //System.out.println(r1.top);
       else if (n2>0){
        while (c2-->0){
            v2=r2.pop();
            cc2.push(v2);
            onebit=v2;
            if (flag==0){
                sum.push(onebit);
                flag=0;
            }
            else if (flag==1){
                if (onebit<9){
                    sum.push(onebit+1);
                    flag=0;
                }
                else {
                    sum.push(onebit-9);
                    flag=1;
                }
            }
            
        }
    }
        if (flag==1){
            sum.push(1);
            flag=0;
        }
        //System.out.print("add at work ");
        //disp(sum);*/
            //for (int j=0;j<sum.top;j++)System.out.print(sum.a[j]);
        s1=revstack(cc1);
        s2=revstack(cc2);
        //disp(s1);
        //disp(s2);
        return sum;
        //return r1;
    }
    public static stack multiplybit(stack f1,int n){
        //multiplies the number stored in stack with single digit integer n and stores the result in empty stack
        //the product is returned in reverse i.e. ones in a[0], tens in a[1]....
        int i=0;
        int onepro,flag=0,mewtwo;
        stack pro=new stack();
        while(i<f1.top){
            onepro=f1.a[i]*n;
            if (flag==0){
                if (onepro<10){
                pro.push(onepro);
                flag=0;
                }
                else if (onepro>=10){
                    pro.push(onepro%10);
                    flag=onepro/10;
                }
            }
            else if (flag>0){
                mewtwo=onepro+flag;
                pro.push(mewtwo%10);
                flag=mewtwo/10;
            }
        i++;
        }
        if (flag>0){
            pro.push(flag);
            flag=0;
        }
        //System.out.print("multiplybit at work ");
        //disp(pro);
        return pro;
    }

    public static stack revstack(stack f1){
        //function to reverse the stack
        //returns a new stack containing the values stored in argument stack in reverse order
        stack rev=new stack();
        int i=0;
        while (f1.top!=0){
            rev.push(f1.pop());
            //i++;
        }
        //System.out.print("revstack at work ");
        //disp(rev);
        return rev;
    }
    /*public static stack copy(stack s1){
        stack t1=revstack(s1);
        stack cp=new stack();
        while(t1.top!=0){
            cp.push(t1.pop());
        }
        return cp;
    }*/
    public static stack multiply(stack f1,int n){
        //function to multiply two numbers, one in the form of stack and other as an integer
        stack temp= new stack();
        stack final_sum=new stack();
        stack t=new stack();
        int j=0,k=0;
        while(n>0){
            temp=multiplybit(f1,n%10);
            k=0;
            temp=revstack(temp);
            while(k<j){temp.push(0);k++;}
            //disp(final_sum);
            temp=revstack(temp);
            t=add(final_sum,temp);
            final_sum=t;
            //disp(final_sum);
            n=n/10;
            j++;
        }
        //disp(final_sum);
        return final_sum;
    }
    public static stack factorial(int n){
        //function to calculate factorial of an integer n
        //returns the stack containing the value of factorial
        int i=n;
        stack f1=numstck(n);
        //disp(f1);
        while (i-->1){
            //System.out.println(i);
            //disp(numstck(i));
            //disp(f1);
            //for (int j=0;j<f1.top;j++)System.out.print(f1.a[j]);
            f1=multiply(f1,i);
        }
        //disp(revstack(f1));
        return f1;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        //disp(numstck(n1));
        //int n2=Reader.nextInt();
        //disp(add(numstck(n1),numstck(n1)));
        //disp(numstck(n1));
        //disp(numstck(n2));
        //disp(multiplybit(numstck(n1),n2));
        //multiply(numstck(n1),n2);
        //revstack(numstck(n1));
        //long t1=System.currentTimeMillis();
        disp(factorial(n1));
        //disp(multiply(numstck(n1),n2));
        //long t2=System.currentTimeMillis();
        //System.out.println(t2-t1);
    }
}