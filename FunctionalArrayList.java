public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
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
		Object head = objectArray[0];
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
		FunctionalList rest = new FunctionalArrayList();
		if (isEmpty()) {
			return rest;
		} else {
			for (int i = 0; i < numberOfItems - 1; i++) {
				rest.add(this.objectArray[i + 1]);
			}
			return rest;
		}
	}
}