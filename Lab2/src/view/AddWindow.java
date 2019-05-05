package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class AddWindow {
	public AddWindow(Display display, Controller controller) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(500, 250, 300, 300);
		shell.open();
		
		Label labelMain = new Label (shell, SWT.NONE);
		labelMain.setText("INPUT INFORMATION ABOUT STUDENT");
		labelMain.setBounds(35, 15, 250, 20);
		
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
		labelExams.setBounds(10, 167, 70, 20);
		
		Text textExams = new Text (shell, SWT.BORDER);
		textExams.setBounds(85, 165, 180, 20);
		
		Label labelGrades = new Label (shell, SWT.NONE);
		labelGrades.setText("Grades:");
		labelGrades.setBounds(10, 197, 70, 20);
		
		Text textGrades = new Text (shell, SWT.BORDER);
		textGrades.setBounds(85, 195, 180, 20);
		
		Button addButton = new Button (shell, SWT.PUSH);
		addButton.setText("Add");
		addButton.setBounds(125, 225, 50, 30);
		addButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String nameToAdd = textName.getText();
				String surnameToAdd = textSurname.getText();
				String middleNameToAdd = textMiddlename.getText();
				String groupToAdd = textGroup.getText();
				String stringOfExams = textExams.getText();
				String stringOfGrades = textGrades.getText();
				controller.addStudent(nameToAdd, surnameToAdd, middleNameToAdd, groupToAdd, stringOfExams, stringOfGrades);
				
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
