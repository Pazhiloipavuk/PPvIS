package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class AddWindow {
	public AddWindow(Display display, Controller controller, Composite composite) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(500, 100, 400, 600);
		shell.open();
		
		Label labelMain = new Label (shell, SWT.NONE);
		labelMain.setText("INPUT INFORMATION ABOUT STUDENT");
		labelMain.setBounds(85, 15, 250, 20);
		
		Label labelName = new Label (shell, SWT.NONE);
		labelName.setText("Name:");
		labelName.setBounds(10, 47, 70, 20);
		
		Text textName = new Text (shell, SWT.BORDER);
		textName.setBounds(85, 45, 180, 20);
		
		Label labelSurname = new Label (shell, SWT.NONE);
		labelSurname.setText("Surname:");
		labelSurname.setBounds(10, 77, 70, 20);
		
		Text textSurname = new Text (shell, SWT.BORDER);
		textSurname.setBounds(85, 75, 180, 20);
		
		Label labelMiddlename = new Label (shell, SWT.NONE);
		labelMiddlename.setText("Middlename:");
		labelMiddlename.setBounds(10, 107, 70, 20);
		
		Text textMiddlename = new Text (shell, SWT.BORDER);
		textMiddlename.setBounds(85, 105, 180, 20);
		
		Label labelGroup = new Label (shell, SWT.NONE);
		labelGroup.setText("Group:");
		labelGroup.setBounds(10, 137, 70, 20);
		
		Text textGroup = new Text (shell, SWT.BORDER);
		textGroup.setBounds(85, 135, 180, 20);
		
		Label labelExams = new Label (shell, SWT.NONE);
		labelExams.setText("Exams:");
		labelExams.setBounds(100, 167, 70, 20);
		
		Text textExams = new Text (shell, SWT.BORDER| SWT.MULTI | SWT.RIGHT);
		textExams.setBounds(10, 195, 180, 300);
		
		Label labelGrades = new Label (shell, SWT.NONE);
		labelGrades.setText("Grades:");
		labelGrades.setBounds(250, 167, 70, 20);
		
		Text textGrades = new Text (shell, SWT.BORDER| SWT.MULTI | SWT.LEFT);
		textGrades.setBounds(195, 195, 180, 300);
		
		Button addButton = new Button (shell, SWT.PUSH);
		addButton.setText("Add");
		addButton.setBounds(175, 525, 50, 30);
		addButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String nameToAdd = textName.getText();
				String surnameToAdd = textSurname.getText();
				String middleNameToAdd = textMiddlename.getText();
				String groupToAdd = textGroup.getText();
				String stringOfExams = textExams.getText();
				String stringOfGrades = textGrades.getText();
				controller.addStudent(nameToAdd, surnameToAdd, middleNameToAdd, groupToAdd, stringOfExams, stringOfGrades);
				new RecordsOnPage(composite, controller, "main");
				textName.setText("");
				textSurname.setText("");
				textMiddlename.setText("");
				textGroup.setText("");
				textExams.setText("");
				textGrades.setText("");
			}
		});
	}
}
