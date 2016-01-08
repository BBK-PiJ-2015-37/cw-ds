public class SampleableListImpl extends ArrayList implements SampleableList {
	private SampleableList sampleList;
	
	@Override
	/**
	 * {@see SampleableList}
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