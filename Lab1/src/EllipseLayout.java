import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;


public class EllipseLayout extends Layout {

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		// TODO Auto-generated method stub
		boolean upperHalfPlane = true;
		int intX = 0;
		int intY = 0;
		double doubleX = 0;
		double doubleY = 0;
		
		Control[] arrayShell = composite.getChildren();
		
		Rectangle screen = composite.getBounds();
		int a = screen.width/2;
		int b = screen.height/2;
		int step = 0;
		if (screen.width < 500) {
			step = screen.width/arrayShell.length - 24;
		} else {
			step = screen.width/arrayShell.length;
		}
		
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
			} else {
		 		arrayShell[i].setLocation(intX, intY - widget.height/2);
		 		doubleX = doubleX + 2*step;
			}
	    }
	}

}
