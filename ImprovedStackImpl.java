public class ImprovedStackImpl implements ImprovedStack {
	private Stack basicStack;
	
	public ImprovedStackImpl(List list) {
		basicStack = new StackImpl(list);
	}

	@Override
	/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return basicStack.isEmpty();
	}

	@Override
	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return basicStack.size();
	}

	@Override
	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		basicStack.push(item);
		return;
	}

	@Override
	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		return basicStack.top();
	}

	@Override
	/**
	 * Returns the element at the top of the stack. The element is
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		return basicStack.pop();
	}
}