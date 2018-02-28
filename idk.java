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
public class idk{
	public int arr[]=new int[10000];
	public int pos;
	public int cap;
	public idk(int c){
		arr=new int[c];
		cap=c;
		pos=-1;
	}
	public int search(int key){
		int i;
		for (i=0;i<(pos+1);i++){
			if(arr[i]==key)return (i);
		}
		return (-1);
	}
	public void display(){
		int i;
		for (i=0;i<(pos+1);i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	public void insert(int key,int place){
		int i,temp;
		if (pos!=(cap-1)){
			for (i=pos;i>=place;i--){
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			arr[place]=key;
			if (place<=pos)
			pos++;
			else
				pos=place;
			}
			display();
	}
	public void dele(int place){
		int i,temp;
		if (pos!=(-1)){
			for (i=place;i<pos;i++){
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			arr[pos]=0;
			pos--;
		}
		display();
	}
	public static void main(String[] args){
		//idk a=new idk(5);
		/*a.insert(1,0);
		a.insert(2,1);
		a.insert(3,2);
		a.insert(6,3);
		a.insert(7,1);
		a.dele(3);*/
		inp i=new inp();
		int n,ch,k,p;
		n=Integer.parseInt(i.getUserInput("Enter max size of array"));
		idk a=new idk(n);
		do{
			ch=Integer.parseInt(i.getUserInput("Enter 1 if you want to insert,2 if you want to delete,3 to exit"));
			if (ch==1){
				k=Integer.parseInt(i.getUserInput("Enter value to be inserted"));
				p=Integer.parseInt(i.getUserInput("Enter index where it is to be inserted"));
				a.insert(k,p);
			}
			if (ch==2){
				p=Integer.parseInt(i.getUserInput("Enter index to be deleted"));
				a.dele(p);
			}
		}while(ch!=3);
	}
}