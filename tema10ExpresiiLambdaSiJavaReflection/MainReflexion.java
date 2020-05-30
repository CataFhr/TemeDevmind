package tema10ExpresiiLambdaSiJavaReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflexion {

	public static void main(String[] args) {

		Class<?> vehicleClass = Vehicle.class; // = Class.forName("tema10ExpresiiLambdaSiJavaReflection.Vehicle");

		String serialNo = "7716471182";
		int noPersons = 4;
		String name = "Audi";
		Vehicle vehicle = new Vehicle(serialNo, noPersons, name);

		Method[] methods = vehicleClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		Method changeNoPersons = methods[0];
		Method displaySerialNoAndPassword = methods[1];
		changeNoPersons.setAccessible(true);
		displaySerialNoAndPassword.setAccessible(true);

		try {
			System.out.println(changeNoPersons.invoke(vehicle, noPersons * 2));
			displaySerialNoAndPassword.invoke(vehicle);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
