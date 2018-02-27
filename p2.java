package foobar;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


class practice {

	public static void main(String[] args) {
		Reader.init(System.in);
	try{	
			int t = Reader.nextInt();
		
			while (t-- >0){
				String str1 = Reader.next();
				char[] ch1=str1.toCharArray();
				Arrays.sort(ch1);
				str1=String.valueOf(ch1);
				String str2 = Reader.next();
				char[] ch2=str2.toCharArray();
				Arrays.sort(ch2);
				str2=String.valueOf(ch2);
ArrayList<Character> arr = new ArrayList<Character>();
for (int i=0;i<ch1.length;i++){ 
	if (!arr.contains(ch1[i])){
	int min=str1.lastIndexOf(ch1[i])-str1.indexOf(ch1[i])+1 ;
	if (str2.indexOf(ch1[i])>=0){
	int x =str2.lastIndexOf(ch1[i])-str2.indexOf(ch1[i])+1 ;
	if (x<min){min=x;}
	for (int j=0;j<min;j++){
	System.out.print(ch1[i]);
	}
	}
	arr.add(ch1[i]);
	
}
}

				
			}
			
	}
	catch (IOException e){e.printStackTrace();}
				
		} 
		
	




/** Class for buffered reading int and double values */
static class Reader {
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
}}