import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Window {
	public static void main (String [] args) {
		
		Display display = new Display ();
		Shell shell = new Shell (display);
	    Group group1 = new Group(shell, SWT.SHADOW_IN);
	    group1.setText("TASK¹1");
	    group1.setLayout(new RowLayout(SWT.HORIZONTAL));
		Text text = new Text (group1, SWT.BORDER);
		text.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		Combo combo = new Combo(group1, SWT.DROP_DOWN | SWT.READ_ONLY);
		Button button = new Button (group1, SWT.PUSH);
		button.setText ("Button");
		
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				String s = text.getText();
				text.setText("");
				text.forceFocus();
				if (s == null || s.length() == 0) {
					return;
	            }
	            String[] items = combo.getItems();
	            for (String item : items) {
	            	if (item.equals(s)) {
	            		MessageBox message = new MessageBox(shell, SWT.ICON_ERROR);
	            		message.setText("ERROR!");
	            		message.setMessage("Unable to add this word:" + s);
	            		message.open();
	            		return;
	                }
	            }
				combo.add(s);	
			}
		});
		
	    Group group2 = new Group(shell, SWT.SHADOW_IN);
	    group2.setText("TASK¹2");
	    group2.setLayout(new RowLayout(SWT.HORIZONTAL));
		Text text1 = new Text (group2, SWT.BORDER);
		text1.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		Button button1 = new Button (group2, SWT.PUSH);
		button1.setText ("Button1");
		Button button2 = new Button (group2, SWT.PUSH);
		button2.setText ("Button2");
		
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				String s1 = text1.getText();
				text1.setText("");
				text1.forceFocus();
				button2.setText(s1);	
			}
		});
		
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				String s2 = button1.getText();
				String s3 = button2.getText();
				button1.setText(s3);
				button2.setText(s2);;	
			}
		});

	    Group group3 = new Group(shell, SWT.SHADOW_IN);
	    group3.setText("TASK¹3");
	    group3.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Group group3_1 = new Group(group3, SWT.SHADOW_IN);
	    group3_1.setLayout(new RowLayout(SWT.VERTICAL));
	    Button radiobutton1 = new Button(group3_1, SWT.RADIO);
	    radiobutton1.setText("R1");
	    String sr1 = radiobutton1.getText();
	    Button radiobutton2 = new Button(group3_1, SWT.RADIO);
	    radiobutton2.setText("R2");
	    String sr2 = radiobutton2.getText();
	    Button radiobutton3 = new Button(group3_1, SWT.RADIO);
	    radiobutton3.setText("R3");
	    String sr3 = radiobutton3.getText();
		Text text2 = new Text (group3, SWT.BORDER);
		text2.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		Button button4 = new Button (group3, SWT.PUSH);
		button4.setText ("Button");
		
		button4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				String s3 = text2.getText();
				text2.setText("");
				text2.forceFocus();
				if (s3.equals(sr1)) {
					radiobutton1.setSelection(true);
					radiobutton2.setSelection(false);
					radiobutton3.setSelection(false);
				}
				else if (s3.equals(sr2)) {
					radiobutton1.setSelection(false);	
					radiobutton2.setSelection(true);
					radiobutton3.setSelection(false);
				}
				else if (s3.equals(sr3)) {
					radiobutton1.setSelection(false);	
					radiobutton2.setSelection(false);		
					radiobutton3.setSelection(true);			
				}	
				else {
					MessageBox message = new MessageBox(shell, SWT.ICON_ERROR);
					message.setText("ERROR!");
					message.setMessage("Unable");
					message.open();
					return;
	            }
			}
		});
		
		Group group4 = new Group(shell, SWT.SHADOW_IN);
	    group4.setText("TASK¹4");
	    group4.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Group group4_1 = new Group(group4, SWT.SHADOW_IN);
	    group4_1.setLayout(new RowLayout(SWT.VERTICAL));
	    Button checkbutton1 = new Button(group4_1, SWT.CHECK);
	    checkbutton1.setText("C1");
	    String sc1 = checkbutton1.getText();
	    Button checkbutton2 = new Button(group4_1, SWT.CHECK);
	    checkbutton2.setText("C2");
	    String sc2 = checkbutton2.getText();
	    Button checkbutton3 = new Button(group4_1, SWT.CHECK);
	    checkbutton3.setText("C3");
	    String sc3 = checkbutton3.getText();
		Text text3 = new Text (group4, SWT.BORDER);
		text3.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		Button button5 = new Button (group4, SWT.PUSH);
		button5.setText ("Button");
		
		button5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				String s4 = text3.getText();
				text3.setText("");
				if (s4.equals(sc1)) {
					checkbutton1.setSelection(!checkbutton1.getSelection());;
				}
				else if (s4.equals(sc2)) {
					checkbutton2.setSelection(!checkbutton2.getSelection());
				}
				else if (s4.equals(sc3)) {	
					checkbutton3.setSelection(!checkbutton3.getSelection());			
				}
				else {
		           	MessageBox message = new MessageBox(shell, SWT.ICON_ERROR);
		           	message.setText("ERROR!");
		           	message.setMessage("Unable");
		           	message.open();
		            return;
				}
			}
		});

	    Group group5 = new Group(shell, SWT.SHADOW_IN);
	    group5.setText("TASK¹5");
	    group5.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Table table = new Table (group5, SWT.MULTI | SWT.BORDER |SWT.FULL_SELECTION); 
	    table.setLinesVisible (true); 
	    table.setHeaderVisible (true);
		table.setItemCount(5);
	    TableColumn column1 = new TableColumn (table, SWT.NONE);
	    column1.setText ("First column");
	    column1.pack();
	    TableColumn column2 = new TableColumn (table, SWT.NONE);
	    column2.setText ("Second column");
	    column2.pack();
		Text text4 = new Text (group5, SWT.BORDER);
		text4.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		Button button6 = new Button (group5, SWT.PUSH);
		button6.setText ("Button");
		
		button6.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = new TableItem (table, SWT.NONE,0);
				item.setText (0, text4.getText());
				text4.setText("");	
			}
		});
		
		Button button7 = new Button (group5, SWT.PUSH);
		button7.setText ("Button1");

		button7.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
				item.setText (1, item.getText(0));
				item.setText (0, "");	
			}
		});
		
		Button button8 = new Button (group5, SWT.PUSH);
		button8.setText ("Button2");

		button8.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
				item.setText (0, item.getText(1));
				item.setText (1, "");	
			}
		});
		shell.setLayout (new RowLayout ());
		shell.open ();
        shell.setText("LABA1");
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
