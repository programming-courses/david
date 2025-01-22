package clase20250122;

import java.util.Iterator;
import java.util.Random;

import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class Ejemplo6 {
	
	public static Iterable<Integer> multiplicaPares(Iterable<Integer> iterable) {
		if (iterable == null) {
			throw new IllegalArgumentException();
		}
		Iterator<Integer> it = iterable.iterator();
		PositionList<Integer> res = new NodePositionList<>();
		if (!it.hasNext()) {
			return res;
		}
		Integer prev = null;
		while (it.hasNext()) {
			Integer current = it.next();
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
		NodePositionList<Integer> lista = new NodePositionList<Integer>();
		Random rnd = new Random();
		for(int i=0; i< 20; i++) {
			int value = rnd.nextInt(100) - 30;  // Valores entre -30 y 69
			if (value < 0)
				lista.addLast(null);
			else
				lista.addLast(value);
		}
		
		System.out.print("La lista:  ");
		System.out.println(lista);
		
		Iterable<Integer> res = Ejemplo6.multiplicaPares(lista);
		System.out.print("Resultado: ");
		System.out.println(res);
	}
	/* Ejemplo de ejecucion:
	 * 
	 * La lista:  [null, 58, 38, null, 4, 53, 34, 68, 61, 17, 8, 37, 16, 24, null, 54, null, null, 30, 49]
	 * Resultado: [2204, 152, 212, 1802, 2312, 4148, 1037, 136, 296, 592, 384, 1296, 1620, 1470]
	 * 
	 */
}
