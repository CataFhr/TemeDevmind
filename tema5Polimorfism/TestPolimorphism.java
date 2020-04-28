package tema5Polimorfism;

public class TestPolimorphism {

	public static void main(String[] args) {

		// polimorfism dinamic

		Movie movie1 = new Movie("No name");
		Movie movie2 = new Matrix();
		Movie movie3 = new HomeAlone();
		movie1.movieCategory();
		movie2.movieCategory();
		movie3.movieCategory();
		System.out.println();

		// polimorfism static

		Calculator calculator = new Calculator();
		System.out.println(calculator.sum(10, 20));
		System.out.println(calculator.sum(9, 5, 10));
		System.out.println(calculator.sum(2.5, 2.2));

	}

}
