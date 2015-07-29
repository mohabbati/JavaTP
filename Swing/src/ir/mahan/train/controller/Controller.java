package ir.mahan.train.controller;

import ir.mahan.train.model.Database;
import ir.mahan.train.model.Person;
import ir.mahan.train.view.FormEvent;

public class Controller {

	Database db;
	
	public Controller() {
		
		db = new Database();
		
	}
	
	public void addPerson(FormEvent ev) {
		
	}
	
	private Person convertFormEventtoPerson(FormEvent ev) {
		
		return null;
		
	}
}
