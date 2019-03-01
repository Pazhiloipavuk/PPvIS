import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Window {
	
	public void solveTasks(Shell shell) {
	    Group group1 = new Group(shell, SWT.SHADOW_IN);
	    group1.setText("TASK¹1");
	    group1.setLayout(new RowLayout(SWT.HORIZONTAL));
		Text textOfGroup1 = new Text(group1, SWT.BORDER);
		textOfGroup1.setLayoutData(new RowData());
		Combo combo = new Combo(group1, SWT.DROP_DOWN | SWT.READ_ONLY);
		Button buttonOfGroup1 = new Button(group1, SWT.PUSH);
		buttonOfGroup1.setText("Button");
		
		buttonOfGroup1.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				if (textOfGroup1.getText() == null || textOfGroup1.getText().length() == 0) {
					return;
	            }
	            String[] items = combo.getItems();
	            for (String item : items) {
	            	if (item.equals(textOfGroup1.getText())) {
	            		showMessage(shell);
	                }
	            }
				combo.add(textOfGroup1.getText());
				textOfGroup1.setText("");
				textOfGroup1.forceFocus();
			}
		});
		
	    Group group2 = new Group(shell, SWT.SHADOW_IN);
	    group2.setText("TASK¹2");
	    group2.setLayout(new RowLayout(SWT.HORIZONTAL));
		Text textOfGroup2 = new Text(group2, SWT.BORDER);
		textOfGroup2.setLayoutData(new RowData());
		Button button1OfGroup2 = new Button(group2, SWT.PUSH);
		button1OfGroup2.setText("Button1");
		Button button2OfGroup2 = new Button(group2, SWT.PUSH);
		button2OfGroup2.setText("Button2");
		
		button1OfGroup2.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				button2OfGroup2.setText(textOfGroup2.getText());
				textOfGroup2.setText("");
				textOfGroup2.forceFocus();
			}
		});
		
		button2OfGroup2.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				textOfGroup2.setText(button1OfGroup2.getText());
				button1OfGroup2.setText(button2OfGroup2.getText());
				button2OfGroup2.setText(textOfGroup2.getText());
				textOfGroup2.setText("");
			}
		});

	    Group group3 = new Group(shell, SWT.SHADOW_IN);
	    group3.setText("TASK¹3");
	    group3.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Group groupRadioButton = new Group(group3, SWT.SHADOW_IN);
	    groupRadioButton.setLayout(new RowLayout(SWT.VERTICAL));
	    Button radiobutton1 = new Button(groupRadioButton, SWT.RADIO);
	    radiobutton1.setText("R1");
	    Button radiobutton2 = new Button(groupRadioButton, SWT.RADIO);
	    radiobutton2.setText("R2");
	    Button radiobutton3 = new Button(groupRadioButton, SWT.RADIO);
	    radiobutton3.setText("R3");
		Text textOfGroup3 = new Text(group3, SWT.BORDER);
		textOfGroup3.setLayoutData(new RowData());
		Button buttonOfGroup3 = new Button(group3, SWT.PUSH);
		buttonOfGroup3.setText("Button");
		
		buttonOfGroup3.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				if (textOfGroup3.getText().equals(radiobutton1.getText())) {
					radiobutton1.setSelection(true);
					radiobutton2.setSelection(false);
					radiobutton3.setSelection(false);
				} else if (textOfGroup3.getText().equals(radiobutton2.getText())) {
					radiobutton1.setSelection(false);	
					radiobutton2.setSelection(true);
					radiobutton3.setSelection(false);
				} else if (textOfGroup3.getText().equals(radiobutton3.getText())) {
					radiobutton1.setSelection(false);	
					radiobutton2.setSelection(false);		
					radiobutton3.setSelection(true);			
				} else {
					showMessage(shell);
					textOfGroup3.setText("");
					textOfGroup3.forceFocus();
	            }
				textOfGroup3.setText("");
				textOfGroup3.forceFocus();
			}
		});
		
		Group group4 = new Group(shell, SWT.SHADOW_IN);
	    group4.setText("TASK¹4");
	    group4.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Group groupCheckButton = new Group(group4, SWT.SHADOW_IN);
	    groupCheckButton.setLayout(new RowLayout(SWT.VERTICAL));
	    Button checkbutton1 = new Button(groupCheckButton, SWT.CHECK);
	    checkbutton1.setText("C1");
	    Button checkbutton2 = new Button(groupCheckButton, SWT.CHECK);
	    checkbutton2.setText("C2");
	    Button checkbutton3 = new Button(groupCheckButton, SWT.CHECK);
	    checkbutton3.setText("C3");
		Text textOfGroup4 = new Text(group4, SWT.BORDER);
		textOfGroup4.setLayoutData(new RowData());
		Button buttonOfGroup4 = new Button(group4, SWT.PUSH);
		buttonOfGroup4.setText("Button");
		
		buttonOfGroup4.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				if (textOfGroup4.getText().equals(checkbutton1.getText())) {
					checkbutton1.setSelection(!checkbutton1.getSelection());;
				} else if (textOfGroup4.getText().equals(checkbutton2.getText())) {
					checkbutton2.setSelection(!checkbutton2.getSelection());
				} else if (textOfGroup4.getText().equals(checkbutton3.getText())) {	
					checkbutton3.setSelection(!checkbutton3.getSelection());			
				} else {
					showMessage(shell);
					textOfGroup4.setText("");
					textOfGroup4.forceFocus();
				}
				textOfGroup4.setText("");
				textOfGroup4.forceFocus();
			}
		});

	    Group group5 = new Group(shell, SWT.SHADOW_IN);
	    group5.setText("TASK¹5");
	    group5.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Table table = new Table(group5, SWT.MULTI | SWT.BORDER |SWT.FULL_SELECTION);
	    RowData layoutTable = new RowData();
	    layoutTable.width=160;
	    layoutTable.height=100;
	    table.setLinesVisible(true); 
	    table.setHeaderVisible(true);
	    table.setLayoutData(layoutTable);
	    TableColumn column1 = new TableColumn(table, SWT.DEFAULT);
	    column1.setText("First column");
	    column1.pack();
	    TableColumn column2 = new TableColumn(table, SWT.DEFAULT);
	    column2.setText("Second column");
	    column2.pack();
		Text textOfGroup5 = new Text(group5, SWT.BORDER);
		textOfGroup5.setLayoutData(new RowData());
		Button button1OfGroup5 = new Button(group5, SWT.PUSH);
		button1OfGroup5.setText("Button");
		
		button1OfGroup5.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = new TableItem(table, SWT.DEFAULT, 0);
				item.setText(0, textOfGroup5.getText());
				textOfGroup5.setText("");	
			}
		});
		
		Button button2OfGroup5 = new Button(group5, SWT.PUSH);
		button2OfGroup5.setText("Button1");

		button2OfGroup5.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
            	if (item.getText(0).equals("")) {
            		return;
                } else {
				item.setText(1, item.getText(0));
				item.setText(0, "");
                }
			}
		});
		
		Button button3OfGroup5 = new Button(group5, SWT.PUSH);
		button3OfGroup5.setText("Button2");

		button3OfGroup5.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
            	if (item.getText(1).equals("")) {
            		return;
                } else {
				item.setText (0, item.getText(1));
				item.setText (1, "");
                }
			}
		});
	}
	
	public void showMessage(Shell shell) {		
		MessageBox message = new MessageBox(shell, SWT.ICON_ERROR);
		message.setText("ERROR!");
		message.setMessage("Unable!");
		message.open();
		return;
	}
		
	public static void main(String [] args) {		
		Display display = new Display();
		Shell shell = new Shell(display);
		new Window().solveTasks(shell);
		shell.setLayout(new RowLayout(SWT.VERTICAL));
		shell.pack();
		shell.open ();
        shell.setText("Lab Work ¹1");
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

}
