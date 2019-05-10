package view;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.*;
import model.Student;

public class DeleteByAverageGrade {
	public DeleteByAverageGrade(Display display, Controller controller, RecordsOnPage recordsOnPage, Composite composite) {
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
		
		Label labelLowerGrade = new Label (shell, SWT.NONE);
		labelLowerGrade.setText("Lower average grade:");
		labelLowerGrade.setBounds(10, 77, 120, 20);
		
		Text textLowerGrade = new Text (shell, SWT.BORDER);
		textLowerGrade.setBounds(140, 75, 30, 20);
		
		Label labelUpperGrade = new Label (shell, SWT.NONE);
		labelUpperGrade.setText("Upper average grade:");
		labelUpperGrade.setBounds(10, 107, 120, 20);
		
		Text textUpperGrade = new Text (shell, SWT.BORDER);
		textUpperGrade.setBounds(140, 105, 30, 20);
		
		Button deleteButton = new Button (shell, SWT.PUSH);
		deleteButton.setText("Find and delete");
		deleteButton.setBounds(90, 150, 120, 30);
		deleteButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String surnameToSearch = textSurname.getText();
				int lowerGrade = Integer.parseInt(textLowerGrade.getText());
				int upperGrade = Integer.parseInt(textUpperGrade.getText());
				List<Student> search = controller.findByAverageGrade(lowerGrade, upperGrade, surnameToSearch);
				if (search.size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("No match found");
					messageError.open();
				} else {
					int i = controller.removeStudent(search);
					MessageBox messageError = new MessageBox(shell, SWT.OK);
					messageError.setText("COMPLETE!");
					messageError.setMessage(i + " records were removed");
					messageError.open();
					recordsOnPage.refresh(composite);
					recordsOnPage.createTable(composite, controller.getStudents());
				}
				textSurname.setText("");
				textLowerGrade.setText("");
				textUpperGrade.setText("");
			}
		});
	}
}
