public class ListNode {
	private Object value;
	private ListNode next;
	
	public ListNode(Object value) {
		this.value = value;
		this.next = null;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	
	public void setNext(ListNode nextNode) {
		this.next = nextNode;
	}
	
}