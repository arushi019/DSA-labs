import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;
//import java.util.Random;
//------------------------
//Arushi Chauhan
//2016019
//AP Lab-5
//------------------------
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}

class node<T> implements Comparable<node<T>>{
	T val;
	node<T> right;
	node<T> left;
	public node(T val){
		this.val=val;
	}
	public int compareTo(node<T> a){
		if (val instanceof String){
			String t1=(String)val;
			String t2=(String)a.val;
			if (t1.compareTo(t2)<0)return -1;
			else return 1;
		}
		else if (val instanceof Double){
		int tem=0;
		Double d1=(Double)val;
		Double d2=(Double)a.val;
		if (d1<d2)tem=-1;
		else tem=1;
		return tem;
		}
		else{
			int tem=0;
			int i1=(Integer)val;
			int i2=(Integer)a.val;
			if (i1<i2)tem=-1;
			else tem=1;
			return tem;
		}
		}
	
}
class bst<T>{
	private node<T> head;
	private ArrayList<node<T>> tr=new ArrayList<node<T>>();
	public bst(node<T> head){
		this.head=head;
	}
	public node<T> ins(node<T> root,node<T> a){
		if (root==null){
			root=a;
		}
		else{
			if (root.compareTo(a)<0){
				root.right=ins(root.right,a);
			}
			else root.left=ins(root.left,a);
		}
		return root;	
	}
	public void inorder(node<T> a){
		if (a!=null){
			inorder(a.left);
			tr.add(a);
			System.out.println(a.val+" "+a);
			//System.out.println("right");
			inorder(a.right);
		}
	}
	public int pos(){
		for (int i=0;i<tr.size();i++){
			System.out.println(head);
			//System.out.println(tr.get(i).val);
			if (tr.get(i)==head)return i+1;
		}
		return -1;
	}
	public ArrayList<node<T>> get_tree(){
		return tr;
	}
	/*public T addz(node<?> a, node<?> b){
		return (T)a.val+(T)b.val;
	}*/
}
class aplab5{
	public static HashMap<Integer, ArrayList<Object>> ls;
	public static void main(String[] args)throws IOException{
		//Reader.init("./src/" + i + ".txt");
		Reader.init(System.in);
		int x=Reader.nextInt();
		int n=Reader.nextInt();
		//BSTFilesBuilder b=new BSTFilesBuilder();
		//b.createBSTFiles(n,x);
		ls=new HashMap<Integer,ArrayList<Object>>();
		for (int i=0;i<n;i++){
			ArrayList<Object> temp=new ArrayList<Object>();
			ls.put(i+1,temp);
		}
		for (int i=0;i<x;i++){
			InputStream ss=new FileInputStream(new String("./src/" + (i+1) + ".txt"));
			Reader.init(ss);
			String s=Reader.next();
			int m=Reader.nextInt();
			if (s.equals("Integer")){
				int h1=Reader.nextInt();
				node<Integer> head=new node<Integer>(h1);
				System.out.println(head);
				bst<Integer> bs=new bst<Integer>(head);
				//node<Integer> it=head;
				int sum=h1;
				for (int j=1;j<m;j++){
					int temp=Reader.nextInt();
					sum+=temp;
					node<Integer> tem=new node<Integer>(temp);
					bs.ins(head,tem);
					//sum+=(Integer)addz(it,tem);
					//it=tem;
				}
				bs.inorder(head);
				int stud=bs.pos();
				//System.out.println(stud);
				ArrayList<Object> te=ls.get(stud);
				te.add(sum);
				ls.put(stud,te);
			}
			else if (s.equals("String")){
				String h1=Reader.next();
				node<String> head=new node<String>(h1);
				System.out.println(head);
				bst<String> bs=new bst<String>(head);
				//node<String> it=head;
				String sum="";
				for (int j=1;j<m;j++){
					String temp=Reader.next();
					//System.out.println(temp);
					node<String> tem=new node<String>(temp);
					bs.ins(head,tem);
					//sum+=(String)addz(it,tem);
					//it=tem;
				}
				bs.inorder(head);
				ArrayList<node<String>> tr=bs.get_tree();
				//System.out.println(tr);
				for (int j=0;j<tr.size();j++){
					sum+=(String)tr.get(j).val;
				}
				bs.inorder(head);
				int stud=bs.pos();
				ArrayList<Object> te=ls.get(stud);
				te.add(sum);
				ls.put(stud,te);
			}
			else {
				double h1=Reader.nextDouble();
				node<Double> head=new node<Double>(h1);
				bst<Double> bs=new bst<Double>(head);
				//node<Double> it=head;
				double sum=h1;
				for (int j=1;j<m;j++){
					double temp=Reader.nextDouble();
					sum+=temp;
					node<Double> tem=new node<Double>(temp);
					bs.ins(head,tem);
					//sum+=(Double)addz(it,tem);
					//it=tem;
				}
				bs.inorder(head);
				int stud=bs.pos();
				ArrayList<Object> te=ls.get(stud);
				//System.out.println(stud);
				te.add(sum);
				ls.put(stud,te);
			}
		}
		int ct=0;
		for (int i=0;i<n;i++){
			ArrayList<Object> temp=ls.get(i+1);
			if (temp.size()==0){ct++;}
			ls.put(i+1,temp);
		}
		PrintWriter w=new PrintWriter("./src/output.txt","UTF-8");
		for (int i=0;i<n;i++){
			ArrayList<Object> temp=ls.get(i+1);
			System.out.println(temp);
			if (temp.size()!=0){
				w.print((i+1)+" ");
				for (int j=0;j<temp.size();j++){
					w.print(temp.get(j)+" ");
				}
				w.println("");
			}
		}
		w.println(ct);
		w.close();
	}
}
class BSTFilesBuilder {

	public void createBSTFiles(int numStudents, int numTrees) {
		Random rand = new Random();
		for (int i = 1; i <= numTrees; i++) {
		    try {
				PrintWriter w = new PrintWriter("./src/" + i + ".txt", "UTF-8");
				int type = rand.nextInt(3) + 1;
				if(type == 1) {
					w.println("Integer");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextInt(1000));
						w.print(" ");
					}
				}
				else if(type == 2) {
					w.println("Float");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextFloat()*1000);
						w.print(" ");
					}
				}
				else {
					w.println("String");
					w.println(numStudents);
					String alphabet = "abcdefghijklmnopqrstuvwxyz";
					for (int j = 1; j <= numStudents; j++) {
						int len = rand.nextInt(10)+1;
						for (int k = 0; k < len; k++)
							w.print(alphabet.charAt(rand.nextInt(alphabet.length())));
						w.print(" ");
					}
				}
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
