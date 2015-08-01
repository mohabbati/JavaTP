package ir.mahan.train.repository;

import java.sql.Connection;
import java.util.List;

public class SQLRepository implements IRepository {

	Connection connection;
	
	@Override
	public boolean Save(List<Object> objects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
