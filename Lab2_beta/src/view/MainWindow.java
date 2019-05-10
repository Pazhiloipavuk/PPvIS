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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.xml.sax.SAXException;

import controller.*;

public class MainWindow {
	
	private Controller controller;
	Display display = new Display();
	Shell shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE | SWT.SHELL_TRIM);
	boolean firstIteration = true;
	RecordsOnPage recordsOnPage;
	
	public MainWindow(Controller controller) {
		this.controller = controller;
	}
	
	public void createMainWindow() {
		shell.setBounds(150, 100, 1200, 600);
		shell.setText("Lab Work ¹2");
		
		Menu menu = new Menu (shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem fileItem = new MenuItem (menu, SWT.CASCADE);
		fileItem.setText("File");
		
		Menu subMenu = new Menu (shell, SWT.DROP_DOWN);
		fileItem.setMenu(subMenu);

		MenuItem fileCommandsItem = new MenuItem (menu, SWT.CASCADE);
		fileCommandsItem.setText("Commands");
		
		Menu subMenuCommands = new Menu (shell, SWT.DROP_DOWN);
		fileCommandsItem.setMenu(subMenuCommands);
		
		MenuItem subItemAdd = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemAdd.setText ("Add student");
		subItemAdd.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
		    	new AddWindow(display, controller, recordsOnPage, shell);
		    }
		});
		
		MenuItem subItemFindByAverageGrade = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemFindByAverageGrade.setText ("Find by Average Grade");
		subItemFindByAverageGrade.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				new FindByAverageGrade(display, controller);
		    }
		});

		MenuItem subItemFindByGroup = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemFindByGroup.setText ("Find by Group");
		subItemFindByGroup.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
		    	new FindByGroup(display, controller);
		    }
		});
		
		MenuItem subItemFindByDiscipline = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemFindByDiscipline.setText ("Find by Discipline");
		subItemFindByDiscipline.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				new FindByDiscipline(display, controller);
		    }
		});
		
		MenuItem subItemDeleteByAverageGrade = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemDeleteByAverageGrade.setText ("Delete by Average Grade");
		subItemDeleteByAverageGrade.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				new DeleteByAverageGrade(display, controller, recordsOnPage, shell);
		    }
		});

		MenuItem subItemDeleteByGroup = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemDeleteByGroup.setText ("Delete by Group");
		subItemDeleteByGroup.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
		    	new DeleteByGroup(display, controller, recordsOnPage, shell);
		    }
		});
		
		MenuItem subItemDeleteByDiscipline = new MenuItem (subMenuCommands, SWT.PUSH);
		subItemDeleteByDiscipline.setText ("Delete by Discipline");
		subItemDeleteByDiscipline.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
				new DeleteByDiscipline(display, controller, recordsOnPage, shell);
		    }
		});
		
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
				if (recordsOnPage == null) {
					recordsOnPage = new RecordsOnPage();
					recordsOnPage.createTable(shell, controller.getStudents());
				} else {
					recordsOnPage.refresh(shell);
					recordsOnPage.createTable(shell, controller.getStudents());
				}
		    }
		});
		
		MenuItem subItemSave = new MenuItem (subMenu, SWT.PUSH);
		subItemSave.setText ("Save");
		subItemSave.addListener (SWT.Selection, new Listener () {
		    @Override
		    public void handleEvent (Event e) {
		    	if (controller.getStudents().size() == 0) {
					MessageBox messageError = new MessageBox(shell, SWT.ICON_ERROR);
					messageError.setText("ERROR!");
					messageError.setMessage("Nothing to save");
					messageError.open();
					return;
		    	}
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

		Button addStudentButton = new Button(shell, SWT.PUSH);
		addStudentButton.setText("add student");
		addStudentButton.setBounds(1070, 15, 90, 40);

		addStudentButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new AddWindow(display, controller, recordsOnPage, shell);
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
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new FindByGroup(display, controller);
			}
		});
		
		Button findByGradeByDiscipline = new Button(shell, SWT.PUSH | SWT.WRAP);
		findByGradeByDiscipline.setText("find by grade by discipline and surname");
		findByGradeByDiscipline.setBounds(1070, 175, 90, 60);

		findByGradeByDiscipline.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				 new FindByDiscipline(display, controller);
			}
		});
		
		Button deleteByGradeAverage = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByGradeAverage.setText("delete by grade average and surname");
		deleteByGradeAverage.setBounds(1070, 235, 90, 60);

		deleteByGradeAverage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new DeleteByAverageGrade(display, controller, recordsOnPage, shell);
			}
		});

		Button deleteByNumberOfGroup = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByNumberOfGroup.setText("delete by number of group and surname");
		deleteByNumberOfGroup.setBounds(1070, 295, 90, 60);

		deleteByNumberOfGroup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new DeleteByGroup(display, controller, recordsOnPage, shell);
			}
		});
		
		Button deleteByGradeByDiscipline = new Button(shell, SWT.PUSH | SWT.WRAP);
		deleteByGradeByDiscipline.setText("delete by grade by discipline and surname");
		deleteByGradeByDiscipline.setBounds(1070, 355, 90, 60);

		deleteByGradeByDiscipline.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new DeleteByDiscipline(display, controller, recordsOnPage, shell);
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
