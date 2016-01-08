public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	@Override
	 /**
     * {@see FunctionalList}
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
     * {@see FunctionalList}
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