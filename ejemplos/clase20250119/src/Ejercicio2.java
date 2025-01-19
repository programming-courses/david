import java.util.ArrayList;
import java.util.Iterator;

import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class Ejercicio2 {
	public static Iterable<Integer> multiplicaPares(Iterable<Integer> iterable) {
		if (iterable == null) {
			throw new IllegalArgumentException();
		}
		Iterator<Integer> it = iterable.iterator();
		PositionList<Integer> res = new NodePositionList<>();
		if (!it.hasNext()) {  // Sin elementos
			return res;   // Devuelve el iterable vacio (NodePositionList)
		}
		Integer prev = null;
		while (it.hasNext()) {
			Integer current = it.next();   // Agarrar elemento
			if (current != null) {
				if (prev != null) {
					res.addLast(prev * current);
				}
				prev = current;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for(Integer i : lista) {  // For each, es para recorrer Iterables, simplifica la creacion del cursor, hasNext, next
			
		}

	}

}
