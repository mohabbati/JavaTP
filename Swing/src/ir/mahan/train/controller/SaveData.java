package ir.mahan.train.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;

import org.json.*;

import ir.mahan.train.view.IstringListener;
import ir.mahan.train.view.MainFrame;

public class SaveData {
	
	public void SaveToFile(String filePath, Object object) {
		try {
			
			JFileChooser fileChooser = null;
			
			if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
				
				/* Sample Code
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				} else {
				  System.out.println("No Selection ");
				}
				*/
				
			}
			
			
			
			
			JSONObject jsonObject = new JSONObject(object);
			
			String content = jsonObject.toString();;
			
			File file = new File("d:/filename.az");//filePath
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			osw.write(content);
			
			osw.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
