/*22. Create a MIDP application, which draws a bar graph to the display. Data values can
be given at int[] array. You can enter four data (integer) values to the input text field.*/

import javax.microedition.midlet.MIDlet; 
import javax.microedition.lcdui.*;

public class PieChart extends MIDlet implements CommandListener {
	public Form form;
	public Command exitCommand;
	public Command OkCommand;
	public Display display;
	public TextField textfield1;
	public TextField textfield2;
	public TextField textfield3;
	public TextField textfield4;
	public Displayable d;
	
	public void startApp(){
		display = Display.getDisplay(this);
		form=new Form("Draw Pie");
		textfield1=new TextField("Value1:-","",30,TextField.ANY);
		textfield2=new TextField("Value2:-","",30,TextField.ANY);
		textfield3=new TextField("Value3:-","",30,TextField.ANY);
		textfield4=new TextField("Value4:-","",30,TextField.ANY);
		form.append(textfield1);
		form.append(textfield2);
		form.append(textfield3);
		form.append(textfield4);
		exitCommand=new Command("exit", Command.EXIT, 1);
		OkCommand=new Command("Ok",Command.OK,1);
		form.addCommand(OkCommand);
		form.addCommand(exitCommand);
		form.setCommandListener(this);
		display.setCurrent(form);
	}
	
	public void pauseApp() {} 
	
	public void destroyApp(boolean unconditional) {}
	
	public void commandAction(Command c, Displayable s) {
		if(s==form){
			if(c==exitCommand)
				notifyDestroyed();
			else if(c==OkCommand){
				int[] data = new int[5];
				data[0]=Integer.parseInt(textfield1.getString());
				data[1]=Integer.parseInt(textfield2.getString());
				data[2]=Integer.parseInt(textfield3.getString());
				data[3]=Integer.parseInt(textfield4.getString());
				d = new PieChartCanvas(data);
				d.addCommand(exitCommand);
				d.setCommandListener(this);
				display.setCurrent(d);
			}
		}
		else if(s==d){
			if(c==exitCommand)
				notifyDestroyed();
		}
	}
}

class PieChartCanvas extends Canvas {
	int[] data;
	int colors[] = { 0xFF0000, 0xA9E969, 0x00FFFF, 0xC675EC, 0x008800, 0x00C400 };
	public PieChartCanvas(int[] data) {
		this.data = data;
	} 
	public void paint(Graphics g) {
		int width = this.getWidth();
		int height = this.getHeight();
		g.setColor(255, 255, 255);
		g.fillRect(0, 0, width, height);
		int sum = 0;
		
		for (int i = 0; i < data.length; i++)
			sum += data[i];
		
		int deltaAngle = 360 * 100 / sum / 100;
		int x = 4;
		int y = 4;
		int diameter;
		
		if (width > height) 
			diameter = height - y * 2;
		else
			diameter = width - x * 2;
		
		int startAngle = 0;
		for (int i = 0; i < data.length; i++){
			g.setColor(colors[i]);
			g.fillArc(x, y, diameter, diameter, startAngle, deltaAngle * data[i]);
			startAngle += deltaAngle * data[i];
		}
	}
}
