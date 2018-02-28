class dog{
	String name;
	public void bark(){
		System.out.println(name+" says Buff!");
	}
	public static void main(String[] args){
		dog d1=new dog();
		d1.bark();
		d1.name="Bart";
		dog[] mydogs=new dog[3];
		mydogs[0]=new dog();
		mydogs[1]=new dog();
		mydogs[2]=d1;
		mydogs[0].name="Fred";
		mydogs[1].name="Marge";
		int x=0;
		while(x<mydogs.length){
			mydogs[x].bark();
			x=x+1;
		}
	}

}