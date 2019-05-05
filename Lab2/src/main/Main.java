package main;

import controller.Controller;
import model.List;
import view.MainWindow;

public class Main {
	public static void main(String[] args) {
		List list = new List();
		Controller controller = new Controller(list);
		MainWindow mainWindow = new MainWindow(controller);
		mainWindow.createMainWindow();
	}
}
