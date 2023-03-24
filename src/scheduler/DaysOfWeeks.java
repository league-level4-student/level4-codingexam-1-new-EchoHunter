package scheduler;

import java.util.LinkedList;

enum DaysOfWeeks {
	Sunday(), Monday(), Tuesday(), Wednesday(), Thursday(), Friday(), Saturday();
	
	private final LinkedList<NameAndTime> schedule;
	
	private DaysOfWeeks () {
		this.schedule = new LinkedList<NameAndTime>();
	}
	public LinkedList<NameAndTime> getLinkedList() {
		return schedule;
	}
}
