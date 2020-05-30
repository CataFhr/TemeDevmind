package tema10ExpresiiLambdaSiJavaReflection;

public class MainFunctional {

	public static void main(String[] args) {

		IOperator sum = (a, b) -> a + b;
		IOperator subtract = (a, b) -> a - b;
		IOperator multiply = (a, b) -> a * b;
		IOperator divide = (a, b) -> a / b;
		IOperator moduleA = (a, b) -> Math.abs(a);
		IOperator moduleB = (a, b) -> Math.abs(b);
		int a = -3;
		int b = 5;
		System.out.println("Adumarea: " + sum.operation(a, b));
		System.out.println("Scaderea: " + subtract.operation(a, b));
		System.out.println("Inmultirea: " + multiply.operation(a, b));
		System.out.println("Impartirea: " + divide.operation(a, b));
		System.out.println("ModulA: " + moduleA.operation(a, b));
		System.out.println("ModulB: " + moduleB.operation(a, b));

		IVerifyProperty isEven = x -> x % 2 == 0;
		IVerifyProperty isNegative = x -> x < 0;
		IVerifyProperty isZero = x -> x == 0;
		int x = -4;
		System.out.println(isEven.hasProperty(x));
		System.out.println(isNegative.hasProperty(x));
		System.out.println(isZero.hasProperty(x));

	}

}
