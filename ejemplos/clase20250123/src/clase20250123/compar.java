package clase20250123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

class Auto implements Comparable<Auto> {
	public int numero;
	public float peso;

	public Auto(int numero) {
		this.numero = numero;
	}

	public int compareTo(Auto o) {

		return this.numero - o.numero;
	}
}

class ComparadorAuto implements Comparator<Auto> {

	public int compare(Auto o1, Auto o2) {
		return o1.numero - o2.numero;
	}
}

public class compar {

	public static <E> PositionList<E> ordenar(PositionList<E> list, Comparator<E> cmp) {
		if (list == null || cmp == null) {
			throw new IllegalArgumentException();
		}

		PositionList<E> res = new NodePositionList<>();
		for (E e : list) {
			Position<E> cursor = res.first();

			while (cursor != null && cmp.compare(cursor.element(), e) < 0) {
				cursor = list.next(cursor);
			}

			if (cursor != null)
				list.addBefore(cursor, e);
			else
				list.addLast(e);
		}
		return res;
	}

	public static void main(String[] args) {
		Auto a = new Auto(50);
		Auto b = new Auto(60);

		a.compareTo(b);

		ComparadorAuto cmp = new ComparadorAuto();

		cmp.compare(a, b);

		ArrayList<Auto> autos = new ArrayList<Auto>();
		autos.add(a);
		autos.add(b);

		Collections.sort(autos, new Comparator<Auto>() {
			public int compare(Auto o1, Auto o2) {
				// TODO Auto-generated method stub
				return 0;
			}

		});

	}
}
