import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
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
    static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}
class comp{
    int salary;
    int quant;
    int current;
    public comp(int salary,int quant){
        this.salary=salary;
        this.quant=quant;
        this.current=0;
    }
}
class gcac{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int m=Reader.nextInt();
            //cand[] c=new cand[n];
            int[] min=new int[n];
            comp[] o=new comp[m];
            int num=0;
            long total=0;
            HashSet<Integer> fin=new HashSet<Integer>();
            for (int i=0;i<n;i++){
                min[i]=Reader.nextInt();
            }
            for (int i=0;i<m;i++){
                o[i]=new comp(Reader.nextInt(),Reader.nextInt());
                fin.add(i);
            }
            for (int i=0;i<n;i++){
                String s=Reader.next();
                int flag=-1;
                int flagsal=0;
                for (int j=0;j<m;j++){
                    if (s.charAt(j)=='1'){
                        if ((o[j].salary>flagsal)&&(o[j].current<o[j].quant)){
                            flag=j;
                            flagsal=o[j].salary;
                        }
                    }
                }
                if (flagsal>=min[i]){
                    //System.out.println(i+" "+o[flag].salary);
                    o[flag].current++;
                    total+=(long)o[flag].salary;
                    num++;
                    fin.remove(flag);
                }
            }
            System.out.println(num+" "+total+" "+fin.size());
        }
    }
}