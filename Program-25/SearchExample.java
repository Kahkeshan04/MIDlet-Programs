/*25. Write a program to design and implement the RSM Search*/

import javax.microedition.rms.*;
import javax.microedition.midlet.*; 
import javax.microedition.lcdui.*;
import java.io.*;

public class SearchExample extends MIDlet implements CommandListener{
	
	private Display display;
	private Alert alert;
	private Form form;
	private Command exit;
	private Command start;
	public  ChoiceGroup ch;
	private RecordStore recordstore = null;
	private RecordEnumeration recordEnumeration = null;
	private Filter filter = null;
	
	public SearchExample (){
		display = Display.getDisplay(this);
		exit = new Command("Exit", Command.SCREEN, 1);
		start = new Command("Start", Command.SCREEN, 1);
		form = new Form("Kahkeshan-01 Mixed RecordEnumeration", null);
		ch=new ChoiceGroup("",Choice.EXCLUSIVE);
		ch.append("MAD",null);
		ch.append("Program",null);
		ch.append("Kahkeshan-01",null);

		form.append(ch);
		form.addCommand(start);
		form.addCommand(exit);
		form.setCommandListener(this);
	}
	
	public void startApp(){
		display.setCurrent(form);
	}

	public void pauseApp(){}

	public void destroyApp( boolean unconditional ){}
	
	public void commandAction(Command command, Displayable displayable){ 
		if (command == exit){
			destroyApp(true);
			notifyDestroyed();
		}
		else if (command == start){
			try{
				recordstore = RecordStore.openRecordStore("myRecordStore", true );
				String outputData[] = {"MAD", "Program", "Kahkeshan-01"};
				int x = ch.getSelectedIndex();
				byte[] byteOutputData = outputData[x].getBytes();
				recordstore.addRecord(byteOutputData, 0, byteOutputData.length);
				filter = new Filter(outputData[x]);
				recordEnumeration = recordstore.enumerateRecords(filter, null, false);
				if (recordEnumeration.numRecords() > 0){
					String string = new String(recordEnumeration.nextRecord());
					alert = new Alert("Reading", string, null, AlertType.WARNING);
					alert.setTimeout(Alert.FOREVER);
					display.setCurrent(alert);
				}
				recordstore.closeRecordStore();
			}
			
			catch (Exception error){
				alert = new Alert("Error Closing",error.toString(), null, AlertType.WARNING);
				alert.setTimeout(Alert.FOREVER);
				display.setCurrent(alert);
			} 
			if (RecordStore.listRecordStores() != null){
				try{
					RecordStore.deleteRecordStore("myRecordStore");
					recordEnumeration.destroy();
					filter.filterClose();
				}
				catch (Exception error){
					alert = new Alert("Error Removing",error.toString(), null, AlertType.WARNING);
					alert.setTimeout(Alert.FOREVER);
					display.setCurrent(alert);
				}
			}
		}
	}
}

class Filter implements RecordFilter{
	
	private String search = null;
	private ByteArrayInputStream inputstream = null;
	private DataInputStream datainputstream = null;
	
	public Filter(String search){
		this.search = search.toLowerCase();
	}
	
	public boolean matches(byte[] suspect){
		String string = new String(suspect).toLowerCase();
		if (string!= null && string.indexOf(search) != -1)
			return true;
		else 
			return false;
	}
	
	public void filterClose(){
		try{
			if (inputstream != null)
				inputstream.close();
			if (datainputstream != null)
				datainputstream.close();
		}
		catch ( Exception error){}
	}
}
