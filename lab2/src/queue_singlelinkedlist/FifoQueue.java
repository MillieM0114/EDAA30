package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> n = new QueueNode<E>(e);

		if (last == null) {
			n.next = n;
			size++;
		} else {
			n.next = last.next;
			last.next = n;
			size++;
		}
		last = n;
		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		}

		return last.next.element;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		}
		E temp = null;
		if (last.next == last) {
			temp = last.element;
			last = null;
		} else {
			temp = last.next.element;
			last.next = last.next.next;
		}
		size--;
		return temp;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			this.element = x;
			next = null;
		}
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			if (last == null) {
				pos = null;
			} else {
				pos = last.next;
			}
		}

		public boolean hasNext() {
			return pos != null;
		}

		public E next() {
			if (hasNext()) {
				E temp = pos.element;
				if (pos == last) {
					pos = null;
				} else {
					pos = pos.next;
				}
				return temp;

			} else {
				throw new NoSuchElementException();
			}
		}
	}
}
