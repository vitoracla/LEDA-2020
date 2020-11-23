package adt.heap.extended;

import java.util.Comparator;

import adt.heap.ComparatorMinHeap;
import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {

		Integer ceil = null;

		return ceil;
	}

}