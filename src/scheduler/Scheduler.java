package scheduler;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
			if (noClose) {
				addNewEvent();
				removeEvent();
				getSched();
			}

		} while (noClose);
	}

	private static void removeEvent() {
		Scanner qAsk = new Scanner(System.in);
		boolean keepAsking = false;
		LinkedList<NameAndTime> day = null;
		Node<NameAndTime> current = null;
		System.out.println("Would you like to remove from your schedule? y/n");
		keepAsking = qAsk.next().equals("y") ? true : false;

		if (keepAsking) {
			System.out.println("enter the day you would like to remove from to");
			String newResponse = qAsk.next();
			switch (newResponse) {
			case "Monday":
				day = DaysOfWeeks.Monday.getLinkedList();
				break;
			case "Tuesday":
				day = DaysOfWeeks.Tuesday.getLinkedList();
				break;
			case "Wednesday":
				day = DaysOfWeeks.Wednesday.getLinkedList();
				break;
			case "Thursday":
				day = DaysOfWeeks.Thursday.getLinkedList();
				break;
			case "Friday":
				day = DaysOfWeeks.Friday.getLinkedList();
				break;
			case "Saturday":
				day = DaysOfWeeks.Saturday.getLinkedList();
				break;
			case "Sunday":
				day = DaysOfWeeks.Sunday.getLinkedList();
				break;
			}
			current = day.getHead();
			System.out.println("Which event would you like to remove?");
			newResponse = qAsk.next();
			for (int i = 0; i < day.size(); i++) {
				if((current.getValue().getDesc().equals(newResponse))) {
					if(current.getNext() != null) {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					}
					day.remove(i);
					break;
				}
				else {
					current = current.getNext();
				}
			}
		}
	}

	public static void addNewEvent() {
		String newResponse = "";
		Scanner qAsk = new Scanner(System.in);
		Boolean keepAsking = false;
		Double time = 1.00;
		String name = "";
		LinkedList<NameAndTime> day = null;
		Node<NameAndTime> current;
		Node<NameAndTime> previous;
		Boolean contCheck = false;

		System.out.println("Would you like to add to your schedule? y/n");
		keepAsking = qAsk.next().equals("y") ? true : false;

		if (keepAsking) {
			System.out.println("enter the day you would like to add to");
			newResponse = qAsk.next();
			switch (newResponse) {
			case "Monday":
				day = DaysOfWeeks.Monday.getLinkedList();
				break;
			case "Tuesday":
				day = DaysOfWeeks.Tuesday.getLinkedList();
				break;
			case "Wednesday":
				day = DaysOfWeeks.Wednesday.getLinkedList();
				break;
			case "Thursday":
				day = DaysOfWeeks.Thursday.getLinkedList();
				break;
			case "Friday":
				day = DaysOfWeeks.Friday.getLinkedList();
				break;
			case "Saturday":
				day = DaysOfWeeks.Saturday.getLinkedList();
				break;
			case "Sunday":
				day = DaysOfWeeks.Sunday.getLinkedList();
				break;
			}
			current = day.getHead();
			System.out.println("The time of the event? Format it as 16.30 for 4:30pm");
			time = Double.parseDouble(qAsk.next());
			System.out.println("The name of the event?");
			name = qAsk.next();

			if (current == null) {
				day.add(new NameAndTime(name, time));
			} else {
				if ((day.getTail() != null) && (day.getTail().getValue().getTime() < time)) {
					day.add(new NameAndTime(name, time));
				}
				if (!checkIf(day, time)) {
					day.add(new NameAndTime(name, time));

				}
			
			}
			sort(day);
		}

	}

	private static boolean checkIf(LinkedList<NameAndTime> list, Double toCheck) {
		Node<NameAndTime> current = list.getHead();

		while (current != null) {
			if (current.getValue().getTime() == toCheck) {
				return true;
			}
			current = current.getNext() == null ? null : current.getNext();
		}

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
				if(DaysOfWeeks.Monday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Monday.getLinkedList().getHead();
				for (int i = 0; i < DaysOfWeeks.Monday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			case "Tuesday":
				if(DaysOfWeeks.Tuesday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Tuesday.getLinkedList().getHead();
				for (int i = 0; i < DaysOfWeeks.Tuesday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			case "Wednesday":
				if(DaysOfWeeks.Wednesday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Wednesday.getLinkedList().getHead();
				for (int i = 0; i < DaysOfWeeks.Wednesday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			case "Thursday":
				if(DaysOfWeeks.Thursday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Thursday.getLinkedList().getHead();
				System.out.println(DaysOfWeeks.Thursday.getLinkedList().size());
				for (int i = 0; i < DaysOfWeeks.Thursday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			case "Friday":
				if(DaysOfWeeks.Friday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Friday.getLinkedList().getHead();
				for (int i = 0; i < DaysOfWeeks.Friday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			case "Saturday":
				if(DaysOfWeeks.Saturday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Saturday.getLinkedList().getHead();
				for (int i = 0; i < DaysOfWeeks.Saturday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			case "Sunday":
				if(DaysOfWeeks.Sunday.getLinkedList().getHead() != null) {
				current = DaysOfWeeks.Sunday.getLinkedList().getHead();
				for (int i = 0; i < DaysOfWeeks.Sunday.getLinkedList().size(); i++) {
					System.out.println(current.getValue().getDesc() + " " + current.getValue().getTime());
					current = current.getNext();
				}
				}
				break;
			}
		}
	}
	private static void sort(LinkedList<NameAndTime> list) {
		for (int i = 0; i < list.size(); i++) {
			Node<NameAndTime> current = list.getHead();
			Node<NameAndTime> next = current.getNext();
			for (int j = 0; j < list.size(); j++) {
				try {
				if((next.getValue().getTime()<current.getValue().getTime())) {
					Node<NameAndTime> placeholder = new Node<NameAndTime>(null);
					placeholder.setValue(next.getValue());
					next.setValue(current.getValue());
					current.setValue(placeholder.getValue());
				}
				}catch(NullPointerException e) {
				}
			}			
		}
	}

}