import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
//-----------------------
//AP LAB 3
//Arushi Chauhan 
//2016019
//-----------------------
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

class creature{
    //creature is a superclass in this question
    //all creatures have name,power,health,cost and asset as common attributes
    protected String name;
    protected int power;
    protected int health;
    protected int cost;
    protected int asset;
    public int attack(){
        //this gives the attack caused by a creature as per Point 1 in question
        Random r=new Random();
        int sum=r.nextInt(power);
        System.out.println("I am a creature and I give damage of "+sum);
        return sum;
    }
    protected void set(String name){
        //setter method for name of creature
        this.name=name;
    }
    protected String get_name(){
        //return name of creature
        return this.name;
    }
    protected void reduce_health(int pts){
        //reduce health of creature by pts points
        health-=pts;
    }
    protected int get_health(){
        //returns integer denoting health of creature
        return health;
    }
    protected int get_asset(){
        //returns integer denoting asset of creature
        return asset;
    }
}
class human extends creature{
    //class human is subclass of class creature
    public human(int cost,int asset,int power,int health){
        //constructor for class human
        super();
        this.cost=cost;
        this.asset=asset;
        this.power=power;
        this.health=health;
    }
}
class dragon extends creature{
    //class dragon is subclass of class creature
    public dragon(int cost,int asset,int power,int health){
        //constructor for class dragon
        super();
        this.cost=cost;
        this.asset=asset;
        this.power=power;
        this.health=health;
    }
    @Override
    public int attack(){
        int sum=super.attack();
        int chance=new Random().nextInt(100);
        if (chance<15)sum+=25;
        System.out.println("I am a dragon and I give damage of "+sum+" when chance was "+chance);
        return sum;
    }
} 
class daemon extends creature{
    //class daemon is subclass of class creature
    public daemon(int cost,int asset,int power,int health){
        //constructor for daemon
        super();
        this.cost=cost;
        this.asset=asset;
        this.power=power;
        this.health=health;
    }
    @Override
    public int attack(){
        int sum=super.attack();
        int chance=new Random().nextInt(100);
        if (chance<50)sum*=2;
        System.out.println("I am a daemon and I give damage of "+sum+" when chance was "+chance);
        return sum;
    }
}
class wolf extends creature{
    //class wolf is subclass of class creature
    public wolf(int cost,int asset,int power,int health){
        //constructor for wolf
        super();
        this.cost=cost;
        this.asset=asset;
        this.power=power;
        this.health=health;
    }
}
class ice_dragon extends dragon{
    //class ice dragon is subclass of class dragon
    public ice_dragon(int cost,int asset,int power,int health){
        //constructor for ice dragon
        super(cost,asset,power,health);
        this.cost=cost;
        this.asset=asset;
        this.power=power;
        this.health=health;
    }
    @Override
    public int attack(){
        //as per Point 4
        //If the combat is with ice dragon, there is another 5% chance that they will attack again
        //but damage will be random.
        int sum=super.attack();
        int chance=new Random().nextInt(100);
        if (chance<5)sum+=new Random().nextInt(power);
        System.out.println("I am an ice dragon and I give damage of "+sum+" when chance was "+chance);
        return sum;
    }
}
class fire_dragon extends dragon{
    //class fire dragon is subclass of class dragon
    public fire_dragon(int cost,int asset,int power,int health){
        //constructor for fire dragon
        super(cost,asset,power,health);
        this.cost=cost;
        this.asset=asset;
        this.power=power;
        this.health=health;
    }
}
class aplab3{
    public static ArrayList<creature> g_team,b_team;
    //g_team===>Team Good
    //b_team===>Team Bad
    public static int g_money,b_money,g_min,b_min;
    //g_money=amount of money with Team Good
    //g_min=minimum amount of money required to purchase a creature for Team Good
    //b_money=amount of money with Team Bad
    //b_min=minimum amount of money required to purchase a creature for Team Bad
    public static int[][] mat;
    //matrix for storing attribute values of different creatures
    public static creature get_creature(String name,ArrayList<creature> a){
        //retrieve a creature from its team based on name
        for (int i=0;i<a.size();i++){
            if (name.equals(a.get(i).get_name()))return a.get(i);
        }
        return null;
    }
    public static void add_creatures(char c)throws IOException{
        //function to add creatures to team
        if (c=='g'){
            //add creatures to Team Good
            int g_choice=0;
            do{
            System.out.println("Select Creatures For Team Good:\n1. Human\n2. Fire Dragon\n3. Wolf\n4. Exit Selection");
            g_choice=Reader.nextInt();
            if (g_choice==1){
                human h=new human(mat[0][0],mat[0][1],mat[0][2],mat[0][3]);
                if (g_money>=mat[0][0]){
                    //buy only if money is sufficient
                System.out.println("Enter Name Of The Human");
                h.set(Reader.next());
                g_team.add(h);
                g_money-=mat[0][0];}
                else System.out.println("Sorry you cannot buy this");
            }
            if (g_choice==2){
                fire_dragon f=new fire_dragon(mat[1][0],mat[1][1],mat[1][2],mat[1][3]);
                if (g_money>=mat[1][0]){
                    //buy only if money is sufficient
                System.out.println("Enter Name Of The Fire Dragon");
                f.set(Reader.next());
                g_team.add(f);
                g_money-=mat[1][0];}
                else System.out.println("Sorry you cannot buy this");
            }
            if (g_choice==3){
                wolf w=new wolf(mat[4][0],mat[4][1],mat[4][2],mat[4][3]);
                if (g_money>=mat[4][0]){
                    //buy only when money is sufficient
                System.out.println("Enter Name Of The Wolf");
                w.set(Reader.next());
                g_team.add(w);
                g_money-=mat[4][0];}
                else System.out.println("Sorry you cannot buy this");
            }
            //System.out.println(g_money);
        }
        while((g_money>=g_min)&&(g_choice!=4));
        }
        else{
            int b_choice=0;
            do{
            System.out.println("Select Creatures For Team Bad:\n1. Daemon\n2. Ice Dragon\n3. Exit Selection");
            b_choice=Reader.nextInt();
            if (b_choice==1){
                daemon d=new daemon(mat[3][0],mat[3][1],mat[3][2],mat[3][3]);
                if (b_money>=mat[3][0]){
                    //buy only when money is sufficient
                System.out.println("Enter Name Of The Daemon");
                d.set(Reader.next());
                b_team.add(d);
                b_money-=mat[3][0];}
                else System.out.println("Sorry you cannot buy this");
            }
            if (b_choice==2){
                ice_dragon ice=new ice_dragon(mat[2][0],mat[2][1],mat[2][2],mat[2][3]);
                if (b_money>=mat[2][0]){
                    //buy only when money is sufficient
                System.out.println("Enter Name Of The Ice Dragon");
                ice.set(Reader.next());
                b_team.add(ice);
                b_money-=mat[2][0];}
                else System.out.println("Sorry you cannot buy this");
            }
        }
        while((b_money>=b_min)&&(b_choice!=3));
        }
    }
    public static void battle()throws IOException{
        System.out.println("Enter Creature from Good's Team to fight in the war");
        String g_name=Reader.next();
        System.out.println("Enter Creature from Bad's Team to fight in the war");
        String b_name=Reader.next();
        int i=1;
        creature g_warrior=get_creature(g_name,g_team);
        creature b_warrior=get_creature(b_name,b_team);
        while((g_team.size()!=0)&&(b_team.size()!=0)){
            System.out.println("Round "+i);
            int g_attack=g_warrior.attack();
            int b_attack=b_warrior.attack();
            System.out.println(g_warrior.get_name()+" gets a damage of "+b_attack);
            System.out.println(b_warrior.get_name()+" gets a damage of "+g_attack);
            g_warrior.reduce_health(b_attack);
            b_warrior.reduce_health(g_attack);
            System.out.println(g_warrior.get_health()+" "+b_warrior.get_health());
          if ((g_warrior.get_health()<=0)&&(b_warrior.get_health()<=0)){
            System.out.println("Both "+g_warrior.get_name()+" "+b_warrior.get_name()+" lose in Round "+i);
            g_team.remove(g_warrior);
            b_team.remove(b_warrior);
            if (g_team.size()>0){
                System.out.println("Enter Creature from Good's Team to fight in the war");
                g_warrior=get_creature(Reader.next(),g_team);
            }
            else{
                if (g_money<g_min)break;
                else{
                    add_creatures('g');
                    System.out.println("Enter Creature from Good's Team to fight in the war");
                    g_warrior=get_creature(Reader.next(),g_team);
                }
            }
            if (b_team.size()>0){
                System.out.println("Enter Creature from Bad's Team to fight in the war");
                b_warrior=get_creature(Reader.next(),b_team);
            }
            else{
                if (b_money<b_min)break;
                else{
                add_creatures('b');
                System.out.println("Enter Creature from Bad's Team to fight in the war");
                b_warrior=get_creature(Reader.next(),b_team);
                }
            }

        }
        else if (g_warrior.get_health()<=0){
            System.out.println(g_warrior.get_name()+" loses in Round "+i);
            b_money+=g_warrior.get_asset();
            g_team.remove(g_warrior);
            if (g_money<g_min)break;
            else{
            add_creatures('g');
            System.out.println("Enter Creature from Good's Team to fight in the war");
            g_warrior=get_creature(Reader.next(),g_team);
            }
        }
        else if (b_warrior.get_health()<=0){
            System.out.println(b_warrior.get_name()+" loses in Round "+i);
            g_money+=b_warrior.get_asset();
            b_team.remove(b_warrior);
            if (b_money<b_min)break;
            else{
            add_creatures('b');
            System.out.println("Enter Creature from Bad's Team to fight in the war");
            b_warrior=get_creature(Reader.next(),b_team);
                }
            }
            i++;
            System.out.println("Money Of Good's Team is "+g_money);
            System.out.println("Money Of Bad's Team is "+b_money);
        }
        if (g_money>b_money)System.out.println("Team Good wins the war. The money the team has is "+g_money);
        else System.out.println("Team Bad wins the war. The money the team has is "+b_money);
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        System.out.println("Enter Team Good's total money");
        g_money=Reader.nextInt();
        g_min=Integer.MAX_VALUE;
        System.out.println("Enter Team Bad's total money");
        b_money=Reader.nextInt();
        b_min=Integer.MAX_VALUE;
        mat=new int[5][4];
        System.out.println("Enter cost, asset , power and health for Human (space-separated)");        
        for (int i=0;i<4;i++){
            mat[0][i]=Reader.nextInt();
        }
        if (mat[0][0]<g_min)g_min=mat[0][0];
        System.out.println("Enter cost, asset , power and health for Fire Dragon (space-separated)");
        for (int i=0;i<4;i++){
            mat[1][i]=Reader.nextInt();
        }
        if (mat[1][0]<g_min)g_min=mat[1][0];
        System.out.println("Enter cost, asset , power and health for Ice Dragon (space-separated)");
        for (int i=0;i<4;i++){
            mat[2][i]=Reader.nextInt();
        }
        if (mat[2][0]<b_min)b_min=mat[2][0];
        System.out.println("Enter cost, asset , power and health for Daemon (space-separated)");
        for (int i=0;i<4;i++){
            mat[3][i]=Reader.nextInt();
        }
        if (mat[3][0]<b_min)b_min=mat[3][0];
        System.out.println("Enter cost, asset , power and health for Wolf (space-separated)");
        for (int i=0;i<4;i++){
            mat[4][i]=Reader.nextInt();
        }
        if (mat[4][0]<g_min)g_min=mat[4][0];
        int g_choice=0,b_choice=0;
        //System.out.println(g_min+" "+b_min);
        g_team=new ArrayList<creature>();
        b_team=new ArrayList<creature>();
        add_creatures('g');
        add_creatures('b');
        battle();
    }
}