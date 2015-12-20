public class SampleableListImpl extends ArrayList implements SampleableList {
	private SampleableList sampleList;
	
	@Override
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample() {
		sampleList = new SampleableListImpl();
		if (isEmpty()) {
			return sampleList;
		} else {
			for (int i = 0; i < size(); i += 2) {
				sampleList.add(get(i).getReturnValue());
			}
			return sampleList;
		}
	}
	
}