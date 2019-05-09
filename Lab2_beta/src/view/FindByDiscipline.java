package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class FindByDiscipline {
	public FindByDiscipline(Display display, Controller controller) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(50, 100, 1090, 580);
		shell.open();
		
		Label labelSurname = new Label (shell, SWT.NONE);
		labelSurname.setText("Surname:");
		labelSurname.setBounds(740, 425, 60, 20);
		
		Text textSurname = new Text (shell, SWT.BORDER);
		textSurname.setBounds(810, 425, 150, 20);
		
		Label labelExam = new Label (shell, SWT.NONE);
		labelExam.setText("Exam name:");
		labelExam.setBounds(740, 455, 70, 20);
		
		Text textExam = new Text (shell, SWT.BORDER);
		textExam.setBounds(810, 455, 80, 20);
		
		Label labelLowerGrade = new Label (shell, SWT.NONE);
		labelLowerGrade.setText("Lower grade:");
		labelLowerGrade.setBounds(740, 485, 70, 20);
		
		Text textLowerGrade = new Text (shell, SWT.BORDER);
		textLowerGrade.setBounds(810, 485, 30, 20);
		
		Label labelUpperGrade = new Label (shell, SWT.NONE);
		labelUpperGrade.setText("Upper grade:");
		labelUpperGrade.setBounds(740, 517, 70, 20);
		
		Text textUpperGrade = new Text (shell, SWT.BORDER);
		textUpperGrade.setBounds(810, 515, 30, 20);
		
		Button findButton = new Button (shell, SWT.PUSH);
		findButton.setText("Find");
		findButton.setBounds(940, 455, 120, 30);
		findButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String surnameToSearch = textSurname.getText();
				String examToSearch = textExam.getText();
				int lowerGrade = Integer.parseInt(textLowerGrade.getText());
				int upperGrade = Integer.parseInt(textUpperGrade.getText());
				controller.findByGradeByDiscipline(examToSearch, surnameToSearch, lowerGrade, upperGrade);
				if (controller.getStudentsForTasks().size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("No match found");
					messageError.open();
				} else {
					new RecordsOnPage(shell, controller, "dialog");
				}
				textSurname.setText("");
				textExam.setText("");
				textLowerGrade.setText("");
				textUpperGrade.setText("");
			}
		});
	}
}
