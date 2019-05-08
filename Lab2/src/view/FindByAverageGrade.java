package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class FindByAverageGrade {
	public FindByAverageGrade(Display display, Controller controller) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(50, 100, 1090, 580);
		shell.open();
		
		Label labelSurname = new Label (shell, SWT.NONE);
		labelSurname.setText("Surname:");
		labelSurname.setBounds(740, 425, 60, 20);
		
		Text textSurname = new Text (shell, SWT.BORDER);
		textSurname.setBounds(810, 425, 150, 20);
		
		Label labelLowerGrade = new Label (shell, SWT.NONE);
		labelLowerGrade.setText("Lower average grade:");
		labelLowerGrade.setBounds(740, 455, 120, 20);
		
		Text textLowerGrade = new Text (shell, SWT.BORDER);
		textLowerGrade.setBounds(870, 455, 30, 20);
		
		Label labelUpperGrade = new Label (shell, SWT.NONE);
		labelUpperGrade.setText("Upper average grade:");
		labelUpperGrade.setBounds(740, 485, 120, 20);
		
		Text textUpperGrade = new Text (shell, SWT.BORDER);
		textUpperGrade.setBounds(870, 485, 30, 20);
		
		Button findButton = new Button (shell, SWT.PUSH);
		findButton.setText("Find");
		findButton.setBounds(940, 455, 120, 30);
		findButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String surnameToSearch = textSurname.getText();
				int lowerGrade = Integer.parseInt(textLowerGrade.getText());
				int upperGrade = Integer.parseInt(textUpperGrade.getText());
				controller.findByAverageGrade(lowerGrade, upperGrade, surnameToSearch);
				if (controller.getStudentsForTasks().size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("No match found");
					messageError.open();
				} else {
					new RecordsOnPage(shell, controller, "dialog");
				}
				textSurname.setText("");
				textLowerGrade.setText("");
				textUpperGrade.setText("");
			}
		});
	}
}
