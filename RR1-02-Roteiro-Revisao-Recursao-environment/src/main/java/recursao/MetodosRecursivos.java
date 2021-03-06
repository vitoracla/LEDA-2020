package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array, int tamArray){
		int result = 0; 
		if (tamArray > 0) {
	            result = array[tamArray - 1] + calcularSomaArray(array, tamArray - 1);
	        } else {
	            return 0;
	        }
			return result;
	    }
	
	
	

	public long calcularFatorial(int n) {
		long result = 1;
		if(n == 1) {
			return result;
		}else {
			result = calcularFatorial(n -1) * n;
		}
		return result;
		
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}
		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		int base = 2;
		if(expoente == 0) {
			result = 1;
		}else {
			result = (int) (base * potenciaDe2(expoente - 1));
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		int i = 0;
		
		if(i == n) {
			result = 1;
		}else {
			result = result + progressaoAritmetica(termoInicial + razao, razao, n - 1 );
			
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
			result = termoInicial;
		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) * razao;
		}
		return result;
	}
	
	
}
