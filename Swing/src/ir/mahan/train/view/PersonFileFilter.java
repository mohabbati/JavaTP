package ir.mahan.train.view;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		if (file.isDirectory() == true){
		
			return true;
			
		}
		
		String name = file.getName();
		String extention = Utils.getFileExtention(name);
		
		if(extention == null){
			return false;
		}
		
		if(extention == null){
			return false;
		}
		
		return false;
		
	}

	@Override
	public String getDescription() {
		
		return "Person Database File (*.per)";
		
	}

}
