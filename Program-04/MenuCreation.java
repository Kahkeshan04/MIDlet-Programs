/*4. Write a program to design and implement MENU creation using Command<class>
on Mobile Information Device Profile.*/

import javax.microedition.midlet.*; 
import javax.microedition.lcdui.*;

public class MenuCreation extends MIDlet implements CommandListener {
	public ChoiceGroup ch;
	public Form form;
	public Display display;
	public Command command;
	public StringItem st;
	public MenuCreation(){
		display=Display.getDisplay(this);
		ch=new ChoiceGroup("Edit",Choice.EXCLUSIVE);
		ch.append("cut",null);
		ch.append("copy",null);
		ch.append("delete",null);
		ch.setSelectedIndex(0, true);
		command=new Command("Select list item",Command.OK,1);
		form=new Form("Kahkeshan-01");
		form.append(ch);
		form.addCommand(command);
		form.setCommandListener(this);
		st=new StringItem("","");
	}
	public void startApp(){
		display.setCurrent(form);
	}
	
	public void pauseApp() { }
	
	public void destroyApp(boolean unconditional) { }
	
	public void commandAction(Command command,Displayable displayable) {
		if(command==command){ 
			st.setText("");
			st.setText("your selected option is "+ch.getString(ch.getSelectedIndex()));
			form.append(st);
		}
	}
}