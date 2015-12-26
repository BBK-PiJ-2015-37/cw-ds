public class ImprovedStackImplTest {
	
	public void launch() {
		System.out.println("Starting tests with null list...");
		ImprovedStack testStack = new ImprovedStackImpl(null);
		System.out.println("What's the class of the null stack?: " + testStack.getClass());
		//Following five method calls all result in Null Pointer Exceptions for stack with null list:
		//testStack.isEmpty();
		//testStack.size();
		//testStack.push("Pushed");
		//testStack.top();
		//testStack.pop();
		System.out.println("Now switching to non-null list...");
		List testList = new ArrayList();
		testStack = new ImprovedStackImpl(testList);
		ReturnObject testResult;
		System.out.println("Stack initially empty: " + testStack.isEmpty());
		System.out.println("Size of initial stack: " + testStack.size());
		for (int i = 0; i < 10; i++) {
			System.out.println("Pushing " + i + " to stack...");
			testStack.push(i);
		}
		System.out.println("Is stack now empty?: " + testStack.isEmpty());
		System.out.println("Size of stack: " + testStack.size());
		System.out.print("What's top of the stack? ");
		testResult = testStack.top();
		printTestResult(testResult);
		System.out.println("Size of stack: " + testStack.size());
		System.out.print("Popping top of stack...");
		testResult = testStack.pop();
		printTestResult(testResult);
		System.out.println("Size of stack: " + testStack.size());
		System.out.print("What's top of the stack? ");
		testResult = testStack.top();
		printTestResult(testResult);
		System.out.println("Pushing null to stack...");
		testStack.push(null);
		System.out.println("Size of stack: " + testStack.size());
		for (int i = testStack.size() - 1; i >= 0; i--) {
			System.out.print("Popping top of stack...");
			testResult = testStack.pop();
			printTestResult(testResult);
		}
		System.out.println("Is stack now empty?: " + testStack.isEmpty());
		System.out.print("What's top of the empty stack? ");
		testResult = testStack.top();
		printTestResult(testResult);
		System.out.print("Popping top of empty stack...");
		testResult = testStack.pop();
		printTestResult(testResult);
		for (int i = 0; i < 10; i++) {
			System.out.println("Pushing " + i + " to stack...");
			testStack.push(i);
		}
		System.out.println("Reversing stack...");
		ImprovedStack reversedStack = testStack.reverse();
		System.out.println("Is reversed stack empty?: " + reversedStack.isEmpty());
		System.out.println("Size of reversed stack: " + reversedStack.size());
		System.out.println("Is original stack empty?: " + testStack.isEmpty());
		System.out.println("Size of original stack: " + testStack.size());
		System.out.print("What's top of the reversed stack? ");
		testResult = reversedStack.top();
		printTestResult(testResult);
		for (int i = reversedStack.size() - 1; i >= 0; i--) {
			System.out.print("Popping top of reversed stack...");
			testResult = reversedStack.pop();
			printTestResult(testResult);
		}
		System.out.println("Removing 2 from original stack...");
		testStack.remove(2);
		System.out.println("Size of original stack: " + testStack.size());
		System.out.println("Removing 6 from original stack...");
		testStack.remove(6);
		System.out.println("Size of original stack: " + testStack.size());
		System.out.println("Removing 'Hello' from original stack...");
		testStack.remove("Hello");
		System.out.println("Size of original stack: " + testStack.size());
		for (int i = testStack.size() - 1; i >= 0; i--) {
			System.out.print("Popping top of original stack...");
			testResult = testStack.pop();
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
		ImprovedStackImplTest tester = new ImprovedStackImplTest();
		tester.launch();
	}
}