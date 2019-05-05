/*package start;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

import java.io.IOException;
import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import sax.SAXExample;

public class Start {
	public static void main(String[] args) {
		
		Display display = new Display ();
		Shell shell = new Shell(display);

		try {
			FileDialog dlg = new FileDialog(shell, SWT.OPEN);
			String fname = dlg.open();
			File myFile = new File(fname);
			SAXExample dl = new SAXExample();
			dl.read(myFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			FileDialog dlg1 = new FileDialog(shell, SWT.SAVE);
			String fname1 = dlg1.open();
			File myFile1 = new File(fname1);
			SAXExample dl1 = new SAXExample();
			dl1.write(myFile1);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}*/
