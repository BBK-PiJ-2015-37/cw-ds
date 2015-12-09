public class ReturnObjectTest {
	private int errorCount = 0;
	
	public void launch() {
		ReturnObject test1 = new ReturnObjectImpl("Successful object.");
		ReturnObject test2 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		ReturnObject test3 = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		ReturnObject test4 = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		if (test1.hasError()) {
			System.out.println("Test 1's hasError() provided incorrect output.");
			errorCount++;
		}
		if (!test1.getError().equals(ErrorMessage.NO_ERROR)) {
			System.out.println("Test 1's getError() provided incorrect output.");
			errorCount++;			
		}
		if (!test1.getReturnValue().equals("Successful object.")) {
			System.out.println("Test 1's getReturnValue() provided incorrect output.");
			errorCount++;
		}
		if (!test2.hasError()) {
			System.out.println("Test 2's hasError() provided incorrect output.");
			errorCount++;
		}
		if (!test2.getError().equals(ErrorMessage.EMPTY_STRUCTURE)) {
			System.out.println("Test 2's getError() provided incorrect output.");
			errorCount++;			
		}
		if (test2.getReturnValue() != null) {
			System.out.println("Test 2's getReturnValue() provided incorrect output.");
			errorCount++;
		}
		if (!test3.hasError()) {
			System.out.println("Test 3's hasError() provided incorrect output.");
			errorCount++;
		}
		if (!test3.getError().equals(ErrorMessage.INDEX_OUT_OF_BOUNDS)) {
			System.out.println("Test 3's getError() provided incorrect output.");
			errorCount++;			
		}
		if (test3.getReturnValue() != null) {
			System.out.println("Test 3's getReturnValue() provided incorrect output.");
			errorCount++;
		}
		if (!test4.hasError()) {
			System.out.println("Test 4's hasError() provided incorrect output.");
			errorCount++;
		}
		if (!test4.getError().equals(ErrorMessage.INVALID_ARGUMENT)) {
			System.out.println("Test 4's getError() provided incorrect output.");
			errorCount++;			
		}
		if (test4.getReturnValue() != null) {
			System.out.println("Test 4's getReturnValue() provided incorrect output.");
			errorCount++;
		}
		if (errorCount == 0) {
			System.out.println("All tests passed.");
		}
	}
	
	public static void main(String[] args) {
		ReturnObjectTest tester = new ReturnObjectTest();
		tester.launch();
	}
}