package com.example.tareaDos.dao;

import java.util.List;

public interface Operaciones<T> {
	int create (T t);
	  int update (T t);
	  int delete(int id);
	  T read(int id);
	  List<T> readAll();
}
