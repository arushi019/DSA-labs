import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.awt.*;
import java.io.PrintWriter;
//-----------
//Arushi Chauhan
//2016019
//------------
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
class QueenFoundException extends Exception{
    public QueenFoundException(PrintWriter w){
        w.println("QueenFoundException: Queen has been Found.Abort!");
    }
}
class NonCoordinateException extends Exception{
    public NonCoordinateException(Object temp,PrintWriter w){
        w.println("NonCoordinateException: Not a coordinate Exception "+temp.toString());
    }
}
class StackEmptyException extends Exception{
    public StackEmptyException(PrintWriter w){
        w.println("StackEmptyException: Stack Empty exception");
    }
}
class OverlapException extends Exception{
    public OverlapException(knight k2,PrintWriter w){
        //System.out.println(k2.get_name());
        w.println(new String("OverlapException: Knight Overlap Exception "+k2.get_name()));
        k2.set_null();
    }
}
class removeKnightException extends Exception{
    public removeKnightException(knight k1){
        //System.out.println("Stack is Empty and Queen has not been found by knight "+k1.get_name());
    }
}
class knight implements Comparable<knight>{
    protected String name;
    protected Point start_loc;
    protected Point next=new Point(0,0);
    protected int size;
    protected ArrayList<Object> stck;
    protected int top;
    protected int flag;
    protected static int final_flag;
    protected static HashMap<Point,knight> grid=new HashMap<Point,knight>();
    public int compareTo(knight k){
        return name.compareTo(k.get_name());
    }
    public knight(int index)throws IOException{
        InputStream ss=new FileInputStream(new String("./src/src1/"+index+".txt"));
        Reader.init(ss);
        flag=0;
        final_flag=0;
        name=Reader.next();
        //System.out.println(name);
        start_loc=new Point(Reader.nextInt(),Reader.nextInt());
        size=Reader.nextInt();
        stck=new ArrayList<Object>();
        grid.put(start_loc,this);
        //grid=new HashSet<Point>();
        for (int i=0;i<size;i++){
            String type=Reader.next();
            //push all the values in the stack
            if (type.equals("Integer"))stck.add(Reader.nextInt());
            else if (type.equals("String"))stck.add(Reader.next());
            else if (type.equals("Float"))stck.add(Reader.nextDouble());
            else stck.add(new Point(Reader.nextInt(),Reader.nextInt()));
        }
        top=size-1;
        //System.out.println(stck);
    }
    public String get_name(){
        return name;
    }
    public void check_queen(Point queen,PrintWriter w)throws QueenFoundException{
        //put in a try catch in main
        if (queen.equals(start_loc))throw new QueenFoundException(w);
    }
    public void check_point(Object temp,PrintWriter w)throws NonCoordinateException{
        if (!(temp instanceof Point))throw new NonCoordinateException(temp,w);
    }
    public void check_stack(PrintWriter w)throws StackEmptyException{
        if (stck.size()==0)throw new StackEmptyException(w);
    }
    public void check_grid(Point p,PrintWriter w)throws OverlapException{
        //System.out.println(name+" "+grid.get(p).name);
        if ((grid.containsKey(p)==true)&&(!(name.equals(grid.get(p).name))))throw new OverlapException(grid.get(p),w);
    }
    public void set_null(){
        name=null;
    }
    public int get_flag(){
        return flag;
    }
    public int get_final_flag(){
        return final_flag;
    }
    public void pop(Point queen,PrintWriter w)throws QueenFoundException,OverlapException,removeKnightException{
        try{
            check_stack(w);
            Object temp=stck.get(top);
            try{
                check_point(temp,w);
                Point tem=(Point)temp;
                next=tem;
                //System.out.println(it+" "+name+" "start_loc.x+" "+start_loc.y);
                //grid.remove(start_loc);
                //start_loc=(Point)temp;
                /*if (grid.containsKey(tem)==false){
                    start_loc=tem;
                    grid.put(tem,this);
                }
                else{
                    knight other=grid.get(tem);
                    other.set_null();
                    grid.put(tem,this);
                }*/
                check_grid(tem,w);
                //grid.put(tem,this);
                stck.remove(temp);
                top--;
                start_loc=tem;
                check_queen(queen,w);
                w.println("No Exception "+tem.x+" "+tem.y);
                //start_loc=tem;

            }
            catch(NonCoordinateException c){
                //....
                //c=new NonCoordinateException(temp,w);
                stck.remove(temp);
                top--;
                //popped value is not a point
            }
        }
        catch(StackEmptyException s){
            //s=new StackEmptyException(w);
            //.....
            throw new removeKnightException(this);
        }
    }
}
class aplab6_game1{
    public static void sort(ArrayList<knight> arr){
        for (int i=0;i<arr.size();i++){
            for (int j=0;j<arr.size();j++){
                knight t1=arr.get(i);
                knight t2=arr.get(j);
                if (t1.compareTo(t2)<0){
                    knight temp=t2;
                    arr.set(j,t1);
                    arr.set(i,temp);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int total_it=Reader.nextInt();
        Point queen=new Point(Reader.nextInt(),Reader.nextInt());
        ArrayList<knight> arr=new ArrayList<knight>();
        for (int i=0;i<n;i++){
            arr.add(new knight(i+1));
        }
        //int pt=0;
        sort(arr);
        int size=n;
        int it=1;
        PrintWriter w=new PrintWriter("./src/src1/output.txt");
        while((size!=0)&&(arr.get(0).get_final_flag()!=-1)&&(it<=total_it)){
            for (int pt=0;pt<arr.size();pt++){
            knight temp=arr.get(pt);
            w.println(it+" "+temp.name+" "+temp.start_loc.x+" "+temp.start_loc.y);
            try{
            temp.pop(queen,w);
            }
            catch (removeKnightException r){
                arr.remove(pt);
                //System.out.println(pt);
                sort(arr);
                size--;
            }
            catch (OverlapException o){
                //o=new OverlapException(temp.grid.get(temp.next),w);
                temp.grid.remove(temp.start_loc);
                knight dead=temp.grid.get(temp.next);
                temp.start_loc=temp.next;
                arr.remove(dead);
                temp.top--;
                temp.stck.remove(temp.start_loc);
                temp.grid.put(temp.start_loc,temp);
                sort(arr);
                size--;
            }
            catch (QueenFoundException q){
                //q=new QueenFoundException(w);
                arr.get(0).final_flag=-1;
            }
            }
            /*if (temp.get_name()==null){
                arr.remove(temp);
                sort(arr);
                size--;
            }*/
            it++;
        }
        /*
        try{
            k.check_queen();
        }
        catch(QueenFoundException q){
            //.......
        }
        */
        w.close();
    }
}
