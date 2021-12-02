//8. Write a program to display the current date and time. 

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class DateAndTime extends MIDlet implements CommandListener{
  private Display disp;
  private Date d;
  Calendar c = Calendar.getInstance();
  String time;
  private DateField currentDate;
  private Command start, exit;
  private Form form;
  private int index;

  public DateAndTime(){
	  form = new Form("Kahkeshan-01");
	  d = new Date();
	  start = new Command("start", Command.SCREEN, 1);
	  exit = new Command("Exit", Command.EXIT, 0);
	  currentDate = new DateField("", DateField.DATE_TIME);
	  currentDate.setDate(d);
	}
  
  public void startApp(){
	  form.append("CURRENT TIME IS: ");
	  index = form.append(currentDate);
	  form.addCommand(start);
	  form.addCommand(exit);
	  form.setCommandListener(this);
	  disp = Display.getDisplay(this);
	  disp.setCurrent(form);
	}

  public void pauseApp(){}

  public void destroyApp(boolean uncond){}

  public void commandAction(Command cmd, Displayable s){
	  if (cmd == exit){
			notifyDestroyed();
		}else if (cmd == start){
		  d = new Date();
		  c.setTime(d);
		  time = c.get(Calendar.HOUR_OF_DAY) + ":" +c.get(Calendar.MINUTE)
			+ ":" + c.get(Calendar.SECOND);
		  form.append("" + time);
		  form.append("\n");
		}
	}
}