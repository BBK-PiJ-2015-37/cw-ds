public class FunctionalLinkedListTest {
	
	public void launch() {
		FunctionalList FLLTest = new FunctionalLinkedList();
		ReturnObject testResult;
		FunctionalList restList = new FunctionalLinkedList();
		System.out.println("List initially empty: " + FLLTest.isEmpty());
		System.out.print("Retrieving from empty list...");
		testResult = FLLTest.get(0);
		printTestResult(testResult);
		System.out.print("Adding at index to empty list...");
		testResult = FLLTest.add(1, "Added0");
		printTestResult(testResult);
		System.out.print("Removing item from empty list...");
		testResult = FLLTest.remove(1);
		printTestResult(testResult);
		System.out.print("Adding null object to list...");
		testResult = FLLTest.add(null);
		printTestResult(testResult);
		System.out.println("Adding item then remove it (to check head is reset to null)...");
		System.out.print("Adding...");
		testResult = FLLTest.add(1);
		printTestResult(testResult);
		System.out.print("Removing...");
		testResult = FLLTest.remove(0);
		printTestResult(testResult);		
		for (int i = 0; i < 6; i++) {
			System.out.print("Adding " + i + " to list...");
			testResult = FLLTest.add(i);
			printTestResult(testResult);
		}
		System.out.println("Is the list empty?: " + FLLTest.isEmpty());
		System.out.println("Number of items in list: " + FLLTest.size());
		for (int i = -1; i < 7; i++) {
			System.out.print("Retrieving element at index " + i + " from list...");
			testResult = FLLTest.get(i);
			printTestResult(testResult);	
		}
		System.out.print("Adding at index 3...");
		testResult = FLLTest.add(3, "Added1");
		printTestResult(testResult);
		System.out.print("Adding at index 0...");
		testResult = FLLTest.add(0, "Added2");
		printTestResult(testResult);
		System.out.print("Adding at index 8...");
		testResult = FLLTest.add(8, "Added3");
		printTestResult(testResult);
		for (int i = 0; i < FLLTest.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from list...");
			testResult = FLLTest.get(i);
			printTestResult(testResult);
		}
		System.out.print("Removing item at index 8...");
		testResult = FLLTest.remove(8);
		printTestResult(testResult);
		System.out.print("Removing item at index -1...");
		testResult = FLLTest.remove(-1);
		printTestResult(testResult);
		for (int i = 7; i >= 0; i--) {
			System.out.print("Removing item at index " + i + "...");
			testResult = FLLTest.remove(i);
			printTestResult(testResult);		
		}
		System.out.println("Is the list empty?: " + FLLTest.isEmpty());
		System.out.print("Retrieving head of empty list...");
		testResult = FLLTest.head();
		printTestResult(testResult);
		System.out.println("Retrieving rest of empty array...");
		restList = FLLTest.rest();
		System.out.println("What is the returned object's class? " + restList.getClass());
		System.out.println("Is returned rest list empty?: " + restList.isEmpty());
		for (int i = 0; i < 6; i++) {
			System.out.println("Adding " + i + " to list...");
			FLLTest.add(i);
		}
		System.out.print("Retrieving head of list...");
		testResult = FLLTest.head();
		printTestResult(testResult);
		System.out.println("Retrieving rest of list...");
		restList = FLLTest.rest();
		System.out.println("Is returned rest list empty?: " + restList.isEmpty());
		for (int i = 0; i < restList.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from rest list...");
			testResult = restList.get(i);
			printTestResult(testResult);
		}
		System.out.print("Adding new head to list...");
		testResult = FLLTest.add(0, "New Head");
		printTestResult(testResult);
		System.out.print("Retrieving head of list...");
		testResult = FLLTest.head();
		printTestResult(testResult);
		System.out.println("Retrieving rest of list...");
		restList = FLLTest.rest();
		System.out.println("Is returned rest list empty?: " + restList.isEmpty());
		for (int i = 0; i < restList.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from rest list...");
			testResult = restList.get(i);
			printTestResult(testResult);
		}
		System.out.println("Checking that changes to rest list do not affect original list...");
		System.out.println("Adding an element to rest list...");
		restList.add(1, "Added1");
		System.out.println("Removing an element from rest list...");
		restList.remove(4);
		for (int i = 0; i < restList.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from rest list...");
			testResult = restList.get(i);
			printTestResult(testResult);
		}
		for (int i = 0; i < FLLTest.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from original list...");
			testResult = FLLTest.get(i);
			printTestResult(testResult);
		}
		System.out.println("Checking the Functional List functions can be carried out on rest list...");
		System.out.print("Retrieving head of rest list...");
		testResult = restList.head();
		printTestResult(testResult);
		System.out.println("Retrieving rest of rest list...");
		FunctionalList restList2 = restList.rest();
		for (int i = 0; i < restList2.size(); i++) {
			System.out.print("Retrieving element at index " + i + " from rest list 2...");
			testResult = restList2.get(i);
			printTestResult(testResult);
		}
		System.out.print("Adding 50,000 items to rest list 2...");
		for (int i = 0; i < 50000; i++) {
			testResult = restList2.add(i);
		}
		System.out.println("done");
		System.out.println("Number of items in rest list: " + restList.size());
		System.out.println("Number of items in rest list 2: " + restList2.size());
		System.out.println("Removing 10000 random elements from rest list 2...");
		for (int i = 0; i < 10000; i++) {
			int randInt = (int)(Math.random() * (restList2.size() + 1));
			testResult = restList2.remove(randInt);
			printTestResult(testResult);
		}
		System.out.println("Number of items in rest list 2: " + restList2.size());
		System.out.println("Number of items in rest list: " + restList.size());
	}

	public void printTestResult(ReturnObject result) {
		if (result.hasError()) {
			System.out.println("Error: " + result.getError());
		} else {
			System.out.println("Return Value: " + result.getReturnValue());
		}
	}

	public static void main(String[] args) {
		FunctionalLinkedListTest tester = new FunctionalLinkedListTest();
		tester.launch();
	}
}