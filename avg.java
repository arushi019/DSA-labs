import java.io.*;
class inp{
	public String getUserInput(String prompt){
		String inputLine=null;
		System.out.print(prompt);
		try{
			BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
			inputLine=is.readLine();
			if (inputLine.length()==0){
				return null;
			}
		}
		catch (IOException e){
			System.out.println("IOException: "+e);
		}
		return inputLine;
	}
}
public class avg{
	public static void main(String[] args) throws IOException{
		int n;
		int a[]=new int[1000];
		float avgs;
		inp i=new inp();
		n=Integer.parseInt(i.getUserInput(""));
		int t,ct;
		long sum;
		sum=0;
		ct=0;
		for(t=0;t<n;t++){
			a[t]=Integer.parseInt(i.getUserInput(""));
			sum+=a[t];
		}
		avgs=sum/n;
		//System.out.println(avgs);
		for (t=0;t<n;t++){
			if (a[t]>avgs)ct++;
		}
		System.out.print(ct);

	}
}