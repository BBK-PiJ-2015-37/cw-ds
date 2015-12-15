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
		} else if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(objectArray[index]);
		}
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
		ReturnObject removedElement = new ReturnObjectImpl(objectArray[index]);
		shiftLeft(index + 1);
		numberOfItems--;
		return removedElement;
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
		shiftRight(index);
		objectArray[index] = item;
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
		if (arraySize - numberOfItems <= 1) {
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
		for (int i = 0; i < numberOfItems; i++) {
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
		for (int i = numberOfItems - 1; i >= index; i--) {
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
		for (int i = index; i < numberOfItems; i++) {
			objectArray[i - 1] = objectArray[i];
		}
		objectArray[numberOfItems - 1] = null;
	}
}