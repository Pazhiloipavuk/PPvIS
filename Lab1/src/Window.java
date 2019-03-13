import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;


public class Window {

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

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.MAX);
		shell.setText("Lab Work ¹1");
		shell.setLayout(new EllipseLayout());
		
		Group firstGroup = new Group(shell, SWT.SHADOW_IN);
		firstGroup.setText("TASK¹1");
		firstGroup.setSize(250, 120);
		firstGroup.setLayout(new EllipseLayout());
		
		Text textFGr = new Text(firstGroup, SWT.BORDER);
		textFGr.setBounds(0, 20, 60, 25);

		Combo combo = new Combo(firstGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setBounds(0, 60, 60, 25);
		
		Button pushButtonFGr = new Button(firstGroup, SWT.PUSH);
		pushButtonFGr.setText("Button");
		pushButtonFGr.setBounds(0, 100, 60, 25);
		pushButtonFGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				if (textFGr.getText() == null || textFGr.getText().length() == 0) {
					return;
				}
				String[] items = combo.getItems();
				for (String item : items) {
					if (item.equals(textFGr.getText())) {
						new Window().showErrorMessage(shell);
					}
				}
				combo.add(textFGr.getText());
				new Window().clearText(textFGr);
			}
		});
		firstGroup.layout();
		
		Group secondGroup = new Group(shell, SWT.SHADOW_IN);
		secondGroup.setText("TASK¹2");
		secondGroup.setSize(250, 120);
		secondGroup.setLayout(new EllipseLayout());

		Text textSGr = new Text(secondGroup, SWT.BORDER);
		textSGr.setBounds(0, 20, 60, 25);

		Button firstPushButtonSGr = new Button(secondGroup, SWT.PUSH);
		firstPushButtonSGr.setText("Button1");
		firstPushButtonSGr.setBounds(0, 60, 60, 25);

		Button secondPushButtonSGr = new Button(secondGroup, SWT.PUSH);
		secondPushButtonSGr.setText("Button2");
		secondPushButtonSGr.setBounds(0, 100, 60, 25);

		firstPushButtonSGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				secondPushButtonSGr.setText(textSGr.getText());
				new Window().clearText(textSGr);
			}
		});

		secondPushButtonSGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				textSGr.setText(firstPushButtonSGr.getText());
				firstPushButtonSGr.setText(secondPushButtonSGr.getText());
				secondPushButtonSGr.setText(textSGr.getText());
				new Window().clearText(textSGr);
			}
		});
		secondGroup.layout();
				
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
		textTGr.setBounds(75, 27, 60, 25);

		Button pushButtonTGr = new Button(thirdGroup, SWT.PUSH);
		pushButtonTGr.setText("Button");
		pushButtonTGr.setBounds(140, 27, 60, 25);

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
					new Window().showErrorMessage(shell);
					new Window().clearText(textTGr);
				}
				new Window().clearText(textTGr);
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
		textFoGr.setBounds(75, 27, 60, 25);

		Button pushButtonFoGr = new Button(fourthGroup, SWT.PUSH);
		pushButtonFoGr.setText("Button");
		pushButtonFoGr.setBounds(140, 27, 60, 25);

		pushButtonFoGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				if (textFoGr.getText().equals(firstCheckButton.getText())) {
					firstCheckButton.setSelection(!firstCheckButton.getSelection());;
				} else if (textFoGr.getText().equals(secondCheckButton.getText())) {
					secondCheckButton.setSelection(!secondCheckButton.getSelection());;
				} else if (textFoGr.getText().equals(thirdCheckButton.getText())) {
					thirdCheckButton.setSelection(!thirdCheckButton.getSelection());;
				} else {
					new Window().showErrorMessage(shell);
					new Window().clearText(textFoGr);
				}
				new Window().clearText(textFoGr);
			}
		});
		
		Group fifthGroup = new Group(shell, SWT.SHADOW_IN);
		fifthGroup.setText("TASK¹5");
		fifthGroup.setSize(270, 180);

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
		textFiGr.setBounds(210, 15, 60, 25);

		Button firstPushButtonFiGr = new Button(fifthGroup, SWT.PUSH);
		firstPushButtonFiGr.setText("Button");
		firstPushButtonFiGr.setBounds(210, 45, 60, 25);

		firstPushButtonFiGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = new TableItem(table, SWT.DEFAULT, 0);
				item.setText(0, textFiGr.getText());
				new Window().clearText(textFiGr);
			}
		});

		Button secondPushButtonFiGr = new Button(fifthGroup, SWT.PUSH);
		secondPushButtonFiGr.setText("Button1");
		secondPushButtonFiGr.setBounds(210, 75, 60, 25);

		secondPushButtonFiGr.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new Window().moveItem(table, 0);
			}
		});

		Button thirdPushButton = new Button(fifthGroup, SWT.PUSH);
		thirdPushButton.setText("Button2");
		thirdPushButton.setBounds(210, 105, 60, 25);

		thirdPushButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				new Window().moveItem(table, 1);
			}
		});
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
