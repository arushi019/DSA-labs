import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
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
/*class node{
    int value;
    int freq;
    node next;
    node right;
    node left;
    public node(int value,int freq){
        this.value=value;
        this.freq=freq;
        this.right=null;
        this.left=null;
        this.next=null;
    }
}*/
class node{
    int freq;
    int value;
    //boolean intern;
    node next;
    node right;
    node left;
    String code;
    //node2 r;
    //node2 l;
    public node(int freq){
        this.right=null;
        this.left=null;
        this.freq=freq;
        this.value=-1;
        this.next=null;
        this.code="";
        //this.r=null;
        //this.l=null;
    }
    public node(int freq,int value){
        this.freq=freq;
        this.value=value;
        this.right=null;
        this.left=null;
        this.next=null;
        this.code="";
    }
}
public class prior{
    static node head;
    static int[] min;
    static int m;
    static int[] a;
    static int ptr;
    static node head2;
    public static void copy(){
        node it=head;
        head2=new node(head.freq,head.value);
        //head2=null;
        node it2=head2;
        while((it.next!=null)&&(it!=null)){
            it=it.next;
            it2.next=new node(it.freq,it.value);
            it2=it2.next;
        }
        /*it2=head2;
        while(it2!=null){
            System.out.println("copied "+it2.freq+" "+it2.value);
            it2=it2.next;
        }*/
    }
    /*public static void form(int val,int freq){
        int par,pos;
        if(ptr<=m){
            min[ptr]=val;
            //disp();
            par=ptr/2;
            pos=ptr;
            //System.out.println(ptr);
            while((ptr!=1)&&(freq>a[min[par]])){
                //par=ptr/2;
                //pos=ptr;
                //System.out.println(par+" "+pos);
                int temp=min[par];
                min[par]=min[pos];
                min[pos]=temp;
                pos=par;
                par=par/2;
                //disp();
            }
        }
        //disp();
    }*/
    public static void form2(){
        int i;
        int j=1;
        for (i=0;i<256;i++){
            if (a[i]>0){
                min[j]=i;
                j++;
                //System.out.println(j);
            }
        }
        ptr=j;
    }
    /*public static void tre(){
        int i=2;
        head=new node(a[min[1]],min[1]);
        //head.left=new node(min[2],a[min[2]]);
        //head.right=new node(min[3],a[min[3]]);
        node it=head;
        while(i<ptr){
            node p=new node(a[min[i]],min[i]);
            it.next=p;
            it=p;
            //if (2*i<ptr)it.left=new node(min[2*i],a[min[2*i]]);
            //if ((2*i+1)<ptr)it.right=new node(min[2*i+1],a[min[2*i+1]]);
            i++;
        }
        /*it=head;
        while(it!=null){
            System.out.println(it.value+" "+it.freq);
            it=it.next;
        }
    }*/
    public static void sort(){
        int i=3;
        head=new node(a[min[1]],min[1]);
        //System.out.println(a[min[1]]+" "+min[1]);
        //i++;
        //while((i<m+1)&&(min[i]>0)){
        node t=new node(a[min[2]],min[2]);
        if (t.freq>head.freq){
            t.next=head;
            head.next=null;
            head=t;
            /*head.next=t;
            t.next=null;
            int temp=head.value;
            head.value=t.value;
            t.value=temp;
            temp=head.freq;
            head.freq=t.freq;
            t.freq=head.freq;*/
        }
        else if (t.freq==head.freq){
            if (t.value>head.value){
                head.next=t;
                t.next=null;
            }
            else{
                /*t.next=head;
                head.next=null;
                head=t;*/
                head.next=t;
                t.next=null;
                int temp=head.value;
                head.value=t.value;
                t.value=temp;
                temp=head.freq;
                head.freq=t.freq;
                t.freq=temp;
            }
        }
        else{
            head.next=t;
            t.next=null;
        }
        while(i<ptr){
            node p=new node(a[min[i]],min[i]);
            if (p.freq>head.freq){
                node temp1=head.next;
                head.next=p;
                p.next=temp1;
                int temp=head.value;
                head.value=p.value;
                p.value=temp;
                temp=head.freq;
                head.freq=p.freq;
                p.freq=temp;
            }
            else{
            node it=head;
            node pre=head;
            it=it.next;
            while((it!=null)&&(a[min[i]]<=it.freq)){
                it=it.next;
                pre=pre.next;

                }
                //node p=new node(a[min[i]],min[i]);
                pre.next=p;
                p.next=it;
            }
                i++;
                //display();
            }
        //node it=head;
        /*while(it!=null){
            System.out.println(it.freq+" "+it.value);
            it=it.next;
        }*/
        }
    public static node srch1(){
         node it=head;
         node min=head;
         while((it!=null)&&(it.next!=null)){
            if (it.freq<=min.freq)min=it;
            it=it.next;
         }
         return min;
    }
    public static node srch2(){
        node it=head;
        node min=srch1();
        node min2=head;
        while(it!=null){
            if((it.value!=min.value)||(min.value==-1)){
                if (it.freq<=min2.freq)min2=it;
            }
            it=it.next;
        }
        return min2;
    }
    public static node srch4(int f){
        node it=head;
        while((it!=null)&&(it.next!=null)&&(it.next.freq>f))it=it.next;
        return it;
    }
    public static node srch_and_join(){
        //joins the node containing v1 and the next value into new node
        //v1 is the grayscale value
        //node it1=srch1();
        //node it2=srch2();
        //System.out.println(it1.value+" "+it2.value);
        //jin do nodes ki frequency minimum hai unko use karo
        //it.next ki jagah pe it2 use karo
        node it1=srch1();
        //System.out.println(it1.value);
        node it2=srch2();
        //System.out.println(it2.value);
        node pre=head;
        //System.out.println(pre.value);
        while((pre!=it1)&&(pre.next!=it1))pre=pre.next;
        /*while((it!=null)&&(it.value!=v1)){
            //if (min.freq>it.freq)min=it;
            //System.out.println(it.value);
            if (it!=head)pre=pre.next;
            it=it.next;
        }*/
        //System.out.println(pre.value);
        node p=new node(it1.freq+it2.freq);
        p.left=it1;
        p.right=it2;
        pre.next=null;
        int f=p.freq;
        node it=head;
        node prev=head;
        int ct=0;
        //System.out.println(it.value+" "+prev.value);
        //node nex=head;
        //nex=it.next;
        //it=it.next;
        //System.out.println(f);
        while((it!=null)&&(it.freq>=f)){
            //System.out.println(it.value+" "+it.freq);
            if(ct>0)prev=prev.next;
            it=it.next;
            ct++;
            //prev=prev.next;
            //nex=nex.next;
        }
        //if (it!=null)System.out.println(prev.freq);
        //System.out.println(prev.freq+" "+it.freq);
        if (prev!=head){
            //node tem=srch4(prev.freq);
            //System.out.println(tem.value)
        prev.next=p;
        p.next=it;
    }
        /*else{
            /*node temp1=head.next;
            head.next=p;
            p.next=temp1;
            int temp=head.value;
            head.value=p.value;
            p.value=temp;
            temp=head.freq;
            head.freq=p.freq;
            p.freq=temp;
            p.next=head;
            head=p;
         }*/
        
        else{
            if (p.freq>=prev.freq){
            p.next=head;
            head=p;
            /*node temp1=head.next;
            head.next=p;
            p.next=temp1;
            int temp=head.value;
            head.value=p.value;
            p.value=temp;
            temp=head.freq;
            head.freq=p.freq;
            p.freq=temp;*/
            }
            else{
                prev.next=p;
                p.next=it;
                //head=prev;
            }
        }
        //System.out.println("nodes removed "+it1.value+" "+it2.value);
        //System.out.println("node added "+p.freq+" "+p.left.freq+" "+p.right.freq);
        //if(head.freq==sum())System.out.println("node added "+head.freq+" "+head.left.freq+" "+head.right.freq);
        //display();
        return head;
    }
    public static int sum(){
        int s=0;
        for (int i=1;i<256;i++)s=s+a[i];
        //System.out.println(s);
        return s;
    }
    public static void join(){
        //val can go upto only ptr-2
        node it=head;
        while(head.freq!=m){
            head=srch_and_join();
            //display();
            }
        head.next=null;
        //display();
        //head=srch_and_join();
        //display();
        /*head=srch_and_join();
        //display();
        head=srch_and_join();
        head=srch_and_join();
        //System.out.println(head.right.freq+" "+head.left.freq);
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        head=srch_and_join();
        //node p=srch_and_join(min[ptr-2]);
            /*for (i=ptr-2;i>0;i--){
            System.out.println(min[i]);
            srch_and_join(min[i]);
        }*/

    }
    public static node srch3(int val){
        node it=head2;
        while((it!=null)&&(it.value!=val)){
            it=it.next;
        }
        return it;
    }
    public static void traverse(node hd,String s){
        node it=hd;
        //System.out.println(hd.value);
        if ((hd.left==null)&&(hd.right==null)&&(hd.value!=-1)){
            node k=srch3(hd.value);
            //System.out.println(hd.value+" "+s);
            k.code=s;
        }
        else if (hd.value==-1){
            if (hd.left!=null){
                //s=s+'0';
                traverse(hd.left,s+'0');
            }
            if (hd.right!=null){
                //s=s+'1';
                traverse(hd.right,s+'1');
            }
        }
        /*System.out.println(it.value+" "+it.freq);
        if (it.left!=null)traverse(hd.left);
        if (it.right!=null)traverse(hd.right);*/
    }
    public static int calc(){
        int i;
        int sum=0;
        node it=head2;
        while(it!=null){
            //System.out.println(it.code);
            sum=sum+it.freq*it.code.length();
            it=it.next;
        }
        //System.out.println(sum);
        return sum;
    }
    public static void display(){
        node it=head;
        while(it!=null){System.out.print(it.value+"  f"+it.freq+" ");
       
        it=it.next;} System.out.println();
    }
    //------------------------------------------------------------------
    public static int[] cnvrt(){
        int[] k=new int[ptr+1];
        int i;
        for (i=1;i<ptr;i++)k[i]=a[min[i]];
        //for (i=1;i<ptr;i++)System.out.println(k[i]+"  ");
        return k;
    }
    public static void rem(int[] y,int flag){
        int i=flag;
        //int t=y.length-1;
        y[i]=0;
        while(i<y.length-1){
            int temp=y[i];
            y[i+1]=y[i];
            y[i+1]=temp;
            i++;
        }
        /*while((i<y.length-1)&&(y[i]!=0)){
            y[i]=y[i+1];
            i++;
        }*/
        for (i=0;i<y.length;i++)System.out.print(y[i]+" ");
        System.out.println();
    }
    public static void add(int[] y){
        int i;
        int min1=y[1];
        int flag1=1,flag2=1;
        for (i=1;i<ptr;i++){
            if ((y[i]!=0)&&(y[i]<=min1)){
                min1=y[i];
                flag1=i;
            }
        }
        int min2=y[1]; 
        for (i=1;i<ptr;i++){
            if ((y[i]!=0)&&(y[i]<=min2)&&(i!=flag1)){
                min2=y[i];
                flag2=i;
            }
        }
        System.out.println(flag1+" "+flag2);
        int sum=min1+min2;
        rem(y,flag1);
        rem(y,flag2);
        //i=ptr-1;
        //while(y[i]==0)i--;
        //y[i+1]=sum;
        for (i=0;i<ptr;i++)System.out.print(y[i]+" ");
        System.out.println();
    }
    public static void cmbn(){
        int[] t=cnvrt();
        int[][] v=new int[ptr][ptr];
        v[0]=t;
        int i=1;
    }
    public static void disp(){
        int i;
        for (i=1;i<=ptr;i++)System.out.print(min[i]+" ");
        System.out.println();
    }
    /*public static node form(int v,int f,int cnt){
        if (cnt==0){
            head=new node(v,f);
        }
        else if (cnt==1){
            if (f>=head.freq){
                p=new node(v,f);
                head.left=p;
            }
            else{
                p=new node(head.value,head.freq);
                head.left=p;
                head.value=v;
                head.freq=f;
            }
        }
        else if (cnt==2){
            if ((f>=head.freq)&&(f>=head.left.freq)){
                p2=new node(v,f);
                head.right=p2;
            }
            else if ((f>=head.freq)&&(f<head.left.freq)){
                p2=new node(head.left.value,head.left.freq);
                head.right=p2;
                head.left.value=v;
                head.left.freq=f;
            }
            else{
                p2=new node(head.value,head.freq);
                head.value=v;
                head.freq=f;
                head.right=head.left;
                head.left=p2;
            }
            else if (cnt>2){
                node it=head;
                while((it!=null)&&(v>it.value)){
                    if ((it.right!=null)&&(v>it.right))it=it.right;
                    else if ((it.left!=null)&&(v>it.left))it=it.left;
                }

            }
        }
    }*/
    /*public static arr_form(int f){

    }*/
    public static void chng(int l1,int l2,int[] t){
        int i;
        int max=l1;
        int sum=0;
        for (i=l1;i<=l2;i++){
            if (t[i]>t[max])max=i;
            sum=sum+t[i];
        }
        for (i=l1;i<=l2;i++){
            if (i!=max)t[i]=0;
            else t[i]=sum;
        }
        /*for (i=l1;i<=l2;i++){
            if (t[i]>0)System.out.print(i+" "+t[i]);}
        System.out.println();*/
        //return t;
    }
    public static void modf(){
        int[] t=new int[256];
        int i;
        for (i=0;i<256;i++)t[i]=a[i];
        for (i=1;i<25;i++){
            chng((i-1)*10,(i-1)*10+9,t);
            //else 
            //chng(250,255,t);
        }
        chng(240,255,t);
        //for (i=1;i<256;i++)System.out.print(t[i]+" ");
        a=t;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1=Reader.nextInt();
        int n2=Reader.nextInt();
        m=n1*n2;
        int i=0,temp;
        a=new int[256];
        int k=0;
        while(i<m){
            temp=Reader.nextInt();
            a[temp]++;
            /*k++;
            if(k==256)
            {
                k=0;
            }*/
            i++;
        }
        //int flag=0;
        /*ptr=1;
        min=new int[m+1];
        for (i=0;i<256;i++){
            if (a[i]>0){
                form(i,a[i]);
                ptr++;
            }
        }*/
        min=new int[m+1];
        form2();
        //System.out.println(ptr);
        //tre();
        sort();
        //display();
        copy();
        //display();
        //cnvrt();
        //int[] s={1,4,2,6,4,2,1,7};
        //add(min);
        //rem(s,4);
        join();
        //System.out.println(head.right.freq+" "+head.left.freq);
        //display();
        //srch_and_join();
        //sum();
        //display();
        /*node it2=srch2();
        System.out.println(it2.value);
        node it1=srch1();
        System.out.println(it1.value);
        node pre=head;
        while((pre!=it1)&&(pre.next!=it1)){
            System.out.println(pre.freq);
            pre=pre.next;
        }
        System.out.println(pre.value);
        node p=new node(it1.freq+it2.freq);
        p.left=it1;
        p.right=it2;
        System.out.println(p.freq+" "+p.right.value+" "+p.left.value);
        pre.next=null;
        display();
        int f=p.freq;
        node it=head;
        node prev=head;
        int ct=0;
        //node nex=head;
        //nex=it.next;
        //it=it.next;
        while(it.freq>f){
            if(ct>0)prev=prev.next;
            it=it.next;
            ct++;
            //prev=prev.next;
            //nex=nex.next;
        }
        System.out.println(prev.value);
        //--------------------------------
        if (prev!=head){
        prev.next=p;
        p.next=it;
    }
        else{
            if (p.freq>=prev.freq){
            p.next=head;
            head=p;
            }
            else{
                prev.next=p;
                p.next=it;
                head=prev;
        }
    }*/

        //display();
        /*node it3=head2;
        while(it3!=null){
            System.out.println(it3.value);
            it3=it3.next;
        }*/
        traverse(head,"");
        System.out.println(Math.round((float)(m*80)/calc())/10.0);
        /*int[] k={7,216,328,0,126,0,328,100,0,30};
        chng(0,9,k);*/
        modf();
        /*ptr=1;
        min=new int[m+1];
        for (i=0;i<256;i++){
            if (a[i]>0){
                form(i,a[i]);
                ptr++;
            }
        }*/
        min=new int[m+1];
        form2();
        //tre();
        sort();
        //display();
        copy();
        /*node it3=head2;
        while(it3!=null){
            System.out.println(it3.value+" "+it3.freq);
            it3=it3.next;
        }*/
        join();
        /*node it1=srch1();
        System.out.println(it1.value);
        node it2=srch2();
        System.out.println(it2.value);
        node pre=head;
        System.out.println(pre.value);
        while((pre!=it1)&&(pre.next!=it1))pre=pre.next;
        System.out.println(pre.value);
        node p=new node(it1.freq+it2.freq);
        p.left=it1;
        p.right=it2;
        pre.next=null;
        display();
        System.out.println(p.right.value+" "+p.left.value);
        int f=p.freq;
        node it=head;
        node prev=head;
        int ct=0;
        while((it!=null)&&(it.freq>f)){
            System.out.println(it.value+" "+it.freq);
            if(ct>0)prev=prev.next;
            it=it.next;
            ct++;
        }
        if (prev!=head){
        prev.next=p;
        p.next=it;
         }
        else{
            p.next=head;
            head=p;
        }
        display();*/
        traverse(head,"");
        System.out.println(Math.round((float)(m*80)/calc())/10.0);

    }
}