package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class FindByGroup {
	public FindByGroup(Display display, Controller controller) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(50, 100, 1090, 580);
		shell.open();
		
		Label labelSurname = new Label (shell, SWT.NONE);
		labelSurname.setText("Surname:");
		labelSurname.setBounds(740, 425, 60, 20);
		
		Text textSurname = new Text (shell, SWT.BORDER);
		textSurname.setBounds(810, 425, 150, 20);
		
		Label labelGroup = new Label (shell, SWT.NONE);
		labelGroup.setText("Group:");
		labelGroup.setBounds(740, 455, 70, 20);
		
		Text textGroup = new Text (shell, SWT.BORDER);
		textGroup.setBounds(810, 455, 70, 20);
		
		Button findButton = new Button (shell, SWT.PUSH);
		findButton.setText("Find");
		findButton.setBounds(900, 455, 120, 30);
		findButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String surnameToSearch = textSurname.getText();
				String groupToSearch = textGroup.getText();
				controller.findByNumberOfGroup(groupToSearch, surnameToSearch);
				if (controller.getStudentsForTasks().size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("No match found");
					messageError.open();
				} else {
					new RecordsOnPage(shell, controller, "dialog");
				}
				textSurname.setText("");
				textGroup.setText("");
			}
		});
	}
}
