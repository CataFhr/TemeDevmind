package Tema1Arraylist;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercitiul0 {

	public static void main(String[] args) {
		
	ArrayList<String> list = new ArrayList<String>(Arrays.asList("Catalin","Feher","Andreea","Catalin"));
	list.add("Daniel");
	list.add(0,"George");
	System.out.println(list);
	
	System.out.println("Dimensiunea listei: "+list.size());
	System.out.println("Contine lista numele Catalin? "+list.contains("Catalin"));
	System.out.println("Poitia primei aparitii a numelui Catalin "+list.indexOf("Catalin"));
	System.out.println("Poitia ultimei aparitii a numelui Catalin "+list.indexOf("Catalin"));
	
	System.out.println(list);
	list.remove("Mariusss");  //false
 
	
	
	for (int i=0;i<list.size();i++) {
		System.out.print(list.get(i)+ " ");
	}
	System.out.println();
	
	int index=0;
	if (index<list.size() && index>=0) {
		list.set(index, "Catalin");
	}
	System.out.println(list);
	
	
	

	}

}
