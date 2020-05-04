package tema6ClaseAbstracte;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Shape triangle1 = new Triangle("\"I reflect light\"", "glass", 23, 11);
		Shape rectangle1 = new Rectangle("\"Yellow rectangle\"", "steel", 10, 50);

		System.out.println(triangle1.getSize());
		System.out.println(rectangle1.getSize());
		System.out.println();

		Triangle triangle2 = new Triangle("\"Red triangle \"", "steel", 10, 50);
		Rectangle rectangle2 = new Rectangle("\"I reflect light\"", "glass", 23, 11);
		Triangle triangle3 = new Triangle("\"Red triangle\"", "iron", 20, 10);
		Rectangle rectangle3 = new Rectangle("\"Yellow rectangle\"", "steel", 5, 20);
		Shape triangle4 = new Triangle("\"Blue triangle\"", "glass", 25, 12);
		Shape rectangle4 = new Rectangle("\"Green rectangle\"", "plastic", 15, 75);

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(triangle2);
		shapes.add(rectangle2);
		shapes.add(triangle3);
		shapes.add(rectangle3);
		shapes.add(triangle4);
		shapes.add(rectangle4);

		for (int i = 0; i < shapes.size(); i++) {
			System.out.println(shapes.get(i));
			System.out.println(shapes.get(i).getSize());
		}
		System.out.println();

		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof Triangle) {
				Triangle triangle = (Triangle) shapes.get(i);
				triangle.displayTriangleHeight();
			} else if (shapes.get(i) instanceof Rectangle) {
				Rectangle rectangle = (Rectangle) shapes.get(i);
				rectangle.displayRectangleHeight();
			}
		}
	}

}
