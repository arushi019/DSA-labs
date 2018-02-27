import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.lang.*;
import java.awt.Point;
public class tr{
	public static void main(String[] args)throws IOException{
		ArrayList<Integer> stack=new ArrayList<Integer>();
		stack.add(3);
		stack.add(4);
		stack.add(5);
		System.out.println(stack.size());
		stack.remove(2);
		System.out.println(stack);
		System.out.println(stack.size());
	}
}