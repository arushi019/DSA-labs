package IntroductoryExamples;

import java.util.Arrays;

public class MyArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr=new int[5];
		arr[0]=100;
		arr[1]=350;
		arr[2]=50;
		arr[3]=200;
		arr[4]=300;
		
		System.out.println("Length of the array: "+arr.length);
		System.out.println("Element at index 2: "+arr[2]);
		System.out.println("Content of the array:"+Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println("\nElement at index 2, after sorting: "+arr[2]);
		System.out.println("Content of the array after sorting:"+Arrays.toString(arr));
		
			
		int[] newarr=Arrays.copyOfRange(arr, 0, 2);
		
		System.out.println("\nContent of the new array");
		for(int element:newarr) //using foreach loop
				System.out.print(element+"\t");
		
	
	}

}
