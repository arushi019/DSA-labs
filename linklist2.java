//Arushi Chauhan 
//2016019
//SEC-A Grp-2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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
//-------------------------------------------------------------------
//declaring node class
class node{
    String st1;
    node next;
    public node(String st1){
        this.st1=st1;
        this.next=null;
    }
}
//-------------------------------------------------------------------
//all linklists in this code are instances of public class linklist2 
public class linklist2{
    node head;
    node tail;
    int len;
    //----------------------------------------------------------------
    //declaring head and tail nodes 
    public linklist2(){
        head=new node("head");
        tail=new node("tail");
        tail.next=null;
        len=2;        
    }
    //add function working fine
    //head nahi iteration ka kaam kar raha hai
    //list ulti aa rahi hai--->ab makhan jaisi chal rahi hai
    //-----------------------------------------------------------------
    //FUNCTION: to add nodes in an empty list
    //USE:when list is initially declared by the user
    //ARGUMENTS: String and an already existing linklist
    public static void add(String st,linklist2 ll){
        //node curr=new node(st);
            //curr.next=ll.realhead;
        //curr.next=ll.head;
        //ll.head=curr;
        //if (ll.len==1){ll.realhead.next=curr;}
        //ll.len++;
        node curr=new node(st);
        if (ll.len==2){
            ll.head.next=curr;
            curr.next=ll.tail;
        }
        else{
            node c=ll.head;
            int i=1;
            while ((c!=null)&&(i<ll.len-1)){c=c.next;i++;}
            c.next=curr;
            curr.next=ll.tail;
        }
        ll.len++;

        /*int i=0;
        node curr=new node(st);
        node ite=ll.head;
        node prev=ll.head;
        while ((ite!=null)&&(i<ll.len)){*/
           /*prev=ite.next;
            ite=ite.next.next;
            System.out.println(ite.next+"<--"+prev.next);*/

            //i++;
        //}
        //ite=curr;
        //prev.next=curr;
        //System.out.println(i+"-->"+ite.st1+" added to linkedlist");
        //ll.len++;
        /*while (i<ll.len){
            //System.out.println(i+"-->"+curr.st1+" added to linkedlist");
            curr=curr.next;
            i++;
        }
        curr.st1=st;
        //ll.len++;*/
    }
    //------------------------------------------------------------------
    //FUNCTION:to display linklist
    //ARGUMENTS:linklist
    public static void disp(linklist2 ll){
        int i=0;
        node curr=ll.head.next;
        //System.out.println(ll.len);
        while ((curr!=ll.tail)&&(i<ll.len)){
            System.out.print(curr.st1+" ");
            curr=curr.next;
            i++;
            //if (i!=ll.len-2)System.out.println();
        }
        System.out.println();
    }
    //problematic in p=1 case-->problem solved
    //------------------------------------------------------------------
    //FUNCTION: to insert a node in the linklist at user-defined position
    //ARGUMENTS: linklist,String and position at which node is to be inserted
    public static int ins(linklist2 ll,String st,int p){
        node adn=new node(st);
        int i=1;
        int flag=-1;
        node curr=ll.head.next;
        node prev=ll.head;
        if (ll.len==2){ll.add(st,ll);return 0;}
        else
        {while ((curr!=null)&&(i<p)){prev=curr;curr=curr.next;i++;}}
        //System.out.println(curr.st1);
        //System.out.println(prev.st1);
        //prev stays in its place
        //curr is the one to be shifted forward
        //increment ll size by 1
        prev.next=adn;
        adn.next=curr;
        ll.len++;
        return 1;
        //disp(ll);
    }
    //problematic in p=1 case------>problem solved
    //------------------------------------------------------------------
    //FUNCTION: to delete a node in the linklist at user-defined position
    //ARGUMENTS: linklist and the position of node which is to be deleted
    public static void del(int p,linklist2 ll){
        int i=1;
        //curr is the node to be deleted
        //prev is the node just before curr
        //dejavu is the node just after curr
        //curr is bali ka bakra
        node curr=ll.head.next;
        node prev=ll.head;
        node dejavu=curr.next;
        while((curr!=null)&&(i<p)){
            curr=curr.next;
            prev=prev.next;
            dejavu=dejavu.next;
            i++;
        }
        prev.next=dejavu;
        ll.len--;
        //disp(ll);
        /*int i=1;
        node curr=ll.head.next.next;
        node prev=ll.head.next;
        node dejavu=ll.head;
        while((curr!=null)&&(i<p)){prev=curr;curr=curr.next;dejavu=curr;i++;}
        prev.next=dejavu;        
        ll.len--;*/
    }
    //-------------------------------------------------------------------
    //FUNCTION: to compare two linklists and return values accordingly
    //ARGUMENTS: two linklists
    //RETURN VALUE: 0 if different, 1 if both are same
    public static int cmp(linklist2 ll1,linklist2 ll2){
        if (ll1.len==ll2.len){
            int i=1;
            node c1=ll1.head;
            node c2=ll2.head;
            while((c1!=null)&&(c2!=null)&&(i<ll1.len)){
                if ((c1.st1.equals(c2.st1))==false) return 0;
                //System.out.println(c1.st1+"<=>"+c2.st1);
                c1=c1.next;
                c2=c2.next;
                i++;
            }
            return 1;
        }
        else return 0;
    }
    //-------------------------------------------------------------------
    //MAIN FUNCTION STARTS HERE
    public static void main(String[] args)throws IOException{
        linklist2 ss=new linklist2();
        int m,q,ch,p,m2;
        int i1;
        String str=new String();
        String str2=new String();
        Reader.init(System.in);
        m=Reader.nextInt();
        q=Reader.nextInt();
        //taking user's input: initial linklist
        for (i1=0;i1<m;i1++){
            str=Reader.next();
            add(str,ss);
            //ss.len++;
        }
        while (q-->0){
            ch=Reader.nextInt();
            //--------------------------------------------------------
            //performing the action as per user's choice
            if (ch==1){
                //if the user wants to insert a node in the linklist
                str=Reader.next();
                p=Reader.nextInt();
                if ((p>0)&&(p<=ss.len-1)){ins(ss,str,p);}
            }
            if (ch==2){
                //if the user wants to delete a node from the linklist
                p=Reader.nextInt();
                //System.out.print(ss.len);
                if ((p>0)&&(p<ss.len-1))del(p,ss);
            }
            //if the user wants to display the linklist
            if (ch==3)disp(ss);
            if (ch==4){
                //if the user wants to compare the existing linklist with another one
                linklist2 s2=new linklist2();
                m2=Reader.nextInt();
                for (i1=0;i1<m2;i1++){
                    str2=Reader.next();
                    add(str2,s2);
                }
                System.out.println(cmp(ss,s2));
            }
        }
        //disp(ss);
    }

}