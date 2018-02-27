import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;
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
class song implements Serializable{
    private String name;
    private double time;
    private String singer;
    public song(String name,double time,String singer){
        this.name=name;
        this.time=time;
        this.singer=singer;
    }
    public String get_name(){
        return name;
    }
    public String toString(){
        String s=new String("Name: "+name+"\nSinger: "+singer+"\nDuration: "+time);
        return s;
    }
    public String get_singer(){
        return singer;
    }
    public double get_time(){
        return time;
    }
}
class player implements Serializable{
    private String name;
    private ArrayList<song> slist;
    public player(String name){
        this.name=name;
        this.slist=new ArrayList<song>();
    }
    public int get_size(){
        return slist.size();
    }
    public String get_name(){
        return name;
    }
    public void add(song s)throws IOException{
        //add song s to list
        slist.add(s);
        System.out.println(slist.size());
    }
    public void del(String s){
        int flag=-1;
        for (int i=0;i<slist.size();i++){
            if (slist.get(i).get_name().equals(s)){flag=i;break;}
        }    
        if (flag==-1)System.out.println("Song does not exist");
        else slist.remove(flag);
    }
    public void search(String name){
        int flag=-1;
        for (int i=0;i<slist.size();i++){
            if (slist.get(i).get_name().equals(name)){flag=i;break;}
        }
        if (flag==-1)System.out.println("Song does not exist");
        else System.out.println(slist.get(flag));
    }
    public String search_string(String name){
        int flag=-1;
        for (int i=0;i<slist.size();i++){
            if (slist.get(i).get_name().equals(name)){flag=i;break;}
        }
        String s=new String();
        if (flag==-1)s="Song does not exist";
        else s=new String("Name: "+name+"\nSinger: "+slist.get(flag).get_singer()+"\nDuration: "+slist.get(flag).get_time());
        return s;
    }
    public void disp(){
        if (slist.size()==0)System.out.println("No song exists");
        else{
        for (int i=0;i<slist.size();i++){
            System.out.println(slist.get(i));
        }
    }
}
    public String disp_string(){
        String s=new String();
        if (slist.size()==0)s=("No song exists");
        else{
            for (int i=0;i<slist.size();i++){
                s=s+slist.get(i).get_name()+"*";
            }
        }
        return s;
    }
    public void set(ArrayList<song> s){
        slist=s;
    }
    public int list_menu()throws IOException{
        System.out.println(name+" Menu");
        System.out.println("1.Add\n2.Delete\n3.Search\n4.Show\n5.Back to Menu\n6.Exit");
        int ch=Reader.nextInt();
        if (ch==1){
            System.out.println("Enter name, duration and name of singer of song");
            String s1=Reader.next();
            double d1=Reader.nextDouble();
            String s2=Reader.next();
            song s=new song(s1,d1,s2);
            add(s);
        }
        else if (ch==2){
            System.out.println("Enter name of song to be deleted");
            String s=Reader.next();
            del(s);
        }
        else if (ch==3){
            System.out.println("Enter name of song to be searched");
            String s=Reader.next();
            search(s);
        }
        else if (ch==4)disp();
        else if (ch==5)return 5;
        else if (ch==6)return 6;
        return -1;
    }
}
class aplab7{
    public static void main(String[] args)throws IOException,ClassNotFoundException{
        Reader.init(System.in);
        launch();
    }
    public static void launch()throws IOException,ClassNotFoundException{
        /*song s11=new song("Attention",315.01,"Charlie_Puth");
            song s12=new song("I_Will_Always_Return",290.13,"Bryan_Adams");
            song s13=new song("November_Rain",610.02,"Guns_N'_Roses");
            song s21=new song("Beautiful_Day",330.56,"U2");
            song s22=new song("Treat_You_Better",300.09,"Shawn_Mendes");
            song s23=new song("I'm_Yours",180.11,"Alessia_Cara");
            song s31=new song("Against_All_Odds",220.89,"Phil_Collins");
            song s32=new song("One_More_Night",340.67,"Maroon5");
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
            player p11=new player("p1");
            player p2=new player("p2");
            player p3=new player("p3");
            p11.set(l1);
            p2.set(l2);
            p3.set(l3);
            ObjectOutputStream out=null;
                try{
                    out=new ObjectOutputStream(new FileOutputStream("p1.txt"));
                    out.writeObject(p11);
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
                }*/
        File dir=new File("C:/Users/Arushi Chauhan/Desktop/desktop/java/src/aplab7/");
        String[] files=dir.list();
        HashMap<String,player> p1=new HashMap<String,player>();
        for (int i=0;i<3;i++){
            System.out.println(files[i]);
            //initialise playlists here
            ObjectInputStream in=null;
            try{
                in=new ObjectInputStream(new FileInputStream(files[i]));
                player p=(player)in.readObject();
                p1.put(p.get_name(),p);
                System.out.println(p.get_size()+" songs");
            }finally{
                //in.close();
            }
        }
        int exit=0;
        do{
            System.out.println("Enter name of playlist");
            String s=Reader.next();
            int flag=-1;
            if (p1.containsKey(s)==false){
                System.out.println("Playlist not found");
                exit=0;
            }else{
                player temp=p1.get(s);
                int ch=temp.list_menu();
                while(ch==-1){
                    ch=temp.list_menu();
                }
                ObjectOutputStream outs=null;
                try{
                    outs=new ObjectOutputStream(new FileOutputStream(new String(temp.get_name()+".txt")));
                    outs.writeObject(temp);
                }finally{
                    outs.close();
                }
                exit=ch;
            }
        }while(exit!=6);
    }
}