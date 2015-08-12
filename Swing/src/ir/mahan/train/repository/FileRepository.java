package ir.mahan.train.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

public class FileRepository implements IRepository {

	File file;
	
	public FileRepository(File file) {
		
		this.file = file;
		
	}
	
	@Override
	public boolean Save(List<Object> objects) {
		
		try {
			
			if (FileValidity(file) == false) {
				
				return false;
				
			}
			
			
			FileOutputStream fileOutputStream = new FileOutputStream(this.file);
			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			
			ObjectMapper objectMapper = new ObjectMapper();

			objectMapper.writeValue(this.file, objects);

			Object json = objectMapper.readValue(objectMapper.writeValueAsString(objects), Object.class);
			
			outputStreamWriter.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
			
			outputStreamWriter.close();
			
			
			JOptionPane.showConfirmDialog(null,
					"Saved successfully.",
					"Save...",
					JOptionPane.PLAIN_MESSAGE,
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

	@Override
	public String Retrieve() {
		/*
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Object> objects = null;
		
		try {
			
			//objects = (List<Object>) objectMapper.readValue(this.file, Object.class);
			
			objects = objectMapper.readValue(this.file, new TypeReference<List<Person>>(){}); //OK
			
			//objects = objectMapper.readValue(this.file, new TypeReference<List<T>>(){});
			
		} catch (IOException e) {

			//e.printStackTrace();
			
			JOptionPane.showConfirmDialog(null,
					"Can not read the file.",
					"Retrieve...",
					JOptionPane.PLAIN_MESSAGE,
					JOptionPane.ERROR_MESSAGE);
		
		}

		return ((List<Object>)objects);
		*/
		
		try {
			
			FileInputStream fileInputStream = new FileInputStream(this.file);
			
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			
			StringBuffer stringBuffer = new StringBuffer();
			
			int content;
			
			while ((content = inputStreamReader.read()) != -1) {

				stringBuffer.append((char) content);
				
			}
			
			inputStreamReader.close();
			
			return stringBuffer.toString();
		
		} catch (IOException e) {

			JOptionPane.showConfirmDialog(null,
					"Can not read the file.",
					"Retrieve...",
					JOptionPane.PLAIN_MESSAGE,
					JOptionPane.ERROR_MESSAGE);
			
			return null;
		
		}
	}

}