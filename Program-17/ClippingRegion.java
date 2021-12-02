//17. Write a program to design and implement Clipping Region on MIDlet. 

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class ClippingRegion extends MIDlet {
  private Display display;
  private MyCanvas canvas;
  public ClippingRegion() {
    display = Display.getDisplay(this);
    canvas = new MyCanvas(this);
  }
  protected void startApp() {
    display.setCurrent(canvas);
  }
  protected void pauseApp() {
  }
  protected void destroyApp(boolean unconditional) {
  }
  public void exitMIDlet() {
    destroyApp(true);
    notifyDestroyed();
  }
  public Display getDisplay() {
    return display;
  }
}
class MyCanvas extends Canvas implements CommandListener {
  private Command exit = new Command("Exit", Command.EXIT, 1);
  private ClippingRegion clippingRegion;
  private Image image = null;
  public MyCanvas(ClippingRegion clippingRegion) {
    this.clippingRegion = clippingRegion;
    
    addCommand(exit);
    setCommandListener(this);
    try {
      image = Image.createImage(70, 70);
      Graphics graphics = image.getGraphics();
      graphics.setColor(255, 180, 200);
      graphics.fillArc(10, 10, 60, 50, 180, 180);
    } catch (Exception error) {
      Alert alert = new Alert("Failure", "Creating Image", null, null);
      alert.setTimeout(Alert.FOREVER);
      this.clippingRegion.getDisplay().setCurrent(alert);
    }
  }
  protected void paint(Graphics graphics) {
    if (image != null) {
      graphics.setColor(25, 205, 250);
      graphics.fillRect(0, 0, getWidth(), getHeight());
      graphics.setClip(35, 35, 40, 40);
      graphics.drawImage(image, 30, 30, Graphics.VCENTER | Graphics.HCENTER);
    }
  }
  public void commandAction(Command command, Displayable display) {
    if (command == exit) {
      clippingRegion.exitMIDlet();
    }
  }
}