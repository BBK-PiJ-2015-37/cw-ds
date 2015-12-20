public class SampleableListImplTest {
	
	public void launch() {
		SampleableList SLTest = new SampleableListImpl();
		ReturnObject testResult;
		SampleableList sampleList = new SampleableListImpl();
		System.out.println("List initially empty: " + SLTest.isEmpty());
		System.out.print("Retrieving from empty list...");
		testResult = SLTest.get(0);
		printTestResult(testResult);
		System.out.print("Adding at index to empty list...");
		testResult = SLTest.add(1, "Added0");
		printTestResult(testResult);
		System.out.print("Removing item from empty list...");
		testResult = SLTest.remove(1);
		printTestResult(testResult);
		System.out.print("Adding null object to list...");
		testResult = SLTest.add(null);
		printTestResult(testResult);
		System.out.println("Adding item then remove it (to check head is reset to null)...");
		System.out.print("Adding...");
		testResult = SLTest.add(1);
		printTestResult(testResult);
		System.out.print("Removing...");
		testResult = SLTest.remove(0);
		printTestResult(testResult);		
		for (int i = 0; i < 6; i++) {
			System.out.print("Adding " + i + " to list...");
			testResult = SLTest.add(i);
			printTestResult(testResult);
		}
		System.out.println("Is the list empty?: " + SLTest.isEmpty());
		System.out.println("Number of items in list: " + SLTest.size());
		for (int i = -1; i < 7; i++) {
			System.out.print("Retrieving element at index " + i + " from list...");
			testResult = SLTest.get(i);
			printTestResult(testResult);	
		}
		System.out.print("Adding at index 3...");
		testResult = SLTest.add(3, "Added1");
		printTestResult(testResult);
		System.out.print("Adding at index 0...");
		testResult = SLTest.add(0, "Added2");
		printTestResult(testResult);
		System.out.print("Adding at index 8...");
		testResult = SLTest.add(8, "Added3");
		printTestResult(testResult);
		for (int i = 0; i < SLTest.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from list...");
			testResult = SLTest.get(i);
			printTestResult(testResult);
		}
		System.out.print("Removing item at index 8...");
		testResult = SLTest.remove(8);
		printTestResult(testResult);
		System.out.print("Removing item at index -1...");
		testResult = SLTest.remove(-1);
		printTestResult(testResult);
		for (int i = 7; i >= 0; i--) {
			System.out.print("Removing item at index " + i + "...");
			testResult = SLTest.remove(i);
			printTestResult(testResult);		
		}
		System.out.println("Is the list empty?: " + SLTest.isEmpty());
		System.out.println("Sampling empty list...");
		sampleList = SLTest.sample();
		System.out.println("Is the sample list empty?: " + sampleList.isEmpty());
		System.out.println("Adding numbers 0 to 30 to original list...");
		for (int i = 0; i < 31; i++) {
			SLTest.add(i);
		}
		System.out.println("Sampling populated list...");
		sampleList = SLTest.sample();
		System.out.println("Is the sample list empty?: " + sampleList.isEmpty());
		for (int i = 0; i < sampleList.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from sample list...");
			testResult = sampleList.get(i);
			printTestResult(testResult);
		}
		System.out.println("Sampling sample list...");
		sampleList = sampleList.sample();
		System.out.println("Is the sample list empty?: " + sampleList.isEmpty());
		for (int i = 0; i < sampleList.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from sample list...");
			testResult = sampleList.get(i);
			printTestResult(testResult);
		}
	}

	public void printTestResult(ReturnObject result) {
		if (result.hasError()) {
			System.out.println("Error: " + result.getError());
		} else {
			System.out.println("Return Value: " + result.getReturnValue());
		}
	}

	public static void main(String[] args) {
		SampleableListImplTest tester = new SampleableListImplTest();
		tester.launch();
	}
	
}