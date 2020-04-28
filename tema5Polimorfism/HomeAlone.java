package tema5Polimorfism;

public class HomeAlone extends Movie {
	
	public HomeAlone() {
		super("Home Alone");
	}

	@Override
	public void movieCategory() {
		System.out.println("Comedy movie");
	}

}
