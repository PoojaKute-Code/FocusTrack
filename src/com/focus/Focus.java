package com.focus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Focus {
public static final List<String> tasks = new ArrayList<>();
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			while (true) {
				System.out.println("\n===== SmartTask Manager =====");
				System.out.println("1. Add Task");
				System.out.println("2. View Tasks");
				System.out.println("3. Delete Task");
				System.out.println("4. Exit");
				System.out.println("Choose an option: ");
				
				int choice = scanner.nextInt();
				scanner.nextLine();
				
				switch (choice) {
				case 1 -> addTask(scanner);
				case 2 -> viewTasks();
				case 3 -> deleteTask(scanner);
				case 4 -> {
					   System.out.println("Exiting... Have a productive day!");
					   return;
				}
				default -> System.out.println("Invalid option! Please try again.");
				}
				
			}
		}
	}
	
	private static void addTask(Scanner scanner) {
		System.out.print("Enter task description: ");
		String task = scanner.nextLine();
		tasks.add(task);
		System.out.println("Task added successfully!");
		System.out.println("DEBUG: Current tasks -> " + tasks);
	}
	
	private static void viewTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
		}
		else {
			System.out.println("\nYour Tasks:");
			for (int i = 0; i< tasks.size(); i++) {
				System.out.println((i + 1) + " . " + tasks.get(i));
			}
		}
	}
	
	private static void deleteTask(Scanner scanner) {
		viewTasks();
		if (!tasks.isEmpty()) {
			System.out.print("Enter task number to delete: ");
			int taskNumber = scanner.nextInt();
			scanner.nextLine();
			
			if (taskNumber > 0 && taskNumber <= tasks.size()) {
				tasks.remove(taskNumber - 1);
				System.out.println("Task deleted successfully!");
			}
			else {
				System.out.println("Invalid task number!");
			}
		}
	}

}
