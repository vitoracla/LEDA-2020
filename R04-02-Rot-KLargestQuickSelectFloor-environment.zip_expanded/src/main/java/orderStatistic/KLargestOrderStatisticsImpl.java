package orderStatistic;

import java.util.Arrays;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		if (k > 0 && k <= array.length && array.length > 0) {
			for (int i = 0; i < k - 1; i++) {
				orderStatistics(array, i + 1);
			}
			array = Arrays.copyOf(array, k);
			return array;
		}
		return null;

	
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		if (k <= 0 || k > array.length || array.length == 0) {
			return null;
		}

		return orderStatistics(array, 0, array.length - 1, k);
	}

	private T orderStatistics(T[] array, int left, int right, int k) {
		if (left < right) {

			int index_pivot = partition(array, left, right);

			if (index_pivot > k) {
				orderStatistics(array, left, index_pivot - 1, k);
			} else if (index_pivot < k) {
				orderStatistics(array, index_pivot + 1, right, k);
			}

		}

		return array[k - 1]; 
	}

	private int partition(T[] values, int left, int right) {

		int range = right - left + 1;
		int rand_pivot_index = (int) (Math.random() * range) + left;

		Util.swap(values, left, rand_pivot_index);

		T pivot = values[left];
		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (values[j].compareTo(pivot) > 0) {
				i += 1;
				Util.swap(values, i, j);
			}
		}

		Util.swap(values, left, i);

		return i;
	}

}