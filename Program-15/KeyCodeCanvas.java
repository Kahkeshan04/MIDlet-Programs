

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

/**
* A canvas that displays the key code corresponding to the
* key pressed.
*/
public class KeyCodeCanvas extends Canvas {

	private KeyCode myMIDlet;
	private String myCurrentCode = "none";
	private boolean myPoundPressed = false;

	/**
	* just set a handle back to the MIDlet.
	*/
	public KeyCodeCanvas(KeyCode midlet) {
		myMIDlet = midlet;
	}

	/**
	* Paint the key code corresponding to the key
	* that has been pressed.
	*
	* Note that this is far from optimized!!!
	*/
	public void paint(Graphics g) {
		// get the size of the painting region:
		int width = getWidth();
		int hcenter = width / 2;
		int height = getHeight();

		// clear the screen by coloring everything white:
		g.setColor(0xffffff);
		g.fillRect(0, 0, width, height);

		// write the instructions at the top in black:
		g.setColor(0x000000);
		Font font = g.getFont();
		int fontHeight = font.getHeight();
		g.drawString("to exit", hcenter, 0,
		Graphics.TOP|Graphics.HCENTER);
		g.drawString("press # twice", hcenter, fontHeight + 1,Graphics.TOP|Graphics.HCENTER);

		// Now draw the key code number:
		g.drawString(myCurrentCode, hcenter, 2*(fontHeight + 1),Graphics.TOP|Graphics.HCENTER);

	}

	/**
	* Record the keycode.
	*/
	public void keyPressed(int keyCode) {
		// check for the pound key, and if this is
		// the second pound in a row, quit:
		if(keyCode == Canvas.KEY_POUND) {
			if(myPoundPressed) {
				myMIDlet.quit();
				return;
			} else {
				myPoundPressed = true;
			}
		} else {
			myPoundPressed = false;
		}
		// Now set the key code:
		myCurrentCode = (new Integer(keyCode)).toString();
		// Now display it:
		repaint();
	}

}