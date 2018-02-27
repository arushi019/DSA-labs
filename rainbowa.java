import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
class Reader{
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static void init(InputStream input){
		reader=new BufferedReader(new InputStreamReader(input));
		tokenizer=new StringTokenizer("");
	}
	static String next()throws IOException{
		while(!tokenizer.hasMoreTokens()){
			tokenizer=new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
	static int nextInt()throws IOException{
		return Integer.parseInt(next());
	}
	static double nextDouble()throws IOException{
		return Double.parseDouble(next());
	}
	static long nextLong()throws IOException{
		return Long.parseLong(next());
	}
}
class rainbowa{
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t-->0){
			int n=Reader.nextInt();
			int[] a=new int[n];
			for (int i=0;i<n;i++){
				a[i]=Reader.nextInt();
			}
			int i=0;
			

		}
	}
}