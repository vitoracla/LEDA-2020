package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	protected int size;

	@Override
	public T search(T element) {

		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
		DoubleLinkedListNode<T> auxLast = this.last;

		T data = null;

		while (!auxHead.equals(auxLast) && !auxHead.getData().equals(auxLast) && !auxHead.getData().equals(element)
				&& !auxLast.getData().equals(element)) {
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
		}

		if (auxHead.getData().equals(element)) {
			data = auxHead.getData();
		}

		if (auxLast.getData().equals(element)) {
			data = auxLast.getData();
		}

		return data;

	}

	@Override
	public void insert(T element) {

		this.size++;

		if (isEmpty()) {

			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();

			newNode.setData(element);
			newNode.setNext(new DoubleLinkedListNode<T>());
			newNode.setPrevious(new DoubleLinkedListNode<T>());
			this.head = newNode;
			this.last = newNode;

		} else {

			DoubleLinkedListNode<T> auxLast = this.last;
			DoubleLinkedListNode<T> auxLast2 = null;

			while (!auxLast.isNIL()) {
				auxLast2 = auxLast;
				auxLast = (DoubleLinkedListNode<T>) auxLast.getNext();
			}

			auxLast.setData(element);
			auxLast.setNext(new DoubleLinkedListNode<T>());
			auxLast.setPrevious(auxLast2);

			this.last = auxLast;
		}

	}

	@Override
	public void remove(T element) {

		DoubleLinkedListNode<T> aux;

		if (this.head.getData().equals(element)) {

			this.size--;

			aux = (DoubleLinkedListNode<T>) this.head.getNext();
			aux.setPrevious(new DoubleLinkedListNode<>());

			this.head = aux;

		}

		else if (this.last.getData().equals(element)) {

			this.size--;

			aux = (DoubleLinkedListNode<T>) this.last.getPrevious();
			aux.setNext(new DoubleLinkedListNode<>());

			this.last = aux;

		} else {

			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
			DoubleLinkedListNode<T> auxLast = this.last;

			while (!auxHead.equals(auxLast) && !auxHead.getData().equals(auxLast) && !auxHead.getData().equals(element)
					&& !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}

			if (auxHead.getData().equals(element)) {

				this.size--;

				DoubleLinkedListNode<T> auxHeadPrev = auxHead.getPrevious();
				DoubleLinkedListNode<T> auxHeadNext = (DoubleLinkedListNode<T>) auxHead.getNext();

				auxHeadPrev.setNext(auxHeadNext);
				auxHeadNext.setPrevious(auxHeadPrev);
				return;

			}

			if (auxLast.getData().equals(element)) {

				this.size--;

				DoubleLinkedListNode<T> auxLastPrev = auxLast.getPrevious();
				DoubleLinkedListNode<T> auxLastNext = (DoubleLinkedListNode<T>) auxHead.getNext();

				auxLastNext.setPrevious(auxLastPrev);
				auxLastPrev.setNext(auxLastNext);
				return;
			}

		}

	}

	@Override
	public void insertFirst(T element) {

		DoubleLinkedListNode<T> aux;
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();

		newNode.setData(element);
		newNode.setPrevious(new DoubleLinkedListNode<T>());

		this.size++;

		if (isEmpty()) {
			newNode.setNext(new DoubleLinkedListNode<T>());
			newNode.setPrevious(new DoubleLinkedListNode<T>());
			this.head = newNode;
			this.last = newNode;

		} else {
			aux = (DoubleLinkedListNode<T>) this.head;
			newNode.setNext(aux);
			aux.setPrevious(newNode);
			this.head = newNode;
		}

	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			this.size--;
			DoubleLinkedListNode<T> aux;

			aux = (DoubleLinkedListNode<T>) this.head.getNext();
			aux.setPrevious(new DoubleLinkedListNode<>());

			this.head = aux;

		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {

			if (this.size == 1) {
				removeFirst();
				return;
			}

			this.size--;
			DoubleLinkedListNode<T> aux;

			aux = (DoubleLinkedListNode<T>) this.last.getPrevious();
			aux.setNext(new DoubleLinkedListNode<>());

			this.last = aux;
		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	public int size() {
		return this.size;
	}

}