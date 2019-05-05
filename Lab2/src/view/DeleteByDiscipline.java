package view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import model.Student;

public class DeleteByDiscipline {
	public DeleteByDiscipline(Display display, Controller controller) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(500, 250, 300, 250);
		shell.open();
		
		Label labelMain = new Label (shell, SWT.NONE);
		labelMain.setText("INPUT INFORMATION ABOUT STUDENT");
		labelMain.setBounds(35, 15, 250, 20);
		
		Label labelSurname = new Label (shell, SWT.NONE);
		labelSurname.setText("Surname:");
		labelSurname.setBounds(10, 47, 70, 20);
		
		Text textSurname = new Text (shell, SWT.BORDER);
		textSurname.setBounds(85, 45, 180, 20);
		
		Label labelExam = new Label (shell, SWT.NONE);
		labelExam.setText("Exam name:");
		labelExam.setBounds(10, 77, 70, 20);
		
		Text textExam = new Text (shell, SWT.BORDER);
		textExam.setBounds(85, 75, 180, 20);
		
		Label labelLowerGrade = new Label (shell, SWT.NONE);
		labelLowerGrade.setText("Lower grade:");
		labelLowerGrade.setBounds(10, 107, 70, 20);
		
		Text textLowerGrade = new Text (shell, SWT.BORDER);
		textLowerGrade.setBounds(85, 105, 30, 20);
		
		Label labelUpperGrade = new Label (shell, SWT.NONE);
		labelUpperGrade.setText("Upper grade:");
		labelUpperGrade.setBounds(10, 137, 70, 20);
		
		Text textUpperGrade = new Text (shell, SWT.BORDER);
		textUpperGrade.setBounds(85, 135, 30, 20);
		
		Button deleteButton = new Button (shell, SWT.PUSH);
		deleteButton.setText("Find and delete");
		deleteButton.setBounds(90, 170, 120, 30);
		deleteButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String surnameToSearch = textSurname.getText();
				String examToSearch = textExam.getText();
				int lowerGrade = Integer.parseInt(textLowerGrade.getText());
				int upperGrade = Integer.parseInt(textUpperGrade.getText());
				ArrayList<Student> studentToFind = controller.findByGradeByDiscipline(examToSearch, surnameToSearch, lowerGrade, upperGrade);
				if (studentToFind.size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("No match found");
					messageError.open();
				} else {
					int i = controller.removeStudent(studentToFind);
					MessageBox messageError = new MessageBox(shell, SWT.OK);
					messageError.setText("COMPLETE!");
					messageError.setMessage(i + " records were removed");
					messageError.open();
				}
				textSurname.setText("");
				textExam.setText("");
				textLowerGrade.setText("");
				textUpperGrade.setText("");
			}
		});
	}
}
