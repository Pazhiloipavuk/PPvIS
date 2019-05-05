package view;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.xml.sax.SAXException;

import controller.Controller;

public class MainWindow {
	
	private Controller controller;
	Display display = new Display();
	Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
	
	public MainWindow(Controller controller) {
		this.controller = controller;
	}
	
	public void createMainWindow() {
		shell.setSize(1200, 640);
		shell.setText("Lab Work ¹2");
		
		Menu menu = new Menu (shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem fileItem = new MenuItem (menu, SWT.CASCADE);
		fileItem.setText("File");
		
		Menu subMenu = new Menu (shell, SWT.DROP_DOWN);
		fileItem.setMenu(subMenu);

		MenuItem subItemOpen = new MenuItem (subMenu, SWT.PUSH);
		subItemOpen.setText ("Open");
		subItemOpen.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				FileDialog dialogOpen = new FileDialog(shell, SWT.OPEN);
				String fileNameOpen = dialogOpen.open();
				File fileOpen = new File(fileNameOpen);
				try {
					controller.loadStudents(fileOpen);
				} catch (SAXException | IOException | ParserConfigurationException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		MenuItem subItemSave = new MenuItem (subMenu, SWT.PUSH);
		subItemSave.setText ("Save");
		subItemSave.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				FileDialog dialogSave = new FileDialog(shell, SWT.SAVE);
				String fileNameSave = dialogSave.open();
				File fileSave = new File(fileNameSave);
				try {
					controller.saveStudents(fileSave);
				} catch (ParserConfigurationException | TransformerException e1) {
					e1.printStackTrace();
				}
		    }
		});

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


		Button addStudentButton = new Button(shell, SWT.PUSH);
		addStudentButton.setText("add student");
		addStudentButton.setBounds(1070, 15, 90, 40);

		addStudentButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new AddWindow(display, controller);
			}
		});

		Button findByGradeAverage = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByGradeAverage.setText("find by grade average and surname");
		findByGradeAverage.setBounds(1070, 55, 90, 60);

		findByGradeAverage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new FindByAverageGrade(display, controller);
			}
		});

		Button findByNumberOfGroup = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByNumberOfGroup.setText("find by number of group and surname");
		findByNumberOfGroup.setBounds(1070, 115, 90, 60);

		findByNumberOfGroup.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new FindByGroup(display, controller);
			}
		});
		
		Button findByGradeByDiscipline = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByGradeByDiscipline.setText("find by grade by discipline and surname");
		findByGradeByDiscipline.setBounds(1070, 175, 90, 60);

		findByGradeByDiscipline.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				 new FindByDiscipline(display, controller);
			}
		});
		
		Button deleteByGradeAverage = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByGradeAverage.setText("delete by grade average and surname");
		deleteByGradeAverage.setBounds(1070, 235, 90, 60);

		deleteByGradeAverage.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new DeleteByAverageGrade(display, controller);
			}
		});

		Button deleteByNumberOfGroup = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByNumberOfGroup.setText("delete by number of group and surname");
		deleteByNumberOfGroup.setBounds(1070, 295, 90, 60);

		deleteByNumberOfGroup.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new DeleteByGroup(display, controller);
			}
		});
		
		Button deleteByGradeByDiscipline = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByGradeByDiscipline.setText("delete by grade by discipline and surname");
		deleteByGradeByDiscipline.setBounds(1070, 355, 90, 60);

		deleteByGradeByDiscipline.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new DeleteByDiscipline(display, controller);
			}
		});
				
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
		
	public Controller getController() {
		return controller;
	}
	
}
