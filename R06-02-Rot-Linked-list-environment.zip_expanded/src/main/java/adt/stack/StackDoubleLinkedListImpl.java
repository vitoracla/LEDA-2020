package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (this.size > this.top.size()) {
			this.top.insert(element);
		} else {
			throw new StackOverflowException();
		}

	}

	@Override
	public T pop() throws StackUnderflowException {

		if (!this.top.isEmpty()) {
			DoubleLinkedListNode<T> aux = ((DoubleLinkedListImpl<T>) this.top).getLast();
			this.top.removeLast();
			T popped = aux.getData();

			return popped;

		}
		throw new StackUnderflowException();
	}

	@Override
	public T top() {

		T popped = null;

		if (!this.top.isEmpty()) {
			DoubleLinkedListNode<T> aux = ((DoubleLinkedListImpl<T>) this.top).getLast();
			this.top.removeLast();

			popped = aux.getData();
		}
		return popped;
	}

	@Override
	public boolean isEmpty() {
		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}