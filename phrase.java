public class phrase{
	public static void main(String[] args){
		String[] word1={"24/7","multi-tier","30000 foot","win-win"};
		String[] word2={"empowered","sticky","value-added","centric"};
		String[] word3={"process","tipping-point","solution","mindshare"};
		int len1=word1.length;
		int len2=word2.length;
		int len3=word3.length;
		int rand1=(int)(Math.random()*len1);
		int rand2=(int)(Math.random()*len2);
		int rand3=(int)(Math.random()*len3);
		String phrase=word1[rand1]+" "+word2[rand2]+" "+word3[rand3];
		System.out.println("What we need is a "+phrase);
	}
}