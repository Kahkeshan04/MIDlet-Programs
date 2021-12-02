//1. Write a program to implement and display a greeting message on MIDlet?

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class HelloWorld extends MIDlet{
  private Form form;
  private Display display;

  public HelloWorld(){
	super();
  }

  public void startApp(){
	  form = new Form("Kahkeshan-01");
	  String msg = "Hello World!!!!!!!";
	  form.append(msg);
	  display = Display.getDisplay(this);
	  display.setCurrent(form);
  }

  public void pauseApp(){}
  
  public void destroyApp(boolean unconditional){
	notifyDestroyed();
  }
}
