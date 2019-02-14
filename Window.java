import static org.eclipse.swt.events.SelectionListener.*;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Window {
	public static void main (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		Text text = new Text (shell, SWT.BORDER);
		text.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		text.forceFocus();
		Button button = new Button (shell, SWT.PUSH);
		button.setText ("Button");
		Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);		 
		button.addSelectionListener(widgetSelectedAdapter(e -> {	
			String s = text.getText();
			text.setText("");
			text.forceFocus();
			 if (s == null || s.length() == 0) {
                 return;
             }
             String[] items = combo.getItems();
             for (String item : items) {
                 if (item.equals(s)) {
                	 MessageBox message = new MessageBox(shell, SWT.ICON_WARNING);
                	 message.setText("Warning!");
                	 message.setMessage("Unable to add this word:" + s);
                	 message.open();
                     return;
                 }
            }
			combo.add(s);
		}));
		Text text1 = new Text (shell, SWT.BORDER);
		text1.setLayoutData (new RowData (SWT.DEFAULT, SWT.DEFAULT));
		text1.forceFocus();
		Button button1 = new Button (shell, SWT.PUSH);
		button1.setText ("Button1");
		Button button2 = new Button (shell, SWT.PUSH);
		button2.setText ("Button2");
		button1.addSelectionListener(widgetSelectedAdapter(e -> {	
			String s1 = text1.getText();
			text1.setText("");
			text1.forceFocus();
			button2.setText(s1);
		}));
		button2.addSelectionListener(widgetSelectedAdapter(e -> {	
			String s2 = button1.getText();
			String s3 = button2.getText();
			button1.setText(s3);
			button2.setText(s2);
		}));
		shell.setLayout (new RowLayout ());
		shell.open ();
        shell.setText("LABA1");
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
