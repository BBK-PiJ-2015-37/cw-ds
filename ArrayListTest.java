public class ArrayListTest {
	
	public void launch() {
		List arrayListTest = new ArrayList();
		System.out.println(arrayListTest.isEmpty());
		System.out.println(arrayListTest.size());
		ReturnObject testResult = arrayListTest.add(null);
		System.out.println(testResult.getError());
		arrayListTest.add("First");
		arrayListTest.add("Second");
		arrayListTest.add("Third");
		arrayListTest.add("Fourth");
		arrayListTest.add("Fifth");
		testResult = arrayListTest.get(0);
		System.out.println(testResult.getReturnValue());
		testResult = arrayListTest.get(1);
		System.out.println(testResult.getReturnValue());
		testResult = arrayListTest.get(2);
		System.out.println(testResult.getReturnValue());
		testResult = arrayListTest.get(3);
		System.out.println(testResult.getReturnValue());
		testResult = arrayListTest.get(4);
		System.out.println(testResult.getReturnValue());
		testResult = arrayListTest.get(5);
		System.out.println(testResult.getError());
		testResult = arrayListTest.get(-1);
		System.out.println(testResult.getError());
	}
	
	public static void main(String[] args) {
		ArrayListTest tester = new ArrayListTest();
		tester.launch();
	}
}