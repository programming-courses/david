import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;


/*
 * Ejercicio es una clase generica, donde E es un tipo de datos "Comodin"
 * <E> se va a "reemplazar" durante la compilacion por el tipo de dato que se necesite
 */
public class Ejercicio<E> {

	public static <E> PositionList<Boolean> estaRepetidoEnListas(PositionList<PositionList<E>> listas, E element) {

		PositionList<Boolean> res = new NodePositionList<>();
		Position<PositionList<E>> cursor = listas.first();	// Agarrar la primera lista
		while (cursor != null) {
			// estaRepedito recibe la i-esima lista 
			
			
			// Aca iria el codigo de la funcion auxiliar
			
			res.addLast(estaRepetido(cursor.element(), element));
			
			cursor = listas.next(cursor);
		}
		return res;
	}

	private static <E> boolean estaRepetido(PositionList<E> list, E element) {
		Position<E> cursor = list.first();
		int counter = 0;
		while (cursor != null && counter < 2) {
			if (eqNull(cursor.element(), element)) {
				counter++;
			}
			cursor = list.next(cursor);   // :)
		}
		return counter == 2;
	}

	public static boolean eqNull(Object o1, Object o2) {
		return o1 == o2 || (o1 != null && o1.equals(o2));
	}
	
	public static void main(String[] args) {
		Ejercicio<Integer> listaInt = new Ejercicio<Integer>(); // Al Compilar se crea una clase nueva de Ejercicio especializada en Integer
		Ejercicio<String> listaStr = new Ejercicio<String>(); // Al Compilar se crea una clase nueva
		Ejercicio<Perro> listaPerros = new Ejercicio<Perro>(); // Al Compilar se crea una clase nueva

	}

}
