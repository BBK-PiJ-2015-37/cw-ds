public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
	@Override
	 /**
     * {@see FunctionalList}
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
     * {@see FunctionalList}
     */
    public FunctionalList rest() {
		FunctionalList rest = new FunctionalLinkedList();
		if (!isEmpty()) {
			ListNode current = head.getNext();
			rest.add(current.getValue());
			while (current.getNext() != null) {
				current = current.getNext();
				rest.add(current.getValue());
			}
		}
		return rest;
	}
}