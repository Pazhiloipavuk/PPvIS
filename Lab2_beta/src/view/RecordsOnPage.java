package view;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import controller.*;
import model.*;

public class RecordsOnPage{
	private Table table;
	private Label countRecords;
	private Label allRecords;
	private Label currentPage;
	private Label allPages;
	private int numberOfCurrentPage = 1;
    private int count = 0;
    private int numberOfColumns = 0;
    private Text countPages;
    private Label countPagesText;
    private List<Student> listMainWindow;
    private List<Student> listDialogWindow;
    private List<Student> listOfRecords;
    private Button lastPage;
    private Button nextPage;
    private Button prevPage;
    private Button firstPage;
    private Button refresh;
	
	public RecordsOnPage(Composite shell, Controller controller, String check){
		update(controller);
		countRecords = new Label(shell, SWT.NONE);
		countRecords.setBounds(10, 425, 100, 30);
		countRecords.setText("Records on page: " + 0);
		
		allRecords = new Label(shell, SWT.NONE);
		allRecords.setBounds(130, 425, 100, 30);
		allRecords.setText("Records at all: " + 0);
		
		currentPage = new Label(shell, SWT.NONE);
		currentPage.setBounds(250, 425, 100, 30);
		currentPage.setText("Current page: " + 1);
				
		allPages = new Label(shell, SWT.NONE);
		allPages.setBounds(370, 425, 80, 30);
		allPages.setText("Pages at all: " + numberOfCurrentPage);
		
        countPagesText = new Label(shell, SWT.NONE);
        countPagesText.setText("Input count of records:");
        countPagesText.setBounds(470, 425, 120, 30);
		
        countPages = new Text(shell, SWT.BORDER);
        countPages.setText("5");
        countPages.setBounds(600, 425, 30, 20);
		if (check.equals("main")) {
			recordsOnPageMainWindow(shell, controller, check);
		} else {
			recordsOnPageDialogWindow(shell, controller, check);
		}
	}
	
	public void recordsOnPageMainWindow(Composite shell, Controller controller, String check) {
		update(controller);
		createTable(shell, check);
		createButtons(shell, check, controller);
	}
	
	public void recordsOnPageDialogWindow(Composite shell, Controller controller, String check) {
		update(controller);
		createTable(shell, check);
		createButtons(shell, check, controller);
	}
	
	public void update(Controller controller) {
		listMainWindow = controller.getStudents();
		listDialogWindow = controller.getStudentsForTasks();
	}
	
	public void createTable(Composite shell, String check) {
		if (check.equals("main")) {
			listOfRecords = listMainWindow;
		} else {
			listOfRecords = listDialogWindow;
		}
		Table tableNew = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		tableNew.setLinesVisible(true);
		tableNew.setHeaderVisible(true);
		tableNew.setBounds(10, 15, 1050, 400);

		this.table = tableNew;
		
		TableColumn FIOColumn = new TableColumn(tableNew, SWT.DEFAULT);
		FIOColumn.setText("FIO");
		FIOColumn.setWidth(200);
		
		TableColumn groupColumn = new TableColumn(tableNew, SWT.DEFAULT);
		groupColumn.setText("Group");
		groupColumn.setWidth(100);

        for (Student student : listOfRecords) {
        	Map<String, Integer> mapOfExams = student.getExams();
	    	if (numberOfColumns < mapOfExams.size()) {
	    			numberOfColumns = mapOfExams.size();
	    	}
        }

		for (int i = 0; i < numberOfColumns * 2; i++) {
			TableColumn tableColumn = new TableColumn(tableNew, SWT.DEFAULT);
			if (i % 2 == 0) {
				tableColumn.setText("Exam name");
				tableColumn.pack();
			} else {
				tableColumn.setText("Grade");
				tableColumn.pack();
			}
		}
		
        if (!countPages.getText().isEmpty()) {
            table.removeAll();
            count = Integer.parseInt(countPages.getText());
            if (count <= listOfRecords.size()) {
            	setRecords(listOfRecords, 0, count);
            	countRecords.setText("Records on page: " + count);
            	allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
            } else {
            	setRecords(listOfRecords, 0, listOfRecords.size());
            	countRecords.setText("Records on page: " + listOfRecords.size());
            	allPages.setText("Pages at all: " + 1);
            }
            allRecords.setText("Records at all: " + listOfRecords.size());
    		currentPage.setText("Current page: " + 1);
            numberOfCurrentPage = 1;
        }
	}
	
	public void createButtons(Composite shell, String check, Controller controller) {
		if (check.equals("main")) {
			listOfRecords = listMainWindow;
		} else {
			listOfRecords = listDialogWindow;
		}

        nextPage = new Button(shell, SWT.PUSH);
        nextPage.setText("Next page");
        nextPage.setBounds(250, 460, 100, 30);
        nextPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	update(controller);
        		if (check.equals("main")) {
        			listOfRecords = listMainWindow;
        		} else {
        			listOfRecords = listDialogWindow;
        		}
            	if (listOfRecords.size() - numberOfCurrentPage * count <= 0) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			if (count <= listOfRecords.size() - numberOfCurrentPage * count) {
            				setRecords(listOfRecords, numberOfCurrentPage * count, numberOfCurrentPage * count + count);
            				countRecords.setText("Records on page: " + count);
            				allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
            			} else {
            				setRecords(listOfRecords, numberOfCurrentPage * count, listOfRecords.size());
            				countRecords.setText("Records on page: " + (listOfRecords.size() - numberOfCurrentPage * count));
            				allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
            			}
            			allRecords.setText("Records at all: " + listOfRecords.size());
            			numberOfCurrentPage++;
            			currentPage.setText("Current page: " + numberOfCurrentPage);
            		} 
            	}
            }
        });

        prevPage = new Button(shell, SWT.PUSH);
        prevPage.setText("Prev page");
        prevPage.setBounds(130, 460, 100, 30);
        prevPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	update(controller);
        		if (check.equals("main")) {
        			listOfRecords = listMainWindow;
        		} else {
        			listOfRecords = listDialogWindow;
        		}
            	if (numberOfCurrentPage == 1) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			setRecords(listOfRecords, (numberOfCurrentPage - 2) * count, (numberOfCurrentPage - 1) * count);
            			countRecords.setText("Records on page: " + count);
            			allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
            			numberOfCurrentPage--;
            			allRecords.setText("Records at all: " + listOfRecords.size());
            			currentPage.setText("Current page: " + numberOfCurrentPage);
            		} 
            	}
            }
        });

        lastPage = new Button(shell, SWT.PUSH);
        lastPage.setText("Last page");
        lastPage.setBounds(370, 460, 100, 30);
        lastPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	update(controller);
        		if (check.equals("main")) {
        			listOfRecords = listMainWindow;
        		} else {
        			listOfRecords = listDialogWindow;
        		}
            	if (numberOfCurrentPage == (int)Math.ceil((double)listOfRecords.size() / (double)count)) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			numberOfCurrentPage = (int)Math.ceil((double)listOfRecords.size() / (double)count);
           				setRecords(listOfRecords, (numberOfCurrentPage - 1) * count, listOfRecords.size());
            			countRecords.setText("Records on page: " + (listOfRecords.size() - (numberOfCurrentPage - 1) * count));
            			allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
            			allRecords.setText("Records at all: " + listOfRecords.size());
            			currentPage.setText("Current page: " + numberOfCurrentPage);
            		} 
            	}
            }
        });

        firstPage = new Button(shell, SWT.PUSH);
        firstPage.setText("First page");
        firstPage.setBounds(10, 460, 100, 30);
        firstPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	update(controller);
        		if (check.equals("main")) {
        			listOfRecords = listMainWindow;
        		} else {
        			listOfRecords = listDialogWindow;
        		}
            	if (numberOfCurrentPage == 1) {
            		return;
            	} else {
            		if (!countPages.getText().isEmpty()) {
            			table.removeAll();
            			count = Integer.parseInt(countPages.getText());
            			setRecords(listOfRecords, 0, count);
            			countRecords.setText("Records on page: " + count);
            			allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
            			numberOfCurrentPage = 1;
            			allRecords.setText("Records at all: " + listOfRecords.size());
            			currentPage.setText("Current page: " + numberOfCurrentPage);
            		} 
            	}
            }
        });
        
        countPages.addKeyListener(new KeyAdapter(){	
        	@Override        		
        	public void keyPressed(KeyEvent e){
        			if(e.keyCode == SWT.CR){
                    	update(controller);
                		if (check.equals("main")) {
                			listOfRecords = listMainWindow;
                		} else {
                			listOfRecords = listDialogWindow;
                		}
                        if (!countPages.getText().isEmpty()) {
                            table.removeAll();
                            count = Integer.parseInt(countPages.getText());
                            if (count <= listOfRecords.size()) {
                            	setRecords(listOfRecords, 0, count);
                            	countRecords.setText("Records on page: " + count);
                            	allPages.setText("Pages at all: " + (int)Math.ceil((double)listOfRecords.size() / (double)count));
                            } else {
                            	setRecords(listOfRecords, 0, listOfRecords.size());
                            	countRecords.setText("Records on page: " + listOfRecords.size());
                            	allPages.setText("Pages at all: " + 1);
                            }
                            allRecords.setText("Records at all: " + listOfRecords.size());
                    		currentPage.setText("Current page: " + 1);
                            numberOfCurrentPage = 1;
                        }
        			}
        		}
        });
        
        refresh = new Button(shell, SWT.PUSH);
        refresh.setText("Refresh table");
        refresh.setBounds(650, 420, 80, 30);
        refresh.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		table.setVisible(false);
        		lastPage.setVisible(false);
        		nextPage.setVisible(false);
        		firstPage.setVisible(false);
        		prevPage.setVisible(false);
        		refresh.setVisible(false);
        		countPages.setVisible(false);
        		countPagesText.setVisible(false);
        		allPages.setVisible(false);
        		currentPage.setVisible(false);
        		allRecords.setVisible(false);
        		countRecords.setVisible(false);
                shell.layout(true);
                update(controller);
                }                
        });		
	}
	
	public void setRecords(List<Student> studentToSet, int start, int end) {
		List<Student> subStudentToSet = studentToSet.subList(start, end);
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