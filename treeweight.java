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
class node{
    int value;
    int[] near;
    node next;
    public node(int value){
        this.value=value;
        this.next=null;
    }
}
public class treeweight{
    static int v;
    static int e;
    static node head;
    //static int[] visited;
    static int[][] graph;
    static int[] edge_start;
    static int[] edge1_start;
    static int[] edge_end;
    static int[] edge1_end;
    //static int[] p;
    static int[] edge_w;
    static int[] edge1_w;
    static int[] status;
    static int[][] msgraph;
    static int[][] fr;
    static boolean[] fr2;
    static boolean[] edge_cnt;
    public static void form(){
        head=new node(1);
        head.near=new int[v+1];
        node it=head;
        int i=2;
        while(i<=v){
            node temp=new node(i);
            temp.near=new int[v+1];
            it.next=temp;
            it=temp;
            i++;
        }
    }
    public static void display(){
        node it=head;
        int i;
        while(it!=null){
            System.out.print("node "+it.value);
            System.out.println();
            for (i=1;i<=v;i++)System.out.print(it.near[i]+" ");
            System.out.println();
            it=it.next;
        }
    }
    public static node srch(int val){
        node it=head;
        while((it!=null)&&(it.value!=val)){
            it=it.next;
        }
        return it;
    }
    /*public static int mst(){
        
    }*/
    public static void addedge(int s,int n,int w,int lev){
        if (lev==1){
            edge_start[0]=s;
            edge_end[0]=n;
            edge_w[0]=w;
        }
        else if (lev==2){
            if (w>=edge_w[0]){
            edge_start[1]=s;
            edge_end[1]=n;
            edge_w[1]=w; 
            }
            else{
                edge_start[1]=edge_start[0];
                edge_start[0]=s;
                edge_end[1]=edge_end[0];
                edge_end[0]=n;
                edge_w[1]=edge_w[0];
                edge_w[0]=w;
            }           
        }
        else{
            int pos=0;
            //System.out.println(edge_w[1]);
            while((pos<e)&&(w>=edge_w[pos])&&(edge_w[pos]!=0)){
                //System.out.println(edge_w[pos]);
                //System.out.println(pos);

                pos++;
                /*if(w==427177){
                System.out.println(pos<e);
                System.out.println(w>=edge_w[pos]);
                System.out.println(edge_w[pos]!=0);*/
            //}
            }
            //System.out.println(pos);
            int ptr=lev-2;
            while(ptr>=pos){
                edge_start[ptr+1]=edge_start[ptr];
                edge_end[ptr+1]=edge_end[ptr];
                edge_w[ptr+1]=edge_w[ptr];
                ptr--;
            }
            edge_start[pos]=s;
            edge_end[pos]=n;
            edge_w[pos]=w;
        }
        //System.out.println(edge_w[1]);
    }
    /*public static void gr(){
        node it=head;
        int i=1;
        int j;
        while(it!=null){
            j=1;
            while(j<v+1){
                msgraph[i][j]=it.near[j];
                j++;
            }
            i++;
            it=it.next;
        }
    }*/
    public static void display2(){
        int i=1;
        int j=1;
        for (i=1;i<v+1;i++){
            for (j=1;j<v+1;j++)System.out.print(msgraph[i][j]+" ");
            System.out.println();
        }
    }
    /*public static boolean dfs_visit(int i){
        status[i]=0;
        int j;
        for (j=1;j<v+1;j++){
            if (msgraph[i][j]>0){
                System.out.println(status[i]+" "+i+" "+status[j]+" "+j+" "+"status");
                if (status[j]==-1)
                    {
                       boolean y= dfs_visit(j);
                       if(y==true)
                        return true;
                    }
                else if (status[j]==0){
                    //System.out.println("Cycle found!");
                    //System.out.println(i+" "+j);
                    return true;
            }
        }
    }
        status[i]=1;
        return false;
    
}
    public static boolean checkcy(int value){
        //run dfs here
        //int[] status=new int[v+1];
        msgraph[edge_start[value]][edge_end[value]]=edge_w[value];
        msgraph[edge_end[value]][edge_start[value]]=edge_w[value];
        display2();
        System.out.println();
        int i;
        boolean b;
        //here i corresponds to vertex
        for (i=1;i<v+1;i++){
            status[i]=-1;
        }
        
        for (i=1;i<v+1;i++){
            if (status[i]==-1){
                b=dfs_visit(i);
                System.out.println(b+" "+i);
                if (b==true)return true;
        }
    }
    return false;
}
    public static boolean check(int value){
        msgraph[edge_start[value]][edge_end[value]]=edge_w[value];
        msgraph[edge_end[value]][edge_start[value]]=edge_w[value];
        display2();
        System.out.println();
        boolean t;
        int i;
        for (i=1;i<v+1;i++)status[i]=-1;
        for (i=1;i<v+1;i++){
            if (status[i]==-1){
                t=dvisit(i);
                System.out.println(i+" "+t);
                if (t==true)return true;
            }
        }
        return false;
    }
    public static boolean dvisit(int i){
        status[i]=0;
        int j;
        for (j=i+1;j<v+1;j++){
            if (msgraph[i][j]>0){
                System.out.println("j= "+j+" status= "+status[j]);
                if (status[j]==-1)dvisit(j);
                else if (status[j]==0){System.out.println(i+" "+j);return true;}
            }
        }
        status[i]=0;
        return false;
    }*/
    public static void set(){
        int i=0;
        int j=0;
            while(j<e){
                edge1_start[j]=0;
                edge1_end[j]=0;
                edge1_w[j]=0;
                j++;
            }
            j=0;
        while(i<e){
            if (edge_cnt[i]==true){
                edge1_start[j]=edge_start[i];
                edge1_end[j]=edge_end[i];
                edge1_w[j]=edge_w[i];
                //System.out.println(j);
                j++;
            }
            i++;
        }
    }
    public static void reset(){
        for (int k2=0;k2<e;k2++)edge_cnt[k2]=true;
    }
    public static int parent(int[] p,int i){
        if (p[i]==-1)return i;
        return parent(p,p[i]);
    }
    public static int check3(int value,int[] edge2_start,int[] edge2_end,int[] edge2_w){
        msgraph[edge_start[value]][edge_end[value]]=edge_w[value];
        msgraph[edge_end[value]][edge_start[value]]=edge_w[value];
        edge_cnt[value]=true;
        set();
        //display2();
        //System.out.println();
        int i;
        int[] p=new int[v+1];
        for (i=0;i<v;i++){
            p[i]=-1;
        }
        i=0;
        while((i<e)&&(edge2_w[i]!=0)){
            //for (int j=0;j<v;j++)System.out.print(p[j]+" ");
            //System.out.println();
            int x=parent(p,edge2_start[i]);
            int y=parent(p,edge2_end[i]);
            if (x==y){
                //edge_cnt[value]=false;
                //set();
                return 1;
            }
            int xset=parent(p,x);
            int yset=parent(p,y);
            p[xset]=yset; 
            i++;
        }
        //edge_cnt[value]=true;
        //set();
        return 0;
    }
    /*public static int mgraph3(int pos){
        int i=0;
        int sum=0;
        int cnt=0;
        while((cnt<v-1)&&(i<e)){
            System.out.println(" * "+edge_w[i]);
            if (i!=pos){
                System.out.println(check3(i));
                if (check3(i)==0){
                    System.out.println(edge_w[i]);
                    sum=sum+edge_w[i];
                    cnt++;
                }
                /*else{
                    msgraph[edge_start[i]][edge_end[i]]=0;
                    msgraph[edge_end[i]][edge_start[i]]=0;
                }*/
            /*}
            i++;
        }
        return sum;
    }*/
    public static int mgraph(int[] edge2_start,int[] edge2_end,int[] edge2_w){
        int i=0;
        int sum=0;
        int cnt=0;
        /*sum=sum+edge_w[0]+edge_w[1];
        msgraph[edge_start[0]][edge_end[0]]=edge_w[0];
        msgraph[edge_end[0]][edge_start[0]]=edge_w[0];
        msgraph[edge_start[1]][edge_end[1]]=edge_w[1];
        msgraph[edge_end[1]][edge_start[1]]=edge_w[1];
        //display2();
        //System.out.println();
        edge_cnt[0]=true;
        edge_cnt[1]=true;*/
        //set();
        while((cnt<v-1)&&(i<e)){
            //if (edge_cnt[i]==true){
            System.out.println(" /"+check3(i,edge2_start,edge2_end,edge2_w));
            //here i corresponds to index of edge
            if (check3(i,edge2_start,edge2_end,edge2_w)==1){
                //sum=sum+edge_w[i];
                msgraph[edge2_start[i]][edge2_end[i]]=0;
                msgraph[edge2_end[i]][edge2_start[i]]=0;
                edge_cnt[i]=false;
                set();
            }
            else {
                System.out.println(edge2_w[i]);
                sum=sum+edge2_w[i];    
                edge_cnt[i]=true;
                //set();
                cnt++;
            }
        //}
            i++;   
        }
        return sum;
    }
    /*public static int mgraph2(int pos){
        int i=0;
        int sum=0;
        /*sum=sum+edge_w[0]+edge_w[1];
        msgraph[edge_start[0]][edge_end[0]]=edge_w[0];
        msgraph[edge_end[0]][edge_start[0]]=edge_w[0];
        msgraph[edge_start[1]][edge_end[1]]=edge_w[1];
        msgraph[edge_end[1]][edge_start[1]]=edge_w[1];
        //display2();
        //System.out.println();
        edge_cnt[0]=true;
        edge_cnt[1]=true;*/
        //display2();
        //System.out.println();
        int cnt=0;
        //set();
        //for (int k1=0;k1<e;k1++)System.out.println(edge_w[k1]+" ");
        /*while((cnt<v-1)&&(i<e)){
            //here i corresponds to index of edge
            if (i!=pos){
                System.out.println(check3(i));
            if (check3(i)==1){
                //sum=sum+edge_w[i];
                msgraph[edge_start[i]][edge_end[i]]=0;
                msgraph[edge_end[i]][edge_start[i]]=0;
                edge_cnt[i]=false;
                set();
            }
            else {
                sum=sum+edge_w[i];    
                edge_cnt[i]=true;
                set();
                cnt++;
                //System.out.println(cnt<v-1);
            }
        }
            i++;   
        }
        return sum;
    }*/
    /*public static int sec2(){

    }*/
    public static void freeze(){
        int i;
        int j;
        for (i=1;i<v+1;i++){
            for (j=1;j<v+1;j++){
                fr[i][j]=msgraph[i][j];
            }
        }
    }
    public static void freeze2(){
        int i;
        for (i=0;i<e;i++)fr2[i]=edge_cnt[i];
    }
    public static int second(){
        int min=0;
        //System.out.println(min);
        freeze();
        freeze2();
        //display2();
        //System.out.println();
        int min2=-1;
        int flag=0;
        int i;
        //for (int k1=0;k1<e;k1++)System.out.print(fr2[k1]+" ");
        //for (int k1=0;k1<e;k1++)System.out.println(k1+" "+edge_cnt[k1]+" ");
        for (i=0;i<e;i++){
        //for (int k1=0;k1<e;k1++)System.out.print(k1+" "+edge_cnt[k1]+" "); 
            //fr2 is the original mst
            //for every edge in original mst
            if (fr2[i]==true){
                //System.out.println(i+" "+edge_cnt[i]);
                //reset msgraph to given graph in beginning
                for (int k1=1;k1<v+1;k1++){
                    for (int k2=1;k2<v+1;k2++){
                        msgraph[k1][k2]=graph[k1][k2];
                    }
                }
                //set i th edge(which is a member of original mst to 0)
                msgraph[edge_start[i]][edge_end[i]]=0;
                msgraph[edge_end[i]][edge_start[i]]=0;
                //reset();
                edge_cnt[i]=false;
                set();
                //for (int k1=0;k1<e;k1++)System.out.print(edge_cnt[k1]+" ");
                //System.out.println();
                //resets the arrrays edge_start, edge_end and edge_w
                //display2();
                //System.out.println();
                int temp=0;
                //System.out.println("mgraph2");
        //for (int k1=0;k1<e;k1++)System.out.println(k1+" "+edge_cnt[k1]+" ");
                //System.out.println(temp);
                /*if (temp>min){
                if (min2==-1)min2=min;
                else if (temp<min2)min2=temp;
                }*/
                //System.out.println(temp);
                if (temp>min){
                    if (flag==0){
                        min2=temp;
                        flag++;
                    }
                    else if (temp<min2){
                        //System.out.println("*");
                        min2=temp;
                        flag++;
                    }
                }
                //System.out.println(min2);
                msgraph[edge_start[i]][edge_end[i]]=edge_w[i];
                msgraph[edge_end[i]][edge_start[i]]=edge_w[i];
                edge_cnt[i]=true;
                set();      
            }
        }
        if (min2>min)
        return min2;
        else return -1;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        v=Reader.nextInt();
        e=Reader.nextInt();
        int x,y,w;
        status=new int[v+1];
        //p= new int[v+1];
        graph=new int[v+1][v+1];
        msgraph=new int[v+1][v+1];
        fr=new int[v+1][v+1];
        fr2=new boolean[e];
        edge_start=new int[e];
        edge1_start=new int[e];
        edge_end=new int[e];
        edge1_end=new int[e];
        edge_w=new int[e];
        edge1_w=new int[e];
        edge_cnt=new boolean[e];
        node p1,p2;
        form();
        int i=1;
        int j;
        while(i<=e){
            x=Reader.nextInt();
            y=Reader.nextInt();
            w=Reader.nextInt();
            p1=srch(x);
            p1.near[y]=w;
            p2=srch(y);
            p2.near[x]=w;
            addedge(x,y,w,i);
            /*System.out.println("----------------------------");
            for (j=0;j<e;j++){
            System.out.print(edge_w[j]+" ");
        }
        System.out.println();
        for (j=0;j<e;j++){
            System.out.print(edge_start[j]+" ");
        }
        System.out.println();
        for (j=0;j<e;j++){
            System.out.print(edge_end[j]+" ");
        }
        System.out.println();
        System.out.println("------------------------------");
            */
            i++;
        }
        node it=head;
        i=1;
        while(it!=null){
            graph[i]=it.near;
            i++;
            it=it.next;
        }
        //display();
        for (i=0;i<e;i++){
            System.out.print(edge_w[i]+" ");
        }
        System.out.println();
        for (i=0;i<e;i++){
            System.out.print(edge_start[i]+" ");
        }
        System.out.println();
        for (i=0;i<e;i++){
            System.out.print(edge_end[i]+" ");
        }
        System.out.println();
        //System.out.println(mgraph3(Reader.nextInt()));
        //display2();
        //display2();
        //System.out.println();
        /*for (i=1;i<v+1;i++){
            for (int j=1;j<v+1;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }*/
        //display();
        //gr();
        //display2();
        /*System.out.println();
        msgraph[edge_start[0]][edge_end[0]]=edge_w[0];
        msgraph[edge_end[0]][edge_start[0]]=edge_w[0];
        msgraph[edge_start[1]][edge_end[1]]=edge_w[1];
        msgraph[edge_end[1]][edge_start[1]]=edge_w[1];
        edge_cnt[0]=true;
        edge_cnt[1]=true;
        set();
        System.out.println(check3(Reader.nextInt()));*/
        //System.out.println(mgraph());
        /*for (i=0;i<e;i++){
            System.out.print(edge_cnt[i]+" ");
        }*/
        set();
        int val=mgraph(edge_start,edge_end,edge_w);
        //display2();
        i=0;
        //set();
        /*while((i<e)&&(edge1_w[i]!=0)){
            System.out.println(edge_cnt[i]+" "+edge1_w[i]+" "+edge1_start[i]+" "+edge1_end[i]);
            i++;
        }*/
        System.out.println(val);
        reset();
        int p=Reader.nextInt();
        edge_cnt[p]=false;
        set();
        for (i=0;i<e;i++){
            System.out.print(edge1_w[i]+" ");
        }
        System.out.println();
        for (i=0;i<e;i++){
            System.out.print(edge1_start[i]+" ");
        }
        System.out.println();
        for (i=0;i<e;i++){
            System.out.print(edge1_end[i]+" ");
        }
        System.out.println();
        System.out.println(mgraph(edge1_start,edge1_end,edge1_w));
        //for (i=0;i<e;i++)System.out.print(edge_cnt[i]+" ");
        //display2();
        //System.out.println(second());
    }
}