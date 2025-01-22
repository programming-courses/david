package clase20250120;

import java.util.ArrayList;
import java.util.Collections;

class Animal implements Comparable<Animal >{
	private int peso;
	private int nombre;
	private int edad;
	
	
	public Animal(int peso) {
		this.peso = peso;
	}

	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}



public class Ejemplos1 {


	public static void main(String[] args) {
		Animal a = new Animal(20);
		Animal b = new Animal(15);
		
		ArrayList<Animal> lista = new ArrayList<Animal>();
		lista.add(a);
		lista.add(b);
		
		Collections.sort(lista);
//		a.compareTo(b);    // negativo a < b , positov 
//		a > b
		

	}

}
