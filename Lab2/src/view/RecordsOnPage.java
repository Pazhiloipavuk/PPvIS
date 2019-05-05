package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.*;
import model.*;

public class RecordsOnPage {
	private Table table;
	private Label countRecords;
	private Label allRecords;
	private Label currentPages;
	private Label allPages;
	private int currentPage = 1;
    private int count = 0;
	
	public RecordsOnPage(Display display, Shell shell, Controller controller){
		table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 15, 1050, 400);
		
		countRecords = new Label(shell, SWT.NONE);
		countRecords.setBounds(10, 420, 130, 30);
		countRecords.setText("Records on page: " + 0);
		
		allRecords = new Label(shell, SWT.NONE);
		allRecords.setBounds(180, 420, 100, 30);
		allRecords.setText("Records at all: " + 0);
		
		currentPages = new Label(shell, SWT.NONE);
		currentPages.setBounds(300, 420, 100, 30);
		currentPages.setText("Current page: " + 1);
				
		allPages = new Label(shell, SWT.NONE);
		allPages.setBounds(420, 420, 100, 30);
		allPages.setText("Pages at all: " + 1);
		
        Button nextPage = new Button(shell, SWT.PUSH);
        nextPage.setText("Next page");
        nextPage.setBounds(250, 460, 100, 30);

        Button prevPage = new Button(shell, SWT.PUSH);
        prevPage.setText("Prev page");
        prevPage.setBounds(130, 460, 100, 30);

        Button lastPage = new Button(shell, SWT.PUSH);
        lastPage.setText("Last page");
        lastPage.setBounds(370, 460, 100, 30);

        Button firstPage = new Button(shell, SWT.PUSH);
        firstPage.setText("First page");
        firstPage.setBounds(10, 460, 100, 30);

        Text countPages = new Text(shell, SWT.BORDER);
        countPages.setText("5");
        countPages.setBounds(615, 465, 30, 20);
        
        Label countPagesText = new Label(shell, SWT.NONE);
        countPagesText.setText("Input count of records:");
        countPagesText.setBounds(490, 465, 120, 30);
        
        Button generate = new Button(shell, SWT.PUSH);
        generate.setText("Generate");
        generate.setBounds(200, 500, 100, 30);
        generate.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!countPages.getText().isEmpty()) {
                    table.removeAll();
                    count = Integer.parseInt(countPages.getText());
                    if (count <= controller.getStudents().size()) {
                    	setRecords(controller.getStudents(), 0, count);
                    	countRecords.setText("Records on page: " + count);
                    	allPages.setText("Pages at all: " + (int)Math.ceil((double)controller.getStudents().size() / (double)count));
                    } else {
                    	setRecords(controller.getStudents(), 0, controller.getStudents().size());
                    	countRecords.setText("Records on page: " + controller.getStudents().size());
                    	allPages.setText("Pages at all: " + 1);
                    }
                    allRecords.setText("Records at all: " + controller.getStudents().size());
            		currentPages.setText("Current page: " + 1);
                    currentPage = 1;
                }                
            }
        });
        
        nextPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if (controller.getStudents().size() - currentPage * count <= 0) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			if (count <= controller.getStudents().size() - currentPage * count) {
            				setRecords(controller.getStudents(), currentPage * count, currentPage * count + count);
            				countRecords.setText("Records on page: " + count);
            				allPages.setText("Pages at all: " + (int)Math.ceil((double)controller.getStudents().size() / (double)count));
            			} else {
            				setRecords(controller.getStudents(), currentPage * count, controller.getStudents().size());
            				countRecords.setText("Records on page: " + (controller.getStudents().size() - currentPage * count));
            				allPages.setText("Pages at all: " + (int)Math.ceil((double)controller.getStudents().size() / (double)count));
            			}
            			allRecords.setText("Records at all: " + controller.getStudents().size());
            			currentPage++;
            			currentPages.setText("Current page: " + currentPage);
            		} 
            	}
            }
        });
              
        prevPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if (currentPage == 1) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			setRecords(controller.getStudents(), (currentPage - 2) * count, (currentPage - 1) * count);
            			countRecords.setText("Records on page: " + count);
            			allPages.setText("Pages at all: " + (int)Math.ceil((double)controller.getStudents().size() / (double)count));
            			currentPage--;
            			allRecords.setText("Records at all: " + controller.getStudents().size());
            			currentPages.setText("Current page: " + currentPage);
            		} 
            	}
            }
        });
        
        firstPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if (currentPage == 1) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			setRecords(controller.getStudents(), 0, count);
            			countRecords.setText("Records on page: " + count);
            			allPages.setText("Pages at all: " + (int)Math.ceil((double)controller.getStudents().size() / (double)count));
            			currentPage = 1;
            			allRecords.setText("Records at all: " + controller.getStudents().size());
            			currentPages.setText("Current page: " + currentPage);
            		} 
            	}
            }
        });
        
        lastPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if (currentPage == (int)Math.ceil((double)controller.getStudents().size() / (double)count)) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			currentPage = (int)Math.ceil((double)controller.getStudents().size() / (double)count);
           				setRecords(controller.getStudents(), (currentPage - 1) * count, controller.getStudents().size());
            			countRecords.setText("Records on page: " + (controller.getStudents().size() - (currentPage - 1) * count));
            			allPages.setText("Pages at all: " + (int)Math.ceil((double)controller.getStudents().size() / (double)count));
            			allRecords.setText("Records at all: " + controller.getStudents().size());
            			currentPages.setText("Current page: " + currentPage);
            		} 
            	}
            }
        });

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
	}
	
	public void setRecords(ArrayList<Student> studentToSet, int start, int end) {
		List<Student> subStudent = studentToSet;
		List<Student> subStudentToSet = subStudent.subList(start, end);
        for (Student student : subStudentToSet) {
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
}
