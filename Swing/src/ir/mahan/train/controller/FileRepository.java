package ir.mahan.train.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class FileRepository implements IRepository {

	File file;
	
	public FileRepository() {
		
	}

	public FileRepository(File file) {
		
		this.file = file;
		
	}
	
	@Override
	public boolean Save(List<Object> objectList) {
		
		try {
			
			if (FileValidity(file) == false) {
				
				return false;
				
			}
			
			JSONObject jsonObject = new JSONObject(objectList.toString());
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			
			outputStreamWriter.write(jsonObject.toString());
			
			//for(Object anObject : objectList) {
			
				//outputStreamWriter.write(anObject.toString());
			
			//}
			
			outputStreamWriter.close();
			
			JOptionPane.showConfirmDialog(null,
					"Saved successfully.",
					"Save...",
					JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			
			return true;
 
		} catch (IOException e) {
			
			//e.printStackTrace();
			
			JOptionPane.showConfirmDialog(null,
					"There is an error to save.",
					"Save to File",
					JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE);
			
			return false;
			
		}
		
	}
	
	private boolean FileValidity(File file) {
		
		if (file.exists() == true) {
			
			int action  = JOptionPane.showConfirmDialog(null,
					"The file is already exist. Do want to overwrite?",
					"File...",
					JOptionPane.YES_NO_OPTION);
			
			if(action == JOptionPane.YES_OPTION) {
			
				try {
					
					file.createNewFile();
					
					return true;
					
				} catch (IOException e) {

					e.printStackTrace();
					
					return false;
				}
				
			}	
			else
			{	
			
				return false;
			
			}
		
		}
		else
		{
			
			return true;
			
		}
		
	}

}