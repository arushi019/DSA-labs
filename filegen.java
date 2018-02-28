import java.io.*;
import java.util.*;
class song implements Serializable{
    private String name;
    private double time;
    private String singer;
    public song(String name,double time,String singer){
        this.name=name;
        this.time=time;
        this.singer=singer;
    }
    public String toString(){
        String s=new String("Name: "+name+"\nSinger: "+singer+"\nDuration: "+time);
        return s;
    }
    }
    class player implements Serializable{
    private String name;
   	private ArrayList<song> slist;
    public player(String name){
        this.name=name;
        this.slist=new ArrayList<song>();
    }
    public void set(ArrayList<song> s){
    	slist=s;
    }
	}
	class filegen{
		public static void main(String[] args)throws IOException,ClassNotFoundException{
			song s11=new song("Attention",315.01,"Charlie Puth");
			song s12=new song("I Will Always Return",290.13,"Bryan Adams");
			song s13=new song("November Rain",610.02,"Guns N' Roses");
			song s21=new song("Beautiful Day",330.56,"U2");
			song s22=new song("Treat You Better",300.09,"Shawn Mendes");
			song s23=new song("I'm Yours",180.11,"Alessia Cara");
			song s31=new song("Against All Odds",220.89,"Phil Collins");
			song s32=new song("One More Night",340.67,"Maroon5");
			song s33=new song("Closer",350.89,"Chainsmokers");
			ArrayList<song> l1=new ArrayList<song>();
			l1.add(s11);
			l1.add(s12);
			l1.add(s13);
			ArrayList<song> l2=new ArrayList<song>();
			l2.add(s21);
			l2.add(s22);
			l2.add(s23);
			ArrayList<song> l3=new ArrayList<song>();
			l3.add(s31);
			l3.add(s32);
			l3.add(s33);
			player p1=new player("p1");
			player p2=new player("p2");
			player p3=new player("p3");
			p1.set(l1);
			p2.set(l2);
			p3.set(l3);
			ObjectOutputStream out=null;
                try{
                    out=new ObjectOutputStream(new FileOutputStream("p1.txt"));
                    out.writeObject(p1);
                }finally{
                    out.close();
                }
            out=null;
                try{
                    out=new ObjectOutputStream(new FileOutputStream("p2.txt"));
                    out.writeObject(p2);
                }finally{
                    out.close();
                }
            out=null;
                try{
                    out=new ObjectOutputStream(new FileOutputStream("p3.txt"));
                    out.writeObject(p3);
                }finally{
                    out.close();
                }
                ObjectInputStream in=null;
            try{
                in=new ObjectInputStream(new FileInputStream("p1.txt"));
                player p=(player)in.readObject();
                //p1.put(p.get_name(),p);
                System.out.println(p+" songs");
            }finally{
                in.close();
            }
		}
	}