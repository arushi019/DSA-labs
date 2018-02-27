package IntroductoryExamples;

public class Stringexample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";

		System.out.println(str); // Output?

		str = "Hello Students";

		System.out.println(str); // Output?

		str.concat(", Welcome!");

		System.out.println(str); // Output?
		
		System.out.println(str.concat(", Welcome!")); // Output?
		
		str = str.replace("Hello", "Hi");

		System.out.println(str); // Output?

	}

}
