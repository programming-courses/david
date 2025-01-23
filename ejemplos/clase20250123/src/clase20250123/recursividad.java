package clase20250123;

public class recursividad {

	public static boolean isFibonacciNumber(int n, int a, int b) {
        if (n == a || n == b) {
            return true; // El número coincide con uno de los valores de Fibonacci
        }
        if (b > n) {
            return false; // El número excede el límite, no es Fibonacci
        }
        return isFibonacciNumber(n, b, a + b); // Avanza en la secuencia
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
