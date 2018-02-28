//Arushi Chauhan-2016019
//Sec-A grp-2
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
//DEFINING NODE CLASS 
class node{
	int value;
	node next;
	public node(int value){
		this.value=value;
		this.next=null;
	}
}
//DEFINING CIRCULAR LINKED LIST WHICH CONSISTS OF OBJECTS OF CLASS NODE
public class circ_list2{
	node head=new node(1);
	int len=0;
	//DEFINES A CONSTRUCTOR WHICH CONSTRUCTS THE CIRCULAR LINKED LIST OF SIZE n1
	circ_list2(int n1){
		int i;
		if(n1>1)
		{
			node it=new node(2);
			this.head.next=it;
			node prev=it;
			for (i=3;i<n1;i++){
				it=new node(i);
				prev.next=it;
				prev=prev.next;
			}
			it.next=new node(n1);
			it=it.next;
			it.next=this.head;
			this.len=n1;
		}
		else {
			this.head.next=this.head;
			this.len++;
		}
	}
	//FUNCTION: TO DISPLAY CIRCULAR LINKED LIST
	//ARGUMENTS: CIRCULAR LINKED LIST c
	public static void disp(circ_list2 c){
		int i=0;
		node it=c.head;
		while (i<c.len){
			System.out.print(it.value+" ");
			it=it.next;
			//if (it.value==c.head.value)continue;
			i++;
		}
		System.out.println();
	}
	//FUNCTION: TO DELETE A NODE AT A GIVEN POSITION
	//ARGUMENTS: CIRCULAR LINKED LIST c AND INTEGER pos
	public static void del(circ_list2 c,int pos){
		int i=0;
		node prev=c.head;
		node curr=c.head;
		node nex=curr.next;
		if (pos==c.head.value){
			c.head=c.head.next;
			node temp=c.head;
			while(i<c.len-2){
				temp=temp.next;
				i++;
			}
			//System.out.println(temp.value);
			temp.next=c.head;
			//System.out.println(c.head.value);
			prev.next=nex;
			c.len--;
		}
		else{
			curr=curr.next;
			nex=nex.next;
			while(curr.value!=pos){
				curr=curr.next;
				nex=nex.next;
				prev=prev.next;
			}
			/*curr=curr.next;
			nex=nex.next;
			while (i<pos-2){
				prev=prev.next;
				curr=curr.next;
				nex=curr.next;
				i++;
			}*/
			prev.next=nex;
			c.len--;
		}
		/*int i=0;
		node curr=c.head.next;
		node prev=c.head;
		node nex=curr.next;
		//curr points to 1, prev to head, nex to 2
		while (i<pos-1){
			//put curr at pos
			curr=curr.next;
			nex=nex.next;
			prev=prev.next;
			//System.out.println("prev="+prev.value+"curr="+curr.value+"nex="+nex.value);
			//if (curr.value==(-1))continue;
			//System.out.print(it.value+" ");
			i++;
		}
		//curr is placed at pos
		prev.next=nex;
		disp(c);*/
	}
	//FUNCTION: TO FIND THE WINNER OF THE GAME
	//ARGUMENTS: CIRCULAR LINKED LIST c
	public static int game(circ_list2 c){
		node pin=c.head;
		//node prev=c.head;
		//disp(c);
		while (c.len>1){
			pin=pin.next;
			//System.out.println(pin.value);
			del(c,pin.value);
			//disp(c);
			pin=pin.next;
		}
		return c.head.value;
		//System.out.println(c.head.value);
		//pin is in 1's hands
		//prev is the one which will be burst
		//del(c,-1);
		//disp(c);
		/*while(c.len>1){
			pin=pin.next;
			//pass the pin to burst
			prev=pin;
			pin=pin.next;
			if (prev.value!=-1){
				del(c,prev.value);
				System.out.println("eliminate "+prev.value);
				//KABOOM!!!!!
				c.len--;
				//pin=pin.next;
				//does the pin remember to whom it is referring???nay
				//pass the pin forward to continue destruction
			}
			//else continue;
		}
		return pin.value;*/
	}
	public static void main(String[] args) throws IOException{
		//circ_list2 c=new circ_list2();
		Reader.init(System.in);
		int t,n;
		t=Reader.nextInt();
		while (t-->0){
			n=Reader.nextInt();
			circ_list2 c=new circ_list2(n);
			//System.out.println(game(c));
			//del(c,-1);
			//int temp=Reader.nextInt();
			//disp(c);
			//del(c,temp);
			//disp(c);
			System.out.print(game(c));
			if (t!=0)System.out.println();
		}
	}
}