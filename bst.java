//Arushi Chauhan
//2016019
//SEc-A GRP-2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


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
class node{
    //node class
    int value;
    node right;
    node left;
}
public class bst{
    static node roots;
    static int n;
    static int[] a1;
    static int cur_lev=0;
    public static node form(int[] a){
        //root=new node();
        //root.value=a[0];
        /*int i=1;
        //for (int j=0;j<a.length;j++)System.out.print(a[j]+" ");
        System.out.println();
        while(a[i]<root.value){
            i++;
        }*/
        //System.out.println(a[i]);
        //System.out.print("Left");
        //for (int j=0;j<a1.length;j++)System.out.print(a1[j]+" ");
        //System.out.println();
        //System.out.print("Right");
        //for (int j=0;j<a2.length;j++)System.out.print(a2[j]+" ");
        //System.out.println();
        node root=new node();
        //System.out.println("Length of array "+a.length);
        //for (int j=0;j<a.length;j++)System.out.print(a[j]+" ");
        //System.out.println();
        if (a.length==1){
            root.value=a[0];
            root.right=null;
            root.left=null;
        }
        else if((a.length==2)||(a.length==3)){
            //a.length>1
            if (a.length==2){
                root.value=a[0];
                if (a[0]>a[1]){
                    root.left=new node();
                    root.left.value=a[1];
                    root.left.right=null;
                    root.left.left=null;
                    root.right=null;
                }
                else{
                    root.right=new node();
                    root.right.value=a[1];
                    root.right.right=null;
                    root.right.left=null;
                    root.left=null;   
                }
            }
            else if (a.length==3){
                root.value=a[0];
                if (a[1]>a[0]){
                    /*if (a[2]<a[0]){
                        root.left=new node();
                        root.left.value=a[2];
                        root.left.right=null;
                        root.left.left=null;
                        root.right=new node();
                        root.right.value=a[1];
                        root.right.right=null;
                        root.right.left=null;
                    }*/
                    if ((a[2]>a[0])&&(a[2]>a[1])){
                        root.right=new node();
                        root.right.value=a[1];
                        root.right.left=null;
                        root.right.right=new node();
                        root.right.right.value=a[2];
                        root.right.right.left=null;
                        root.right.right.right=null;
                        root.left=null;
                 
                    }
                    else if ((a[2]>a[0])&&(a[2]<a[1])){
                        root.left=null;
                        root.right=new node();
                        root.right.value=a[1];
                        root.right.right=null;
                        root.right.left=new node();
                        root.right.left.value=a[2];
                        root.right.left.right=null;
                        root.right.left.left=null;
                    }
                }
                else if (a[1]<a[0]){
                    if (a[2]>a[0]){
                        root.right=new node();
                        root.right.value=a[2];
                        root.right.left=null;
                        root.right.right=null;
                        root.left=new node();
                        root.left.value=a[1];
                        root.left.right=null;
                        root.left.left=null;
                    }
                    else if ((a[2]<a[0])&&(a[2]>a[1])){
                        root.right=null;
                        root.left=new node();
                        root.left.value=a[1];
                        root.left.left=null;
                        root.left.right=new node();
                        root.left.right.value=a[2];
                        root.left.right.left=null;
                        root.left.right.right=null;
                    }
                    else if ((a[2]>a[0])&&(a[2]<a[1])){
                        root.right=null;
                        root.left=new node();
                        root.left.value=a[1];
                        root.left.right=null;
                        root.left.left=new node();
                        root.left.left.value=a[2];
                        root.left.left.right=null;
                        root.left.left.left=null;
                    }
                }
            
                }

            }
            else {
                root.value=a[0];
                int i=1;
                while((i<a.length)&&(a[i]<root.value)){
                    i++;
                }
                if ((i>1)&&(i<a.length)){
                int[] a1=Arrays.copyOfRange(a,1,i);
                int[] a2=Arrays.copyOfRange(a,i,a.length);
                root.left=form(a1);
                root.right=form(a2);
            }
            else if ((i>1)&&(a[i-1]<a[0])){
                int[] a1=Arrays.copyOfRange(a,1,a.length);
                for (int j=0;j<a1.length;j++)System.out.print(a1[j]+" ");
                root.left=form(a1);
            }
            else if ((i>1)&&(a[i-1]>a[0])){
                int[] a1=Arrays.copyOfRange(a,1,a.length);
                root.right=form(a1);
            }
            else if (i==1){
                int[] a1=Arrays.copyOfRange(a,1,a.length);
                root.right=form(a1);
            }
            }
            

        
        return root;
    } 
    public static node ins(node root,int val){
        //inserts a node in the tree for a node of value val
        if (root==null){
            //System.out.print("leaf");
            root=new node();
            root.value=val;
            root.right=null;
            root.left=null;
        }
        else{
            if (val<root.value){
                //System.out.print("left");
                root.left=ins(root.left,val);
            }
            else{
                //System.out.print("right");
                root.right=ins(root.right,val);
            }
        }
        return root;
    }
    public static node srch(node root,int val){
        if (root.value==val){
            return root;
        }
        else{
            if (val>root.value){
                if (root.right!=null)return srch(root.right,val);
                else return null;
            }
            else{
                if (root.left!=null)return srch(root.left,val);
                else return null;
            }
        }
        //return null;
    }
    public static  node it_srch(int val){
        node it=roots;
        while(it!=null){
            if (it.value==val)return it;
            else if (it.value<val)it=it.right;
            else it=it.left;
        }
        return null;
    }
    public static node parnt(node root,int val){
        if((root.right!=null)&&(root.left!=null)){
            if ((root.right.value==val)||(root.left.value==val))return root;
            else {
                if (val>root.value)return parnt(root.right,val);
                else return parnt(root.left,val);
            }
        }
        else if((root.right!=null)&&(root.left==null)){
            if (root.right.value==val)return root;
            else{
                return parnt(root.right,val);
            }
        }
        else if((root.right==null)&&(root.left!=null)){
            if (root.left.value==val)return root;
            else{
                return parnt(root.left,val);
            }
        }
        return null;
    }
    public static node min(node root){
        //returns the node containing minimum value in the right subtree of node root
        node start=root;
        while(start.left!=null){
            start=start.left;
        }
        return start;
    }
    /*public static node del(node root,int val){
        node d=srch(root,val);
        node p=parnt(root,val);
        
        if ((d.right==null)&&(d.left==null)){
            //d=null;
            if (val>p.value)p.right=null;
            else p.left=null;
        }
        else if ((d.right!=null)&&(d.left==null)){
            if (val>p.value){
                p.right=d.right;
            }
            else{
                p.left=d.right;
            }
            d=null;
        }
        else if ((d.left!=null)&&(d.right==null)){
            if (val>p.value){
                p.right=d.left;
            }
            else{
                p.left=d.left;
            }
            d=null;
        }
        else{
            node m=min(d.right);
            //node pm=parnt(root,m.value);
            d.value=m.value;
            /*if (m.right!=null)pm.left=m.right;
            else pm.left=null;
            d.right=del(d.right,d.value);
        }
        disp(root);
        return root;
    }*/
    public static node del2(node root,int val){
        //carries out deletion of node having value val
        if (root==null)return null;
        else{
        if (val<root.value){
            //System.out.print("hi");
            root.left=del2(root.left,val);

        }
        else if (val>root.value){
            root.right=del2(root.right,val);
        }
        else if((root.left!=null)&&(root.right!=null)){
            root.value=min(root.right).value;
            root.right=del2(root.right,root.value);
        }
        else if ((root.right==null)&&(root.left!=null)){
            root=root.left;
        }
        else if ((root.left==null)&&(root.right!=null)){
            root=root.right;
        }
        else if ((root.left==null)&&(root.right==null)){
            //System.out.print("hi");
            root=null;
        }
    }
        return root;
    }
    public static void disp(node rt){
        //used to display the tree
        node it=rt;
        if (rt.left!=null)disp(rt.left);
        System.out.print(rt.value+" ");
        //System.out.println("Going left..");
        //else System.out.println("Nothing found");
        //System.out.println("Going right..");
        if (rt.right!=null)disp(rt.right);
        //else System.out.println("Nothing found :(");
    }
    public static int ht(node root){
        if (root==null)return 0;
        else{ 
            int hl=ht(root.left);
            int hr=ht(root.right);
            int max=hl>hr?hl:hr;
            return 1+max;
    }
}
    /*public static int leaf(node root){
        if ((root.right==null)&&(root.left==null)){
            return 1;
        }
        else if (root==null)return 0;
        else return leaf(root.right)+leaf(root.left);
    }*/

    public static void right_disp2(node root,int level){
        //displays the right profile of the tree
        if (cur_lev<level){
            System.out.print(root.value+" ");
            cur_lev=level;
        }
        if (root.right!=null)right_disp2(root.right,level+1);
        if(root.left!=null)right_disp2(root.left,level+1);
    }
    /*public static void right_disp(){
        node it=roots;
        //node l=it.left;
        //node r=it.right;
        int rcnt=0,rlcnt=0,lrcnt=0,lcnt=0;
        int i;
        int h=ht(roots);
        while(it!=null){
            System.out.print(it.value+" ");
            it=it.right;
            rcnt++;
        }
        //System.out.println(rcnt);
        //--------------------------------------------
        rcnt--;
        if (rcnt<h){
            it=roots.right.left;
            i=2;
            while(i<rcnt){
                if ((it.right!=null)&&(it.left!=null)){
                    it=it.right;
                    i++;
                }
                else if (it.right!=null){
                    it=it.right;
                    i++;
                }
                else if (it.left!=null){
                    it=it.left;
                    i++;
                }
                else{
                    rlcnt=i;
                    break;
                }
            }
            if (rlcnt==0)rlcnt=i;
        }
        i=rlcnt;
        while((it.right!=null)||(it.left!=null)){
            if ((it.right!=null)&&(it.left!=null)){
                it=it.right;
                i++;
            }
            else if ((it.right!=null)&&(it.left==null)){
                it=it.right;
                i++;
            }
            else if((it.right==null)&&(it.left!=null)){
                it=it.left;
                i++;
            }
            System.out.print(it.value+" ");

        }
        rlcnt=i;
        //System.out.println(rlcnt+" "+it.value);
        //-----------------------------------------------

}
*/
    public static void main(String[] args)throws IOException{
        /*int[] a={50,17,12,9,14,23,19,72,54,67,76};
        int[] b={72,54,67,76};
        roots=form(a);
        disp(roots.right);*/
        Reader.init(System.in);
        int n,q;
        n=Reader.nextInt();
        q=Reader.nextInt();
        int ch,val;
        a1=new int[n];
        for (int i=0;i<n;i++){
            a1[i]=Reader.nextInt();
            if (i==0){
                roots=new node();
                roots.value=a1[0];
                roots.right=null;
                roots.left=null;
            }
            else
            roots=ins(roots,a1[i]);
        }
        //roots=ins(a1);
        while(q-->0){
        ch=Reader.nextInt();
        if (ch==1){
            val=Reader.nextInt();
            //System.out.println(parnt(roots,val).value);
            roots=del2(roots,val);
            int lc,k;
            for (k=0;k<a1.length;k++){
                if (a1[k]==val)break;
            }
            lc=k;
            int[] t=new int[a1.length-1];
            int i=0;
            while(i<a1.length){
                if (i<lc){
                    t[i]=a1[i];
                    //i++;
                }
                else if (i>lc){
                    t[i-1]=a1[i];
                    //i++;
                }
                i++;
            }
            a1=t;
            /*for (int j=0;j<a1.length;j++){
                System.out.print(a1[j]+" ");
            }*/
            //disp(roots);
        }
        else if (ch==2){
            //int h=ht(roots);
            if (roots!=null){
                right_disp2(roots,1);
                cur_lev=0;
            }
            else System.out.println();
            //cur_lev=0;
        }
        else if (ch==3){
            val=Reader.nextInt();
            System.out.print(it_srch(val).value);
        }
        else if (ch==4){
            disp(roots);
        }
        }
    }
}