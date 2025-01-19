import java.util.ArrayList;

public class Consultas {

	public static void main(String[] args) {
		hacerAlgo(new ArrayList<Integer>());
		hacerAlgo(null);
		
		Animal a = new Animal();
		a.equals("dddd");
	}

	private static void hacerAlgo(ArrayList<Integer> arrayList) {
		if (arrayList == null || arrayList.size() == 0) {
			System.out.println("Esta vacio");
		}

		if (arrayList != null && arrayList.size() > 0) {
		}
	}
}

class Animal {
	public String nombre;
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o instanceof Animal) {
			Animal a = (Animal) o;    // Cast o Moldear
			return a.nombre.equals(this.nombre);
		} else {
			return false;
		}
	}
}

class Perro extends Animal {
	public void ladrar() {}
	
	public boolean equals(Object o) {
		if (o instanceof Animal) {
			Animal a = (Animal) o;
			return a.nombre.equals(this.nombre);
		}
		return false;
		
		// Opcion 2, en una sola linea:
//		return o != null && (o instanceof Animal) && ((Animal)o).nombre.equals(this.nombre);
	}
}