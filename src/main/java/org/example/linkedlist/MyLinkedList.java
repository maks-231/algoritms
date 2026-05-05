package org.example.linkedlist;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	public LLNode<E> head;
	public LLNode<E> tail;
	public int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		size = 0;

		head.setNextNode(tail);
		head.setName("Head");
		tail.setPrevNode(head);
		tail.setName("Tail");
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	@Override
	public boolean add(E element ) {
		if(element == null) {
			throw new NullPointerException("Null value cannot be added");
		}

		LLNode<E> node = new LLNode<>(element);
		node.setNextNode(tail);
		node.setPrevNode(tail.getPrevNode());
		tail.getPrevNode().setNextNode(node);
		tail.setPrevNode(node);

		node.setName("Node");
		size++;
		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {
		if(size() == 0 || index < 0 || (size() != 0 && index >= size())) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}

		LLNode<E> node = head.getNextNode();
		int i = 0;
		while(node.getNextNode() != tail) {
			if(i == index) {
				break;
			}
			i++;
			node = node.getNextNode();
		}

		return node.getData();
	}


	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	@Override
	public void add(int index, E element) {
		if(element == null) {
			throw new NullPointerException("Null value cannot be added");
		}

		if(index < 0 || (size() != 0 && index >= size())) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}

		LLNode<E> node = head.getNextNode();
		LLNode<E> prev = head;
		int i = 0;
		while(node != tail) {
			if(i == index) {
				break;
			}
			prev = node;
			node = node.getNextNode();
			i++;
		}
		LLNode<E> newNode = new LLNode<>(element);
		prev.setNextNode(newNode);
		newNode.setNextNode(node);
		newNode.setPrevNode(prev);
		node.setPrevNode(newNode);
		size++;
	}


	/** Return the size of the list */
	@Override
	public int size() {
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	@Override
	public E remove(int index) {
		if(index < 0 || (size() != 0 && index >= size())) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}

		LLNode<E> node = head.getNextNode();
		LLNode<E> prev = head;
		int i = 0;
		E data = null;
		while(node != tail) {
			if(i == index) {
				data = node.getData();
				prev.setNextNode(node.getNextNode());
				node.getNextNode().setPrevNode(prev);
				size--;
				break;
			}
			prev = node;
			node = node.getNextNode();
			i++;
		}
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		if(index < 0 || (size() != 0 && index >= size())) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}

		if(element == null) {
			throw new NullPointerException("Null value cannot be added");
		}

		LLNode<E> node = head.getNextNode();
		int i = 0;
		while(node != tail) {
			if(i == index) {
				break;
			}
			node = node.getNextNode();
			i++;
		}

		node.setData(element);
		return element;
	}
}

class LLNode<E> {
	public LLNode<E> prev;
	public LLNode<E> next;
	public E data;

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setNextNode(LLNode<E> next) {
		this.next = next;
	}

	public void setPrevNode(LLNode<E> prev) {
		this.prev = prev;
	}

	public E getData() {
		return data;
	}

	public LLNode<E> getNextNode() {
		return next;
	}

	public LLNode<E> getPrevNode() {
		return prev;
	}

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}
}
