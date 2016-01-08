public class StackImpl extends AbstractStack {
	
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