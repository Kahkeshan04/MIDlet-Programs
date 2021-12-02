//9. Write a program to display the Calendar of current month. 

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import java.util.Date;
import java.util.TimeZone;

public class CalenderMIDlet extends MIDlet{
  private Form form;
  private Display display;
  private DateField calender;  
  private static final int DATE = 0;

  public CalenderMIDlet(){
	calender = new DateField("Date In:", DateField.DATE, TimeZone.getTimeZone("GMT"));
  }

  public void startApp(){
	  display = Display.getDisplay(this);
	  Form form = new Form("Kahkeshan-01");
	  form.append(calender);
	  display.setCurrent(form);
  }

  public void pauseApp(){}

  public void destroyApp(boolean destroy){
	notifyDestroyed();
  }
} 