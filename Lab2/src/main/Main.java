package main;

import controller.Controller;
import model.ListOfStudents;
import view.MainWindow;

public class Main {
	public static void main(String[] args) {
		ListOfStudents listOfStudents = new ListOfStudents();
		Controller controller = new Controller(listOfStudents);
		MainWindow mainWindow = new MainWindow(controller);
		mainWindow.createMainWindow();
	}
}
