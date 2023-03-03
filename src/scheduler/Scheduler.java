package scheduler;

import java.util.Scanner;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler {

	DaysOfWeeks[] days = DaysOfWeeks.values();

	public static void main(String[] args) {
		String newResponse = "";
		Scanner qAsk = new Scanner(System.in);
		Boolean noClose = true;
		do {
			System.out.println("Would you like to close the program? y/n");
			newResponse = qAsk.next();
			noClose = newResponse.equals("y") ? true : false;
			

		} while (noClose);
	}
	
	
	public static void addNewEvent() {
		String newResponse = "";
		Scanner qAsk = new Scanner(System.in);
		Boolean keepAsking = false;
		Double time = 1.00;
		String name = "";
		Node day = null;
		Node next;
		do {
			System.out.println("Would you like to add to your schedule? y/n");
			keepAsking = qAsk.next().equals("y") ? true : false;

			if (keepAsking) {
				System.out.println("enter the day you would like to add to");
				newResponse = qAsk.next();
				switch (newResponse) {
				case "Monday":
					day = DaysOfWeeks.Monday.getLinkedList().getHead();
					break;
				case "Tuesday":
					day = DaysOfWeeks.Tuesday.getLinkedList().getHead();
					break;
				case "Wednesday":
					day = DaysOfWeeks.Wednesday.getLinkedList().getHead();
					break;
				case "Thursday":
					day = DaysOfWeeks.Thursday.getLinkedList().getHead();
					break;
				case "Friday":
					day = DaysOfWeeks.Friday.getLinkedList().getHead();
					break;
				case "Saturday":
					day = DaysOfWeeks.Saturday.getLinkedList().getHead();
					break;
				case "Sunday":
					day = DaysOfWeeks.Sunday.getLinkedList().getHead();
					break;
				}
				next = day.equals(null) ? null : day.getNext();
				System.out.println("The time of the event? Format it as 16.30 for 4:30pm");
				time = Double.parseDouble(qAsk.next());
				System.out.println("The name of the event?");
				name = qAsk.next();
				
				if(day==null) {
					day.setValue(name + " " + time.toString());
				}else {
					if (day.getValue().toString().contains(time.toString())) {
						day = next;
						next = day.getNext();
						
					}
				}
			}
		} while (keepAsking);
	}
}