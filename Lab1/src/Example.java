import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
public class Example {
	public static void main (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
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
		text4.forceFocus();
		Button button4 = new Button (group5, SWT.PUSH);
		button4.setText ("Button");
		button4.addSelectionListener(widgetSelectedAdapter(e -> {
			TableItem item = new TableItem (table, SWT.NONE,0);
			item.setText (0, text4.getText());
			text4.setText("");
		})); 
		Button button6 = new Button (group5, SWT.PUSH);
		button6.setText ("Button1");
		button6.addListener (SWT.Selection, event ->{
		TableItem item = table.getSelection()[0];
		item.setText (1, item.getText(0));
		item.setText (0, "");
		});
		Button button7 = new Button (group5, SWT.PUSH);
		button7.setText ("Button2");
		button7.addListener (SWT.Selection, event ->{
		TableItem item = table.getSelection()[0];
		item.setText (0, item.getText(1));
		item.setText (1, "");
		});
		shell.setLayout (new RowLayout ());
        shell.setText("Example");
        shell.pack();        
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
