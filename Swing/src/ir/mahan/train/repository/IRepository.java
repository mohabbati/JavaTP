package ir.mahan.train.repository;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;

public interface IRepository {

	public boolean Save(List<Object> objects);
	
	//public <T> List<Object> Retrieve(Class<T> valueType);
	public String Retrieve();
	
}