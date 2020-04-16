package Tema3Mostenire;

public class Main {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle("3FDS9DFF8FSD7", 4, "Moby");
		vehicle.goTo(10, 10);
		vehicle.addFuel(20);
		vehicle.printInfo();
		System.out.println();

		OnRoad car = new OnRoad("FDFL8KMFSDLKM6", 2, "Sportify", 4, 2);
		car.goTo(21.3, 12.88);
		car.addFuel(35);
		car.printInfo();
		System.out.println();

		OnWater boat = new OnWater("F8GFDG86D87GGD", 20, "Wavess", 2, 2000.0);
		boat.goTo(11.8, 4.33);
		boat.addFuel(148.5);
		boat.printInfo();
		System.out.println();
		
		OnAir plane = new OnAir("GJR96GDF98DF9ND", 120, "Bluesky", 4, true);
		plane.goTo(41.3, 120.88);
		plane.addFuel(3000.5);
		plane.printInfo();
		System.out.println();

	}

}
