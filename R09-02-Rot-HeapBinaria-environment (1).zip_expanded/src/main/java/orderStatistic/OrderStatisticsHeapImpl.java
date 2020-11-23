package orderStatistic;

import java.util.PriorityQueue;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {

			T KEsimaEstatiscaDeOrdem = null;

			if (k > 0 && k <= array.length && array.length > 0) {

				
				ComparatorMaxHeap<T> comparator = new ComparatorMaxHeap<>();
				ComparatorMinHeap<T> comparatorMinHeap = new ComparatorMinHeap<>();
				PriorityQueue<T> heap = new PriorityQueue<T>(comparator);

				for (T element : array) {
					heap.add(element);
				}

				while (!heap.isEmpty() && k > 0) {
					KEsimaEstatiscaDeOrdem = heap.remove();
					k--;
				}

			}

			return KEsimaEstatiscaDeOrdem;
		}

		
		
	}

	
	
