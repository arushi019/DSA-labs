import java.util.concurrent.*;
import java.util.*;
public class Pascal extends RecursiveTask<Integer>{
	protected int n;
	protected int k;
	public boolean equals(Pascal p1){
		if ((n==p1.n)&&(k==p1.k))return true;
		else return false;
	}
	//protected int result;
	//protected static HashMap<Pascal,Integer> h=new HashMap<Pascal,Integer>();
	public Pascal(int n,int k){
		this.n=n;
		this.k=k;
	}
	public Integer compute(){
		if (n==0){return 1;}
		else if (k==0){return 1;}
		else if (n==k){return 1;}
		else{
			Pascal left=new Pascal(n-1,k-1);
			Pascal right=new Pascal(n-1,k);
			left.fork();
			int temp=right.compute()+left.join();
			return temp;
		}
	}
	public static void main(String[] args){
		ForkJoinPool pool=new ForkJoinPool(2);
		Pascal task=new Pascal(100,4);
		int result=pool.invoke(task);
		System.out.println(result);
	}
}
