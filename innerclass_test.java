/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class a{
	void prnt(){
		System.out.println("hello from a");
	}
	b bb;
	b b2;
	private int k;
	a(){
		k=5;
		prnt();
		b2=new b();
	}
	class b{
		private int k;
		b(){
			k=9;
			//super.prnt();
			prnt();
		}
		//@Override
		void prnt(){
			a.this.prnt();
			//this.prnt() keeps calling itself 
			System.out.println(a.this.k+" "+k);
			System.out.println("hello from b");
		}
	}
}
/* Name of the class has to be "Main" only if the class is public. */
class innerclass_test
{
	private class c{
		private int k;
		c(){
			k=10;
		}
		private void prnt(){
			System.out.println(k);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		a aa=new a();
		a.b bb=aa.new b();
		bb.prnt();
		innerclass_test i=new innerclass_test();
		innerclass_test.c cc=i.new c();
		System.out.println(cc.k);
	}
}