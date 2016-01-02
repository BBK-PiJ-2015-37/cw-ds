public class LinkedListTest {
	
	public void launch() {
		List linkedListTest = new LinkedList();
		ReturnObject testResult;
		System.out.println("List initially empty: " + linkedListTest.isEmpty());
		System.out.print("Attempting to retrieve from empty list...");
		testResult = linkedListTest.get(0);
		printTestResult(testResult);
		System.out.print("Attempting to add at index to empty list...");
		testResult = linkedListTest.add(1, "Added0");
		printTestResult(testResult);
		System.out.print("Attempting to remove item from empty list...");
		testResult = linkedListTest.remove(1);
		printTestResult(testResult);
		System.out.print("Attempting to add null object to list...");
		testResult = linkedListTest.add(null);
		printTestResult(testResult);
		System.out.println("Attempting to add item then remove it (to check head is reset to null)...");
		System.out.print("Adding...");
		testResult = linkedListTest.add(1);
		printTestResult(testResult);
		System.out.print("Removing...");
		testResult = linkedListTest.remove(0);
		printTestResult(testResult);		
		for (int i = 0; i < 6; i++) {
			System.out.print("Attempting to add " + i + " to list...");
			testResult = linkedListTest.add(i);
			printTestResult(testResult);
		}
		System.out.println("Is the list empty?: " + linkedListTest.isEmpty());
		System.out.println("Number of items in list: " + linkedListTest.size());
		for (int i = -1; i < 7; i++) {
			System.out.print("Attempting to retrieve element at index " + i + " from list...");
			testResult = linkedListTest.get(i);
			printTestResult(testResult);	
		}
		System.out.print("Attempting to add at index 3...");
		testResult = linkedListTest.add(3, "Added1");
		printTestResult(testResult);
		System.out.print("Attempting to add at index 0...");
		testResult = linkedListTest.add(0, "Added2");
		printTestResult(testResult);
		System.out.print("Attempting to add at index 8...");
		testResult = linkedListTest.add(8, "Added3");
		printTestResult(testResult);
		for (int i = 0; i < linkedListTest.size(); i++) {
			System.out.print("Attempting to retrieve element at index " + i + " from list...");
			testResult = linkedListTest.get(i);
			printTestResult(testResult);
		}
		System.out.print("Attempting to remove item at index 8...");
		testResult = linkedListTest.remove(8);
		printTestResult(testResult);
		System.out.print("Attempting to remove item at index -1...");
		testResult = linkedListTest.remove(-1);
		printTestResult(testResult);
		for (int i = 7; i >= 0; i--) {
			System.out.print("Attempting to remove item at index " + i + "...");
			testResult = linkedListTest.remove(i);
			printTestResult(testResult);		
		}
		System.out.println("Is the list empty?: " + linkedListTest.isEmpty());
		System.out.print("Adding 50000 items...");
		for (int i = 0; i < 50000; i++) {
			testResult = linkedListTest.add(i);
		}
		System.out.println("done");
		System.out.println("Number of items in list: " + linkedListTest.size());
		System.out.println("Removing 10000 random elements from list...");
		for (int i = 0; i < 10000; i++) {
			int randInt = (int)(Math.random() * (linkedListTest.size() + 1));
			testResult = linkedListTest.remove(randInt);
			printTestResult(testResult);
		}
		System.out.println("Number of items in list: " + linkedListTest.size());
	}

	public void printTestResult(ReturnObject result) {
		if (result.hasError()) {
			System.out.println("Error: " + result.getError());
		} else {
			System.out.println("Return Value: " + result.getReturnValue());
		}
	}
	
	public static void main(String[] args) {
		LinkedListTest tester = new LinkedListTest();
		tester.launch();
	}
}