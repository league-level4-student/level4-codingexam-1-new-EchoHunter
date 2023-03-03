package scheduler;

enum DaysOfWeeks {
	Sunday(), Monday(), Tuesday(), Wednesday(), Thursday(), Friday(), Saturday();
	
	private final LinkedList<Node<String>> schedule;
	
	private DaysOfWeeks () {
		this.schedule = new LinkedList<Node<String>>();
	}
	public LinkedList<Node<String>> getLinkedList() {
		return schedule;
	}
}
