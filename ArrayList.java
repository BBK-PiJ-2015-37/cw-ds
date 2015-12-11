public class ArrayList implements List {
	private Object[] objectArray;
	private static final int DEFAULT_ARRAY_SIZE = 4;
	private int arraySize;
	private int numberOfItems;
	
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
		return (numberOfItems == 0);
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
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(objectArray[index]);
		}
	}

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
	//public ReturnObject remove(int index);

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
	//public ReturnObject add(int index, Object item);

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
		return new ReturnObjectImpl(null);
	}
	
	/**
	 * Returns true if number of items in array is one less than
	 * current array size, false otherwise.
	 *
	 * @return true if number of items in array is one less than
	 * current array size, false otherwise
	 */
	public boolean arrayNearFull() {
		if (numberOfItems == arraySize - 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Creates an array double the size of the current array,
	 * copies all items from current array into new array,
	 * then switches instance's pointer from current to new array.
	 */
	public void doubleArraySize() {
		Object[] biggerArray = new Object[arraySize * 2];
		for (int i = 0; i < numberOfItems; i++) {
			biggerArray[i] = objectArray[i];
		}
		objectArray = biggerArray;
		arraySize = arraySize * 2;
	}
}