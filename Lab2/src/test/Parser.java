/*package test;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.xml.sax.SAXException;

//import View.SearchDisplay;
import sax.SAXExample;

public class Parser {
    public static void main(String[] args)
    {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE);
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
				try {
					FileDialog dialogOpen = new FileDialog(shell, SWT.OPEN);
					String fileNameOpen = dialogOpen.open();
					File fileOpen = new File(fileNameOpen);
					SAXExample SAX = new SAXExample();
					SAX.read(fileOpen);
				} catch (ParserConfigurationException k) {
					k.printStackTrace();
				} catch (SAXException k) {
					k.printStackTrace();
				} catch (IOException k) {
					k.printStackTrace();
				}
		    }
		});
		
		MenuItem subItemSave = new MenuItem (subMenu, SWT.PUSH);
		subItemSave.setText ("Save");
		subItemSave.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				try {
					FileDialog dialogSave = new FileDialog(shell, SWT.SAVE);
					String fileNameSave = dialogSave.open();
					File fileSave = new File(fileNameSave);
					SAXExample DOM = new SAXExample();
					DOM.write(fileSave);
				} catch (ParserConfigurationException l) {
					l.printStackTrace();
				} catch (TransformerException l) {
					l.printStackTrace();
				}
		    }
		});

		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 15, 1050, 400);

		TableColumn firstColumn = new TableColumn(table, SWT.DEFAULT);
		firstColumn.setText("First column");
		firstColumn.pack();

		TableColumn secondColumn = new TableColumn(table, SWT.DEFAULT);
		secondColumn.setText("Second column");
		secondColumn.pack();

		Button addStudentButton = new Button(shell, SWT.PUSH);
		addStudentButton.setText("add student");
		addStudentButton.setBounds(1070, 15, 90, 40);

		addStudentButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
			}
		});

		Button findByGradeAverage = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByGradeAverage.setText("find by grade average and surname");
		findByGradeAverage.setBounds(1070, 55, 90, 60);

		findByGradeAverage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//FindByAverageGrade searchDisplay = new FindByAverageGrade(display);
			}
		});

		Button findByNumberOfGroup = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByNumberOfGroup.setText("find by number of group and surname");
		findByNumberOfGroup.setBounds(1070, 115, 90, 60);

		findByNumberOfGroup.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		
		Button findByGradeByDiscipline = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByGradeByDiscipline.setText("find by grade by discipline and surname");
		findByGradeByDiscipline.setBounds(1070, 175, 90, 60);

		findByGradeByDiscipline.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		
		Button deleteByGradeAverage = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByGradeAverage.setText("delete by grade average and surname");
		deleteByGradeAverage.setBounds(1070, 235, 90, 60);

		deleteByGradeAverage.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
			}
		});

		Button deleteByNumberOfGroup = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByNumberOfGroup.setText("delete by number of group and surname");
		deleteByNumberOfGroup.setBounds(1070, 295, 90, 60);

		deleteByNumberOfGroup.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		
		Button deleteByGradeByDiscipline = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByGradeByDiscipline.setText("delete by grade by discipline and surname");
		deleteByGradeByDiscipline.setBounds(1070, 355, 90, 60);

		deleteByGradeByDiscipline.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
			}
		});
				
		shell.open();
		
		Button close = new Button(shell, SWT.PUSH);
		close.setText("close");
		close.setBounds(500, 500, 90, 70);

		close.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
		});
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
    }
}*/
