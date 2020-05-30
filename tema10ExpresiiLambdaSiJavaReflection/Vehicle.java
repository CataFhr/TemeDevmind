package tema10ExpresiiLambdaSiJavaReflection;

public class Vehicle {
	  private final String serialNumber;
	  private int noPersons;
	  private String name;
	 
	  public Vehicle(String serialNumber, int noPersons, String name) {
	    this.serialNumber = serialNumber;
	    this.noPersons = noPersons;
	    this.name = name;
	  }
	 
	  public Vehicle(String serialNumber, int noPersons) {
	    this(serialNumber, noPersons, "");
	  }
	 
	  private void displaySerialNumberAndPassword() {
	    System.out.println("Method hacked: " + serialNumber);
	    System.out.println("Password is: " + "dsf98fsd98!{dev}hack!345m");
	  }
	 
	  private boolean changeNoPersons(int no) {
	    this.noPersons = no;
	  //  System.out.println("Numarul de persoane maxim:" + this.noPersons);
	    return true;
	  }
	}
