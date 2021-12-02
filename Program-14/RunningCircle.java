//14. Write a program to design and implement Draw Arc on MIDlet

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class RunningCircle extends MIDlet{
  
  Form form;

  public void startApp(){
	  form = new Form("Kahkeshan-01");
	  Display display = Display.getDisplay (this);
	  display.setCurrent(new CircleCanvas(display, 10)); 
  }

  public void pauseApp(){}

  public void destroyApp(boolean unconditional){}
}

class CircleCanvas extends Canvas implements Runnable{
  int degree = 360;
  long startTime;
  int seconds;
  Display display;
  CircleCanvas(Display display, int seconds){
	  this.display = display;
	  this.seconds = seconds;
	  startTime = System.currentTimeMillis();
  }

  public void paint(Graphics g){
	  g.setColor(0, 0, 255);
	  g.fillRect(0, 0, getWidth(), getHeight());

	  g.setColor(255, 0, 0);
	  g.fillArc(15,15, 200, 200, 90, degree);
	  display.callSerially(this);
	  g.setColor(255, 0, 0);
	  g.drawArc(15, 15, 200, 200, 0, 360);
	}

  public void run(){
	  int i = 0;
	  int milisecond = (int)((System.currentTimeMillis() - startTime)/seconds); 
	  degree = 360 - (milisecond * 360)/7200;
	  for(i = 0; i <= milisecond; i++){
		repaint();
	  }
	}
}