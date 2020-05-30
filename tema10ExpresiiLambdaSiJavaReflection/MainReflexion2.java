package tema10ExpresiiLambdaSiJavaReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflexion2 {
	
	public static Object invocareMetodaPrinReflection(Object obj, String numeMetoda, Object... setDeParametri) {
		int numarParametri = setDeParametri.length;
		Method metodaApelata;
		Object valoareReturn = null;
		Class<?>[] tipurileParametrilor = new Class<?>[numarParametri];
		for (int i = 0; i < numarParametri; i++) {
			tipurileParametrilor[i] = setDeParametri[i].getClass();
		}
		try {
			metodaApelata = obj.getClass().getDeclaredMethod(numeMetoda, tipurileParametrilor);
			metodaApelata.setAccessible(true);
			valoareReturn = metodaApelata.invoke(obj, setDeParametri);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return valoareReturn;
	}

	public static void main(String[] args) {
		String serialNo = "7716471182";
		int noPersons = 4;
		String name = "Audi";
		Vehicle vehicle = new Vehicle(serialNo, noPersons, name);
		Method primaMetoda = Vehicle.class.getDeclaredMethods()[0];
		invocareMetodaPrinReflection(vehicle, primaMetoda.getName(), (Object[]) primaMetoda.getParameters());
	}
}
