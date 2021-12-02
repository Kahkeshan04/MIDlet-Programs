//15. Write a program to design and implement KeyCode actions on MIDlet. 

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

// A simple MIDlet to display the Key Codes of the handset.

public class KeyCode extends MIDlet {

	public void startApp() {
		KeyCodeCanvas kcc = new KeyCodeCanvas(this);
		Display.getDisplay(this).setCurrent(kcc);
	}

	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void quit() {
		notifyDestroyed();
	}

}
