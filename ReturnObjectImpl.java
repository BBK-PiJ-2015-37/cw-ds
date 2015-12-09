public class ReturnObjectImpl implements ReturnObject {
	private Object objectToReturn;
	private ErrorMessage errorFound;
	
	public ReturnObjectImpl(Object objectToReturn) {
		this.objectToReturn = objectToReturn;
		this.errorFound = ErrorMessage.NO_ERROR;
	}
	
	public ReturnObjectImpl(ErrorMessage errorFound) {
		this.objectToReturn = null;
		this.errorFound = errorFound;
	}

	@Override
	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError() {
		if (errorFound != ErrorMessage.NO_ERROR) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError() {
		return errorFound;
	}

	@Override
	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue() {
		return objectToReturn;
	}
}