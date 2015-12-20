public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
	@Override
	 /**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public ReturnObject head() {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		Object head = this.head.getValue();
		return new ReturnObjectImpl(head);
	}

	@Override
    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public FunctionalList rest() {
		FunctionalList rest = new FunctionalLinkedList();
		if (isEmpty()) {
			return rest;
		} else {
			ListNode current = head.getNext();
			rest.add(current.getValue());
			while (current.getNext() != null) {
				current = current.getNext();
				rest.add(current.getValue());
			}
			return rest;
		}
	}
}