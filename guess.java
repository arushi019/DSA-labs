public class Player{
	int number=0;
	public void guess(){
		number=(int)(Math.random()*10);
		System.out.println("I'm guessing"+number);
	}
}
public class GuessGame{
	Player p1;
	Player p2;
	Player p3;
	public void startGame(){
	p1=new Player();
	p2=new Player();
	p3=new Player();
	int guessp1=0;
	int guessp2=0;
	int guessp3=0;
	boolean p1isright=false;
	boolean p2isright=false;
	boolean p3isright=false;
	int targetNumber=(int)(Math.random()*10);
	System.out.println("Thinking of a number");
	while (true){
		System.out.println("number to guess"+targetNumber);
		p1.guess();
		p2.guess();
		p3.guess();
		guessp1=p1.number;
		System.out.println("Player 1 guessed"+guessp1);
		guessp2=p2.number;
		System.out.println("Player 2 guessed"+guessp2);
		guessp3=p3.number;
		System.out.println("Player 3 guessed"+guessp3);
		if (guessp1==targetNumber){
			p1isright=true;
		}
		if (guessp2==targetNumber){
			p2isright=true;
		}
		if (guessp3==targetNumber){
			p3isright=true;
		}
		if (p1isright||p2isright||p3isright){
			System.out.println("Winner!");
			System.out.println("Player1:"+p1isright);
			System.out.println("Player2:"+p2isright);
			System.out.println("Player3:"+p3isright);
			System.out.println("Game Over");
			break;
		}
		else{
			System.out.println("Try Again");
		}
	}
	}
}
public class GameLauncher{
	public static void main (String[] args){
		GuessGame game=new GuessGame();
		game.startGame();
	}
}