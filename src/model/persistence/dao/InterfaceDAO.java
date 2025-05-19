package model.persistence.dao;

import java.util.ArrayList;

public interface InterfaceDAO <T>{

	ArrayList<T> getAll();
	String getAllAsString();
	boolean add(T x);
	boolean delete(T x);
	boolean update(T x, T y);
	T find(T x);
	
}
 