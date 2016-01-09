public class StackImpl extends AbstractStack {
	
	/**
     * Creates a new stack using the provided list as the
     * underlying data structure.
     * 
     * Note: This constructor does not check whether the provided list
     * is null. Programmers must do their own checks. If a null list
     * is provided, a NullPointerException will be thrown at runtime
     * as soon as any operation is attempted on the underlying list.
     * 
     * @param list the list to be used 
     */
	public StackImpl(List list) {
		super(list);
	}
	
	@Override
	/**
	 * {@see Stack}
	 */
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public int size() {
		return internalList.size();
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public void push(Object item) {
		if (item != null) {
			internalList.add(item);
		}
		return;
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public ReturnObject top() {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return internalList.get(size() - 1);
		}
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public ReturnObject pop() {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return internalList.remove(size() - 1);	
		}
	}
}