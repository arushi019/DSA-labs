class player{
	int number=0;
	public void guess(){
		number=(int)(Math.random()*10);
		System.out.println("I am guessing number "+number);
	}
}
class guessgame{
	player p1;
	player p2;
	player p3;
	public void startgame(){
		p1=new player();
		p2=new player();
		p3=new player();
		int guessp1=0;
		int guessp2=0;
		int guessp3=0;
		boolean p1isright=false;
		boolean p2isright=false;
		boolean p3isright=false;
		int targetnumber=(int)(Math.random()*10);
		System.out.println("Thinking.....");
		while(true){
			System.out.println("Number to be guessed "+targetnumber);
			p1.guess();
			p2.guess();
			p3.guess();
			guessp1=p1.number;
			System.out.println("Number guessed by p1 is "+guessp1);
			guessp2=p2.number;
			System.out.println("Number guessed by p2 is "+guessp2);
			guessp3=p3.number;
			System.out.println("Number guessed by p3 is "+guessp3);
			if (guessp1==targetnumber){
				p1isright=true;
			}
			if (guessp2==targetnumber){
				p2isright=true;
			}
			if (guessp3==targetnumber){
				p3isright=true;
			}
		
		if (p1isright||p2isright||p3isright){
			System.out.println("Winner!!");
			System.out.println("Player1 "+p1isright);
			System.out.println("Player2 "+p2isright);
			System.out.println("Player3 "+p3isright);
			break;
		}
		else{
			System.out.println("Players will have to try again");
		}
	}
		}
	}

public class gamelauncher{
	public static void main(String[] args){
		guessgame game=new guessgame();
		game.startgame();
	}
}