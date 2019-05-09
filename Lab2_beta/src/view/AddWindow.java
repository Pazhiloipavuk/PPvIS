package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class AddWindow {
	
	String stringOfExams;
	String stringOfGrades;
	boolean firstIteration = true;
	
	public AddWindow(Display display, Controller controller, Composite composite) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(500, 100, 400, 350);
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
		labelExams.setText("Exam:");
		labelExams.setBounds(10, 167, 70, 20);
		
		Text textExams = new Text (shell, SWT.BORDER);
		textExams.setBounds(85, 165, 140, 20);
		
		Label labelGrades = new Label (shell, SWT.NONE);
		labelGrades.setText("Grade:");
		labelGrades.setBounds(10, 197, 70, 20);
		
		Text textGrades = new Text (shell, SWT.BORDER);
		textGrades.setBounds(85, 195, 40, 20);
		
		Label labelAllExams = new Label (shell, SWT.NONE);
		labelAllExams.setText("All exams and grades:");
		labelAllExams.setBounds(250, 167, 120, 20);
		
		Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setBounds(250, 195, 120, 20);
		
		Button addExamButton = new Button (shell, SWT.PUSH);
		addExamButton.setText("Add exam");
		addExamButton.setBounds(155, 193, 70, 28);
		addExamButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String addExam = textExams.getText();
				String addGrade = textGrades.getText();
				if (firstIteration == true) {
					stringOfExams = addExam;
					stringOfGrades = addGrade;
					firstIteration = false;
				} else {
					stringOfExams = stringOfExams + " " + addExam;
					stringOfGrades = stringOfGrades + " " + addGrade;
				}
				combo.add(addExam + " " + addGrade);
				textExams.setText("");
				textGrades.setText("");
			}
		});
		
		Button addButton = new Button (shell, SWT.PUSH);
		addButton.setText("Add");
		addButton.setBounds(175, 255, 50, 30);
		addButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String nameToAdd = textName.getText();
				String surnameToAdd = textSurname.getText();
				String middleNameToAdd = textMiddlename.getText();
				String groupToAdd = textGroup.getText();
				controller.addStudent(nameToAdd, surnameToAdd, middleNameToAdd, groupToAdd, stringOfExams, stringOfGrades);
				//new RecordsOnPage(composite, controller, "main");
				textName.setText("");
				textSurname.setText("");
				textMiddlename.setText("");
				textGroup.setText("");
				textExams.setText("");
				textGrades.setText("");
				firstIteration = true;
			}
		});
	}
}
