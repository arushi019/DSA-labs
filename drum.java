class drumkit{
	boolean tophat=true;
	boolean snare=true;
	void playsnare(){
		System.out.println("bang bang ba-bang");
	}
	void playtophat(){
		System.out.println("ding ding da-ding");
	}
}
class drumkittestdrive{
	public static void main(String[] args){
		drumkit d=new drumkit();
		d.playsnare();
		d.playtophat();
		d.snare=false;
		if (d.snare==false){
			d.playsnare();
		}
	}
}