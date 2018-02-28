//Arushi Chauhan
//2016019
//Sec- A Grp -2

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
/*
------------------------------------------------------------------


1. + represents multiplication
2. - represents addition
3. * represents division
4. / represents subtraction or negative unary operator ( / 3 means negative 3).

------------------------------------------------------------------
*/

public class intopost{
    static int op_top=0;
    static int opt_top=0;
    public static int prio(char c1,char c2){
        int k1=(int)c1;
        int k2=(int)c2;
        /*if ((k1==126)&&(k2!=126))return 1;
        if ((k2==126)&&(k1!=126))return 2;
        if ((k1==126)&&(k2==126))return 4;
        if ((k1==43)||(k1==42)){
            if ((k2==45)||(k2==47))return 1;
            else if((k2==43)||(k2==42))return 0;
        }
        if ((k2==43)||(k2==42)){
            if ((k1==45)||(k1==47))return 2;
            else if ((k1==43)||(k1==42)) return 0;
        }
        return 3;*/
        //0=equal precedence: left to right :pop then push
        //1=c1 is higher:pop then push
        //2=c2 is higher: push
        //3=equal precedence: right to left: push
        if (k1==126){
            if(k2==126)return 3;
            if(k2!=126)return 1;
        }
        else if ((k1==43)||(k1==42)){
            if (k2==126)return 2;
            else if (k2==43)return 0;
            else if (k2==42)return 0;
            else return 1;
        }
        else if ((k1==45)||(k1==47)){
            if (k2==126)return 2;
            else if ((k2==43)||(k2==42))return 2;
            else if ((k2==45)||(k2==47))return 0;
            else return 1;
        }
        return 3;

        
        /*//if operators are of equal precedence
        if ((k1==k2)||((k1==42)&&(k2==47))||((k1==43)&&(k2==45)))return 0;
        //if c1 has higher precedence than c2
        if ((k1==42)||(k1==47))return 1;
        //if c2 has higher precedence
        return 2;*/
    }
    public static void disp(char[] op){
        int i;
        for (i=0;i<op_top;i++)System.out.print(op[i]+" ");
        System.out.println();
    }
    public static void action(char[] op,char c2,char[] opt){
        //op_top=operator stack top
        //opt_top=output stack top
        char c1=op[op_top-1];
        int pri=prio(c1,c2);
        //System.out.println(op_top);
        //char c1 is the top most element in operator in the stack
        //if c2 has higher precedence-->pop c1 and place c2 in stack
        //i guess this goes in a loop-->not implemented yet
        if((pri==2)||(pri==3)){
            /*opt[opt_top]=c1;
            opt_top++;
            op[op_top-1]=c2;
            System.out.println(pri);
            System.out.println(c1+" pushed at "+opt_top);
            System.out.println(c2+" pushed at "+op_top+" in operator stack");
            disp(op);*/
            //System.out.println(pri);
            op[op_top]=c2;
            op_top++;
            //c1=op[op_top];
            //pri=prio(c1,c2);
        }
        //if c2 has lower precedence-->push c2 into operator stack and increment top
        if ((pri==1)||(pri==0)){
            //System.out.println(pri);
        while((op_top>1)&&((pri==1)||(pri==0))){
            /*op[op_top]=c2;
            op_top++;
            System.out.println(pri);
            System.out.println(c2+" pushed at "+op_top+" in operator stack");
            disp(op);*/
            c1=op[op_top-1];
            opt[opt_top]=c1;
            opt_top++;
            op[op_top-1]='\u0000';
            op_top--;
            pri=prio(op[op_top-1],c2);
            //System.out.println(op_top);
            //disp(op);
        }
        if((op_top==1)&&((prio(op[op_top-1],c2)==1)||(prio(op[op_top-1],c2)==0))){
            opt[opt_top]=op[op_top-1];
            opt_top++;
            op[op_top-1]=c2;
        }
        else{
        op[op_top]=c2;
        op_top++;
    }
    }
    /*if (pri==4){
        op[op_top]=c2;
        op_top++;
    }*/
        //if both have equal precedence
        /*if (pri==0){
            op[op_top]=c2;
            op_top++;
            disp(op);
            opt[opt_top]=c1;
            op[op_top-1]=c2;
            opt_top++;
            System.out.println(pri);
            System.out.println(c1+" pushed at "+opt_top);
            System.out.println(c2+" pushed at "+op_top+" in operator stack");
            disp(op);
        }*/
        //
        //disp(op);

    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        //declare array of chars
        char[] output=new char[n+1];
        char[] operator=new char[n+1];
        char[] input=new char[n];
        //ek saare operators wala test case bhi chala ke dekhna
        int i=0;
        int flag=-1;
        //int o_top=0;//top position indicator of output stack
        //int op_top=0;//top position indicator of operator stack
        while(i<n){
            String st=Reader.next();
            char ch=st.charAt(0);
            input[i]=ch;
        //----------------------------------------------------------------------------------------------
            if (((int)ch>47)&&((int)ch<58)){
                //pushing numbers to output stack
                //print operands as they arrive
                output[opt_top]=ch;
                opt_top++;
                //System.out.println("push "+ch+" when opt_top= "+opt_top);
            }
        //-------------------------------------------------------------------------------------------
            else if ((int)ch==40){
                //if we encounter ( ,push it on the operator stack
                operator[op_top]=ch;
                op_top++;
                //disp(operator);
                }
            else if ((int)ch==41){
                //if we encounter ), operator stack is cleared and ( removed from stack
                //op_top will never be 0 since it is insured that we get a ( before a )
                while ((int)operator[op_top-1]!=40){
                    output[opt_top]=operator[op_top-1];
                    opt_top++;
                    operator[op_top-1]='\u0000';
                    op_top--;                    
                }
                operator[op_top-1]='\u0000';
                op_top--;
                //disp(operator);
            }
            //-----------------------------------------------------------------------------------------
            else{
                //System.out.println("action "+(int)ch);
                if ((op_top==0)||((op_top!=0)&&((int)operator[op_top-1]==40))){
                    //checks idiot
                    //push incoming operator when stack is empty or the top most element in operator stack is (
                    //need to incorporate ~ condition here(or where we get the closing parenthesis)
                    if ((int)ch!=47){
                    operator[op_top]=ch;
                    op_top++;
                    //action(operator,ch,output);
                    }
                    else if((int)ch==47){
                        if((op_top!=0)&&((int)input[i-1]==40)){
                            //if ((i>0)&&(Character.isDigit(input[i-1])==false)){
                                //System.out.println(input[i-1]+" "+operator[op_top-1]);
                            operator[op_top]=(char)126;
                            op_top++;}
                            /*flag=0;
                            output[opt_top]='~';
                            opt_top++;
                            operator[op_top-1]='\u0000';
                            op_top--;*/
                            /*else{
                                operator[op_top]=ch;
                                op_top++;
                            }*/
                        
                        else{
                            /*output[opt_top]=ch;
                            opt_top++;*/
                            operator[op_top]=ch;
                            op_top++;
                        }
                    }
                    //disp(operator);
                }
            //------------------------------------------------------------------------------------------
                else
                    //System.out.println("action "+ch);
                    action(operator,ch,output);

            }
            i++;
        }
        //push the leftovers in operator stack to output stack
        //System.out.println("push leftovers "+op_top);
        for (i=op_top-1;i>=0;i--){
            //System.out.println((int)operator[i]);
            if (((int)operator[i]!=40)&&((int)operator[i]!=41))
            {output[opt_top]=operator[i];
            opt_top++;}
        }
    for (i=0;i<n;i++){
        if (output[i]!='\u0000')System.out.print(output[i]+" ");}
    //--------------------------------------------------------------------------------------------------------    
    }
}