/*package test;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import sax.SAXExample;
import sax.Student;

public class FindByAverageGrade {
    private Shell shell;
	public static void main(String[] args) {
		Display display= new Display();
		new FindByAverageGrade().Find(display);
	}
	public void Find(Display display) {
		shell = new Shell(display, SWT.MAX | SWT.TITLE | SWT.CLOSE);
		shell.setSize(1200, 640);
		shell.setText("Search");
		
		Text textLowerLimit = new Text(shell, SWT.BORDER);
		textLowerLimit.setBounds(1070, 15, 100, 40);
		Text textUpperLimit = new Text(shell, SWT.BORDER);
		textUpperLimit.setBounds(1070, 60, 100, 40);
		Text textSurname = new Text(shell, SWT.BORDER);
		textSurname.setBounds(1070, 105, 100, 40);
		
		Button pushButtonFGr = new Button(shell, SWT.PUSH);
		pushButtonFGr.setText("Button");
		pushButtonFGr.setBounds(1070, 150, 90, 40);
		
 	    for (Student student : students) {
 	    	for (Map.Entry<String, Integer> pair : student.getExams().entrySet()) {
 	    		System.out.println("Key: " + pair.getKey() + " Value: " + pair.getValue());
 	    	}
 	    	System.out.println("Average grade:" + student.getAverageGrade());
 	    	System.out.println("-------------------------------------------");
 	    }    
		
		pushButtonFGr.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {

			}
		});
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}*/
