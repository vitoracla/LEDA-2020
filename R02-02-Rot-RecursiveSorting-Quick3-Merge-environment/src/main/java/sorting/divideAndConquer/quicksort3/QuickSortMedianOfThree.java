package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte: 1. Comparar o elemento mais a
 * esquerda, o central e o mais a direita do intervalo. 2. Ordenar os elementos,
 * tal que: A[left] < A[center] < A[right]. 3. Adotar o A[center] como pivô. 4.
 * Colocar o pivô na penúltima posição A[right-1]. 5. Aplicar o particionamento
 * considerando o vetor menor, de A[left+1] até A[right-1]. 6. Aplicar o
 * algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		} else {
			int median = (leftIndex + rightIndex) / 2;
			if (array[leftIndex].compareTo(array[median]) > 0) {
				Util.swap(array, leftIndex, median);
			}
			if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
				Util.swap(array, leftIndex, rightIndex);
			}
			if (array[median].compareTo(array[rightIndex]) > 0) {
				Util.swap(array, median, rightIndex);
			}
			T pivot =  array[median];
			Util.swap(array, median, rightIndex - 1);
			int i = leftIndex;
			int j = rightIndex - 2;

			if (rightIndex - leftIndex <= 10) {
				insertionSort(array, leftIndex, rightIndex);
			} else {

				while (true) {
					while (array[i++].compareTo(pivot) < 0)
						;
					while (array[--j].compareTo(pivot) > 0)
						;
					if (i < j) 
						Util.swap(array, i, j);
					
					else 
						break;
					
				}
				
				Util.swap(array, i, rightIndex -1 );
				sort(array, leftIndex, i-1);
				sort(array, i + 1, rightIndex);
				
			}

		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
			for (int i = leftIndex; i < rightIndex; i++) {
				int j = i + 1;
				while(j > leftIndex) {
					if(array[j].compareTo(array[j - 1]) < 0) {
						Util.swap(array, j, j - 1);
					}
					
					j = j - 1;
				}
			}
		}
		
	}

	


