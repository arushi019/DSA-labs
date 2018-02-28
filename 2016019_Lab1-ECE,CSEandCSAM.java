import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
//-------------------------------
//Arushi Chauhan 
//BTech CSE 2020 
//Roll no: 2016019
//AP Lab-1 Submission
//-------------------------------
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
class student{
	//create a class student with details for name, roll no,program,distance 
	private String name;
	private String roll;
	private String program;
	private int distance;
	private boolean got_hostel;
	public student(String name,String roll,String program,int distance){
		this.name=name;
		this.roll=roll;
		this.program=program;
		this.distance=distance;
		//by default, student is initialised without a hostel
		this.got_hostel=false;
	}
	public String get_name(){
		//getter for student name
		return this.name;
	}
	public String get_roll(){
		//getter for roll no
		return this.roll;
	}
	public String get_program(){
		//getter for program
		return this.program;
	}
	public int get_distance(){
		//getter for distance
		return this.distance;
	}
	public void give_hostel(){
		//invoke this method when a student has been allotted hostel
		this.got_hostel=true;
	}
	public boolean check_hostel(){
		//getter for hostel value
		return this.got_hostel;
	}
	public String toString(){
		//method for printing the instance of student
		return this.name+" "+this.roll+" "+this.program+" "+this.distance;
	}
}
class aplab1{
	private int n,m,phd_st,ug_st,pg_st,phd_room,pg_room,ug_room;
	private student[] s1;
	private ArrayList<student> phd,pg,ug;
	private static void sort(ArrayList<student> arr){
		//sorts an arraylist based on distance of students 
		for (int i=0;i<arr.size();i++){
			for (int j=i+1;j<arr.size();j++){
				if (arr.get(i).get_distance()<arr.get(j).get_distance()){
					student temp=arr.get(i);
					arr.set(i,arr.get(j));
					arr.set(j,temp);
				}
			}
		}
	}
	public static void main(String[] args)throws IOException{
		Reader.init(System.in);
		int n=Reader.nextInt();
		int m=Reader.nextInt();
		//list of all students
		student[] s1=new student[n];
		//list of all phd students
		ArrayList<student> phd=new ArrayList<student>();
		//list of all pg students
		ArrayList<student> pg=new ArrayList<student>();
		//list of all ug students
		ArrayList<student> ug=new ArrayList<student>();
		//number of phd students, pg students, ug students
		int phd_st,pg_st,ug_st;
		phd_st=0;
		pg_st=0;
		ug_st=0;
		for (int i=0;i<n;i++){
			s1[i]=new student(Reader.next(),Reader.next(),Reader.next(),Reader.nextInt());
			if (s1[i].get_program().equals("PhD")){
				phd_st++;
				phd.add(s1[i]);
			}
			else if ((s1[i].get_program().equals("PG"))){
				pg_st++;
				pg.add(s1[i]);
			}
			else if ((s1[i].get_program().equals("UG"))){
				ug_st++;
				ug.add(s1[i]);
			}
		}
		//number of rooms for phd,pg and ug students
		int phd_room,pg_room,ug_room;
		ug_room=0;
		if (m%2==0){
			phd_room=m/2;
			pg_room=m/2;
		}
		else{
			phd_room=m/2+1;
			pg_room=m/2;
		}
		if (phd_st<=phd_room){
			//if number of phd students is less than number of rooms
			//for phd students, then give rooms to all phd students
			for (int i=0;i<phd.size();i++){
				student temp=phd.get(i);
				temp.give_hostel();
			}
			//rooms for ug students
			ug_room+=phd_room-phd_st;
		}
		else{
			//if condition is not satisfied, then sort students
			//on distance and give hostel according to order
			sort(phd);
			for (int i=0;i<phd_room;i++){
				phd.get(i).give_hostel();
			}
		}
		if (pg_st<=pg_room){
			//if number of pg students is less than number of rooms
			//for pg students, then give rooms to all pg students
			for (int i=0;i<pg.size();i++){
				student temp=pg.get(i);
				temp.give_hostel();
			}
			//rooms for ug students
			ug_room+=pg_room-pg_st;
		}
		else{
			//if condition is not satisfied, then sort students
			//on distance and give hostel according to order
			sort(pg);
			for (int i=0;i<pg_room;i++){
				pg.get(i).give_hostel();
			}
		}
		if (ug_room!=0){
			//if number of rooms for ug students!=0,
			//give them hostel according to distance
			sort(ug);
			for (int i=0;i<ug_room;i++){
				ug.get(i).give_hostel();
			}
		}
		for (int i=0;i<n;i++){
			//print list of students who got hostel
			if (s1[i].check_hostel()==true)System.out.println(s1[i]);
		}
	}
}