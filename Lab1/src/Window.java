import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.Rectangle;


public class Window {
	public void solveTasks(Shell shell) {
		Group firstGroup = new Group(shell, SWT.SHADOW_IN);
		firstGroup.setText("TASK¹1");
		firstGroup.setSize(250, 120);

		Text textFGr = new Text(firstGroup, SWT.BORDER);
		textFGr.setBounds(0, 20, 60, 20);

		Combo combo = new Combo(firstGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setBounds(0, 60, 60, 20);
		
		Button pushButtonFGr = new Button(firstGroup, SWT.PUSH);
		pushButtonFGr.setText("Button");
		pushButtonFGr.setBounds(0, 100, 50, 20);
		pushButtonFGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				if (textFGr.getText() == null || textFGr.getText().length() == 0) {
					return;
				}
				String[] items = combo.getItems();
				for (String item : items) {
					if (item.equals(textFGr.getText())) {
						showErrorMessage(shell);
					}
				}
				combo.add(textFGr.getText());
				clearText(textFGr);
			}
		});
		
		ellipseLayout(firstGroup);
		
		Group secondGroup = new Group(shell, SWT.SHADOW_IN);
		secondGroup.setText("TASK¹2");
		secondGroup.setSize(250, 120);

		Text textSGr = new Text(secondGroup, SWT.BORDER);
		textSGr.setBounds(0, 20, 60, 20);

		Button firstPushButtonSGr = new Button(secondGroup, SWT.PUSH);
		firstPushButtonSGr.setText("Button1");
		firstPushButtonSGr.setBounds(0, 60, 50, 20);

		Button secondPushButtonSGr = new Button(secondGroup, SWT.PUSH);
		secondPushButtonSGr.setText("Button2");
		secondPushButtonSGr.setBounds(0, 100, 50, 20);

		firstPushButtonSGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				secondPushButtonSGr.setText(textSGr.getText());
				clearText(textSGr);
			}
		});

		secondPushButtonSGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				textSGr.setText(firstPushButtonSGr.getText());
				firstPushButtonSGr.setText(secondPushButtonSGr.getText());
				secondPushButtonSGr.setText(textSGr.getText());
				clearText(textSGr);
			}
		});
		
		ellipseLayout(secondGroup);
		
		Group thirdGroup = new Group(shell, SWT.SHADOW_IN);
		thirdGroup.setText("TASK¹3");
		thirdGroup.setSize(210, 120);

		Group groupRadioButton = new Group(thirdGroup, SWT.SHADOW_IN);
		groupRadioButton.setBounds(10, 20, 60, 80);

		Button firstRadioButton = new Button(groupRadioButton, SWT.RADIO);
		firstRadioButton.setText("R1");
		firstRadioButton.setBounds(10, 15, 40, 20);

		Button secondRadionButton = new Button(groupRadioButton, SWT.RADIO);
		secondRadionButton.setText("R2");
		secondRadionButton.setBounds(10, 35, 40, 20);

		Button thirdRadioButton = new Button(groupRadioButton, SWT.RADIO);
		thirdRadioButton.setText("R3");
		thirdRadioButton.setBounds(10, 55, 40, 20);

		Text textTGr = new Text(thirdGroup, SWT.BORDER);
		textTGr.setBounds(75, 27, 60, 20);

		Button pushButtonTGr = new Button(thirdGroup, SWT.PUSH);
		pushButtonTGr.setText("Button");
		pushButtonTGr.setBounds(140, 27, 50, 20);

		pushButtonTGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				if (textTGr.getText().equals(firstRadioButton.getText())) {
					firstRadioButton.setSelection(true);
					secondRadionButton.setSelection(false);
					thirdRadioButton.setSelection(false);
				} else if (textTGr.getText().equals(secondRadionButton.getText())) {
					firstRadioButton.setSelection(false);
					secondRadionButton.setSelection(true);
					thirdRadioButton.setSelection(false);
				} else if (textTGr.getText().equals(thirdRadioButton.getText())) {
					firstRadioButton.setSelection(false);
					secondRadionButton.setSelection(false);
					thirdRadioButton.setSelection(true);
				} else {
					showErrorMessage(shell);
					clearText(textTGr);
				}
				clearText(textTGr);
			}
		});
		
		Group fourthGroup = new Group(shell, SWT.SHADOW_IN);
		fourthGroup.setText("TASK¹4");
		fourthGroup.setSize(210, 120);

		Group groupCheckButton = new Group(fourthGroup, SWT.SHADOW_IN);
		groupCheckButton.setBounds(10, 20, 60, 80);

		Button firstCheckButton = new Button(groupCheckButton, SWT.CHECK);
		firstCheckButton.setText("1");
		firstCheckButton.setBounds(10, 15, 40, 20);
		
		Button secondCheckButton = new Button(groupCheckButton, SWT.CHECK);
		secondCheckButton.setText("2");
		secondCheckButton.setBounds(10, 35, 40, 20);

		Button thirdCheckButton = new Button(groupCheckButton, SWT.CHECK);
		thirdCheckButton.setText("3");
		thirdCheckButton.setBounds(10, 55, 40, 20);

		Text textFoGr = new Text(fourthGroup, SWT.BORDER);
		textFoGr.setBounds(75, 27, 60, 20);

		Button pushButtonFoGr = new Button(fourthGroup, SWT.PUSH);
		pushButtonFoGr.setText("Button");
		pushButtonFoGr.setBounds(140, 27, 50, 20);

		pushButtonFoGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				if (textFoGr.getText().equals(firstCheckButton.getText())) {
					firstCheckButton.setSelection(!firstCheckButton.getSelection());;
				} else if (textFoGr.getText().equals(secondCheckButton.getText())) {
					secondCheckButton.setSelection(!secondCheckButton.getSelection());;
				} else if (textFoGr.getText().equals(thirdCheckButton.getText())) {
					thirdCheckButton.setSelection(!thirdCheckButton.getSelection());;
				} else {
					showErrorMessage(shell);
					clearText(textFoGr);
				}
				clearText(textFoGr);
			}
		});
		
		Group fifthGroup = new Group(shell, SWT.SHADOW_IN);
		fifthGroup.setText("TASK¹5");
		fifthGroup.setSize(300, 300);

		Table table = new Table(fifthGroup, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 15, 190, 160);

		TableColumn firstColumn = new TableColumn(table, SWT.DEFAULT);
		firstColumn.setText("First column");
		firstColumn.pack();

		TableColumn secondColumn = new TableColumn(table, SWT.DEFAULT);
		secondColumn.setText("Second column");
		secondColumn.pack();

		Text textFiGr = new Text(fifthGroup, SWT.BORDER);
		textFiGr.setBounds(15, 180, 50, 20);

		Button firstPushButtonFiGr = new Button(fifthGroup, SWT.PUSH);
		firstPushButtonFiGr.setText("Button");
		firstPushButtonFiGr.setBounds(15, 210, 50, 20);

		firstPushButtonFiGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = new TableItem(table, SWT.DEFAULT, 0);
				item.setText(0, textFiGr.getText());
				clearText(textFiGr);
			}
		});

		Button secondPushButtonFiGr = new Button(fifthGroup, SWT.PUSH);
		secondPushButtonFiGr.setText("Button1");
		secondPushButtonFiGr.setBounds(15, 240, 50, 20);

		secondPushButtonFiGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				moveItem(table, 0);
			}
		});

		Button thirdPushButton = new Button(fifthGroup, SWT.PUSH);
		thirdPushButton.setText("Button2");
		thirdPushButton.setBounds(15, 270, 50, 20);

		thirdPushButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				moveItem(table, 1);
			}
		});
		ellipseLayout(shell);
	}

	public void showErrorMessage(Shell shell) {
		MessageBox message = new MessageBox(shell, SWT.ICON_ERROR);
		message.setText("ERROR!");
		message.setMessage("Unable!");
		message.open();
		return;
	}

	public void clearText(Text text) {
		text.setText("");
		text.forceFocus();
	}
	
	public void moveItem(Table table, int numColumn) {
		TableItem item = table.getSelection()[0];
		if (item.getText(numColumn).equals("")) {
			return;
		} else {
			if (numColumn == 0) {
				item.setText(1, item.getText(numColumn));
				item.setText(0, "");
			} else {
				item.setText(0, item.getText(numColumn));
				item.setText(1, "");
			}
		}
	}
	
	public void ellipseLayout(Shell shell) {
		boolean upperHalfPlane = true;
		int intX = 0;
		int intY = 0;
		int a = 0;
		int b = 0;
		int step = 0;
		double doubleX = 0;
		double doubleY = 0;
		
		Control[] arrayShell = shell.getChildren();
		
		Rectangle screen = shell.getBounds();
		a = screen.width/2;
		b = screen.height/2;
		step = screen.width/arrayShell.length;
		
	    for (int i = 0; i < arrayShell.length; i++) {
	    	Rectangle widget = arrayShell[i].getBounds();
	    	
	    	if (doubleX <= a) {
	        	doubleY = Math.sqrt((a*a - doubleX*doubleX)*b*b/(a*a));
	    	} else {
	           	doubleY = Math.sqrt((doubleX*doubleX - a*a)*b*b/(a*a));
	    	}
	    	
	    	if (upperHalfPlane == true) {
	        	intX = (int)doubleX;
	        	intY = (int)doubleY;
	    	} else {
	        	intX = (int)doubleX;
	        	intY = (int)(screen.height - doubleY);
	    	}
	    	
			if (intX == 0) {
		 		arrayShell[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX + 2*step;
		 		upperHalfPlane = true;
			} else if (intX == screen.width) {
				arrayShell[i].setLocation(intX - widget.width, intY - widget.height/2);
				doubleX = doubleX - 2*step;
				upperHalfPlane = false;
			} else if (intX + 2*step > screen.width) {
				arrayShell[i].setLocation(intX, intY - widget.height/2);
				doubleX = doubleX - 2*step;
				upperHalfPlane = false;
			} else if (intX + 2*step > a) {
		 		arrayShell[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX + step;
			} else if (upperHalfPlane == false & intX - 2*step < a) {
		 		arrayShell[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX - step;
			} else if (upperHalfPlane == false) {
		 		arrayShell[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX - 2*step;
			}
	    }
	}
	
	public void ellipseLayout(Group group) {
		boolean upperHalfPlane = true;
		int intX = 0;
		int intY = 0;
		int a = 0;
		int b = 0;
		int step = 0;
		double doubleX = 0;
		double doubleY = 0;
		
		Control[] arrayGroup = group.getChildren();
		
		Rectangle screen = group.getBounds();
		a = screen.width/2;
		b = screen.height/2;
		step = screen.width/arrayGroup.length - 24;
		
	    for (int i = 0; i < arrayGroup.length; i++) {
	    	Rectangle widget = arrayGroup[i].getBounds();
	    	
	    	if (doubleX <= a) {
	        	doubleY = Math.sqrt((a*a - doubleX*doubleX)*b*b/(a*a));
	    	} else {
	           	doubleY = Math.sqrt((doubleX*doubleX - a*a)*b*b/(a*a));
	    	}
	    	
	    	if (upperHalfPlane == true) {
	        	intX = (int)doubleX;
	        	intY = (int)doubleY;
	    	} else {
	        	intX = (int)doubleX;
	        	intY = (int)(screen.height - doubleY);
	    	}
	    	
			if (intX == 0) {
		 		arrayGroup[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX + 2*step;
		 		upperHalfPlane = true;
			} else if (intX == screen.width) {
				arrayGroup[i].setLocation(intX - widget.width, intY - widget.height/2);
				doubleX = doubleX - 2*step;
				upperHalfPlane = false;
			} else if (intX + 2*step > screen.width) {
				arrayGroup[i].setLocation(intX, intY - widget.height/2);
				doubleX = doubleX - 2*step;
				upperHalfPlane = false;
			} else if (intX + 2*step > a) {
		 		arrayGroup[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX + step;
			} else if (upperHalfPlane == false & intX - 2*step < a) {
		 		arrayGroup[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX - step;
			} else if (upperHalfPlane == false) {
		 		arrayGroup[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX - 2*step;
			}
	    }
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.MAX);
		shell.setText("Lab Work ¹1");
		shell.setBounds(display.getClientArea ());
		shell.open();
		new Window().solveTasks(shell);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
