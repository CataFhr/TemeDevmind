package tema4FormeGeometrice;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Shape shape1 = new Shape("Math is easy", "plastic");
		Triangle triangle1 = new Triangle("\"I reflect light\"", "glass", 23, 11);
		Rectangle rectangle1 = new Rectangle("\"Yellow rectangle\"", "steel", 10, 50);

		Shape shape2 = new Shape("Math is easy", "plastic");
		Triangle triangle2 = new Triangle("\"I reflect light\"", "glass", 23, 11);
		Rectangle rectangle2 = new Rectangle("\"Yellow rectangle\"", "steel", 10, 50);

		Shape shape3 = new Shape();
		Triangle triangle3 = new Triangle(23, 11);
		Rectangle rectangle3 = new Rectangle("\"Yellow rectangle\"", "steel", 15, 75);

		Triangle triangle4 = new Triangle("\"Yellow rectangle\"", "steel", 10, 50);
		Rectangle rectangle4 = new Rectangle("\"I reflect light\"", "glass", 23, 11);

		System.out.println("//getSize() test");
		System.out.println(shape1.getSize());
		System.out.println(triangle1.getSize());
		System.out.println(rectangle1.getSize());
		System.out.println(triangle3.getSize());
		System.out.println(rectangle3.getSize());
		System.out.println();

		System.out.println("//toString() test");
		System.out.println(shape1);
		System.out.println(triangle1);
		System.out.println(rectangle1);
		System.out.println();

		System.out.println("//equals(Object obj) test");
		System.out.println(triangle1.equals(triangle2));
		System.out.println(rectangle1.equals(rectangle2));
		System.out.println(shape1.equals(shape2));

		System.out.println(triangle1.equals(triangle3));
		System.out.println(rectangle1.equals(rectangle3));
		System.out.println(shape1.equals(shape3));

		System.out.println(triangle1.equals(rectangle4));
		System.out.println(rectangle1.equals(triangle4));
		System.out.println();

		System.out.println("//hashCode() test");
		System.out.println(triangle1.hashCode());
		System.out.println(triangle2.hashCode());
		System.out.println(triangle3.hashCode());
		System.out.println(triangle4.hashCode());
		System.out.println();

		System.out.println(rectangle1.hashCode());
		System.out.println(rectangle2.hashCode());
		System.out.println(rectangle3.hashCode());
		System.out.println(rectangle4.hashCode());
		System.out.println();

		System.out.println(shape1.hashCode());
		System.out.println(shape2.hashCode());
		System.out.println(shape3.hashCode());
		System.out.println();

		System.out.println("//Upcasting test");
		Shape shape5 = new Shape("Math is fun", "iron");
		Triangle triangle5 = new Triangle("\"Red triangle\"", "iron", 20, 10);
		Rectangle rectangle5 = new Rectangle("\"Yellow rectangle\"", "steel", 5, 20);
		Shape shape6 = new Shape("Math is easy", "plastic");
		Triangle triangle6 = new Triangle("\"Blue triangle\"", "glass", 25, 12);
		Rectangle rectangle6 = new Rectangle("\"Green rectangle\"", "plastic", 15, 75);

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(shape5);
		shapes.add(triangle5);
		shapes.add(rectangle5);
		shapes.add(shape6);
		shapes.add(triangle6);
		shapes.add(rectangle6);

		for (int i = 0; i < shapes.size(); i++) {
			System.out.println(shapes.get(i));
			System.out.println(shapes.get(i).getSize());
		}
		System.out.println();

		System.out.println("//Downcasting test");
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
