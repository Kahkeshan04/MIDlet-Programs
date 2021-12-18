/*20. Write a program to design and implement Sample Quiz for user on MIDlet.*/

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.io.*;

public class Quiz extends MIDlet implements CommandListener{
	public Form form1;
	public Form form2;
	public Form form3;
	public Form form4;
	public Form form5;
	public Form form6;
	public Form form;
	
	public ChoiceGroup ch1;
	public ChoiceGroup ch2;
	public ChoiceGroup ch3;
	public ChoiceGroup ch4;
	public ChoiceGroup ch5;

	public Command nextCmd;
	public Command backCmd;
	public Command exitCmd;

	public Display display;
	public StringItem st;
	public StringItem st1;
	public TextField textfield;
	public int count;
	
	
	public Quiz(){ 	
		count=0;
		display=Display.getDisplay(this);
		nextCmd=new Command("Next",Command.OK,1);
		backCmd=new Command("Back",Command.BACK,1);
		exitCmd=new Command("EXIT",Command.EXIT,1);
		st= new StringItem("","");
		st1= new StringItem("","");
		textfield=new TextField("EnterName","",20,TextField.ANY);
		form1=new Form("1) J2Me stands for");
		form2=new Form("2) a+b=");
		form3=new Form("3) 5*5");
		form4=new Form("4) who is TS CM");
		form5=new Form("5) How many districts in TS");
		form6=new Form("Score");
		
		form=new Form("Quiz");
		st1.setText("There are five question \n1) J2Me stands for \n2) a+b= \n3) 5*5 \n4) who is TS CM \n5) How many districts in TS");
		form.append(st1);
		form.addCommand(nextCmd);
		form.setCommandListener(this);
		
		ch1=new ChoiceGroup("",Choice.EXCLUSIVE);
		ch1.append("Java 2 Mobile Edition",null);
		ch1.append("Java 2 Macro Edition",null);
		ch1.append("Java 2 Micro Edition",null);
		ch1.append("Java 2 Music Edition",null);
		form1.append(ch1);
		form1.addCommand(nextCmd);
		form1.addCommand(backCmd);
		form1.setCommandListener(this);
		
		/* Second question*/
		ch2=new ChoiceGroup("",Choice.EXCLUSIVE);
		ch2.append("b+a",null);
		ch2.append("b*a",null);
		ch2.append("b/a",null);
		ch2.append("b-a",null);
		form2.append(ch2);
		form2.addCommand(nextCmd);
		form2.addCommand(backCmd);
		form2.setCommandListener(this);
		
		/* Third question*/
		ch3=new ChoiceGroup("",Choice.EXCLUSIVE);
		ch3.append("20",null);
		ch3.append("30",null);
		ch3.append("10",null);
		ch3.append("25",null);
		form3.append(ch3);
		form3.addCommand(nextCmd);
		form3.addCommand(backCmd);
		form3.setCommandListener(this);
		
		/* Fourth question*/
		ch4=new ChoiceGroup("",Choice.EXCLUSIVE);
		ch4.append("KCR",null);
		ch4.append("YSR",null);
		ch4.append("Chandra Babu Naidu",null);
		ch4.append("Pawan kalyan",null);
		form4.append(ch4);
		form4.addCommand(nextCmd);
		form4.addCommand(backCmd);
		form4.setCommandListener(this);
		
		/* Fifth question*/
		ch5=new ChoiceGroup("",Choice.EXCLUSIVE);
		ch5.append("23",null);
		ch5.append("10",null);
		ch5.append("15",null);
		ch5.append("33",null);
		form5.append(ch5);
		form5.addCommand(nextCmd);
		form5.addCommand(backCmd);
		form5.setCommandListener(this);
		
		/* Final Score*/
		form6.addCommand(exitCmd);
		form6.setCommandListener(this);
	}

	public void startApp(){
		display.setCurrent(form);
	}

	public void pauseApp()
	{}

	public void destroyApp(boolean unconditional)
	{}
		
	public void commandAction(Command cmd, Displayable displayable){
		if(displayable==form){
			if(cmd==nextCmd)
				display.setCurrent(form1);
		}
		else if(displayable==form1){
			if(cmd==nextCmd)
				display.setCurrent(form2);
			else if(cmd==backCmd)
				display.setCurrent(form);
		}
		else if(displayable==form2){
			if(cmd==nextCmd)
				display.setCurrent(form3);
			else if(cmd==backCmd)
				display.setCurrent(form1);
		}
		else if(displayable==form3){
			if(cmd==nextCmd)
				display.setCurrent(form4);
			else if(cmd==backCmd)
				display.setCurrent(form2);
		}
		else if(displayable==form4){
			if(cmd==nextCmd)
				display.setCurrent(form5);
			else if(cmd==backCmd)
				display.setCurrent(form3);
		}
		else if(displayable==form5){
			if(ch1.getSelectedIndex()==2)
					++count;
				if(ch2.getSelectedIndex()==0)
					++count;
				if(ch3.getSelectedIndex()==3)
					++count;
				if(ch4.getSelectedIndex()==0)
					++count;
				if(ch5.getSelectedIndex()==3)
					++count;
				st.setText(String.valueOf(count));
				form6.append(st);
			if(cmd==nextCmd)
				display.setCurrent(form6);
			else if(cmd==backCmd)
				display.setCurrent(form4);
		}	
		else if(displayable==form6){
			display.setCurrent(form6);
			if(cmd==exitCmd){
				notifyDestroyed();
			}
		}
	}
}
