public class ArrayListTest {
	
	public void launch() {
		List arrayListTest = new ArrayList();
		ReturnObject testResult;
		System.out.println("Array initially empty: " + arrayListTest.isEmpty());
		System.out.print("Retrieving from empty array...");
		testResult = arrayListTest.get(0);
		printTestResult(testResult);
		System.out.print("Adding at index to empty array...");
		testResult = arrayListTest.add(1, "Added0");
		printTestResult(testResult);
		System.out.print("Removing item from empty array...");
		testResult = arrayListTest.remove(1);
		printTestResult(testResult);
		System.out.print("Adding null object to array...");
		testResult = arrayListTest.add(null);
		printTestResult(testResult);
		for (int i = 0; i < 6; i++) {
			System.out.print("Adding " + i + " to array...");
			testResult = arrayListTest.add(i);
			printTestResult(testResult);
		}
		System.out.println("Is the array empty?: " + arrayListTest.isEmpty());
		System.out.println("Number of items in array: " + arrayListTest.size());
		for (int i = -1; i < 7; i++) {
			System.out.print("Retrieving element at index " + i + " from array...");
			testResult = arrayListTest.get(i);
			printTestResult(testResult);	
		}
		System.out.print("Adding at index 3...");
		testResult = arrayListTest.add(3, "Added1");
		printTestResult(testResult);
		System.out.print("Adding at index 0...");
		testResult = arrayListTest.add(0, "Added2");
		printTestResult(testResult);
		System.out.print("Adding at index 8...");
		testResult = arrayListTest.add(8, "Added3");
		printTestResult(testResult);
		for (int i = 0; i < arrayListTest.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from array...");
			testResult = arrayListTest.get(i);
			printTestResult(testResult);
		}
		System.out.print("Removing item at index 8...");
		testResult = arrayListTest.remove(8);
		printTestResult(testResult);
		System.out.print("Removing item at index -1...");
		testResult = arrayListTest.remove(-1);
		printTestResult(testResult);
		for (int i = 7; i >= 0; i--) {
			System.out.print("Removing item at index " + i + "...");
			testResult = arrayListTest.remove(i);
			printTestResult(testResult);		
		}
		System.out.println("Is the array empty?: " + arrayListTest.isEmpty());
		System.out.print("Adding 1 million items...");
		for (int i = 0; i < 1000000; i++) {
			testResult = arrayListTest.add(i);
		}
		System.out.println("done");
		System.out.println("Number of items in array: " + arrayListTest.size());
		System.out.println("Removing 10000 random elements from array...");
		for (int i = 0; i < 10000; i++) {
			int randInt = (int)(Math.random() * (arrayListTest.size() + 1));
			testResult = arrayListTest.remove(randInt);
			printTestResult(testResult);
		}
		System.out.println("Number of items in array: " + arrayListTest.size());
	}
	
	public void printTestResult(ReturnObject result) {
		if (result.hasError()) {
			System.out.println("Error: " + result.getError());
		} else {
			System.out.println("Return Value: " + result.getReturnValue());
		}
	}
	
	public static void main(String[] args) {
		ArrayListTest tester = new ArrayListTest();
		tester.launch();
	}
}