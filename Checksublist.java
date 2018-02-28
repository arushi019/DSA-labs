package lab4sat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node{
	public int data;
	public Node link;
	
	public Node(int d){
		data=d;
		link=null;
	}
	public void setlink(Node n){
		link=n;
	}
	public void setdata(int d){
		data=d;
	}
	public Node getlink(){
		return link;
	}
	public int getdata(){
		return data;
	}
}

class linkedlist{
	public Node start;
	public Node rear;
	public int size;
	
	public linkedlist(){
		start=null;
		rear=null;
		size=0;
	}
	
	public void insertatbegin(int val){
		Node nptr=new Node(val);
		size++;
		if(start == null){
			start=nptr;
			rear=start;
		}
		else{
			nptr.setlink(start);
			start=nptr;
		}
		
	}
	 public void insertatend(int val){
		 Node nptr=new Node(val);
		 size++;
		 if(start == null){
			 start=nptr;
			 rear=start;
		 }
		 else{
			 rear.setlink(nptr);
			 rear=nptr;
		 }
	 }
	 public void insertatpos(int pos,int val){
		 Node nptr=new Node(val);
		 pos=pos-1;
		 Node ptr=start;
		 for(int i=1 ; i < size;i++){
			 if(i == pos){
				 Node temp=ptr.getlink();
				 ptr.setlink(nptr);
				 nptr.setlink(temp);
				 break;
			 }
			 ptr=ptr.getlink();
		 }
		 size++;
	 }
	 public void deleteatpos(int pos){
		 if(pos == 1){
			 start=start.getlink();
			 size--;
			 return;
		 }
		 if(pos == size){
			 Node s=start;
			 Node t=start;
			 while(s != rear){
				 t=s;
				 s=s.getlink();
			 }
			 rear=t;
			 rear.setlink(null);
			 size--;
			 return;
		 }
		 Node ptr=start;
		 pos=pos-1;
		 for(int v=1;v<size-1;v++){
			 if(v==pos){
				 Node tmp=ptr.getlink();
				 tmp=tmp.getlink();
				 ptr.setlink(tmp);
				 break;
			 }
			 ptr=ptr.getlink();
		 }
		 size--;
	 }
	 public void display(){
		 Node ptr=start;
		 if(start == null){
			 System.out.println();
			 return;
		 }
		 while(ptr != null ){
			 System.out.print(ptr.data+" ");
			 ptr=ptr.getlink();
		 }
		 System.out.println();
	 }
	 public void sublist(linkedlist l2){
		 Node l2_s=l2.start;
		 Node l1_s=start;
		 int flag=0;
		 while(l2_s != null){
			 System.out.println(l1_s.data+" "+l2_s.data);
			 if(l2_s.data == l1_s.data){
				 while( l1_s != null){
					 l1_s=l1_s.getlink();
					 if(l1_s == null){
						 System.out.println("1 null");
					 }
					 l2_s=l2_s.getlink();
					 if(l2_s == null){
						 System.out.println("2 null");
					 }
					 if(l1_s.data != l2_s.data){
						 flag=1;
						 System.out.println("0");
						 break;
					 }
				 }
				 if(flag == 1)
					 break;
			 }
			 
			 l2_s=l2_s.getlink();
		 }
		if(flag == 0){
			System.out.println("1");
		}
	 }
}
public class Checksublist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int M=Reader.nextInt();
			int Q=Reader.nextInt();
			int u,c,d,k,w;
			linkedlist L1=new linkedlist();
			for(int y=0;y<M;y++){
				u=Reader.nextInt();
				L1.insertatend(u);
			}
			for(int p=0;p<Q;p++){
				c=Reader.nextInt();
				if(c == 1){
					d=Reader.nextInt();
					L1.insertatbegin(d);
				}
				else if(c==2){
					L1.deleteatpos(1);
				}
				else if(c==3){
					L1.display();
				}
				else if(c==4){
					linkedlist L2=new linkedlist();
					k=Reader.nextInt();
					for(int j=0;j<k;j++){
						w=Reader.nextInt();
						L2.insertatend(w);
					}
					L1.sublist(L2);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
	}


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

