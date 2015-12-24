public class StackImplTest {
	
	public void launch() {
		System.out.println("Starting tests with null list...");
		Stack testStack = new StackImpl(null);
		System.out.println("What's the class of the null stack?: " + testStack.getClass());
		//Following five method calls all result in Null Pointer Exceptions for stack with null list:
		//testStack.isEmpty();
		//testStack.size();
		//testStack.push("Pushed");
		//testStack.top();
		//testStack.pop();
		System.out.println("Now switching to non-null list...");
		List testList = new ArrayList();
		testStack = new StackImpl(testList);
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
	}
	
	public void printTestResult(ReturnObject result) {
		if (result.hasError()) {
			System.out.println("Error: " + result.getError());
		} else {
			System.out.println("Return Value: " + result.getReturnValue());
		}
	}
	
	public static void main(String[] args) {
		StackImplTest tester = new StackImplTest();
		tester.launch();
	}
}