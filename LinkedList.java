public class LinkedList implements List {
	private ListNode head;
	private int numberOfItems;
	
	public LinkedList() {
		head = null;
		numberOfItems = 0;
	}
	
	@Override
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		return numberOfItems;
	}

	@Override
	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index) {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		int currentIndex = 0;
		ListNode current = head;
		while (currentIndex != index) {
			current = current.getNext();
			currentIndex++;
		}
		return new ReturnObjectImpl(current.getValue());
	}

	@Override
	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index) {
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		ReturnObject removedElement;
		ListNode current = head;
		if (size() == 1) {
			// if head is only item in list, remove it and set head to null
			removedElement = new ReturnObjectImpl(current.getValue());
			head = null;
			numberOfItems--;
			return removedElement;
		} else if (index == 0) {
			// when removing head, first make next item the new head, then remove old head
			removedElement = new ReturnObjectImpl(current.getValue());
			head = current.getNext();
			current.setNext(null);
			numberOfItems--;
			return removedElement;
		} else {
			// in other cases, traverse list to item before that which is to be removed
			int currentIndex = 0;
			while (currentIndex != index - 1) {
				current = current.getNext();
				currentIndex++;
			}
			removedElement = new ReturnObjectImpl(current.getNext().getValue());
			if (current.getNext().getNext() == null) {
				// when removing tail, cut pointer from item before it
				current.setNext(null);
			} else {
				// otherwise set preceding item's pointer to item after that to be removed
				ListNode temp = current.getNext();
				current.setNext(temp.getNext());
				temp.setNext(null);
			}
			numberOfItems--;
			return removedElement;
		}
	}

	@Override
	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(int index, Object item) {
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		ListNode itemToAdd = new ListNode(item);
		if (index == 0) {
			// when adding at head, set new item's next to current head, then make new item head
			itemToAdd.setNext(head);
			head = itemToAdd;
		} else {
			// otherwise traverse list to necessary position and reset pointers
			int currentIndex = 0;
			ListNode current = head;
			while (currentIndex != index - 1) {
				current = current.getNext();
				currentIndex++;
			}
			itemToAdd.setNext(current.getNext());
			current.setNext(itemToAdd);
		}
		numberOfItems++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	@Override
	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		ListNode itemToAdd = new ListNode(item);
		if (head == null) {
			head = itemToAdd;
		} else {
			ListNode current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(itemToAdd);
		}
		numberOfItems++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
}