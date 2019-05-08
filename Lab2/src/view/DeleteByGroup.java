package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.Controller;

public class DeleteByGroup {
	public DeleteByGroup(Display display, Controller controller) {
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
		
		Label labelGroup = new Label (shell, SWT.NONE);
		labelGroup.setText("Group:");
		labelGroup.setBounds(10, 87, 70, 20);
		
		Text textGroup = new Text (shell, SWT.BORDER);
		textGroup.setBounds(85, 85, 180, 20);
		
		Button deleteButton = new Button (shell, SWT.PUSH);
		deleteButton.setText("Find and delete");
		deleteButton.setBounds(90, 150, 120, 30);
		deleteButton.addSelectionListener(new SelectionAdapter() {

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
					int i = controller.removeStudent(controller.getStudentsForTasks());
					MessageBox messageError = new MessageBox(shell, SWT.OK);
					messageError.setText("COMPLETE!");
					messageError.setMessage(i + " records were removed");
					messageError.open();
				}
				textSurname.setText("");
				textGroup.setText("");
			}
		});
	}
}
