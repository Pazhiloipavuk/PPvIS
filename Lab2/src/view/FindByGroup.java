package view;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import model.Student;

public class FindByGroup {
	public FindByGroup(Display display, Controller controller) {
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
		shell.setBounds(50, 100, 1090, 580);
		shell.open();
		
		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 15, 1050, 400);

		TableColumn FIOColumn = new TableColumn(table, SWT.DEFAULT);
		FIOColumn.setText("FIO");
		FIOColumn.setWidth(200);
		
		TableColumn groupColumn = new TableColumn(table, SWT.DEFAULT);
		groupColumn.setText("Group");
		groupColumn.setWidth(100);;

		TableColumn firstExamNameColumn = new TableColumn(table, SWT.DEFAULT);
		firstExamNameColumn.setText("Exam name");
		firstExamNameColumn.pack();
		
		TableColumn firstGradeColumn = new TableColumn(table, SWT.DEFAULT);
		firstGradeColumn.setText("Grade");
		firstGradeColumn.pack();
		
		TableColumn secondExamNameColumnn = new TableColumn(table, SWT.DEFAULT);
		secondExamNameColumnn.setText("Exam name");
		secondExamNameColumnn.pack();
		
		TableColumn secondGradeColumn = new TableColumn(table, SWT.DEFAULT);
		secondGradeColumn.setText("Grade");
		secondGradeColumn.pack();
		
		TableColumn thirdExamNameColumn = new TableColumn(table, SWT.DEFAULT);
		thirdExamNameColumn.setText("Exam name");
		thirdExamNameColumn.pack();
		
		TableColumn thirdGradeColumn = new TableColumn(table, SWT.DEFAULT);
		thirdGradeColumn.setText("Grade");
		thirdGradeColumn.pack();
		
		TableColumn fourthExamNameColumn = new TableColumn(table, SWT.DEFAULT);
		fourthExamNameColumn.setText("Exam name");
		fourthExamNameColumn.pack();
		
		TableColumn fourthGradeColumn = new TableColumn(table, SWT.DEFAULT);
		fourthGradeColumn.setText("Grade");
		fourthGradeColumn.pack();
		
		TableColumn fifthExamNameColumnn = new TableColumn(table, SWT.DEFAULT);
		fifthExamNameColumnn.setText("Exam name");
		fifthExamNameColumnn.pack();
		
		TableColumn fifthGradeColumn = new TableColumn(table, SWT.DEFAULT);
		fifthGradeColumn.setText("Grade");
		fifthGradeColumn.pack();
		
		TableColumn sixthExamNameColumn = new TableColumn(table, SWT.DEFAULT);
		sixthExamNameColumn.setText("Exam name");
		sixthExamNameColumn.pack();
		
		TableColumn sixthGradeColumn = new TableColumn(table, SWT.DEFAULT);
		sixthGradeColumn.setText("Grade");
		sixthGradeColumn.pack();
		
		TableColumn seventhExamNameColumn = new TableColumn(table, SWT.DEFAULT);
		seventhExamNameColumn.setText("Exam name");
		seventhExamNameColumn.pack();
		
		TableColumn seventhGradeColumn = new TableColumn(table, SWT.DEFAULT);
		seventhGradeColumn.setText("Grade");
		seventhGradeColumn.pack();
		
		Label labelSurname = new Label (shell, SWT.NONE);
		labelSurname.setText("Surname:");
		labelSurname.setBounds(10, 437, 70, 20);
		
		Text textSurname = new Text (shell, SWT.BORDER);
		textSurname.setBounds(85, 435, 180, 20);
		
		Label labelGroup = new Label (shell, SWT.NONE);
		labelGroup.setText("Group:");
		labelGroup.setBounds(10, 467, 70, 20);
		
		Text textGroup = new Text (shell, SWT.BORDER);
		textGroup.setBounds(85, 465, 100, 20);
		
		Button findButton = new Button (shell, SWT.PUSH);
		findButton.setText("Find");
		findButton.setBounds(300, 445, 120, 30);
		findButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String surnameToSearch = textSurname.getText();
				String groupToSearch = textGroup.getText();
				ArrayList<Student> studentToFind = controller.findByNumberOfGroup(groupToSearch, surnameToSearch);
				if (studentToFind.size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("No match found");
					messageError.open();
				} else {
			        for (Student student : studentToFind) {
			            TableItem tableItem = new TableItem(table, SWT.DEFAULT);
			            tableItem.setText(0, student.getSurname() + " " + student.getName() + " " + student.getMiddleName());
			            tableItem.setText(1, student.getGroup());
			            int i = 2;
				    	for (Map.Entry<String, Integer> pair : student.getExams().entrySet()) {
				            tableItem.setText(i, pair.getKey());
				            i++;
				            tableItem.setText(i, String.valueOf(pair.getValue()));
				            i++;
				    	}
			        }
				}
				textSurname.setText("");
				textGroup.setText("");
			}
		});
	}
}
