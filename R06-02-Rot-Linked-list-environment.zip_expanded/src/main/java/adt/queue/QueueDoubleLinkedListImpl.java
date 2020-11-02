package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.stack.StackUnderflowException;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!this.isFull()) {
			this.list.insert(element);
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!this.isEmpty()) {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) ((DoubleLinkedListImpl<T>) this.list).getHead();

			T firstOfQueue = aux.getData();

			this.list.removeFirst();

			return firstOfQueue;

		}
		throw new QueueUnderflowException();
	}

	@Override
	public T head() {
		T firstOfQueue = null;

		if (!this.isEmpty()) {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) ((DoubleLinkedListImpl<T>) this.list).getHead();
			firstOfQueue = aux.getData();

		}
		return firstOfQueue;
	}

	@Override
	public boolean isEmpty() {
		return this.list.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.size == this.list.size();
	}

}