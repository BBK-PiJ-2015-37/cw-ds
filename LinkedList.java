public class LinkedList implements List {
	protected ListNode head;
	protected int numberOfItems;
	
	public LinkedList() {
		head = null;
		numberOfItems = 0;
	}
	
	@Override
	/**
	 * {@see List}
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	/**
	 * {@see List}
	 */
	public int size() {
		return numberOfItems;
	}

	@Override
	/**
	 * {@see List}
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
	 * {@see List}
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
	 * {@see List}
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
	 * {@see List}
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