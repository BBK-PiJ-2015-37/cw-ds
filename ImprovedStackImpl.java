public class ImprovedStackImpl implements ImprovedStack {
	private Stack basicStack;
	
	public ImprovedStackImpl(List list) {
		basicStack = new StackImpl(list);
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public boolean isEmpty() {
		return basicStack.isEmpty();
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public int size() {
		return basicStack.size();
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public void push(Object item) {
		basicStack.push(item);
		return;
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public ReturnObject top() {
		return basicStack.top();
	}

	@Override
	/**
	 * {@see Stack}
	 */
	public ReturnObject pop() {
		return basicStack.pop();
	}
	
	@Override
	/**
	 * {@see ImprovedStack} 
	 */
	public ImprovedStack reverse() {
		List reversedArray = new ArrayList();
		List tempArray = new ArrayList();
		while (!basicStack.isEmpty()) {
			ReturnObject itemToAdd = basicStack.pop();
			reversedArray.add(itemToAdd.getReturnValue());
			tempArray.add(itemToAdd.getReturnValue());
		}
		ImprovedStack reversedStack = new ImprovedStackImpl(reversedArray);
		Stack tempStack = new StackImpl(tempArray);
		List originalArray = new ArrayList();
		while (!tempStack.isEmpty()) {
			ReturnObject itemToAdd = tempStack.pop();
			originalArray.add(itemToAdd.getReturnValue());
		}
		basicStack = new StackImpl(originalArray);
		return reversedStack;
	}
	
	@Override
	/**
	 * {@see ImprovedStack} 
	 */
	public void remove(Object object) {
		if (!isEmpty()) {
			List tempArray = new ArrayList();
			Stack tempStack = new StackImpl(tempArray);
			while (!basicStack.isEmpty()) {
				ReturnObject itemToAdd = basicStack.pop();
				if (itemToAdd.getReturnValue().equals(object)) {
					continue;
				} else {
					tempStack.push(itemToAdd.getReturnValue());
				}
			}
			while (!tempStack.isEmpty()) {
				ReturnObject itemToAdd = tempStack.pop();
				basicStack.push(itemToAdd.getReturnValue());
			}
		}
		return;
	}
	
}