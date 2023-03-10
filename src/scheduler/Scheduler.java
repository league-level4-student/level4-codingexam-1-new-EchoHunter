package scheduler;

import java.util.Iterator;
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
			noClose = newResponse.equals("n") ? true : false;
			if(noClose) {
				addNewEvent();
				getSched();
			}

		} while (noClose);
	}
	
	
	public static void addNewEvent() {
		String newResponse = "";
		Scanner qAsk = new Scanner(System.in);
		Boolean keepAsking = false;
		Double time = 1.00;
		String name = "";
		Node<NameAndTime> day = null;
		Node<NameAndTime> previous;
		Boolean contCheck = false;
		
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
				System.out.println("The time of the event? Format it as 16.30 for 4:30pm");
				time = Double.parseDouble(qAsk.next());
				System.out.println("The name of the event?");
				name = qAsk.next();
				
				if(day==null) {
					day = new Node<NameAndTime>(new NameAndTime(name, time));
					day.getValue().getTime()
				}else {
					while(!checkIf(day, time)) {
						previous = day.getPrev().getValue().equals(null) ? null : day.getPrev();
						if((previous == null)&&(day.getValue().getTime()<time)) {
							previous.setValue(new NameAndTime(name,time));
						}else  {
							previous = day;
							day = day.getNext();
						}
					}
		
				}
			}
		
	}
	private static boolean checkIf(Node<NameAndTime> list, Double toCheck) {
	Node<NameAndTime> current = list;
	Node<NameAndTime> next = current.getNext();
	boolean cont = true;
		
		do {
			if(current.getValue().getTime()>toCheck) {
				cont = false;
			}else if(current.getValue().getTime()<toCheck) {
				current = next;
				next = current.getNext();
			}else {
				return true;
			}
		}while(cont);
		
	return false;	
	}
	public static void getSched() {
		Scanner qAsk = new Scanner(System.in);
		String newResponse = "";
		Boolean keepAsking = false;
		System.out.println("Would you like to see your schedule?");
		keepAsking = qAsk.next().equals("y") ? true : false;
		if (keepAsking) {
		System.out.println("enter the day you would like to see");
		newResponse = qAsk.next();
		Node<NameAndTime> current;
		switch (newResponse) {
		case "Monday":
			current = DaysOfWeeks.Monday.getLinkedList().getHead();
			for(int i = 0; i< DaysOfWeeks.Monday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
		case "Tuesday":
			current = DaysOfWeeks.Tuesday.getLinkedList().getHead();
			for(int i = 0; i< DaysOfWeeks.Tuesday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
		case "Wednesday":
			current = DaysOfWeeks.Wednesday.getLinkedList().getHead();
			for(int i = 0; i< DaysOfWeeks.Wednesday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
		case "Thursday":
			current = DaysOfWeeks.Thursday.getLinkedList().getHead();
			System.out.println(DaysOfWeeks.Thursday.getLinkedList().size());
			for(int i = 0; i< DaysOfWeeks.Thursday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
		case "Friday":
			current = DaysOfWeeks.Friday.getLinkedList().getHead();
			for(int i = 0; i< DaysOfWeeks.Friday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
		case "Saturday":
			current = DaysOfWeeks.Saturday.getLinkedList().getHead();
			for(int i = 0; i< DaysOfWeeks.Saturday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
		case "Sunday":
			current = DaysOfWeeks.Sunday.getLinkedList().getHead();
			for(int i = 0; i < DaysOfWeeks.Sunday.getLinkedList().size();i++) {
				System.out.println( current.getValue().getDesc() + " " + current.getValue().getTime());
				current = current.getNext();
			}
			break;
	}
		}
	}
	
}