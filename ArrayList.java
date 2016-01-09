public class ArrayList implements List {
	protected Object[] objectArray;
	protected static final int DEFAULT_ARRAY_SIZE = 4;
	protected int arraySize;
	protected int numberOfItems;
	
	public ArrayList() {
		objectArray = new Object[DEFAULT_ARRAY_SIZE];
		arraySize = DEFAULT_ARRAY_SIZE;
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
		} else if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(objectArray[index]);
		}
	}

	@Override
	/**
	 * {@see List}
	 */
	public ReturnObject remove(int index) {
		if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		ReturnObject removedElement = new ReturnObjectImpl(objectArray[index]);
		shiftLeft(index + 1);
		numberOfItems--;
		return removedElement;
	}
	
	@Override
	/**
	 * {@see List}
	 */
	public ReturnObject add(int index, Object item) {
		if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		shiftRight(index);
		objectArray[index] = item;
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
		if (arrayNearFull()) {
			doubleArraySize();
		}
		objectArray[numberOfItems] = item;
		numberOfItems++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	/**
	 * Returns true if number of items in array is one less than
	 * or equal to current array size, false otherwise.
	 *
	 * @return true if number of items in array is one less than
	 * or equal to current array size, false otherwise
	 */
	private boolean arrayNearFull() {
		if (arraySize - size() <= 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Creates an array double the size of the current array,
	 * copies all items from current array into new array,
	 * then switches instance's pointer from current to new array.
	 */
	private void doubleArraySize() {
		Object[] biggerArray = new Object[arraySize * 2];
		for (int i = 0; i < size(); i++) {
			biggerArray[i] = objectArray[i];
		}
		objectArray = biggerArray;
		arraySize = arraySize * 2;
	}

	/**
	 * Checks that array is currently big enough to accommodate shift,
	 * then shifts all elements in array one index up, starting from 
	 * user-provided index.
	 *
	 * @param index from which to begin shift
	 */	
	private void shiftRight(int index) {
		if (arrayNearFull()) {
			doubleArraySize();
		}
		for (int i = size() - 1; i >= index; i--) {
			objectArray[i + 1] = objectArray[i];
		}
	}

	/**
	 * Shifts all elements in array one index down, starting from 
	 * user-provided index.
	 *
	 * @param index from which to begin shift
	 */	
	private void shiftLeft(int index) {
		for (int i = index; i < size(); i++) {
			objectArray[i - 1] = objectArray[i];
		}
		objectArray[size() - 1] = null;
	}
}