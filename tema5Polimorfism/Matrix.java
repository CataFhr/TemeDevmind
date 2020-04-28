package tema5Polimorfism;

public class Matrix extends Movie {

	public Matrix() {
		super("Matrix");
	}

	@Override
	public void movieCategory() {
		System.out.println("SF movie");
	}
	
}
