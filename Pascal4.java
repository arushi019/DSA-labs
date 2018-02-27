package aplab7code;

//Arushi Chauhan
//2016019
//Lab-8
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Pascal3 extends RecursiveTask<Double>{
	protected double n;
	protected double k;
	public boolean equals(Pascal3 p1){
		if ((n==p1.n)&&(k==p1.k))return true;
		else return false;
	}
	//protected int result;
	//protected static HashMap<Pascal3,Integer> h=new HashMap<Pascal3,Integer>();
	public Pascal3(double n,double k){
		this.n=n;
		this.k=k;
	}
	public Double compute(){
		if (n==0){return 1D;}
		else if (k==0){return 1D;}
		else if (n==k){return 1D;}
		else{
			Pascal3 left=new Pascal3(n-1,k-1);
			Pascal3 right=new Pascal3(n-1,k);
			left.fork();
			double temp=right.compute()+left.join();
			return temp;
		}
	}
	
}

class Pascal2 extends RecursiveTask<Double>{
	protected double n;
	protected double k;
	protected String s;
	//protected double result;
	//protected int result;
	protected volatile static HashMap<String,Pascal2> h=new HashMap<String,Pascal2>();
	public Pascal2(double n,double k){
		this.n=n;
		this.k=k;
		//this.result=result;
		s=new String(n+" "+k);
	}
	public Double compute(){
		if (n==0){return 1D;}
		else if (k==0){return 1D;}
		else if (n==k){return 1D;}
		else{
				String temp=new String(n+" "+k);
				if (h.containsKey(temp)){
					String temp1=new String((n-1)+" "+(k-1));
					String temp2=new String((n-1)+" "+k);
					Pascal2 temp1_res=null;
					Pascal2 temp2_res=null;
					if (h.containsKey(temp1))temp1_res=h.get(temp1);
					if (h.containsKey(temp2))temp2_res=h.get(temp2);
					if ((temp1_res!=null)&&(temp2_res!=null)){
						//System.out.println(":)");
						temp1_res.fork();
						double c=temp1_res.join()+temp2_res.compute();
						return c;
					}
					else if ((temp1_res==null)&&(temp2_res!=null)){
						//System.out.println(":))");
						Pascal2 left=new Pascal2(n-1,k-1);
						left.fork();
						double c=temp2_res.compute()+left.join();
						h.put(temp1,left);
						return c;
					}
					else if ((temp2_res==null)&&(temp1_res!=null)){
						//System.out.println(":)))");
						Pascal2 right=new Pascal2(n-1,k);
						temp1_res.fork();
						double c=temp1_res.join()+right.compute();
						h.put(temp2,right);
						return c;
					}
					else{
						//System.out.println(":))))");
						Pascal2 left=new Pascal2(n-1,k-1);
						Pascal2 right=new Pascal2(n-1,k);
						left.fork();
						double c=left.join()+right.compute();
						h.put(temp1, left);
						h.put(temp2,right);
						return c;
					}

					
				}
				else{
				String temp1=new String((n-1)+" "+(k-1));
				String temp2=new String((n-1)+" "+k);
				Pascal2 temp1_res=null;
				Pascal2 temp2_res=null;
				if (h.containsKey(temp1))temp1_res=h.get(temp1);
				if (h.containsKey(temp2))temp2_res=h.get(temp2);
				if ((temp1_res!=null)&&(temp2_res!=null)){
					//System.out.println(":)");
					temp1_res.fork();
					double c=temp1_res.join()+temp2_res.compute();
					Pascal2 p=new Pascal2(n,k);
					h.put(temp,p);
					return c;
				}
				else if ((temp1_res==null)&&(temp2_res!=null)){
					//System.out.println(":))");
					Pascal2 left=new Pascal2(n-1,k-1);
					left.fork();
					double c=temp2_res.compute()+left.join();
					h.put(temp1,left);
					Pascal2 p=new Pascal2(n,k);
					h.put(temp,p);
					return c;
				}
				else if ((temp2_res==null)&&(temp1_res!=null)){
					//System.out.println(":)))");
					Pascal2 right=new Pascal2(n-1,k);
					temp1_res.fork();
					double c=temp1_res.join()+right.compute();
					h.put(temp2,right);
					Pascal2 p=new Pascal2(n,k);
					h.put(temp,p);
					return c;
				}
				else{
					//System.out.println(":))))");
					Pascal2 left=new Pascal2(n-1,k-1);
					Pascal2 right=new Pascal2(n-1,k);
					left.fork();
					double c=left.join()+right.compute();
					Pascal2 p=new Pascal2(n,k);
					h.put(temp,p);
					h.put(temp1, left);
					h.put(temp2,right);
					return c;
				}
			}
		}
	}
}

class Pascal extends RecursiveTask<Double>{
	protected double n;
	protected double k;
	protected String s;
	protected double result;
	//protected int result;
	protected volatile static HashMap<String,Pascal> h=new HashMap<String,Pascal>();
	public Pascal(double n,double k,double result){
		this.n=n;
		this.k=k;
		this.result=result;
		s=new String(n+" "+k);
	}
	public Double compute(){
		if (n==0){return 1D;}
		else if (k==0){return 1D;}
		else if (n==k){return 1D;}
		else{
				String temp=new String(n+" "+k);
				if (h.containsKey(temp))return h.get(temp).result;
			else{
				String temp1=new String((n-1)+" "+(k-1));
				String temp2=new String((n-1)+" "+k);
				double temp1_res=-1D;
				double temp2_res=-1D;
				if (h.containsKey(temp1))temp1_res=h.get(temp1).result;
				if (h.containsKey(temp2))temp2_res=h.get(temp2).result;
				if ((temp1_res!=-1)&&(temp2_res!=-1)){
					//System.out.println(":)");
					double c=temp1_res+temp2_res;
					Pascal p=new Pascal(n,k,c);
					h.put(temp,p);
					return c;
				}
				else if ((temp1_res==-1D)&&(temp2_res!=-1D)){
					//System.out.println(":))");
					Pascal left=new Pascal(n-1,k-1,0);
					left.fork();
					left.result=left.join();
					double c=temp2_res+left.result;
					h.put(temp1,left);
					Pascal p=new Pascal(n,k,c);
					h.put(temp,p);
					return c;
				}
				else if ((temp2_res==-1D)&&(temp1_res!=-1D)){
					//System.out.println(":)))");
					Pascal right=new Pascal(n-1,k,0);
					right.result=right.compute();
					double c=temp1_res+right.result;
					h.put(temp2,right);
					Pascal p=new Pascal(n,k,c);
					h.put(temp,p);
					return c;
				}
				else{
					//System.out.println(":))))");
					Pascal left=new Pascal(n-1,k-1,0);
					Pascal right=new Pascal(n-1,k,0);
					left.fork();
					left.result=left.join();
					right.result=right.compute();
					double c=left.result+right.result;
					Pascal p=new Pascal(n,k,c);
					h.put(temp,p);
					return c;
				}
			}
		}
	}
}

public class Pascal4 {
	public static void main(String[] args){
		double m=30D;
		double n=10D;
		long[] a=new long[9];
		ForkJoinPool pool=new ForkJoinPool(1);
		Pascal task=new Pascal(m,n,0);
		long start=System.currentTimeMillis();
		double result=pool.invoke(task);
		long end=System.currentTimeMillis();
		System.out.println("With flyweight and storing result-Threads: 1");
		a[0]=end-start;
		System.out.println(end-start);
		pool=new ForkJoinPool(2);
		task=new Pascal(m,n,0);
		start=System.currentTimeMillis();
		result=pool.invoke(task);
		end=System.currentTimeMillis();
		System.out.println("With flyweight and storing result-Threads: 2");
		System.out.println(end-start);
		a[1]=end-start;
		pool=new ForkJoinPool(1);
		task=new Pascal(m,n,0);
		start=System.currentTimeMillis();
		result=pool.invoke(task);
		end=System.currentTimeMillis();
		System.out.println("With flyweight and storing result-Threads: 3");
		System.out.println(end-start);
		a[2]=end-start;
		
		pool=new ForkJoinPool(1);
		Pascal2 task2=new Pascal2(m,n);
		start=System.currentTimeMillis();
		result=pool.invoke(task);
		end=System.currentTimeMillis();
		System.out.println("With flyweight without storing result-Threads: 1");
		System.out.println(end-start);
		a[3]=end-start;
		pool=new ForkJoinPool(2);
		task2=new Pascal2(m,n);
		start=System.currentTimeMillis();
		result=pool.invoke(task);
		end=System.currentTimeMillis();
		System.out.println("With flyweight without storing result-Threads: 2");
		System.out.println(end-start);
		a[4]=end-start;
		pool=new ForkJoinPool(3);
		task2=new Pascal2(m,n);
		start=System.currentTimeMillis();
		result=pool.invoke(task);
		end=System.currentTimeMillis();
		System.out.println("With flyweight without storing result-Threads: 3");
		System.out.println(end-start);
		a[5]=end-start;
			pool=new ForkJoinPool(1);
			Pascal3 task1=new Pascal3(m,n);
			start=System.currentTimeMillis();
			result=pool.invoke(task1);
			end=System.currentTimeMillis();
			System.out.println("Without flyweight-Threads: 1");
			System.out.println(end-start);
			a[6]=end-start;
			pool=new ForkJoinPool(2);
			task1=new Pascal3(m,n);
			start=System.currentTimeMillis();
			result=pool.invoke(task1);
			end=System.currentTimeMillis();
			System.out.println("Without flyweight-Threads: 2");
			System.out.println(end-start);
			a[7]=end-start;
			pool=new ForkJoinPool(3);
			task1=new Pascal3(m,n);
			start=System.currentTimeMillis();
			result=pool.invoke(task1);
			end=System.currentTimeMillis();
			System.out.println("Without flyweight-Threads: 3");
			System.out.println(end-start);
			a[8]=end-start;
		System.out.println("speed up flyweighted vs non flyweighted(not storing result) for threads 1 "+(a[3]/a[6]));
		System.out.println("speed up flyweighted vs non flyweighted(not storing result) for threads 2 "+(a[4]/a[7]));
		System.out.println("speed up flyweighted vs non flyweighted(not storing result) for threads 3 "+(a[5]/a[8]));
		System.out.println("speed up flyweighted vs non flyweighted(storing result) for threads 1 "+(a[0]/a[6]));
		System.out.println("speed up flyweighted vs non flyweighted(storing result) for threads 2 "+(a[1]/a[7]));
		System.out.println("speed up flyweighted vs non flyweighted(storing result) for threads 3 "+(a[2]/a[8]));
	}
}
