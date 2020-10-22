package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os daods em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso redua a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 */
	public T quickSelect(T[] array, int k) {

		if (k <= 0 || k > array.length || array.length == 0) {
			return null;
		}

		return quickSelect(array, 0, array.length - 1, k);
	}

	private T quickSelect(T[] array, int left, int right, int k) {
		 int partition = partition(array, left, right);

	        if (partition == k)
	            return array[partition];
	        else if (partition < k)
	            return quickSelect(array, partition + 1, right, k);
	        else {
	            return quickSelect(array, left, partition - 1, k);
	        }

	}

	private int partition(T[] array, int left, int right) {
		
	    T pivot =  array[right];
		int pivotloc = left;
        for (int a = left; a <= right; a++) {

            if (array[a].compareTo(pivot) < 0) {
                T temp = array[a];
                array[a] = array[pivotloc];
                array[pivotloc] = temp;
                pivotloc++;
            }
        }

        T temp = array[right];
        array[right] = array[pivotloc];
        array[pivotloc] = temp;

        return pivotloc;
    }

}