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
	 * {@see ReturnObject}
	 */
	public boolean hasError() {
		if (errorFound != ErrorMessage.NO_ERROR) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * {@see ReturnObject}
	 */
	public ErrorMessage getError() {
		return errorFound;
	}

	@Override
	/**
	 * {@see ReturnObject}
	 */
	public Object getReturnValue() {
		return objectToReturn;
	}
}